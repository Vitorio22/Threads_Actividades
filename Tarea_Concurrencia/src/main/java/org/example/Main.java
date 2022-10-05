package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        List<Integer> packageList = new Vector<Integer>();

        Semaphore sendPackageSemaphore = new Semaphore(3);
        Semaphore receivePackageSemaphore = new Semaphore(0);

        Thread sendPackage = new Thread(new SendPackage(packageList, sendPackageSemaphore, receivePackageSemaphore, 100));
        Thread receivePackage = new Thread(new ReceivePackage(packageList, sendPackageSemaphore, receivePackageSemaphore, 100));

        sendPackage.start();
        receivePackage.start();
    }
}