
import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Solution {

    private static LinkedList<Integer> adjencyList[];

    private static void addEdge(int v, int w) {
        adjencyList[v].add(w);
        adjencyList[w].add(v);
    }

    private static String getSchedule(int vertices) {

        int result[] = new int[vertices];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean available[] = new boolean[vertices];
        Arrays.fill(available, true);

        for (int u = 1; u < vertices; u++) {

            Iterator<Integer> it = adjencyList[u].iterator();

            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = false;
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

        OUTER:
        for (int j = 0; j < vertices; j++) {

            switch (result[j]) {
                case 0:
                    scheduled.append("C");
                    break;
                case 1:
                    scheduled.append("J");
                    break;
                default:
                    scheduled = new StringBuilder();
                    scheduled.append("IMPOSSIBLE");
                    break OUTER;
            }
        }

        return scheduled.toString();
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] solutionArray = new String[T];

        for (int i = 0; i < T; i++) {

            int N = in.nextInt();

            adjencyList = new LinkedList[N];
            for (int j = 0; j < N; j++) {
                adjencyList[j] = new LinkedList();
            }

            List<WorkTime<Integer, Integer>> workList = new ArrayList<>();

            for (int j = 0; j < N; j++) {

                int S = in.nextInt();
                int E = in.nextInt();

                workList.add(new WorkTime(S, E));
            }

            for (int j = 0; j < N; j++) {

                WorkTime<Integer, Integer> w1 = workList.get(j);
                
                for (int k = j + 1; k < N; k++) {
                    
                    WorkTime<Integer, Integer> w2 = workList.get(k);

                    if (isClashing(w1, w2)) {
                        addEdge(j, k);
                    }
                }
            }

            solutionArray[i] = getSchedule(N);
        }

        for (int i = 0; i < solutionArray.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, solutionArray[i]));
        }
    }

    private static boolean isClashing(WorkTime<Integer, Integer> w1, WorkTime<Integer, Integer> w2) {
        return !(w1.getStart() >= w2.getEnd() || w1.getEnd() <= w2.getStart());
    }

    protected static class WorkTime<Start, End> {

        private final Start start;
        private final End end;

        protected WorkTime(Start start, End end) {
            this.start = start;
            this.end = end;
        }

        protected int getStart() {
            return (Integer) start;
        }

        protected int getEnd() {
            return (Integer) end;
        }
    }
}
