package org.example;


public class Contador {
    private int valor;

    public Contador(int valor) {
        this.valor = valor;
    }

    public void incrementar() {
        synchronized (this) {
            valor = valor + 1;
        }
    }

    public void decrementar() {
        synchronized (this) {
            valor = valor - 1;
        }
    }

    public int getValor() {
        return valor;
    }

}

