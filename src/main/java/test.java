import java.io.*;
import java.util.*;

public class test {

    static class City{
        public String name;
        public Set<Miliarder> sum = new HashSet<>();
        public Long summ;
        public int count;


        public City( String nam){
            this.name = nam;
            this.count = 0;
        }

        public void addMil(Miliarder mil){
            this.sum.add(mil);
        }

        public void removeMil(Miliarder mil){
            this.sum.remove(mil);
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

    static class Miliarder {
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

    public static void findMaxCash(Map<String, City> map) {
        long max = 0;
        String key = null;
        for (Map.Entry<String, City> entry: map.entrySet()) {
           if (max < entry.getValue().cash()){
               key = entry.getKey();
               max = entry.getValue().cash();
           }
        }
        for (Map.Entry<String, City> entry: map.entrySet()) {
            if ((map.get(key).summ == entry.getValue().cash())) {
                if ((key != entry.getKey())) {
                    return;
                }
            }
        }
        map.get(key).count += 1;
    }

    public static void main(String[] args) throws IOException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("Info.txt");
        Writer writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
        Scanner sc = new Scanner(reader);
        PrintWriter out = new PrintWriter(writer);
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            lines.add(s);
        }
        Map<String, City> cityMap = new HashMap<>();
        Map<String, Miliarder> milMap = new HashMap<>();

        int lines1 = Integer.parseInt(lines.get(0).replaceAll("[^\\x00-\\xFF]", ""));
//        int lines1 = 5;
        for(int i = 0; i< lines1; i++){
            String[] info = lines.get(i+1).split(" ");

            Miliarder mil = new Miliarder(info[0], Long.valueOf(info[2]));
            if (cityMap.get(info[1])!= null){
                cityMap.get(info[1]).addMil(mil);
                mil.setCity(cityMap.get(info[1]));
            }
            else {
                City ct = new City(info[1]);
                ct.addMil(mil);
                mil.setCity(ct);
                cityMap.put(ct.name, ct);
            }
            milMap.put(mil.name, mil);
        }

        findMaxCash(cityMap);

        String[] nums = lines.get(lines1+1).split(" ");
        int days = Integer.valueOf(nums[0]);
        for (int i = 1; i<days;i++){
            for (int j = 2; j<lines.size()-lines1; j++){

              String[] str = lines.get(lines1+j).split(" ");
              if (Integer.valueOf(str[0]) == i && cityMap.containsKey(str[2])) {
                  milMap.get(str[1]).moveTO(cityMap.get(str[2]));
              } else if (Integer.valueOf(str[0]) == i && !(cityMap.containsKey(str[2]))){
                  City ct = new City(str[2]);
                  cityMap.put(ct.name, ct);
                  milMap.get(str[1]).moveTO(cityMap.get(str[2]));
              }
            }
            findMaxCash(cityMap);
        }
        ArrayList<String> view = new ArrayList<>();
        for (Map.Entry<String, City> entry : cityMap.entrySet()){
            if (entry.getValue().count != 0 ){
                view.add(entry.getKey() + " " + entry.getValue().count);
            }
        }
        Collections.sort(view);
        Iterator<String> iter =  view.iterator();
        while (iter.hasNext()) {
            out.write(iter.next());
            writer.append('\n');
            out.flush();
        }
    }
}




