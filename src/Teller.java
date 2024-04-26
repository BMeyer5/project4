import java.util.ArrayList;
import java.util.HashMap;

public class Teller extends Bank{
    private String name;
    private String id;
    private HashMap<String, String> tellerInfo = new HashMap<>();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Teller(String TellerName, String TellerID){
        this.name = TellerName;
        this.id = TellerID;
    }
    public void addTeller(String key, String value){
        tellerInfo.put(key,value);
    }
    public void removeTeller(String key){
        tellerInfo.remove(key);
    }
    @Override
    public String toString(){
        return String.format("Teller Name %s\nTeller ID:  %s\n",name,id);
    }

}
