import java.util.Date;

public class CreditCard {
    public enum CardType {
        VISA, MC, AMERICAN_EXPRESS, DISCOVER
    }
    private long cardNumber;
    private CardType type;
    private double creditLimit;
    private double currentBalance;
    private boolean isActive;

    public CreditCard(long cardNumber, CardType type, double creditLimit) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.creditLimit = creditLimit;
        this.currentBalance = 0.0;
        this.isActive = false;
    }

    public CreditCard createDuplicateCard(){
        CreditCard card = new CreditCard(cardNumber, type, creditLimit);
        card.setCurrentBalance(currentBalance);
        card.setIsActive(isActive);
        return card;
    }

    public long getCardNumber(){
        return cardNumber;
    }

    public CardType getType(){
        return type;
    }

    public double getCreditLimit(){
        return creditLimit;
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public boolean getIfIsActive(){
        return isActive;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }

    public void setCurrentBalance(double currentBalance){
        this.currentBalance = currentBalance;
    }

    public void buy(int customerID, double price, int vendorID, TransactionCollection collection){
        currentBalance += price;
        Date date = new Date();

        Transaction t = new Transaction(date, customerID, this.cardNumber, vendorID, price);

        collection.addNewTransaction(this, t);
    }

    public void payOffCard(){
        currentBalance = 0;
    }
}
