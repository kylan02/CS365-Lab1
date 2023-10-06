public class Vendor {
    private int id;
    private String name;
    private String location;

    public Vendor(int id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId(){
        return id;
    }
}
