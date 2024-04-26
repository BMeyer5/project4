
public class Account {
    private int accounts;
    private double balance;
    private static int numOfAccount = 1000;

    public Account(Double initialDeposit) {
        this.accounts = Account.numOfAccount++;
        this.balance = initialDeposit;

    }

    public int getAccounts()
    {
        return accounts;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("You have deposited: " + amount + " \n Your new balance is: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("You have withdraw: " + amount + "New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    @Override
    public String toString(){
        return String.format("Account Number: %d\nBalance: %.2f\n", accounts,balance);
    }


}
