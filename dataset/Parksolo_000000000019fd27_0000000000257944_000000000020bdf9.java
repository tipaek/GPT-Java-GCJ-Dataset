
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(final String[] args) throws IOException {
        StringBuilder sb;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= caseCnt; t++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> inputs = new ArrayList<>();
            Set<String> impossibles = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                String[] times = line.split(" ");
                inputs.add(new int[]{Integer.parseInt(times[0]), Integer.parseInt(times[1])});
            }
            while (true) {
                sb = new StringBuilder();
                List<int[]> jamie = new ArrayList<>();
                List<int[]> cameron = new ArrayList<>();
                boolean impossible = false;
                for (final int[] input : inputs) {
                    int start = input[0];
                    int end = input[1];
                    if (!impossibles.contains(sb.toString() + "J")) {
                        if (isValid(jamie, start, end)) {
                            sb.append("J");
                            continue;
                        }
                    }
                    if (!impossibles.contains(sb.toString() + "C")) {
                        if (isValid(cameron, start, end)) {
                            sb.append("C");
                            continue;
                        }
                    }
                    impossible = true;
                    break;
                }
                if (impossible) {
                    if (!impossibles.add(sb.toString())) {
                        sb = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else {
                    break;
                }
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
            boolean a = start < nums[1] && end > nums[1];
            boolean b = start < nums[0] && end > nums[0];
            if (invalidStartTime || invalidEndTime || equal || a || b) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}
