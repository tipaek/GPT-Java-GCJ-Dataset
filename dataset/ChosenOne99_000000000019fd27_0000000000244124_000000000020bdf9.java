import java.util.*;
import java.io.*;
import java. util. Collection;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc
    for (int p = 1; p <= t; p++) {
        int number = in.nextInt();
        String answer = "";
        boolean impossible = false;
        Map<Integer, Integer> jmap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> cmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < number; i++) {
            int count = 0;
            int start = in.nextInt();
            int end = in.nextInt();
            for (int time : jmap.keySet()) {
                if ((start < time && time < end) || (start == time) || (start > time && start < jmap.get(time))) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                jmap.put(start, end);
                answer += "J";
            } else {
                for (int times : cmap.keySet()) {
                    if ((start < times && times < end)|| (start == times) || (start > times && start < cmap.get(times))) {
                        count++;
                        break;
                    }
                }
                if (count == 1) {
                    cmap.put(start, end);
                    answer += "C";
                }
                if (count == 2) {
                    impossible = true;
                }
            }
    
        }
        if (impossible) {
            answer = "IMPOSSIBLE";
        }
        System.out.println("Case #" + p + ": " + answer);
    }
 }
}