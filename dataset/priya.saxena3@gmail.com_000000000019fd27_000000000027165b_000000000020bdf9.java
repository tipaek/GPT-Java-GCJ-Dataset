import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        List<Integer> list = new ArrayList(timeMap.keySet());
        boolean isJFree = true ;
        boolean isCFree = true;
        int jFreeTime = Integer.MIN_VALUE ;
        int cFreeTime = Integer.MIN_VALUE ;
        list.addAll(timeMap.values());
        list = list.stream().sorted().collect(toList());
        Map<Integer,String> result = new HashMap<>();
        for (Integer i : list){
            if (i.intValue() == jFreeTime){
                isJFree = true;
                jFreeTime = Integer.MIN_VALUE;
            }else if (cFreeTime == i.intValue()){
                isCFree = true;
                cFreeTime = Integer.MIN_VALUE;
            }else if (timeMap.containsKey(i)){
                if (isJFree){
                    isJFree = false;
                    jFreeTime = timeMap.get(i);
                    result.put(i , "J");
                }else if(isCFree){
                    isCFree = false;
                    cFreeTime = timeMap.get(i);
                    result.put(i , "C");
                }else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return timeMap.keySet().stream()
            .map(key -> result.get(key)).collect(Collectors.joining());
    }

    private static Map<Integer,Integer> createArr(int n, Scanner in) {
        Map<Integer,Integer> timeMap = new LinkedHashMap<>(n);
        for (int j = 0; j < n; j++) {
            Integer key = in.nextInt();
            Integer value = in.nextInt();
            timeMap.put(key,value);
        }
        return timeMap;
    }
}
