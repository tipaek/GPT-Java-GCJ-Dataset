import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int activityCount = in.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            TreeMap<Integer,Integer> activityMap = new TreeMap<>();
            for (int j = 0; j < activityCount; j++){
                int currentActivityStart = in.nextInt();
                int currentActivityEnd = in.nextInt();
                activityMap.put(currentActivityStart, currentActivityEnd);
            }

            int cActivityEnd = 0;
            int jActivityEnd = 0;

            while (activityMap.entrySet().size() != 0){

               Map.Entry<Integer, Integer> entry = activityMap.pollFirstEntry();

               if (cActivityEnd <= entry.getKey()){
                   cActivityEnd =  entry.getValue();
                   stringBuilder.append("C");
               } else if (jActivityEnd <= entry.getKey()) {
                   jActivityEnd =  entry.getValue();
                   stringBuilder.append("J");
               }else {
                   stringBuilder.replace(0, stringBuilder.length(), "IMPOSSIBLE");
                   break;
               }

            }


            System.out.println("Case #" + i + ": " + (stringBuilder.toString()));
        }
    }
}