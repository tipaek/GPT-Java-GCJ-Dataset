import java.util.*;
import java.io.*;
import java. util. Collection;
import java.util.TreeSet; 

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc
    for (int p = 1; p <= t; p++) {
        int number = in.nextInt();
        String answer = "";
        int start;
        int end;
        TreeMap<Integer, Integer> temp = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> temp2 = new TreeMap<Integer, Integer>();
        for (int i = 0; i < number; i++) {
            start = in.nextInt();
            end = in.nextInt();
            if (!temp.containsKey(start)) {
                temp.put(start, end);
            } else if (!temp2.containsKey(start)) {
                temp2.put(start, end);
            } else {
                answer = "IMPOSSIBLE";
            }
        }
        Map<Integer, Integer> jmap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cmap = new HashMap<Integer, Integer>();
        while (answer != "IMPOSSIBLE" && (!temp.isEmpty() || !temp2.isEmpty())) {
            if (temp.isEmpty()) {
                start = temp2.firstKey();
                end = temp2.get(temp2.firstKey());
                temp2.remove(start);
            } else if (temp2.isEmpty()) {
                start = temp.firstKey();
                end = temp.get(temp.firstKey());
                temp.remove(start);
            } else if (temp.firstKey() <= temp2.firstKey()) {
                start = temp.firstKey();
                end = temp.get(temp.firstKey());
                temp.remove(start);
            } else {
                start = temp2.firstKey();
                end = temp2.get(temp2.firstKey());
                temp2.remove(start);
            }
            int count = 0;
            for (int time : jmap.keySet()) {
                if ((start < time && time < end) || (start == time) || (start > time && start < jmap.get(time))) {
                    count = 1;
                    break;
                }
            }
            if (count == 0) {
                jmap.put(start, end);
                answer += "C";
            } else {
                for (int times : cmap.keySet()) {
                    if ((start < times && times < end)|| (start == times) || (start > times && start < cmap.get(times))) {
                        count++;
                        break;
                    }
                }
                if (count == 1) {
                    cmap.put(start, end);
                    answer += "J";
                }
                if (count == 2) {
                    answer = "IMPOSSIBLE";
                }
            }
        }
        System.out.println("Case #" + p + ": " + answer);
    }
 }
}