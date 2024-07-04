import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                TimeSpan[] tasks = new TimeSpan[n];

                for (int i = 0; i < n; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    tasks[i] = new TimeSpan(start, end);
                }

                TimeSpan[] sortedTasks = tasks.clone();
                Arrays.sort(sortedTasks);

                int lastC = 0;
                sortedTasks[lastC].assignedTo = "C";
                for (int i = 1; i < n; i++) {
                    if (!sortedTasks[lastC].overlaps(sortedTasks[i])) {
                        lastC = i;
                        sortedTasks[lastC].assignedTo = "C";
                    }
                }

                boolean impossible = false;
                int lastJ = -1;
                for (int i = 0; i < n; i++) {
                    if (sortedTasks[i].assignedTo.equals("J")) {
                        if (lastJ < 0) {
                            lastJ = i;
                        } else if (sortedTasks[lastJ].overlaps(sortedTasks[i])) {
                            impossible = true;
                            break;
                        }
                    }
                }

                String result;
                if (impossible) {
                    result = "IMPOSSIBLE";
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (TimeSpan task : tasks) {
                        sb.append(task.assignedTo);
                    }
                    result = sb.toString();
                }

                System.out.println(String.format("Case #%d: %s", t, result.trim()));
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
        }
    }

    static class TimeSpan implements Comparable<TimeSpan> {
        final int start;
        final int end;
        String assignedTo = "J";

        TimeSpan(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeSpan other) {
            return Integer.compare(this.start, other.start);
        }

        boolean overlaps(TimeSpan other) {
            return (this.start < other.end && this.end > other.start);
        }
    }
}