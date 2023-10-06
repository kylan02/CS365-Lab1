import java.sql.Array;
import java.util.*;

public class OwnershipCollection {
    //hash map with customer to ownership
    //hash map with credit card to ownership
    private HashMap<Integer, ArrayList<Long>> customerOwnsWhichCardsID;
    private HashMap<Long, ArrayList<Long>> customerOwnsWhichCardsSSN;
    private HashMap<Long, ArrayList<Integer>> cardOwnedByWhichCustomers;

    public OwnershipCollection() {
        this.customerOwnsWhichCardsID = new HashMap<>();
        this.customerOwnsWhichCardsSSN = new HashMap<>();
        this.cardOwnedByWhichCustomers = new HashMap<>();
    }

    public void addOwnership(Ownership owner){
        ArrayList<Long> cards = customerOwnsWhichCardsID.get(owner.getCustomerID());
        ArrayList<Integer> customer = cardOwnedByWhichCustomers.get(owner.getCreditCard());
        if(cards == null){
            cards = new ArrayList<>();
        }
        if(customer == null){
            customer = new ArrayList<>();
        }
        cards.add(owner.getCreditCard());
        customer.add(owner.getCustomerID());

        customerOwnsWhichCardsID.replace(owner.getCustomerID(), cards);
        customerOwnsWhichCardsSSN.replace(owner.getCustomerSSN(), cards);
        cardOwnedByWhichCustomers.replace(owner.getCreditCard(), customer);
        customerOwnsWhichCardsID.putIfAbsent(owner.getCustomerID(), cards);
        customerOwnsWhichCardsSSN.putIfAbsent(owner.getCustomerSSN(), cards);
        cardOwnedByWhichCustomers.putIfAbsent(owner.getCreditCard(), customer);
    }

    public ArrayList<Long> getCreditCardsFromOwner(int customerID){
        return customerOwnsWhichCardsID.get(customerID);
    }
    public ArrayList<Integer> getOwnerFromCC(long ccNumber){
        return cardOwnedByWhichCustomers.get(ccNumber);
    }

    public void printCardInfo(long ssn, CreditCardCollection collection) {
            for(long cardNum: customerOwnsWhichCardsSSN.get(ssn)){
                CreditCard card = collection.getCardByNumber(cardNum);
                ArrayList<Integer> owners = cardOwnedByWhichCustomers.get(cardNum);
                String ownersString = "";
                for(int id: owners){
                    ownersString = ownersString + id + " ";
                }
                System.out.println("Balance: $" + card.getCurrentBalance() + ", Credit Limit: $" + card.getCreditLimit() + ", Card Holders: "+ ownersString);
            }
    }

    public void printCardInfo(int id, CreditCardCollection collection) {
        for(long cardNum: customerOwnsWhichCardsID.get(id)){
            CreditCard card = collection.getCardByNumber(cardNum);
            ArrayList<Integer> owners = cardOwnedByWhichCustomers.get(cardNum);
            String ownersString = "";
            for(int i: owners){
                ownersString = ownersString + i + " ";
            }
            System.out.println("Balance: $" + card.getCurrentBalance() + ", Credit Limit: $" + card.getCreditLimit() + ", Card Holders: "+ ownersString);
        }
    }
}
