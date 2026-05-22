// Cameriere.java

import java.util.concurrent.BlockingQueue;

public class Cameriere implements Runnable {

    private BlockingQueue<Integer> vassoio;
    private int numeroCameriere;

    public Cameriere(BlockingQueue<Integer> vassoio, int numeroCameriere) {
        this.vassoio = vassoio;
        this.numeroCameriere = numeroCameriere;
    }

    @Override
    public void run() {
        try {
            while (true) {

                Integer piatto = vassoio.take();

                System.out.println("Cameriere " + numeroCameriere + " prende il piatto " + piatto);

                Thread.sleep(1000);

                System.out.println("Cameriere " + numeroCameriere + " serve il piatto " + piatto);
            }

        } catch (InterruptedException e) {
            System.out.println("Cameriere " + numeroCameriere + " termina il turno.");
            Thread.currentThread().interrupt();
        }
    }
}