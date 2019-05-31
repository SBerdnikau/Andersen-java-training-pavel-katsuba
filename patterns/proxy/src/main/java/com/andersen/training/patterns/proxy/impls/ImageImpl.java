package com.andersen.training.patterns.proxy.impls;

import com.andersen.training.patterns.proxy.interfaces.Image;

public class ImageImpl implements Image {
    private String fileName;

    public ImageImpl(String fileName) {
        this.fileName = fileName;
        System.out.println("Creating ImageImpl");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
