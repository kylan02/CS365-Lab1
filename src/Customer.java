public class Customer {
    private long SSN;
    private int id;
    private String name;
    private String address;
    private long phoneNum;
    private static int idCounter = 0;

    public Customer(long SSN, String name, String address, long phoneNum){
        this.SSN = SSN;
        this.id = idCounter++;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public long getSSN(){
        return SSN;
    }
    public int getID(){
        return id;
    }

    public String getName() { return name; }
}
