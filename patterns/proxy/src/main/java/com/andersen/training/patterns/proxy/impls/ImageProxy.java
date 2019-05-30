package com.andersen.training.patterns.proxy.impls;

import com.andersen.training.patterns.proxy.interfaces.Image;

public class ImageProxy implements Image {
    private ImageImpl realImage;
    private String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new ImageImpl(fileName);
        }
        realImage.display();
    }
}
