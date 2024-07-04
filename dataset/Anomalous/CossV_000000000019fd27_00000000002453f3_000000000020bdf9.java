import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfIntervals = Integer.parseInt(scanner.nextLine().trim());
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < numberOfIntervals; i++) {
                String[] intervalData = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalData[0]);
                int end = Integer.parseInt(intervalData[1]);
                intervals.add(new Interval(start, end, i));
            }
            
            Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
            
            int cameronEnd = 0;
            int jamieEnd = 0;
            char[] assignments = new char[numberOfIntervals];
            boolean possible = true;

            for (Interval interval : intervals) {
                if (interval.start >= cameronEnd) {
                    assignments[interval.index] = 'C';
                    cameronEnd = interval.end;
                } else if (interval.start >= jamieEnd) {
                    assignments[interval.index] = 'J';
                    jamieEnd = interval.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + new String(assignments));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    static class Interval {
        int start;
        int end;
        int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}