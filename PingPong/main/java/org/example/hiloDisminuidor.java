package org.example;

public class hiloDisminuidor implements Runnable {
    private final Contador contador;
    private final int tiempoEspera;

    public hiloDisminuidor(Contador contador, int tiempoEspera) {
        this.contador = contador;
        this.tiempoEspera = tiempoEspera;
    }

    public void run() {
        while (contador.getValor() != 0) {
            contador.decrementar();
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
