import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      ArrayList<Map.Entry<Map.Entry<Integer, Integer>,Integer>> list = new ArrayList();
      for (int ni = 0; ni < n; ni++) {
          int start = in.nextInt();
          int end = in.nextInt();
          list.add(new AbstractMap.SimpleEntry(new AbstractMap.SimpleEntry(start, end),ni));
        }
        Collections.sort(list, new Comparator<Map.Entry<Map.Entry<Integer, Integer>, Integer>>() {
            @Override
            public int compare(Map.Entry<Map.Entry<Integer, Integer>, Integer> t1,
                               Map.Entry<Map.Entry<Integer, Integer>, Integer> t2) {
                return t1.getKey().getKey() - t2.getKey().getKey();
            }
        });
       System.out.println("Case #" + i + ": " + calculate(list));
    }
  }
  
      public static String calculate(
            ArrayList<Map.Entry<Map.Entry<Integer, Integer>, Integer>> list) {
        char[] ansArray = new char[list.size()];
        String j = "J";
        String c = "C";
        Integer jTime = 0;
        Integer cTime = 0;

        Map<Map.Entry<Integer, Integer>, String> ans = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Map.Entry<Integer, Integer>, Integer> entry = list.get(i);
            Map.Entry<Integer, Integer> timeEntry = entry.getKey();
            if (cTime <= timeEntry.getKey()) {
                cTime = timeEntry.getValue();
                ansArray[entry.getValue()] = 'J';
            } else if (jTime <= timeEntry.getKey()) {
                jTime = timeEntry.getValue();
                ansArray[entry.getValue()] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(ansArray);
    }
} 