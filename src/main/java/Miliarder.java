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

    public void getCity(City place){
        this.place = place;
    }
}
