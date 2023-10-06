import java.util.ArrayList;

public class PaymentCollection {
    ArrayList<Payment> payments = new ArrayList<>();

    public void addPayment(Payment payment){
        payments.add(payment);
    }
}
