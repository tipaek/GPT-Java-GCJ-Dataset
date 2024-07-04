
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activityCount = in.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            TreeMap<Integer, AbstractMap.SimpleEntry<Integer,Integer>> activityMap = new TreeMap<>();
            for (int j = 0; j < activityCount; j++){
                int currentActivityStart = in.nextInt();
                int currentActivityEnd = in.nextInt();
                activityMap.put(currentActivityStart, new TreeMap.SimpleEntry<>(currentActivityEnd,j));
            }

            int cActivityEnd = 0;
            int jActivityEnd = 0;
            boolean isImpossible = false;
            String[] sequence = new String[activityMap.entrySet().size()];

            while (activityMap.entrySet().size() != 0){

               Map.Entry<Integer, AbstractMap.SimpleEntry<Integer,Integer>> entry = activityMap.pollFirstEntry();

               if (cActivityEnd <= entry.getKey()){
                   cActivityEnd =  entry.getValue().getKey();
                   sequence[entry.getValue().getValue()] = "C";
               } else if (jActivityEnd <= entry.getKey()) {
                   jActivityEnd =  entry.getValue().getKey();
                   sequence[entry.getValue().getValue()] = "J";
               }else {
                   stringBuilder.replace(0, stringBuilder.length(), "IMPOSSIBLE");
                   isImpossible = true;
                   break;
               }
            }

            if (! isImpossible)
                for (int index = 0; index < sequence.length; index++)
                    stringBuilder.append(sequence[index]);

            System.out.println("Case #" + i + ": " + (stringBuilder.toString()));
        }
    }
}

