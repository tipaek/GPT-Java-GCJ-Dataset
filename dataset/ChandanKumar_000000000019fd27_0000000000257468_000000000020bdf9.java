
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] finalArray = new String[T];

        for (int i = 0; i < T; i++) {

            int N = in.nextInt();

            StringBuilder scheduled = new StringBuilder();

            List<WorkTime<Integer, Integer>> workList = new ArrayList<>();

            List<WorkTime<Integer, Integer>> allotedCList = new ArrayList<>();
            List<WorkTime<Integer, Integer>> allotedJList = new ArrayList<>();
            
            for (int j = 0; j < N; j++) {

                int S = in.nextInt();
                int E = in.nextInt();

                workList.add(new WorkTime(S, E));
            }

            for (int j = 0; j < N; j++) {

                WorkTime toAllot = workList.get(j);

                if (canWork(allotedCList, toAllot)) {

                    allotedCList.add(toAllot);
                    scheduled.append("C");
                } else if (canWork(allotedJList, toAllot)) {

                    allotedJList.add(toAllot);
                    scheduled.append("J");
                } else {

                    finalArray[i] = "IMPOSSIBLE";
                    scheduled = null;
                    break;
                }
            }

            if (scheduled != null) {
                finalArray[i] = scheduled.toString();
            }
        }

        for (int i = 0; i < finalArray.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, finalArray[i]));
        }
    }

    private static boolean canWork(List<WorkTime<Integer, Integer>> allocatedList, WorkTime<Integer, Integer> toAllot) {

        for (WorkTime<Integer, Integer> allocated : allocatedList) {

            if (!(toAllot.getStart() >= allocated.getEnd() || toAllot.getEnd() <= allocated.getStart())) {
                return false;
            }
        }

        return true;
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
