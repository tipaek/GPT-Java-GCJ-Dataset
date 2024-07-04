import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            StringBuilder schedule = new StringBuilder();
            int numIntervals = scanner.nextInt();
            PriorityQueue<Interval> intervalQueue = new PriorityQueue<>();

            for (int i = 0; i < numIntervals; i++) {
                intervalQueue.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            Interval current = intervalQueue.poll();
            int currentStart = current.start;
            int currentEnd = current.end;
            String currentPerson = "C";
            schedule.append(currentPerson);

            for (int i = 1; i < numIntervals; i++) {
                Interval next = intervalQueue.poll();
                if (next.start >= currentEnd) {
                    currentStart = next.start;
                    currentEnd = next.end;
                    schedule.append(currentPerson);
                } else if (!intervalQueue.isEmpty()) {
                    currentPerson = switchPerson(currentPerson);
                    if (next.end < currentEnd) {
                        Interval peek = intervalQueue.peek();
                        if (next.start <= peek.start && peek.start < next.end) {
                            schedule.setLength(0);
                            schedule.append("IMPOSSIBLE");
                            break;
                        } else {
                            currentStart = next.end;
                            schedule.append(currentPerson);
                        }
                    } else {
                        Interval peek = intervalQueue.peek();
                        if (peek.start < currentEnd) {
                            schedule.setLength(0);
                            schedule.append("IMPOSSIBLE");
                            break;
                        } else {
                            currentStart = next.start;
                            currentEnd = next.end;
                            schedule.append(currentPerson);
                        }
                    }
                } else {
                    currentPerson = switchPerson(currentPerson);
                    schedule.append(currentPerson);
                    break;
                }
            }
            result.append(schedule).append("\n");
        }
        System.out.print(result);
    }

    private static String switchPerson(String person) {
        return person.equals("C") ? "J" : "C";
    }
}