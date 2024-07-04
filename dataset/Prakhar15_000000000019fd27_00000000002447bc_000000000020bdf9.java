// "static void main" must be defined in a public class.

    import java.util.*;
    import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          
            int n = in.nextInt();
            char out[] = new char[n];
            Map<Integer, String> tasks = new TreeMap<>();
            
            for (int j = 0; j < n; j++) {
                tasks.put(in.nextInt(), in.nextInt() + ":" + j);
            }
            
            int p1 = 0, p2 = 0;
            
            for(Map.Entry<Integer, String> task : tasks.entrySet()) {
                int start = task.getKey();
                int end = Integer.parseInt(task.getValue().split(":")[0]);
                int location = Integer.parseInt(task.getValue().split(":")[1]);
                if (p1 <= start) {
                    p1 = end;
                    out[location] = 'C';
                } else if (p2 <= start) {
                    p2 = end;
                    out[location] = 'J';
                } else {
                    out = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            
            StringBuffer output = new StringBuffer();
            for (int j = 0; j < out.length; j++) {
                output.append(out[j]);
            }
            
            System.out.println("Case #" + i + ": " + output.toString());
        }
      }
    }