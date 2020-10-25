package bank;

import java.util.Date;

public class Transaction {
    private Date time;
    private long balanceStart;
    private long amount;

    public Transaction(Date time, long balanceStart, long amount) {
        this.time = time;
        this.balanceStart = balanceStart;
        this.amount = amount;
    }

    public void detail() {
        System.out.println("=============================");
        System.out.println(time);
        System.out.println("Số tiền ban đầu: " + balanceStart);
        System.out.print("Giao dịch ");
        System.out.print(amount > 0 ? "nạp " : "rút ");
        System.out.print(amount + " vào tài khoản.");
        System.out.println();
        System.out.println("------------");
        System.out.println();
        System.out.println();
    }
}
