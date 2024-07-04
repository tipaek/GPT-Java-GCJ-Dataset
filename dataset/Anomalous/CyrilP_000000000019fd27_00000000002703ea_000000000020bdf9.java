import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static class Entry implements Comparable<Entry> {
        int time;
        int status;
        int index;

        Entry(int time, int status, int index) {
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
            int numIntervals = scanner.nextInt();
            String[] assignments = new String[numIntervals];
            ArrayList<Integer> cameron = new ArrayList<>();
            ArrayList<Integer> jamie = new ArrayList<>();
            PriorityQueue<Entry> events = new PriorityQueue<>();

            for (int i = 0; i < numIntervals; i++) {
                events.add(new Entry(scanner.nextInt(), 1, i));
                events.add(new Entry(scanner.nextInt(), -1, i));
            }

            boolean impossible = false;

            while (!events.isEmpty()) {
                Entry event = events.poll();
                if (event.status == -1) {
                    if (!cameron.remove((Integer) event.index)) {
                        jamie.remove((Integer) event.index);
                        assignments[event.index] = "J";
                    } else {
                        assignments[event.index] = "C";
                    }
                } else {
                    if (cameron.size() == 1) {
                        if (jamie.size() == 1) {
                            impossible = true;
                            break;
                        } else {
                            jamie.add(event.index);
                        }
                    } else {
                        cameron.add(event.index);
                    }
                }
            }

            resultBuilder.append(String.format("Case %d: ", t + 1));
            if (impossible) {
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