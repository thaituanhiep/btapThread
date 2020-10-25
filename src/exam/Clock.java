package exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock implements Runnable {

    Thread t;
    int time;
    boolean infinity;

    public void join() {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        infinity = true;
        t = new Thread(this);
        t.start();
    }

    public void start(int counter) {
        time = counter;
        t = new Thread(this);
        t.start();
    }

    public void stop() {
        if (isRunning()) {
            t.stop();
            System.out.println("Thread ket thuc");
        }
    }

    public boolean isRunning() {
        return t.isAlive();
    }

    @Override
    public void run() {
        while (time > 0 || infinity) {

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
            String now = dateFormat.format(date);
            System.out.println(now);
            time -= 1;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
