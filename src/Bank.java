import java.util.ArrayList;

public class Bank {

    private ArrayList<Customer> customerArrayList = new ArrayList<>();


    public Customer getCustomer(String Pin){
        Customer foundCustomer = null;
        for(Customer customer : customerArrayList){
            if(customer.getPin().equals(Pin)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;

    }
    public StringBuilder getAllCustomer(){
        StringBuilder sb = new StringBuilder();
        for(Customer customer: customerArrayList){
            sb.append(customer);
        }
        return sb;
    }
    public void addAccount(Customer customer){
        customerArrayList.add(customer);
    }
    public void removeAccount(Customer customer){
        customerArrayList.remove(customer);
    }


}
