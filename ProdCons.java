import java.util.Stack;
public class ProdCons {  // Problema dos Produtores e Consumidores
    public static Stack buffer = new Stack();
    public static final int MAXBUFSIZE = 10;
    
    public static void main(String args[]) {
        Runnable prod = new Runnable() {  // Código do Produtor
            public void run() {
                for (int i=0; i<100; i++) {
                    synchronized(buffer) {
                        if (buffer.size() >= MAXBUFSIZE)
                            try { buffer.wait(); } catch (InterruptedException e) {}
                        buffer.push(new Integer(i));
                        System.out.println("Item "+i+" produzido. No. itens: "+buffer.size());
                        buffer.notify();
                    }
                }
            }
        };
        Runnable cons = new Runnable() { // Código do Consumidor
            public void run() {
                for (int i=0; i<100; i++) {
                    synchronized(buffer) {
                        if (buffer.size() == 0)
                            try { buffer.wait(); } catch (InterruptedException e) {}
                        int item = ((Integer)buffer.pop()).intValue();
                        System.out.println("Item "+item+" consumido. No. itens: " + buffer.size());
                        buffer.notify();
                    }
                }
            }
        };
        
        new Thread(prod).start(); // Inicia o Produtor
        new Thread(cons).start(); // Inicia o Consumidor
        // new Thread(prod).start(); // Inicia o Produtor
        // new Thread(cons).start(); // Inicia o Consumidor
    }
}
