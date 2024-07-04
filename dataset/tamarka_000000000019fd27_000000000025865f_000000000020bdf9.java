import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Integer> cameronSSchedule = new ArrayList<>();
            List<Integer> jamieSSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            // for (int task = 0; task < n; task++) {
            //     int s = in.nextInt();
            //     int e = in.nextInt();

            //     if (isSchedulable(cameronSSchedule, s, e)) {
            //         cameronSSchedule.add(s);
            //         cameronSSchedule.add(e);
            //         result.append(CAMERON);
            //     } else if (isSchedulable(jamieSSchedule, s, e)) {
            //         jamieSSchedule.add(s);
            //         jamieSSchedule.add(e);
            //         result.append(JAMIE);
            //     } else {
                    result = new StringBuilder(IMPOSSIBLE);
            //         break;
            //     }
            // }
            System.out.println(String.format("Case #%d: %s", i, result.toString()));
        }
    }

    private static boolean isSchedulable(List<Integer> schedule, int s, int e) {
        for (int i = 0; i < schedule.size(); i += 2) {
            if (schedule.get(i) <= s && s < schedule.get(i + 1)) {
                return false;
            }
            if (schedule.get(i) < e && e <= schedule.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}