import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LetsStart {

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval [start=" + start + ", end=" + end + "]";
        }
    }

    public static boolean isOverlapping(Interval a, Interval b) {
        if (Math.min(a.end, b.end) <= Math.max(a.start, b.start)) {
            System.out.println("Intervals not overlapping: " + a + " and " + b);
            return false;
        }
        System.out.println("Intervals overlapping: " + a + " and " + b);
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            HashMap<Character, ArrayList<Interval>> schedule = new HashMap<>();
            schedule.put('C', new ArrayList<>());
            schedule.put('J', new ArrayList<>());

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Interval interval = new Interval(start, end);

                if (schedule.get('C').isEmpty()) {
                    schedule.get('C').add(interval);
                    result.append('C');
                } else if (schedule.get('J').isEmpty()) {
                    schedule.get('J').add(interval);
                    result.append('J');
                } else {
                    boolean canAssignToC = true;
                    for (Interval existingInterval : schedule.get('C')) {
                        if (isOverlapping(existingInterval, interval)) {
                            canAssignToC = false;
                            break;
                        }
                    }

                    if (canAssignToC) {
                        schedule.get('C').add(interval);
                        result.append('C');
                    } else {
                        boolean canAssignToJ = true;
                        for (Interval existingInterval : schedule.get('J')) {
                            if (isOverlapping(existingInterval, interval)) {
                                canAssignToJ = false;
                                break;
                            }
                        }

                        if (canAssignToJ) {
                            schedule.get('J').add(interval);
                            result.append('J');
                        } else {
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }

        scanner.close();
    }
}