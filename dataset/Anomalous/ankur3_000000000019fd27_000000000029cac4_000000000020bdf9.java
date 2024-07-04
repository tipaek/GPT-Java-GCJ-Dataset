import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int totalCases = t;

        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Time> times = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                times.add(new Time(start, end));
            }

            times.sort(Comparator.comparingInt(time -> time.start));

            Time lastC = null;
            Time lastJ = null;
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (Time time : times) {
                if (lastC == null) {
                    lastC = time;
                    schedule.append('C');
                } else if (lastJ == null) {
                    lastJ = time;
                    schedule.append('J');
                } else {
                    if (time.start >= lastC.end) {
                        lastC = time;
                        schedule.append('C');
                    } else if (time.start >= lastJ.end) {
                        lastJ = time;
                        schedule.append('J');
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (totalCases - t) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (totalCases - t) + ": " + schedule.toString());
            }
        }
    }

    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}