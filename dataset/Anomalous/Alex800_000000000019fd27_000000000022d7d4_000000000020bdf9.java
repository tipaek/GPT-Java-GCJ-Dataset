import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static class Tuple implements Comparable<Tuple> {
        int startTime;
        int index;
        boolean isStart;

        public Tuple(int startTime, int index, boolean isStart) {
            this.startTime = startTime;
            this.index = index;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Tuple other) {
            if (this.startTime == other.startTime) {
                if (!this.isStart && other.isStart) {
                    return -1;
                } else if (this.isStart && !other.isStart) {
                    return 1;
                }
            }
            return this.startTime - other.startTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            PriorityQueue<Tuple> events = new PriorityQueue<>();
            int count = 0;

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Tuple(start, count, true));
                events.add(new Tuple(end, count++, false));
            }

            int cameron = -1, jamie = -1;
            boolean isImpossible = false;
            char[] schedule = new char[N];
            Arrays.fill(schedule, 'C');

            for (int i = 0; i < 2 * N; i++) {
                Tuple currentEvent = events.poll();

                if (currentEvent.isStart) {
                    if (cameron == -1) {
                        cameron = currentEvent.index;
                    } else if (jamie == -1) {
                        schedule[currentEvent.index] = 'J';
                        jamie = currentEvent.index;
                    } else {
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (currentEvent.index == cameron) {
                        cameron = -1;
                    } else {
                        jamie = -1;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(schedule));
            }
        }

        scanner.close();
    }
}