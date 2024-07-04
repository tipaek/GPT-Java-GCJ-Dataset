import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int n = scan.nextInt();
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            for (int i = 0; i < n; i++) {
                int from = scan.nextInt();
                int to = scan.nextInt();
                if (!impossible && isFree(cameron, from, to)) {
                    cameron.add(new int[] {from, to});
                    result.append("C");
                } else if (!impossible && isFree(jamie, from, to)) {
                    jamie.add(new int[] {from, to});
                    result.append("J");
                } else {
                    impossible = true;
                }
            }
            System.out.println("Case #" + test + ": " + (impossible ? "IMPOSSIBLE" : result));
        }
    }

    private static boolean isFree(List<int[]> schedule, int from, int to) {
        return schedule.stream().allMatch(activity -> activity[0] >= to || activity[1] <= from);
    }
}