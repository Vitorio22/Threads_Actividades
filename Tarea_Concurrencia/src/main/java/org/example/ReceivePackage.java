package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class ReceivePackage implements Runnable {

    List<Integer> packageList;
    int times;
    Semaphore sendPackageSemaphore;
    Semaphore receivePackageSemaphore;

    public ReceivePackage(List<Integer> packageList, Semaphore sendPackageSemaphore, Semaphore receivePackageSemaphore, int times) {
        this.packageList = packageList;
        this.times = times;
        this.sendPackageSemaphore = sendPackageSemaphore;
        this.receivePackageSemaphore = receivePackageSemaphore;
    }

    @Override
    public void run() {

        for (int i = 1; i <= times; i++) {
            try {
                receivePackageSemaphore.acquire();
                int num = packageList.remove(0);
                System.out.println("Receive Package " + num);
                sendPackageSemaphore.release();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Programa terminado");
    }
}

