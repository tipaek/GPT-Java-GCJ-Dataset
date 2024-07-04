import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));
            
            ArrayList<Character> schedule = new ArrayList<>();
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;
            
            for (Interval interval : intervals) {
                if (interval.start >= cameronEnd) {
                    schedule.add('C');
                    cameronEnd = interval.end;
                } else if (interval.start >= jamieEnd) {
                    schedule.add('J');
                    jamieEnd = interval.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            if (possible) {
                for (char ch : schedule) {
                    System.out.print(ch);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}