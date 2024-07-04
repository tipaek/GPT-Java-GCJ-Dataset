
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] solutionArray = new String[T];

        for (int i = 0; i < T; i++) {

            int N = in.nextInt();

            List<Integer>[] adjencyList = new ArrayList[N];
            for (int j = 0; j < N; j++) {
                adjencyList[j] = new ArrayList<>();
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
                        addEdge(adjencyList, j, k);
                    }
                }
            }

            solutionArray[i] = getSchedule(adjencyList, N);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, solutionArray[i]));
        }
    }

    private static void addEdge(List<Integer>[] adjencyList, int i, int j) {
        adjencyList[i].add(j);
        adjencyList[j].add(i);
    }

    private static String getSchedule(List<Integer>[] adjencyList, int N) {

        int result[] = new int[N];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean available[] = new boolean[N];
        Arrays.fill(available, true);

        for (int i = 1; i < N; i++) {

            Iterator<Integer> iterator = adjencyList[i].iterator();

            while (iterator.hasNext()) {
                int j = iterator.next();
                if (result[j] != -1) {
                    available[result[j]] = false;
                }
            }

            int color;
            for (color = 0; color < N; color++) {
                if (available[color]) {
                    break;
                }
            }

            result[i] = color;
            Arrays.fill(available, true);
        }

        StringBuilder scheduled = new StringBuilder();

        OUTER:
        for (int j = 0; j < N; j++) {

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
