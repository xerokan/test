import java.io.*;
import java.util.*;

public class test {
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
        System.out.println(lines.get(0));

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

        for (Map.Entry<String, City> entry: cityMap.entrySet()) {
            System.out.println(entry.getValue().cash());
        }

    }
}




