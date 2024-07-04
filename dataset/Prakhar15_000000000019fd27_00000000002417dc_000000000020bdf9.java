// "static void main" must be defined in a public class.

    import java.util.*;
    import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          
            StringBuffer out = new StringBuffer();
            int n = in.nextInt();
            Map<Integer, Integer> tasks = new TreeMap<>();
            
            for (int j = 0; j < n; j++) {
                tasks.put(in.nextInt(), in.nextInt());
            }
            
            int p1 = 0, p2 = 0;
            
            for(Map.Entry<Integer, Integer> task : tasks.entrySet()) {
                int start = task.getKey();
                int end = task.getValue();
                if (p1 <= start) {
                    p1 = end;
                    out.append("C");
                } else if (p2 <= start) {
                    p2 = end;
                    out.append("J");
                } else {
                    out = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + out.toString());
        }
      }
    }