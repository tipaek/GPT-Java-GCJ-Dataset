
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
        String result = "";
        Map<String, List<AbstractMap.SimpleEntry<Integer, Integer>>> pa = new HashMap<>();
        pa.put("J", new ArrayList<>());
        pa.put("C", new ArrayList<>());
        String p = "J";
        for(AbstractMap.SimpleEntry<Integer, Integer> a: row){
            if(!hasTime(pa.get(p), a.getKey(), a.getValue())){
                p = other(p);
                if(!hasTime(pa.get(p), a.getKey(), a.getValue())){
                    return "IMPOSSIBLE";
                }
            }
            List<AbstractMap.SimpleEntry<Integer, Integer>> activities = pa.get(p);
            activities.add(a);
            result += p;
        }
        return result;
    }

    private static boolean hasTime(List<AbstractMap.SimpleEntry<Integer, Integer>> activities, Integer start, Integer end){
        for(AbstractMap.SimpleEntry<Integer, Integer> a: activities){
            if(a.getKey() < end && a.getValue() > start){
                return false;
            }
            if(a.getKey()<start && a.getValue() > end){
                return false;
            }
        }
        return true;
    }

    private static String other(String p){
        if(p.equals("J")){
            return "C";
        }else{
            return "J";
        }
    }
}
