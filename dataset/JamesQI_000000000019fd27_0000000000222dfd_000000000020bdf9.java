import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList();
      for (int ni = 0; ni < n; ni++) {
          int start = in.nextInt();
          int end = in.nextInt();
          list.add(new AbstractMap.SimpleEntry(start, end));
        }
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> t1, Map.Entry<Integer, Integer> t2) {
                return t1.getKey() - t2.getKey();
            }
        });

       System.out.println("Case #" + i + ": " + calculate(list));
    }
  }
  
  public static String calculate(ArrayList<Map.Entry<Integer, Integer>> list) {
        Map<String, Integer> schedule = new HashMap<>();
        String j = "J";
        String c = "C";
        schedule.put(j, -1);
        schedule.put(c, -1);
        String ans = "";
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            Integer jTime = schedule.get(j);
            Integer cTime = schedule.get(c);
            if (cTime <= entry.getKey()) {
                schedule.put(c, entry.getValue());
                ans += c;
            } else if (jTime <= entry.getKey()) {
                schedule.put(j, entry.getValue());
                ans += j;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return ans;
    }

  
} 