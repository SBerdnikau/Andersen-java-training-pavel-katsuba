package com.andersen.training.cachingproxy.annotations;

import com.andersen.training.cachingproxy.utils.CacheManager;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Caching {
    CacheManager cachingWay() default CacheManager.FILE;
    String rootDir() default "caching_proxy/src/main/resources/";
    String key() default "";
}
