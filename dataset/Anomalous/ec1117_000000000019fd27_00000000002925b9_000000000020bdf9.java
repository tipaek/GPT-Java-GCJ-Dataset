import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Pair> originalOrder = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            ArrayList<Integer> overlappingJobs = new ArrayList<>();
            ArrayList<Pair> jobPairs = new ArrayList<>();
            ArrayList<Pair> sortedJobs = new ArrayList<>();
            originalOrder = new ArrayList<>();
            int[] jobAssignments = new int[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                sortedJobs.add(new Pair(start, end));
                originalOrder.add(new Pair(start, end));
            }

            Collections.sort(sortedJobs);
            int lastEnd = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                int currentStart = sortedJobs.get(j).start;
                int currentEnd = sortedJobs.get(j).end;

                if (currentStart >= lastEnd) {
                    lastEnd = currentEnd;
                } else {
                    overlappingJobs.add(j + 1);
                    jobPairs.add(new Pair(currentStart, currentEnd));
                }
            }

            boolean isPossible = true;
            for (int j = 1; j < overlappingJobs.size(); j++) {
                int currentStart = jobPairs.get(j).start;
                int previousEnd = jobPairs.get(j - 1).end;
                if (!(currentStart >= previousEnd)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                StringBuilder result = new StringBuilder();
                for (int j = 1; j <= n; j++) {
                    if (overlappingJobs.contains(j)) {
                        int index = findJobIndex(sortedJobs.get(j - 1).start, sortedJobs.get(j - 1).end);
                        jobAssignments[index] = 1;
                    }
                }
                for (int job : jobAssignments) {
                    result.append(job == 1 ? "J" : "C");
                }
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static int findJobIndex(int start, int end) {
        for (int i = 0; i < originalOrder.size(); i++) {
            if (originalOrder.get(i).start == start && originalOrder.get(i).end == end) {
                return i;
            }
        }
        return 0;
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair other) {
            return this.start - other.start;
        }
    }
}