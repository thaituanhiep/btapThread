package exam;

public class mainClass {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.start(5);
        clock.join();

        Clock clock1 = new Clock();
        clock1.start();

        Thread thread = new Thread(() -> {
            int count = 10;
            for (int i = count; i > 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Hết giờ");
            clock1.stop();
        });
        thread.start();
    }
}
