// "static void main" must be defined in a public class.

    import java.util.*;
    import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          
            int n = in.nextInt();
            StringBuffer out = new StringBuffer(n);
            out.setLength(n);
            Map<Integer, String> tasks = new TreeMap<>();
            
            for (int j = 0; j < n; j++) {
                tasks.put(in.nextInt(), in.nextInt() + ":" + j);
            }
            
            int p1 = 0, p2 = 0;
            
            for(Map.Entry<Integer, String> task : tasks.entrySet()) {
                int start = task.getKey();
                int end = Integer.parseInt(task.getValue().split(":")[0]);
                int location = Integer.parseInt(task.getValue().split(":")[1]);
                // System.out.println(start + " " + end + " " + p1 + " " + p2 + " " + out.length());
                if (p1 <= start) {
                    p1 = end;
                    out.insert(location, "C");
                } else if (p2 <= start) {
                    p2 = end;
                    out.insert(location, "J");
                } else {
                    out = new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + out.toString());
        }
      }
    }