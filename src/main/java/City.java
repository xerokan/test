import java.util.*;

public class City{
    public String name;
    public Set<Miliarder> sum = new HashSet<>();
    public Long summ;

    public City(Miliarder mil, String nam){
        this.sum.add(mil);
        this.name = nam;
    }

    public City( String nam){
        this.name = nam;
    }

    public long summ(){
        Iterator<Miliarder> iter =  this.sum.iterator();
        while (iter.hasNext()) {
            Miliarder mil = iter.next();
            this.summ += mil.money ;
        }
        return this.summ;
    }
}
