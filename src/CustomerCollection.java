import java.util.*;

public class CustomerCollection {
    private HashMap<Long, Customer> customersBySSN;
    private HashMap<Integer, Customer> customersByID;

    public CustomerCollection() {
        this.customersBySSN = new HashMap<>();
        this.customersByID = new HashMap<>();
    }

    public void addCustomer(Customer customer){
        customersBySSN.put(customer.getSSN(), customer);
        customersByID.put(customer.getID(), customer);
    }

    public Customer getCustomerByID(int id){
        return customersByID.get(id);
    }
    public Customer getCustomerBySSN(long SSN){
        return customersBySSN.get(SSN);
    }
}
