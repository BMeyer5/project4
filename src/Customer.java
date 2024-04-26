import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String firstName;
    private String lastName;
    private String Pin;
    private ArrayList<Account> accountArrayList = new ArrayList<>();
    public Customer(String firstName, String lastName, String Pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.Pin = Pin;
    }

    public Account getAccount(int accountNumber){
        Account foundAccount = null;
        for(Account account : accountArrayList){
            if(account.getAccounts() == accountNumber){
                foundAccount = account;
                break;
            }
        }
        return foundAccount;

    }
    public StringBuilder getAllAccounts(){
        StringBuilder sb = new StringBuilder();
        for(Account account: accountArrayList){
            sb.append(account);
        }
        return sb;
    }
    public void addAccount(Account account){
        accountArrayList.add(account);
    }
    public void removeAccount(Account account){
        accountArrayList.remove(account);
    }
    @Override
    public String toString(){
        return String.format("First Name: %s\nLast Name:  %s\nPin: %s\n",firstName,lastName,Pin);
    }
    public String getPin(){
        return Pin;
    }



}
