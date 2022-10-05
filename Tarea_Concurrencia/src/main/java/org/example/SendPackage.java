package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class SendPackage implements Runnable {

    List<Integer> packageList;
    int times;
    Semaphore sendPackageSemaphore;
    Semaphore recivePackageSemaphore;
    public SendPackage(List<Integer> packageList, Semaphore sendPackageSemaphore, Semaphore recivePackageSemaphore, int times) {
        this.packageList = packageList;
        this.times = times;
        this.sendPackageSemaphore = sendPackageSemaphore;
        this.recivePackageSemaphore = recivePackageSemaphore;
    }

    @Override
    public void run() {
        for (int i = 1; i <= times; i++) {
            try {
                sendPackageSemaphore.acquire();
                System.out.println("Send Package " + i);
                packageList.add(i);
                recivePackageSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

