import java.io.*;
import java.util.*;

class Solution {

    private static List<Integer>[] adjacencyList;

    private static void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    private static String getSchedule(int vertices) {
        int[] result = new int[vertices];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean[] available = new boolean[vertices];
        Arrays.fill(available, true);

        for (int u = 1; u < vertices; u++) {
            for (int neighbor : adjacencyList[u]) {
                if (result[neighbor] != -1) {
                    available[result[neighbor]] = false;
                }
            }

            int cr;
            for (cr = 0; cr < vertices; cr++) {
                if (available[cr]) {
                    break;
                }
            }

            result[u] = cr;
            Arrays.fill(available, true);
        }

        StringBuilder scheduled = new StringBuilder();
        for (int j = 0; j < vertices; j++) {
            switch (result[j]) {
                case 0:
                    scheduled.append("C");
                    break;
                case 1:
                    scheduled.append("J");
                    break;
                default:
                    return "IMPOSSIBLE";
            }
        }

        return scheduled.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        String[] solutionArray = new String[T];

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            adjacencyList = new LinkedList[N];
            for (int j = 0; j < N; j++) {
                adjacencyList[j] = new LinkedList<>();
            }

            List<WorkTime> workList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int S = in.nextInt();
                int E = in.nextInt();
                workList.add(new WorkTime(S, E));
            }

            for (int j = 0; j < N; j++) {
                WorkTime w1 = workList.get(j);
                for (int k = j + 1; k < N; k++) {
                    WorkTime w2 = workList.get(k);
                    if (isClashing(w1, w2)) {
                        addEdge(j, k);
                    }
                }
            }

            solutionArray[i] = getSchedule(N);
        }

        for (int i = 0; i < solutionArray.length; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, solutionArray[i]);
        }
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