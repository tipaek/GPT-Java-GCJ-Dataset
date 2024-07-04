import  java.util.Scanner;
import  java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static void main(String[]  args) {
        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        int c = 1;
        while (t-- > 0) {

            int n = sc.nextInt();
            Interval [] intervals= new Interval[n];
            for (int i = 0; i < n; i++)  {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(),  i);
            }

            Arrays.sort(intervals, (a, b) -> a.start - b.start);
            StringBuilder result = new StringBuilder();
            List<Interval> jTask = new ArrayList<>();
            List<Interval> cTask = new ArrayList<>();

            for (Interval interval : intervals) {
                if (jTask.isEmpty()) {
                    jTask.add(interval);
                    interval.assignee = 'J';
                    continue;
                } else if (cTask.isEmpty()) {
                    cTask.add(interval);
                    interval.assignee = 'C';
                    continue;
                }

                if (jTask.get(jTask.size() - 1).end <= interval.start) {
                    jTask.add(interval);
                    interval.assignee = 'J';
                } else if (cTask.get(cTask.size() - 1).end <= interval.start) {
                    cTask.add(interval);
                    interval.assignee = 'C';
                } else {
                    result.append("IMPOSSIBLE");
                    break;
                }
            }


            if (result.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + c++ + ": " + result.toString());
                continue;
            }

            Arrays.sort(intervals, (a,  b) -> a.originalIdx  - b.originalIdx);
            for (int i =  0; i < intervals.length;  i++) {
                result.append(intervals[i].assignee);
            }
            System.out.println("Case #" + c++ + ": " + result.toString());
        }
    }
}

class Interval {
    int start;
    int end;
    int originalIdx;
    char assignee =  'x';
    public Interval(int start, int end, int  originalIdx) {
        this.start = start;
        this.end =  end;
        this.originalIdx = originalIdx;
    }
}