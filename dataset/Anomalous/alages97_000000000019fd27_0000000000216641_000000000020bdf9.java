import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int intervalsCount = sc.nextInt();
            List<TimeInterval> intervals = new ArrayList<>();
            
            for (int i = 0; i < intervalsCount; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new TimeInterval(start, end, i));
            }

            Collections.sort(intervals);
            StringBuilder result = new StringBuilder();
            List<Assignment> assignments = new ArrayList<>();
            int cEndTime = 0;
            int jEndTime = 0;
            boolean isPossible = true;

            for (TimeInterval interval : intervals) {
                if (interval.start >= cEndTime) {
                    assignments.add(new Assignment(interval.id, "C"));
                    cEndTime = interval.end;
                } else if (interval.start >= jEndTime) {
                    assignments.add(new Assignment(interval.id, "J"));
                    jEndTime = interval.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                Collections.sort(assignments);
                for (Assignment assignment : assignments) {
                    result.append(assignment.person);
                }
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }
}

class TimeInterval implements Comparable<TimeInterval> {
    int start;
    int end;
    int id;

    TimeInterval(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(TimeInterval other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }
}

class Assignment implements Comparable<Assignment> {
    int id;
    String person;

    Assignment(int id, String person) {
        this.id = id;
        this.person = person;
    }

    @Override
    public int compareTo(Assignment other) {
        return this.id - other.id;
    }
}