import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
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
        StringBuilder resultBuilder = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            StringBuilder currentResult = new StringBuilder();
            String currentPerson = "C";
            int numberOfIntervals = scanner.nextInt();
            PriorityQueue<Interval> intervals = new PriorityQueue<>();

            for (int i = 0; i < numberOfIntervals; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            Interval firstInterval = intervals.poll();
            int currentStart = firstInterval.start;
            int currentEnd = firstInterval.end;
            currentResult.append(currentPerson);

            for (int i = 0; i < numberOfIntervals - 1; i++) {
                Interval interval = intervals.poll();

                if (interval.start >= currentEnd) {
                    currentStart = interval.start;
                    currentEnd = interval.end;
                    currentResult.append(currentPerson);
                } else if (!intervals.isEmpty()) {
                    if (interval.end < currentEnd) {
                        Interval nextInterval = intervals.peek();
                        if (nextInterval.start < interval.end) {
                            currentResult.setLength(0);
                            currentResult.append("IMPOSSIBLE");
                            break;
                        } else {
                            currentPerson = switchPerson(currentPerson);
                            currentStart = interval.end;
                            currentResult.append(currentPerson);
                            currentPerson = switchPerson(currentPerson);
                        }
                    } else {
                        Interval nextInterval = intervals.peek();
                        if (nextInterval.start < currentEnd) {
                            currentResult.setLength(0);
                            currentResult.append("IMPOSSIBLE");
                            break;
                        } else {
                            currentStart = interval.start;
                            currentEnd = interval.end;
                            currentResult.append(currentPerson);
                        }
                    }
                } else {
                    currentPerson = switchPerson(currentPerson);
                    currentResult.append(currentPerson);
                    break;
                }
            }

            resultBuilder.append(currentResult).append("\n");
        }

        System.out.print(resultBuilder);
    }

    private static String switchPerson(String currentPerson) {
        return currentPerson.equals("C") ? "J" : "C";
    }
}