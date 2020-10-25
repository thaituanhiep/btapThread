package bank;

public class ATM implements Runnable {
    private String nameATM;
    private BankAccount bankAccount;
    private long drawalLimit;
    private Thread thread;

    public ATM(String nameATM, BankAccount bankAccount, long drawalLimit) {
        this.nameATM = nameATM;
        this.bankAccount = bankAccount;
        this.drawalLimit = drawalLimit;
        thread = new Thread(this);
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        int count = 5;
        while (count > 0) {
            if (bankAccount.getBalance() == 0) {
                System.out.println("=============================");
                System.out.println("ATM " + nameATM + ": Tài khoản hết tiền");
                System.out.println("------------");
                System.out.println();
                System.out.println();
                thread.stop();
            }
            bankAccount.withdraw(drawalLimit);
            count--;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=============================");
        System.out.println("ATM " + nameATM + ": rút tiền xong.");
        System.out.println("------------");
        System.out.println();
        System.out.println();

    }
}
