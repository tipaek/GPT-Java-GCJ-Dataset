import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int q = 1; q <= t; ++q) {
      int n = in.nextInt();
      Task[] tasks = new Task[n];
      for(int i = 0; i < n; i++) {
        tasks[i] = new Task();
        tasks[i].s = in.nextInt();
        tasks[i].e = in.nextInt();
        tasks[i].order = i;
        tasks[i].assignment = "";
      }
        Arrays.sort(tasks, new Comparator<Task>() {
           @Override
           public int compare(Task p1, Task p2) {
               return ((Integer)p1.s).compareTo(p2.s);
           }
        });
        
        boolean possible = true;
        int cuntil = 0;
        int juntil = 0;
        for (Task ta : tasks) {
            if(ta.s >= cuntil) {
                ta.assignment = "C";
                cuntil = ta.e;
            } else if (ta.s >= juntil) {
                ta.assignment = "J";
                juntil = ta.e;
            } else {
                possible = false;
            }
        }
      
        Arrays.sort(tasks, new Comparator<Task>() {
           @Override
           public int compare(Task p1, Task p2) {
               return ((Integer)p1.order).compareTo(p2.order);
           }
        });
        
        if(!possible) {
      System.out.println("Case #" + q + ": " + "IMPOSSIBLE");
        } else {
            String ret = "";
            for (Task ta : tasks) {
                ret = ret + ta.assignment;
            }
            System.out.println("Case #" + q + ": " + ret);
        }
      

    }
  }
}

class Task
{
    public int s;
    public int e;
    public String assignment;
    public int order;
}