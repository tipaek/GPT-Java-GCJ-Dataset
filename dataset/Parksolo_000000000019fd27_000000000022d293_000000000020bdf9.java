import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= caseCnt; t++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> jamie = new ArrayList<>();
            List<int[]> cameron = new ArrayList<>();
            boolean impossible = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (impossible) {
                    continue;
                }
                String[] times = line.split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                if (isValid(jamie, start, end)) {
                    sb.append("J");
                    continue;
                }
                if (isValid(cameron, start, end)) {
                    sb.append("C");
                    continue;
                }
                sb = new StringBuilder("IMPOSSIBLE");
                impossible = true;
            }
            String output = String.format("Case #%s: %s", t, sb.toString());
            System.out.println(output);
        }
    }

    private static boolean isValid(final List<int[]> list, final int start, final int end) {
        for (final int[] nums : list) {
            boolean invalidStartTime = nums[0] < start && nums[1] > start;
            boolean invalidEndTime = nums[0] < end && nums[1] > end;
            boolean equal = nums[0] == start && nums[1] == end;
            if (invalidStartTime || invalidEndTime || equal) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}