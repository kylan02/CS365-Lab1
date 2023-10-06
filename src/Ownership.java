import java.util.ArrayList;

public class Ownership {
    private int customerID;
    private long customerSSN;
    private long cardNumber;
    private boolean isCurrent;

    public Ownership(int customerID, long customerSSN, long cardNumber, boolean isCurrent){
        this.customerID = customerID;
        this.customerSSN = customerSSN;
        this.cardNumber = cardNumber;
        this.isCurrent = isCurrent;
    }

    public long getCreditCard(){
        return cardNumber;
    }
    public int getCustomerID() {
        return customerID;
    }
    public long getCustomerSSN() {
        return customerSSN;
    }
}
