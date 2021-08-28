package gmibank.com.pojos;

public class States {

    private int Id;
    private String Name;
    private String Tpcountry;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTpcountry() {
        return Tpcountry;
    }

    public void setTpcountry(String tpcountry) {
        Tpcountry = tpcountry;
    }

    public States() {
    }

    public States(int id, String name, String tpcountry) {
        Id = id;
        Name = name;
        Tpcountry = tpcountry;
    }

    @Override
    public String toString() {
        return "States{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Tpcountry='" + Tpcountry + '\'' +
                '}';
    }
}
