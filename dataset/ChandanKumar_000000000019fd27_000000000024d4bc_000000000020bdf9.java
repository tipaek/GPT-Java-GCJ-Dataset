
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] finalArray = new String[T];

        for (int i = 0; i < T; ++i) {

            int N = in.nextInt();

            StringBuilder scheduled = new StringBuilder();

            List<WorkTime<Integer, Integer>> allotedC = new ArrayList<>();
            List<WorkTime<Integer, Integer>> allotedJ = new ArrayList<>();

            for (int j = 0; j < N; j++) {

                int S = in.nextInt();
                int E = in.nextInt();

                WorkTime toAllot = new WorkTime(S, E);

                if (allotedC.isEmpty()) {

                    allotedC.add(toAllot);
                    scheduled.append("C");
                } else if (allotedJ.isEmpty()) {

                    allotedJ.add(toAllot);
                    scheduled.append("J");
                } else {

                    if (canWork(allotedC, toAllot)) {

                        allotedC.add(toAllot);
                        scheduled.append("C");
                    } else if (canWork(allotedJ, toAllot)) {

                        allotedJ.add(toAllot);
                        scheduled.append("J");
                    } else {

                        finalArray[i] = "IMPOSSIBLE";
                        scheduled = null;
                        break;
                    }
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

            if (toAllot.getStart() >= allocated.getEnd() || toAllot.getEnd() <= allocated.getStart()) {

            } else {
                return false;
            }
        }

        return true;
    }

    protected static class WorkTime<Start, End> {

        private final Start x;
        private final End y;

        private WorkTime(Start x, End y) {
            this.x = x;
            this.y = y;
        }

        protected int getStart() {
            return (Integer) x;
        }

        protected int getEnd() {
            return (Integer) y;
        }
    }
}
