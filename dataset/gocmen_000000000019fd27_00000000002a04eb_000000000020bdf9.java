
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activityCount = in.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            boolean isImpossible = false;
            TreeMap<Integer, List<AbstractMap.SimpleEntry<Integer,Integer>>> activityMap = new TreeMap<>();
            for (int j = 0; j < activityCount; j++){
                int currentActivityStart = in.nextInt();
                int currentActivityEnd = in.nextInt();
                if (activityMap.get(currentActivityStart) != null) {
                    if (activityMap.get(currentActivityStart).size() >= 2)
                        isImpossible = true;
                    else {
                        List<AbstractMap.SimpleEntry<Integer, Integer>> newEntries = new ArrayList<>();
                        newEntries.add(activityMap.get(currentActivityStart).get(0));
                        newEntries.add(new TreeMap.SimpleEntry<>(currentActivityEnd, j));
                        activityMap.replace(currentActivityStart, newEntries);
                    }
                }
                else
                    activityMap.put(currentActivityStart, Collections.singletonList(new TreeMap.SimpleEntry<>(currentActivityEnd,j)));
            }

            int cActivityEnd = 0;
            int jActivityEnd = 0;
            String[] sequence = new String[activityCount];

            while (activityMap.entrySet().size() != 0 && !isImpossible){

                Map.Entry<Integer, List<AbstractMap.SimpleEntry<Integer,Integer>>> entry = activityMap.pollFirstEntry();
                if (entry.getValue().size() > 1)
                    activityMap.put(entry.getKey(),Collections.singletonList(entry.getValue().get(1)));

                if (cActivityEnd <= entry.getKey()){
                    cActivityEnd =  entry.getValue().get(0).getKey();
                    sequence[entry.getValue().get(0).getValue()] = "C";
                } else if (jActivityEnd <= entry.getKey()) {
                    jActivityEnd =  entry.getValue().get(0).getKey();
                    sequence[entry.getValue().get(0).getValue()] = "J";
                }else {
                    isImpossible = true;
                }
            }

            if (! isImpossible)
                for (int index = 0; index < sequence.length; index++)
                    stringBuilder.append(sequence[index]);
            else
                stringBuilder.replace(0, stringBuilder.length(), "IMPOSSIBLE");

            System.out.println("Case #" + i + ": " + (stringBuilder.toString()));
        }
    }
}

