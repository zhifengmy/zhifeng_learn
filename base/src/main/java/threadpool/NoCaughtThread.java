package threadpool;

public class NoCaughtThread {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new Task());
            thread.start();
        } catch (Exception e) {
            System.out.println("==Exception: " + e.getMessage());
        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(3 / 2);
        try {
            System.out.println(3 / 0);
        } catch (Exception e) {
            System.out.println("error...");
        }
        System.out.println(3 / 1);
    }
}