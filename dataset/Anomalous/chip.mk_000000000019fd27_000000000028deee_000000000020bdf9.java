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
            int testCaseCount = scanner.nextInt();

            for (int t = 1; t <= testCaseCount; t++) {
                int n = scanner.nextInt();
                TimeSpan[] originalTasks = new TimeSpan[n];
                TimeSpan[] sortedTasks = new TimeSpan[n];

                for (int i = 0; i < n; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    originalTasks[i] = new TimeSpan(start, end);
                    sortedTasks[i] = originalTasks[i];
                }

                Arrays.sort(sortedTasks);

                int lastCIndex = 0;
                sortedTasks[lastCIndex].assignedTo = "C";
                for (int i = 1; i < n; i++) {
                    if (!sortedTasks[lastCIndex].overlaps(sortedTasks[i])) {
                        lastCIndex = i;
                        sortedTasks[lastCIndex].assignedTo = "C";
                    }
                }

                boolean isImpossible = false;
                int lastJIndex = -1;
                for (int i = 0; i < n; i++) {
                    if (sortedTasks[i].assignedTo.equals("J")) {
                        if (lastJIndex < 0) {
                            lastJIndex = i;
                        } else if (sortedTasks[lastJIndex].overlaps(sortedTasks[i])) {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                String answer;
                if (isImpossible) {
                    answer = "IMPOSSIBLE";
                } else {
                    StringBuilder result = new StringBuilder();
                    for (TimeSpan task : originalTasks) {
                        result.append(task.assignedTo);
                    }
                    answer = result.toString();
                }

                System.out.printf("Case #%d: %s%n", t, answer);
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle the exception as needed
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
            return (this.start < other.end && other.start < this.end);
        }
    }
}