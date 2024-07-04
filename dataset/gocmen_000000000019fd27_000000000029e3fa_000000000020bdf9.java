
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activityCount = in.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            TreeMap<Integer, List<AbstractMap.SimpleEntry<Integer,Integer>>> activityMap = new TreeMap<>();
            for (int j = 0; j < activityCount; j++){
                int currentActivityStart = in.nextInt();
                int currentActivityEnd = in.nextInt();
                if (activityMap.get(currentActivityStart) != null)
                    activityMap.get(currentActivityStart).add(new TreeMap.SimpleEntry<>(currentActivityEnd,j));
                else
                    activityMap.put(currentActivityStart, List.of(new TreeMap.SimpleEntry<>(currentActivityEnd,j)));
            }

            int cActivityEnd = 0;
            int jActivityEnd = 0;
            boolean isImpossible = false;
            String[] sequence = new String[activityMap.entrySet().size()];

            while (activityMap.entrySet().size() != 0 && !isImpossible){

               Map.Entry<Integer, List<AbstractMap.SimpleEntry<Integer,Integer>>> entry = activityMap.pollFirstEntry();
               if (entry.getValue().size() > 1)
                   activityMap.put(entry.getKey(),List.of(entry.getValue().get(1)));

               if (cActivityEnd <= entry.getKey()){
                   cActivityEnd =  entry.getValue().get(0).getKey();
                   sequence[entry.getValue().get(0).getValue()] = "C";
               } else if (jActivityEnd <= entry.getKey()) {
                   jActivityEnd =  entry.getValue().get(0).getKey();
                   sequence[entry.getValue().get(0).getValue()] = "J";
               }else {
                   stringBuilder.replace(0, stringBuilder.length(), "IMPOSSIBLE");
                   isImpossible = true;
               }
            }

            if (! isImpossible)
                for (int index = 0; index < sequence.length; index++)
                    stringBuilder.append(sequence[index]);

            System.out.println("Case #" + i + ": " + (stringBuilder.toString()));
        }
    }
}

