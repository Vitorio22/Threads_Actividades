package org.example;

public class hiloAumentador implements Runnable {
    private final Contador contador;
    private final int tiempoEspera;

    public hiloAumentador(Contador contador, int tiempoEspera) {
        this.contador = contador;
        this.tiempoEspera = tiempoEspera;
    }

    public void run() {
        while (contador.getValor() != 0) {
            contador.incrementar();
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
