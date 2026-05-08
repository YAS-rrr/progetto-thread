import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Ristorante {
    public static void main(String[] args) {
        
        BlockingQueue<Integer> vassoio = new ArrayBlockingQueue<>(3);
        
     
        Thread cuoco = new Thread(new Cuoco(vassoio));
        Thread cameriere1 = new Thread(new Cameriere(vassoio, 1));
        Thread cameriere2 = new Thread(new Cameriere(vassoio, 2));
   
        cuoco.start();
        cameriere1.start();
        cameriere2.start();
        
      
        try {
            cuoco.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Interrompo i camerieri (tanto non arrivano più piatti)
        cameriere1.interrupt();
        cameriere2.interrupt();
        
        System.out.println("\n=== RISTORANTE CHIUSO ===");
    }
}


