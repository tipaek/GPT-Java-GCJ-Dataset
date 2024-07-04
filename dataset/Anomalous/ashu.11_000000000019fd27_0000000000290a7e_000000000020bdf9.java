import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	
	public static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
	}
	
	public static boolean isOverlapping(Interval a, Interval b) {
		return Math.min(a.end, b.end) > Math.max(a.start, b.start);
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
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Interval interval = new Interval(start, end);
                boolean assigned = false;

                if (possible) {
                    ArrayList<Interval> cSchedule = schedule.get('C');
                    if (canAssign(cSchedule, interval)) {
                        cSchedule.add(interval);
                        result.append('C');
                        assigned = true;
                    } else {
                        ArrayList<Interval> jSchedule = schedule.get('J');
                        if (canAssign(jSchedule, interval)) {
                            jSchedule.add(interval);
                            result.append('J');
                            assigned = true;
                        }
                    }

                    if (!assigned) {
                        possible = false;
                    }
                }
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }

    private static boolean canAssign(ArrayList<Interval> schedule, Interval interval) {
        for (Interval existingInterval : schedule) {
            if (isOverlapping(existingInterval, interval)) {
                return false;
            }
        }
        return true;
    }
}