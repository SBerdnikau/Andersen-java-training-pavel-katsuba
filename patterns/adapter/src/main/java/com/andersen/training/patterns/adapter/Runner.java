package com.andersen.training.patterns.adapter;

import java.io.*;

/**
 * Reader works like adapter between application wich needs for chars and InputStream which can work with bytes only.
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File(args[0]));
        Reader reader = new InputStreamReader(in);
        char dataChar = (char) reader.read();
    }
}
