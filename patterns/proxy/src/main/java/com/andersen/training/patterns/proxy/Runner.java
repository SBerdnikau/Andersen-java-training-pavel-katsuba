package com.andersen.training.patterns.proxy;

import com.andersen.training.patterns.proxy.impls.ImageProxy;
import com.andersen.training.patterns.proxy.interfaces.Image;

/**
 * Class ImageProxy contains ImageImpl.
 * And creates ImageImpl object with first call of display().
 */
public class Runner {
    public static void main(String[] args) {
        Image image = new ImageProxy("Some image");
        System.out.println("first call");
        image.display();
        System.out.println("second call");
        image.display();
    }
}
