import java.util.*;
public class Transaction {
    private Date date;
    private int customerId;
    private long creditCardNum;
    private int vendorId;
    private double amountPurchased;

    public Transaction(Date date, int customerId, long creditCardNum, int vendorId, double amountPurchased){
        this.date = date;
        this.customerId = customerId;
        this.creditCardNum = creditCardNum;
        this.vendorId = vendorId;
        this.amountPurchased = amountPurchased;

    }

    public Date getDate(){
        return date;
    }
}
