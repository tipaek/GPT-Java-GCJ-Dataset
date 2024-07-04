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
            List<int[]> cameronSSchedule = new ArrayList<>();
            List<int[]> jamieSSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            try {
                for (int task = 0; task < n; task++) {
                    int s = in.nextInt();
                    int e = in.nextInt();

                    if (isSchedulable(cameronSSchedule, s, e)) {
                        cameronSSchedule.add(new int[]{s, e});
                        result.append(CAMERON);
                    } else if (isSchedulable(jamieSSchedule, s, e)) {
                        jamieSSchedule.add(new int[]{s, e});
                        result.append(JAMIE);
                    } else {
                        throw new ImpossibleException();
                    }
                }
            } catch (ImpossibleException e) {
                result = new StringBuilder(IMPOSSIBLE);
            }
            System.out.println(String.format("Case #%d: %s", i, result.toString()));
        }
    }

    private static boolean isSchedulable(List<int[]> schedule, int s, int e) {
        for (int[] task : schedule) {
            if (task[0] <= s && s < task[1]) {
                return false;
            }
            if (task[0] < e && e <= task[1]) {
                return false;
            }
        }

        return true;
    }
    
    private static class ImpossibleException extends Exception {
        //
    }
}