package src_assignment_day6.q2;

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void addAmount(double amount) {
        this.balance += amount;
    }

    public synchronized void subtractAmount(double amount) {
        this.balance -= amount;
    }

    public synchronized void print() {
        System.out.println("Balance is: " + balance);
    }
}

class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.subtractAmount(1000);
        }
    }
}

class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.addAmount(1000);
        }
    }
}

public class DemoAccount {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000.00);
        account.print();

        Bank bank = new Bank(account);
        Company comp = new Company(account);

        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(comp);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        account.print();
    }
}
