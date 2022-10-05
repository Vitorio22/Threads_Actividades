package org.example;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador(100);
        Thread aumentador = new Thread(new hiloAumentador(contador, 20));
        Thread disminuidor = new Thread(new hiloDisminuidor(contador, 10));

        aumentador.start();
        disminuidor.start();

        try {
            aumentador.join();
            disminuidor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(contador.getValor());
    }
}