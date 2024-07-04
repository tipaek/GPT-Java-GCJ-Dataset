import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int periodsNum = in.nextInt();

            List<TimePoint> timePoints = new ArrayList<>();
            for (int i = 0; i < periodsNum; i++) {
                timePoints.add(new TimePoint(in.nextInt(), true));
                timePoints.add(new TimePoint(in.nextInt(), false));
            }

            timePoints.sort(Comparator.comparingInt(TimePoint::getTime));

            int currentParallelism = 0;
            StringBuilder sb = new StringBuilder();
            boolean cam = true;
            for (TimePoint timePoint : timePoints) {
                if (timePoint.isStart()) {
                    currentParallelism++;
                    if (currentParallelism < 3) {
                        sb.append(cam ? "C" : "J");
                        cam = !cam;
                    } else {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else {
                    currentParallelism--;
                }
            }

            System.out.println("Case #" + caseIndex + ": " + sb.toString());
        }
    }

    public static class TimePoint {
        int time;
        boolean start;

        public TimePoint(final int time, final boolean start) {
            this.time = time;
            this.start = start;
        }

        public int getTime() {
            return time;
        }

        public boolean isStart() {
            return start;
        }
    }

}