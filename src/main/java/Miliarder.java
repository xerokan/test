import java.util.HashMap;
import java.util.Map;

public class Miliarder<T extends City> {
    public String name;
    public Long money;
    public City place;

    public Miliarder(String name, Long money){
        this.name = name;
        this.money = money;
    }

    public void setCity(City place){
        this.place = place;
    }

    public void moveTO(City ct){
        this.place.removeMil(this);
        ct.addMil(this);
        this.place = ct;
    }
}
