    import java.util.*;
    import java.io.*;
    public class Solution {
        static class Interval {
            int start, end;
            int pos;
            String assignee = "";

            Interval(int start, int end, int i) {
                this.start = start;
                this.end = end;
                this.pos = i;
            }
        }
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        
        for (int k=1;k<=numCases;k++) {
            int numOfIntervals = in.nextInt();
            Interval C = null, J = null;
            List<Interval> intervals = new ArrayList<>();

            for (int i=0;i<numOfIntervals;i++) {
                intervals.add(new Interval(in.nextInt(), in.nextInt(), i));
            }

            boolean impossible = false;
            List<Interval> temp = new ArrayList<>(intervals);
            Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
            String res = "";

            for (int i=0;i<intervals.size();i++) {
                Interval curr = intervals.get(i);
                if (C == null || C.end <= curr.start) {
                    C = curr;
                    curr.assignee = "C";
                } else if (J == null || J.end <= curr.start) {
                    J = curr;
                    curr.assignee = "J";
                } else {
                    impossible = true;
                }
            }

            for (int i=0;i<temp.size();i++) {
                res += temp.get(i).assignee;
            }

            String answer = impossible ? "IMPOSSIBLE" : res;

            System.out.println("Case #" + k + ": " + answer);
        }
      }
    }
  