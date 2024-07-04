
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
            WorkTime<Integer, Integer> allotedC = new WorkTime(0, 0);
            WorkTime<Integer, Integer> allotedJ = new WorkTime(0, 0);

            List<WorkTime<Integer, Integer>> workTimeList = new ArrayList<>();

            for (int j = 0; j < N; j++) {

                int S = in.nextInt();
                int E = in.nextInt();
                WorkTime pair = new WorkTime(S, E);
                workTimeList.add(pair);
            }

            for (int j = 0; j < N; j++) {

                WorkTime<Integer, Integer> toAllot = workTimeList.get(j);

                if (allotedC.getStart() == 0 && allotedC.getEnd() == 0) {

                    allotedC = toAllot;
                    scheduled.append("C");
                } else if (allotedJ.getStart() == 0 && allotedJ.getEnd() == 0) {

                    allotedJ = toAllot;
                    scheduled.append("J");
                } else {

                    if (canWork(allotedC, toAllot)) {

                        allotedC = toAllot;
                        scheduled.append("C");
                    } else if (canWork(allotedJ, toAllot)) {

                        allotedJ = toAllot;
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

    private static boolean canWork(WorkTime<Integer, Integer> allocated, WorkTime<Integer, Integer> toAllot) {
        if (toAllot.getStart() >= allocated.getEnd()) {
            return true;
        } else return toAllot.getEnd() <= allocated.getStart();
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
