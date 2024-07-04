import java.util.*;
import java.io.*;

public class Solution {

    private static boolean solved;

    private static void solve(Interval[] tasks, ArrayList<Interval> j, ArrayList<Interval> c, int i, int n, int t, String res) {
        /*
        Pseudocode:

        if we have reached task N + 1: we are done, print string, exit
        else: 
        can jamie do task i? If yes, run solve on task i + 1 with Jamie doing task i as well
        can cameron do task i? If yes, run solve on task i + 1 with cameron doing task i as well
        */
        if (i == n) {
            if (!solved) {
                System.out.println("Case #" + t + ": " + res);            
            }
            solved = true;
            return;
        }
        else {
            if (canDo(tasks[i], j)) {
                j.add(tasks[i]);
                solve(tasks, j, c, i+1, n, t, res+"J");
            }
            j.remove(tasks[i]);
            if (canDo(tasks[i], c)) {
                c.add(tasks[i]);
                solve(tasks, j, c, i+1, n, t, res+"C");
            }
            c.remove(tasks[i]);
        }
    }

    private static boolean canDo(Interval x, ArrayList<Interval> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            if (x.intersects(tasks.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int n = 0;
        for (int i = 1; i <= t; ++i) {
            n = in.nextInt();
            Interval[] tasks = new Interval[n];
            for (int j = 0; j < n; j++) {
                tasks[j] = new Interval(in.nextInt(), in.nextInt());
            }
            //Arrays.sort(tasks);
            ArrayList<Interval> j = new ArrayList<Interval>();
            ArrayList<Interval> c = new ArrayList<Interval>();
            String res = "IMPOSSIBLE";

            solved = false;
            solve(tasks, new ArrayList<Interval>(), new ArrayList<Interval>(), 0, n, i, "");
            if (!solved) {
                System.out.println("Case #" + i + ": " + res);
            }
        }

        in.close();
      }

      /*
      Stack<State> stack = new Stack<State>();
            State st = new State(0, "", j ,c);
            stack.add(st);
            while (!stack.isEmpty()) {
                st = stack.pop();
                if (st.i == n) {
                    res = st.s;
                    break;
                }
                else {
                    if (canDo(tasks[st.i], st.j)) {
                        st.j.add(tasks[st.i]);
                        stack.add(new State(st.i+1, st.s+"J", st.j, st.c));
                    }
                    st.j.remove(tasks[st.i]);
                    
                    if (canDo(tasks[st.i], st.c)) {
                        st.c.add(tasks[st.i]);
                        stack.add(new State(st.i+1, st.s+"C", st.j, st.c));
                    }
                    st.c.remove(tasks[st.i]);
                }
            }

      */
      private static class State
      {
          int i;
          String s;
          ArrayList<Interval> j, c;

          public State(int i, String s, ArrayList<Interval> j, ArrayList<Interval> c) {
              this.i = i;
              this.s = s;
              this.j = j;
              this.c = c;
          }
      }
      private static class Interval implements Comparable<Interval>{
          int start, end;

          public Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }

          public boolean intersects (Interval ot) {
            if (this.start < ot.start && this.end > ot.start) 
            {
                return true;
            }
            if (this.start >= ot.start && this.start < ot.end) 
            {
                return true;
            }
            return false;
          }

        public int compareTo(Interval ot) {
            return this.start - ot.start;
        }
    }
}