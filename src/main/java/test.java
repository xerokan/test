import java.io.*;
import java.util.*;

public class test {

    public static void findMaxCash(Map<String, City> map) {
        long max = 0;
        String key = null;
        for (Map.Entry<String, City> entry: map.entrySet()) {
           if (max < entry.getValue().cash()){
               key = entry.getKey();
               max = entry.getValue().cash();
           }
        }
        map.get(key).count += 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("Info.txt");
        Scanner sc = new Scanner(reader);
        ArrayList<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            lines.add(s);
            System.out.println(lines);
        }
        Map<String, City> cityMap = new HashMap<>();
        Map<String, Miliarder> milMap = new HashMap<>();

//        Byte str = Byte.parseByte(lines.get(0));
        for(int i = 0; i< 5; i++){
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

        String[] nums = lines.get(5+1).split(" ");
        int days = Integer.valueOf(nums[0]);
        for (int i = 1; i<days;i++){
            for (int j = 2; j<lines.size()-5; j++){

              String[] str = lines.get(5+j).split(" ");
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
    }
}




