import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static class Entry implements Comparable<Entry> {
        int time;
        int status;
        int index;

        public Entry(int time, int status, int index) {
            this.time = time;
            this.status = status;
            this.index = index;
        }

        @Override
        public int compareTo(Entry other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return Integer.compare(this.status, other.status);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            boolean isImpossible = false;
            int activityCount = scanner.nextInt();
            String[] assignments = new String[activityCount];

            ArrayList<Integer> cameronActivities = new ArrayList<>();
            ArrayList<Integer> jamieActivities = new ArrayList<>();
            PriorityQueue<Entry> events = new PriorityQueue<>();

            for (int i = 0; i < activityCount; i++) {
                events.add(new Entry(scanner.nextInt(), 1, i));
                events.add(new Entry(scanner.nextInt(), -1, i));
            }

            while (!events.isEmpty()) {
                Entry currentEvent = events.poll();
                if (currentEvent.status == -1) {
                    if (!cameronActivities.remove((Integer) currentEvent.index)) {
                        jamieActivities.remove((Integer) currentEvent.index);
                        assignments[currentEvent.index] = "J";
                    } else {
                        assignments[currentEvent.index] = "C";
                    }
                } else {
                    if (cameronActivities.size() == 1) {
                        if (jamieActivities.size() == 1) {
                            isImpossible = true;
                            break;
                        } else {
                            jamieActivities.add(currentEvent.index);
                        }
                    } else {
                        cameronActivities.add(currentEvent.index);
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

        System.out.println(resultBuilder);
        scanner.close();
    }
}