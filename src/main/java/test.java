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
        for (int i = 0; i < Integer.valueOf(lines.get(0).charAt(0)); i++) {
            int j = 1;
            while (lines.get(i+1).substring(0, j).lastIndexOf(" ") == -1){
                j++;
            }

            int g = j+1;
            while (lines.get(i+1).substring(j+1,g).lastIndexOf(" ") == -1){
                g++;
            }

            Miliarder mil = new Miliarder(lines.get(i+1).substring(0,j),Long.valueOf(lines.get(i+1).substring(g,lines.get(i+1).length()-1)));
            City ct = new City(mil,lines.get(i+1).substring(j,g));
            mil.getCity(ct);

            cityMap.put(ct.name, ct);
            milMap.put(mil.name, mil);
        }
        for(Map.Entry<String, City> entry: cityMap.entrySet()) {
            City value = entry.getValue();
           System.out.println(value.summ());
        }
        for (int i = Integer.valueOf(lines.get(0).charAt(0)); i < lines.size(); i++) {
            int j = 1;
            while (lines.get(i+1).substring(0, j).lastIndexOf(" ") == -1){

            }
        }
    }

}




