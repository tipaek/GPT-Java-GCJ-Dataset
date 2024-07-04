import  java.util.Scanner;
import  java.util.Arrays;

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

            Arrays.sort(intervals, (a, b) -> a.end - b.end);
            StringBuilder result = new StringBuilder();
            intervals[0].assignee = 'C';
            int firstOverlapIdx = 1;
            for (int i = 1; i < n; i++) {
                if (intervals[i].start < intervals[i -  1].end) {
                    firstOverlapIdx = i;
                    intervals[i].assignee = 'J';
                    break;
                } else {
                    intervals[i].assignee = intervals[i - 1].assignee;
                }
            }

            for (int i = firstOverlapIdx + 1; i < n; i++) {
                Interval interval = intervals[i];

                // go back in the interval list and see if we can allocate
                for (int j = i - 1; j >= 0; j--) {
                    // find the first interval with which current
                    // doesnt overlap
                    if (intervals[j].end <= interval.start) {
                        interval.assignee = intervals[j].assignee;
                        break;
                    }
                }

                if (interval.assignee == 'x') {
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