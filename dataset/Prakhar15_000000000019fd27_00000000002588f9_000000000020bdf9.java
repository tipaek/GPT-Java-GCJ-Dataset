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
            PriorityQueue<String> tasks = new PriorityQueue<String>(new TaskComparator()); 
            
            for (int j = 0; j < n; j++) {
                tasks.add(in.nextInt() + ":" + in.nextInt() + ":" + j);
            }
            
            int p1 = 0, p2 = 0;
            
            while(!tasks.isEmpty()) {
                String task = tasks.poll();
            
                int start = Integer.parseInt(task.split(":")[0]);
                int end = Integer.parseInt(task.split(":")[1]);
                int location = Integer.parseInt(task.split(":")[2]);
                
                // System.out.println(start + " " + end + " " + p1 + " " + p2);
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

    class TaskComparator implements Comparator<String> { 
        public int compare(String task1, String task2) { 
            int start1 = Integer.parseInt(task1.split(":")[0]);
            int start2 = Integer.parseInt(task2.split(":")[0]);
            return Integer.compare(start1, start2); 
        } 
    } 