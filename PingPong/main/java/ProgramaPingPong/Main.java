package ProgramaPingPong;

public class Main {
    public static void main(String[] args) {
        Bola bola = new Bola();
        Thread jugador1 = new Thread(new hiloPing(bola));
        Thread jugador2 = new Thread(new hiloPong(bola));
        jugador1.start();
        jugador2.start();
    }
}
