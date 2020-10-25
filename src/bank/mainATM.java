package bank;

public class mainATM {
    public static void main(String[] args) {
        BankAccount vietcombank = new BankAccount(100000000, 120396);

        ATM atm = new ATM("VCB Lai Xá", vietcombank, 5000000);
        ATM atm1 = new ATM("VCB Cầu Diễn", vietcombank, 10000000);
        ATM atm2 = new ATM("VCB Minh Khai", vietcombank, 10000000);
        ATM atm3 = new ATM("VCB Nhổn", vietcombank, 10000000);
        ATM atm4 = new ATM("VCB Trôi", vietcombank, 10000000);

        atm.start();
        atm1.start();
        atm2.start();
        atm3.start();
        atm4.start();

        atm.join();
        atm1.join();
        atm2.join();
        atm3.join();
        atm4.join();

        int size = vietcombank.getTransactionList().size();
        for (int i = 0; i < size; i++) {
            vietcombank.getTransactionList().pop().detail();
        }
    }
}
