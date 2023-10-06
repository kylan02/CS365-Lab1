import java.lang.reflect.Array;
import java.util.*;

public class TransactionCollection {
    //need hash maps with date as key and
    //Print all transactions in a specified date range

    HashMap<CreditCard, TreeMap<Date, List<Transaction>>> transactionCollectionMap;

    public TransactionCollection(){
        transactionCollectionMap = new HashMap<>();
    }

    public void addNewTransaction(CreditCard card, Transaction transaction){
        TreeMap<Date, List<Transaction>> treeMap;
        Date date = transaction.getDate();
        if(transactionCollectionMap.containsKey(card)){
            treeMap = transactionCollectionMap.get(card);
            List<Transaction> transactionList;
            if(treeMap.get(date) != null){
                transactionList = treeMap.get(date);
            }else{
                transactionList = new ArrayList<>();
            }
            transactionList.add(transaction);
            treeMap.put(date, transactionList);
        }else{
            List<Transaction> list = new ArrayList<>();
            list.add(transaction);
            treeMap = new TreeMap<>();
            treeMap.put(date, list);
        }
        transactionCollectionMap.put(card, treeMap);
    }

    public void getTransactionBetweenDates(CreditCard card, Date startdate, Date enddate){
        Map<Date, List<Transaction>> transactions = transactionCollectionMap.get(card).subMap(startdate, enddate);
        System.out.println("Get Transaction: "+transactions);
    }
}
