import java.io.*;
import java.util.*;

public class Solution {

    private static List<Integer>[] adjacencyList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            List<WorkTime> workTimes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                workTimes.add(new WorkTime(start, end));
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isClashing(workTimes.get(i), workTimes.get(j))) {
                        addEdge(i, j);
                    }
                }
            }

            results[t] = getSchedule(n);
        }

        for (int t = 0; t < results.length; t++) {
            System.out.println(String.format("Case #%d: %s", t + 1, results[t]));
        }
    }

    private static void addEdge(int i, int j) {
        adjacencyList[i].add(j);
        adjacencyList[j].add(i);
    }

    private static String getSchedule(int n) {
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        boolean[] available = new boolean[n];
        Arrays.fill(available, true);

        for (int i = 1; i < n; i++) {
            for (int adj : adjacencyList[i]) {
                if (result[adj] != -1) {
                    available[result[adj]] = false;
                }
            }

            int color;
            for (color = 0; color < n; color++) {
                if (available[color]) {
                    break;
                }
            }

            result[i] = color;
            Arrays.fill(available, true);
        }

        StringBuilder schedule = new StringBuilder();
        for (int i = 0; i < n; i++) {
            switch (result[i]) {
                case 0:
                    schedule.append("C");
                    break;
                case 1:
                    schedule.append("J");
                    break;
                default:
                    return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isClashing(WorkTime w1, WorkTime w2) {
        return !(w1.getStart() >= w2.getEnd() || w1.getEnd() <= w2.getStart());
    }

    private static class WorkTime {
        private final int start;
        private final int end;

        public WorkTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}