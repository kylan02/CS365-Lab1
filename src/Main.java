import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        //Collections:
        CustomerCollection customerCollection = new CustomerCollection();
        CreditCardCollection cardCollection = new CreditCardCollection();
        OwnershipCollection ownershipCollection = new OwnershipCollection();
        TransactionCollection transactionCollection = new TransactionCollection();

        //Customer
        Customer john = new Customer(1234567899L, "John", "hi", 8059045088L);
        Customer steve = new Customer(4324567899L, "Steve", "bye", 8051234567L);
        customerCollection.addCustomer(john);
        System.out.println("Name: "+customerCollection.getCustomerBySSN(1234567899).getName());

        //Credit Card
        CreditCard card = new CreditCard(12345536454L, CreditCard.CardType.AMERICAN_EXPRESS, 3400);
        CreditCard card2 = new CreditCard(32145536454L, CreditCard.CardType.VISA, 5000);
        card.setIsActive(true);
        System.out.println("Is Card Active: "+card.getIfIsActive());
        long johnCardNumber = card.getCardNumber();
        cardCollection.addCreditCard(card);
        System.out.println("Limit: "+cardCollection.getCardByNumber(johnCardNumber).getCreditLimit());

        //Ownership
        Ownership ownership = new Ownership(john.getID(),john.getSSN(), johnCardNumber, true);
        ownershipCollection.addOwnership(ownership);
        ownership = new Ownership(steve.getID(),steve.getSSN(), card.getCardNumber(), true);
        ownershipCollection.addOwnership(ownership);
        ownershipCollection.printCardInfo(john.getSSN(), cardCollection);
        ownershipCollection.printCardInfo(john.getID(), cardCollection);

        //Vendor
        Vendor vendor = new Vendor(123, "Costco", "123 Main St.");

        //Transaction
        card.buy(john.getID(),12.50, vendor.getId(), transactionCollection);
        card.buy(steve.getID(),4.99, vendor.getId(), transactionCollection);
        cardCollection.printCardInfo(card.getCardNumber(), ownershipCollection);

        card.payOffCard(); //pays off card

        //Date
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginningDate = sdf.parse("2022-01-01");
        Date endDate = sdf.parse("2024-01-01");
        transactionCollection.getTransactionBetweenDates(card, beginningDate, endDate);
    }
}