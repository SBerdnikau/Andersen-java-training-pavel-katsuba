package com.andersen.training.patterns.decorator;

import java.io.*;

/**
 * Here we have FileInputStream is wrapped with BufferedInputStream.
 * BufferedInputStream adds new functional.
 */
public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new BufferedInputStream(new FileInputStream(new File(args[0])));
    }
}
