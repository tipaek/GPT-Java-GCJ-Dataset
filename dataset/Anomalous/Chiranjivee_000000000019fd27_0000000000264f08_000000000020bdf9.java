import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;
        
        while (t-- > 0) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt(), i);
            }
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a.end, b.end));
            StringBuilder result = new StringBuilder();
            intervals[0].assignee = 'C';
            int firstOverlapIndex = 1;
            
            for (int i = 1; i < n; i++) {
                if (intervals[i].start < intervals[i - 1].end) {
                    firstOverlapIndex = i;
                    intervals[i].assignee = 'J';
                    break;
                } else {
                    intervals[i].assignee = intervals[i - 1].assignee;
                }
            }
            
            for (int i = firstOverlapIndex + 1; i < n; i++) {
                Interval currentInterval = intervals[i];
                
                for (int j = i - 1; j >= 0; j--) {
                    if (intervals[j].end <= currentInterval.start) {
                        currentInterval.assignee = intervals[j].assignee;
                        break;
                    }
                }
                
                if (currentInterval.assignee == 'x') {
                    result.append("IMPOSSIBLE");
                    break;
                }
            }
            
            if (result.toString().equals("IMPOSSIBLE")) {
                System.out.println("Case #" + caseNumber++ + ": " + result);
                continue;
            }
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a.originalIdx, b.originalIdx));
            for (Interval interval : intervals) {
                result.append(interval.assignee);
            }
            
            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }
}

class Interval {
    int start;
    int end;
    int originalIdx;
    char assignee = 'x';
    
    public Interval(int start, int end, int originalIdx) {
        this.start = start;
        this.end = end;
        this.originalIdx = originalIdx;
    }
}