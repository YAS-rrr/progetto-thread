// Cuoco.java

import java.util.concurrent.BlockingQueue;

public class Cuoco implements Runnable {

    private BlockingQueue<Integer> vassoio;

    public Cuoco(BlockingQueue<Integer> vassoio) {
        this.vassoio = vassoio;
    }

    @Override
    public void run() {
        try {
            for (int piatto = 1; piatto <= 10; piatto++) {

                System.out.println("Cuoco prepara il piatto " + piatto);

                vassoio.put(piatto);

                System.out.println("Cuoco mette il piatto " + piatto + " sul vassoio");

                Thread.sleep(500);
            }

            System.out.println("Cuoco ha finito di preparare i piatti.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}