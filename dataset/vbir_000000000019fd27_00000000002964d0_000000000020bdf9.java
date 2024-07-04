
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<List<AbstractMap.SimpleEntry<Integer, Integer>>> data = new ArrayList<>();
        int lineNr = 0;
        List<AbstractMap.SimpleEntry<Integer, Integer>> t = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] cells = line.split(" ");
            if(lineNr == 0) {
                lineNr ++;
                continue;
            }
            if(cells.length == 1){
                if(t != null){
                    data.add(t);
                }
                t = new ArrayList<>();
                lineNr ++;
                continue;
            }

            assert(cells.length == 2);
            AbstractMap.SimpleEntry<Integer, Integer> a = new AbstractMap.SimpleEntry<>(Integer.parseInt(cells[0]), Integer.parseInt(cells[1]));
            t.add(a);
            lineNr ++;
        }
        if(t != null){
            data.add(t);
        }

        String output = "";
        int caseNr = 1;
        for(List<AbstractMap.SimpleEntry<Integer,Integer>> dp: data){
            output += String.format("Case #%d: %s\n",caseNr,transform(dp));
            caseNr++;
        }
        System.out.println(output);
    }

    private static String transform(List<AbstractMap.SimpleEntry<Integer, Integer>> row){
        List<AbstractMap.SimpleEntry<Integer, Integer>> unsortedRow = new ArrayList<>(row);
        row.sort((AbstractMap.SimpleEntry<Integer, Integer> o1, AbstractMap.SimpleEntry<Integer, Integer> o2)->o1.getKey() - o2.getKey());
        String result = "";
        List<String> sorted = new ArrayList<>();
        Map<String, Integer> s = new HashMap<>();
        s.put("C",row.get(0).getValue());
        s.put("J",0);

        String current = "C";
        sorted.add(current);
        for(int i = 1; i < row.size(); i++){
            AbstractMap.SimpleEntry<Integer, Integer> a = row.get(i);
            AbstractMap.SimpleEntry<Integer, Integer> aPrev = row.get(i-1);
            if(aPrev.getValue() > a.getKey()){
                if(s.get(other(current)) <= a.getKey()){
                    current = other(current);
                }else{
                    return "IMPOSSIBLE";
                }
            }
            sorted.add(current);
            s.put(current, a.getValue());
        }

        return putTogether(row, unsortedRow, sorted);
    }

    private static String other(String p){
        if(p.equals("J")){
            return "C";
        }else{
            return "J";
        }
    }

    private static int searchPosition(List<AbstractMap.SimpleEntry<Integer, Integer>> row, Integer key, Integer value){
        for(int i = 0; i < row.size(); i++){
            AbstractMap.SimpleEntry<Integer, Integer> a = row.get(i);
            if(a.getKey() == key && a.getValue() == value){
                return i;
            }
        }
        return -1;
    }

    private static String putTogether(List<AbstractMap.SimpleEntry<Integer, Integer>> row, List<AbstractMap.SimpleEntry<Integer, Integer>> unsortedRow, List<String> sorted){
        String result = "";
        for(int i = 0; i < row.size(); i++){
            AbstractMap.SimpleEntry<Integer, Integer> a = row.get(i);
            int index = searchPosition(unsortedRow, a.getKey(), a.getValue());
            result += sorted.get(index);
        }
        return result;
    }
}
