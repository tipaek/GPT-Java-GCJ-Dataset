import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= caseCnt; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] jamie = new int[n][2];
            int[][] cameron = new int[n][2];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                if (isValid(i, jamie, start, end)) {
                    sb.append("J");
                    continue;
                }
                if (isValid(i, cameron, start, end)) {
                    sb.append("C");
                    continue;
                }
                sb = new StringBuilder("IMPOSSIBLE");
                break;
            }
            String output = String.format("Case #%s: %s", t, sb.toString());
            System.out.println(output);
        }
    }

    private static boolean isValid(final int i, final int[][] arr, final int start, final int end) {
        for (final int[] nums : arr) {
            boolean condition1 = nums[0] < start && nums[1] > start;
            boolean condition2 = nums[0] < end && nums[1] > end;
            if (condition1 || condition2) {
                return false;
            }
        }
        arr[i][0] = start;
        arr[i][1] = end;
        return true;
    }
}