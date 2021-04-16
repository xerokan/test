import java.util.*;

public class City{
    public String name;
    public Set<Miliarder> sum = new HashSet<>();
    public Long summ;


    public City( String nam){
        this.name = nam;
    }

    public void addMil(Miliarder mil){
        this.sum.add(mil);
    }

    public long cash(){
        Long s = Long.valueOf(0);
        Iterator<Miliarder> iter =  this.sum.iterator();
        while (iter.hasNext()) {
            Miliarder mil = iter.next();
            s += mil.money ;
        }
        this.summ = s;
        return this.summ;
    }
}
