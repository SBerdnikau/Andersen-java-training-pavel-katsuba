package com.andersen.training.cachingproxy.utils;

import com.andersen.training.cachingproxy.ArrayComporator;
import com.andersen.training.cachingproxy.annotations.Caching;
import com.andersen.training.cachingproxy.beans.Pair;
import com.andersen.training.cachingproxy.exceptions.CacheManagerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum CacheManager {
    FILE {
        @Override
        public void cache(Caching annotation, Object result, Object[] args, String key) {
            fileLock.lock();
            Set<Pair> pairs = deserialize(annotation, key);
            pairs.add(new Pair<>(result, args));
            try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(annotation.rootDir() + key))) {
                os.writeObject(pairs);
            } catch (ObjectStreamException e) {
                throw new CacheManagerException(e);
            } catch (IOException e) {
                LOGGER.log(Level.INFO, e.getMessage(), e);
            } finally {
                fileLock.unlock();
            }
        }

        @Override
        public Object checkCache(Caching annotation, Object[] args, String key) {
            try {
                fileLock.lock();
                Set<Pair> pairs = deserialize(annotation, key);
                for (Pair pair : pairs) {
                    Comparator<Object[]> comparator = new ArrayComporator();
                    if (comparator.compare(pair.getArgs(), args) == 0) {
                        return pair.getResult();
                    }
                }
                return null;
            } finally {
                fileLock.unlock();
            }
        }

        private Set<Pair> deserialize(Caching annotation, String key) {
            String path = annotation.rootDir() + key;
            Path filePath = Paths.get(path);
            if (Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
                    return (Set<Pair>) objectInputStream.readObject();
                } catch (ObjectStreamException e) {
                    throw new CacheManagerException(e);
                } catch (ClassNotFoundException | IOException e) {
                    LOGGER.log(Level.INFO, e.getMessage(), e);
                }
            }
            return new HashSet<>();
        }
    },
    MAP {
        private Map<String, Set<Pair>> cache = new HashMap<>();

        @Override
        public  void cache(Caching annotation, Object result, Object[] args, String key) {
            mapLock.lock();
            Set<Pair> pairs = cache.computeIfAbsent(key, k -> new HashSet<>());
            pairs.add(new Pair<>(result, args));
            mapLock.unlock();
        }

        @Override
        public Object checkCache(Caching annotation, Object[] args, String key) {
            mapLock.lock();
            try {
                Set<Pair> pairs = cache.get(key);
                if (pairs != null) {
                    for (Pair pair : pairs) {
                        ArrayComporator arrayComporator = new ArrayComporator();
                        if (arrayComporator.compare(pair.getArgs(), args) == 0) {
                            return pair.getResult();
                        }
                    }
                }
                return null;
            } finally {
                mapLock.unlock();
            }
        }
    };

    private static final Logger LOGGER = Logger.getLogger(CacheManager.class.getName());

    private static Lock fileLock = new ReentrantLock();

    private static Lock mapLock = new ReentrantLock();

    public abstract void cache(Caching annotation, Object result, Object[] args, String key);

    public abstract Object checkCache(Caching annotation, Object[] args, String key);
}
