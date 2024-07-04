import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int eventsCount = scanner.nextInt();
            ArrayList<int[]> events = new ArrayList<>(eventsCount);
            for (int i = 0; i < eventsCount; i++) {
                events.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }

            Pair<ArrayList<int[]>, ArrayList<Integer>> sortedEvents = sortEvents(events);
            boolean[] scheduleC = new boolean[1440];
            boolean[] scheduleJ = new boolean[1440];
            char[] results = new char[eventsCount];
            boolean isImpossible = false;

            for (int i = 0; i < sortedEvents.getFirst().size(); i++) {
                int start = sortedEvents.getFirst().get(i)[0];
                int end = sortedEvents.getFirst().get(i)[1];
                int originalIndex = sortedEvents.getSecond().get(i);

                if (canSchedule(scheduleC, start, end)) {
                    schedule(scheduleC, start, end);
                    results[originalIndex] = 'C';
                } else if (canSchedule(scheduleJ, start, end)) {
                    schedule(scheduleJ, start, end);
                    results[originalIndex] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(results));
            }
        }
    }

    private static boolean canSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) return false;
        }
        return true;
    }

    private static void schedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private static Pair<ArrayList<int[]>, ArrayList<Integer>> sortEvents(ArrayList<int[]> events) {
        ArrayList<int[]> sortedEvents = new ArrayList<>(events.size());
        ArrayList<Integer> originalIndices = new ArrayList<>(events.size());
        boolean[] added = new boolean[events.size()];

        while (sortedEvents.size() < events.size()) {
            int minStart = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < events.size(); i++) {
                if (!added[i] && events.get(i)[0] < minStart) {
                    minStart = events.get(i)[0];
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                sortedEvents.add(events.get(minIndex));
                originalIndices.add(minIndex);
                added[minIndex] = true;
            }
        }

        return new Pair<>(sortedEvents, originalIndices);
    }

    private static class Pair<F, S> {
        private final F first;
        private final S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }
}