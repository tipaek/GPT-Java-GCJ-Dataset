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
            int numActivities = scanner.nextInt();
            String[] assignments = new String[numActivities];
            ArrayList<Integer> cList = new ArrayList<>();
            ArrayList<Integer> jList = new ArrayList<>();
            PriorityQueue<Entry> events = new PriorityQueue<>();

            for (int i = 0; i < numActivities; i++) {
                events.add(new Entry(scanner.nextInt(), 1, i));
                events.add(new Entry(scanner.nextInt(), -1, i));
            }

            while (!events.isEmpty()) {
                Entry currentEvent = events.poll();
                if (currentEvent.status == -1) {
                    if (!cList.remove((Integer) currentEvent.index)) {
                        jList.remove((Integer) currentEvent.index);
                        assignments[currentEvent.index] = "J";
                    } else {
                        assignments[currentEvent.index] = "C";
                    }
                } else {
                    if (cList.size() == 1) {
                        if (jList.size() == 1) {
                            isImpossible = true;
                            break;
                        } else {
                            jList.add(currentEvent.index);
                        }
                    } else {
                        cList.add(currentEvent.index);
                    }
                }
            }

            resultBuilder.append(String.format("Case #%d: ", t + 1));
            if (isImpossible) {
                resultBuilder.append("IMPOSSIBLE\n");
            } else {
                for (String assignment : assignments) {
                    resultBuilder.append(assignment);
                }
                resultBuilder.append("\n");
            }
        }

        System.out.print(resultBuilder);
    }
}