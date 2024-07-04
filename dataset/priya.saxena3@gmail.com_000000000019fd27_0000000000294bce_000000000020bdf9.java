import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Map<Integer,Integer> schedule = createMap(n,in);
            System.out.println("Case #" + i + ": " +  solve(schedule));;
        }
    }

    private static String solve(Map<Integer, Integer> schedule) {
        StringBuilder s = new StringBuilder();
        List<Integer> JUsedSlot = new ArrayList<>();
        List<Integer> CUsedSlot = new ArrayList<>();
        for (Integer i : schedule.keySet()){
            boolean isJFree = isThereAnyFreeSlot(JUsedSlot,schedule,i);
            if (isJFree) {
                s.append("J");
                JUsedSlot.add(i);
            }
            else  if (isThereAnyFreeSlot(CUsedSlot,schedule,i)) {
                s.append("C");
                CUsedSlot.add(i);
            }
            else
                return "IMPOSSIBLE";
        }
        return s.toString();
    }

    private static boolean isThereAnyFreeSlot(List<Integer> jUsedSlot, Map<Integer, Integer> schedule,Integer startTime) {
        Integer endTime = schedule.get(startTime);
        boolean result = true;
        for (Integer currentUsedStartTime : jUsedSlot){
            Integer currentUsedEndTime = schedule.get(currentUsedStartTime);
            if( (startTime < currentUsedStartTime || startTime >= currentUsedEndTime) &&
                (endTime <= currentUsedStartTime || endTime > currentUsedEndTime))
                result = true;
            else
                result = false;
        }
        return result;
    }

    private static Map<Integer, Integer> createMap(int n, Scanner in) {
        Map<Integer,Integer> schedule = new LinkedHashMap<>();
        for (int j = 0; j < n; j++) {
            int key = in.nextInt();
            int value = in.nextInt();
            schedule.put(key, value);
        }
        return schedule ;
    }
}