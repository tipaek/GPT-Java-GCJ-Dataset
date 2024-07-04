import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static class Entry implements Comparable<Entry> {
        int start;
        int end;
        int index;

        public Entry(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            boolean isImpossible = false;
            int activitiesCount = scanner.nextInt();
            String[] assignments = new String[activitiesCount];
            PriorityQueue<Entry> activityQueue = new PriorityQueue<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activityQueue.add(new Entry(start, end, i));
            }

            String currentAssignment = "C";
            Entry currentActivity = activityQueue.poll();
            int currentEndTime = currentActivity.end;
            assignments[currentActivity.index] = currentAssignment;

            while (!activityQueue.isEmpty()) {
                Entry nextActivity = activityQueue.poll();

                if (nextActivity.start >= currentEndTime) {
                    currentEndTime = nextActivity.end;
                    assignments[nextActivity.index] = currentAssignment;
                } else {
                    if (!activityQueue.isEmpty() && activityQueue.peek().start < nextActivity.end) {
                        isImpossible = true;
                        break;
                    } else {
                        currentAssignment = toggleAssignment(currentAssignment);
                        currentEndTime = nextActivity.end;
                        assignments[nextActivity.index] = currentAssignment;
                        currentAssignment = toggleAssignment(currentAssignment);
                    }
                }
            }

            if (isImpossible) {
                resultBuilder.append("IMPOSSIBLE\n");
            } else {
                for (String assignment : assignments) {
                    resultBuilder.append(assignment);
                }
                resultBuilder.append("\n");
            }
        }

        System.out.print(resultBuilder.toString());
    }

    private static String toggleAssignment(String assignment) {
        return assignment.equals("C") ? "J" : "C";
    }
}