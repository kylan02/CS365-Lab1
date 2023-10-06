import java.util.ArrayList;
import java.util.HashMap;

public class CreditCardCollection {
    private HashMap<Long, CreditCard> creditCardTable;

    public CreditCardCollection(){
        this.creditCardTable = new HashMap<>();
    }

    public void addCreditCard(CreditCard creditCard){
        creditCardTable.put(creditCard.getCardNumber(), creditCard);
    }

    public CreditCard getCardByNumber(long CCNumber){
        return creditCardTable.get(CCNumber);
    }

    public void printCardInfo(long cardNum, OwnershipCollection ownersColl) {
            CreditCard card = this.getCardByNumber(cardNum);
            ArrayList<Integer> owners = ownersColl.getOwnerFromCC(cardNum);
            String ownersString = "";
            for(int id: owners){
                ownersString = ownersString + id + " ";
            }
            System.out.println("Balance: $" + card.getCurrentBalance() + ", Credit Limit: $" + card.getCreditLimit() + ", Card Holders: "+ ownersString);

    }
}
