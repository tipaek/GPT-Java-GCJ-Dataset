import static java.util.Collections.sort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
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
            System.out.println("Case #" + i + ": " +  solve(n,in));;
        }
    }

    private static String  solve(int n, Scanner in) {
        Map<LocalTime,LocalTime> timeMap = new LinkedHashMap<>(n);
        List<LocalTime> localTimeList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            LocalTime key = createLocalTime(in.nextInt());
            LocalTime value = createLocalTime(in.nextInt());
            timeMap.put(key,value);
            localTimeList.add(key);
            localTimeList.add(value);
        }
        sort(localTimeList);
        return compute(localTimeList,timeMap);
    }

    private static String compute(List<LocalTime> localTimeList, Map<LocalTime, LocalTime> timeMap) {
        String s = "";
        boolean isJFree = true ;
        boolean isCFree = true;
        LocalTime jFreeTime = null;
        LocalTime cFreeTime = null;
        Map<LocalTime,String> result = new HashMap<>();
        for (LocalTime i : localTimeList){
            if (i.equals(jFreeTime)){
                isJFree = true;
                jFreeTime = null;
            }else if (i.equals(cFreeTime)){
                isCFree = true;
                cFreeTime =null;
            }else if (timeMap.containsKey(i)){
                if(isCFree){
                    isCFree = false;
                    cFreeTime = timeMap.get(i);
                    result.put(i , "C");
                }else if (isJFree){
                    isJFree = false;
                    jFreeTime = timeMap.get(i);
                    result.put(i , "J");
                }else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return timeMap.keySet().stream()
                      .map(key -> result.get(key)).collect(Collectors.joining());
    }

    private static LocalTime createLocalTime(int value) {
        int hour = value/60;
        int minute = value % 60;
        if(hour == 24){
            hour = 23;
            minute = 59;
        }
        return LocalTime.of(hour,minute);
    }
}