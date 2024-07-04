import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Map<Integer,Integer> timeMap = createArr(n,in);
            System.out.println("Case #" + i + ": " + solve(timeMap));;
        }
    }

    private static String solve(Map<Integer, Integer> timeMap) {
        String s = "";
        List<Integer> result = new ArrayList(timeMap.keySet());
        boolean isJFree = true ;
        boolean isCFree = true;
        int jFreeTime = Integer.MIN_VALUE ;
        int cFreeTime = Integer.MIN_VALUE ;
        result.addAll(timeMap.values());
        result = result.stream().sorted().collect(toList());
        for (Integer i : result){
            if (i.intValue() == jFreeTime){
                isJFree = true;
                jFreeTime = 0;
            }else if (cFreeTime == i.intValue()){
                isCFree = true;
                cFreeTime = 0;
            }else if (timeMap.containsKey(i)){
                if (isJFree){
                    isJFree = false;
                    jFreeTime = timeMap.get(i);
                    s += "J";
                }else if(isCFree){
                    isCFree = false;
                    cFreeTime = timeMap.get(i);
                    s += 'C';
                }else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return s;
    }

    private static Map<Integer,Integer> createArr(int n, Scanner in) {
        Map<Integer,Integer> timeMap = new HashMap<>(3);
        for (int j = 0; j < n; j++) {
            Integer key = in.nextInt();
            Integer value = in.nextInt();
            timeMap.put(key,value);
        }
        return timeMap;
    }
}