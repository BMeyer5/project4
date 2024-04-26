import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Bank banks = new Bank();

    private Teller bank = new Teller("Teller Name: ","12345");

    public void mainMenu() {
        System.out.println("Your Teller's name is " + bank.getName());
        System.out.println("Your Teller's ID is " + bank.getId());
        while (true) {
            int menuSelection;
            System.out.println("****Main Menu****");
            System.out.println("1. Access Account");
            System.out.println("2. Open a New Account");
            System.out.println("3. Close All Accounts");
            System.out.println("4. Exit");
            menuSelection = Integer.parseInt(scanner.nextLine());

            if (menuSelection == 1) {
                accessAccount();
            } else if (menuSelection == 2) {
                createNewAccount();
            } else if (menuSelection == 3) {
                closeAllAccounts();
            } else if (menuSelection == 4) {
                System.out.println("Exiting");
                break;
            } else {
                System.out.println("Invalid Entry");
            }

        }
    }

    private void createNewAccount() {
        String newcustomer;
        Customer customer;
        Account account;


        System.out.println("Are you a new Customer? \n 1. Yes\n2. No");
        newcustomer = scanner.nextLine();
        if(newcustomer.equals("1")){
            customer = newCustomer();
        }
        else{
            System.out.println("Enter Pin: ");
            customer = bank.getCustomer(scanner.nextLine());
            if (customer == null) {
                System.out.println("Pin is invalid");
                return;
            }
        }

        System.out.println("Please Enter Deposit Amount: ");
        double deposit = Double.parseDouble(scanner.nextLine());
        account = new Account(deposit);
        customer.addAccount(account);
        System.out.println("New Account Opened" + account.getAccounts());

    }

    private void closeAllAccounts() {
        Customer customer;
        System.out.println("Pleas Enter Pin: ");
        String Pin = scanner.nextLine();
        customer = bank.getCustomer(Pin);
        if (customer == null) {
            System.out.println("Pin is invalid");
            return;
        }
        bank.removeAccount(customer);
        System.out.println("Customer Has Been Removed: ");

    }

    private Customer newCustomer() {
        String firstName;
        String lastName;
        String Pin;
        System.out.println("Enter First Name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter Pin: ");
        Pin = scanner.nextLine();
        Customer customer = new Customer(firstName, lastName, Pin);
        bank.addAccount(customer);
        return customer;
    }

    private void accessAccount() {
        Account account;
        System.out.println("Please enter your Pin: ");
        String Pin = scanner.nextLine();
        Customer customer = bank.getCustomer(Pin);

        if (customer == null) {
            System.out.println("Pin is invalid");
            return;
        }
        System.out.println(" **** Active Accounts **** ");
        System.out.println(customer.getAllAccounts());
        System.out.println("Enter Account Number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());
        account = customer.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account number is invalid");
            return;
        }
        while (true) {
            int menuSelection;
            System.out.println("****Make a Selection****");
            System.out.println("1. Make a Deposit");
            System.out.println("2. Make a Withdraw");
            System.out.println("3. See Account Balance");
            System.out.println("4. Close Account");
            System.out.println("5. Exit");
            menuSelection = Integer.parseInt(scanner.nextLine());

            if (menuSelection == 1) {
                System.out.println("Enter Deposit Amount");
                double amount = Double.parseDouble(scanner.nextLine());
                account.deposit(amount);
            } else if (menuSelection == 2) {
                System.out.println("Enter Withdraw Amount");
                double amount = Double.parseDouble(scanner.nextLine());
                account.withdraw(amount);
            } else if (menuSelection == 3) {
                System.out.println("Account Number: " + account.getAccounts());
                System.out.println("Account Balance: " + account.getBalance());

            } else if (menuSelection == 4) {
                System.out.println("Account Number you close: " + account.getAccounts());
            } else if (menuSelection == 5) {
                System.out.println("Exiting");
                break;
            } else {
                System.out.println("Invalid Entry");
            }

        }
    }

}