import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        new Solution().solve();
    }

    private void solve() {
        int currentCase = 1;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());

            while (testCases-- > 0) {
                System.out.println("Case #" + currentCase++ + ": " + findResult(br));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String findResult(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean[] c = new boolean[2400];
        boolean[] j = new boolean[2400];

        int lines = Integer.parseInt(br.readLine());
        for (int i = 0; i < lines; ++i) {
            String[] arr = br.readLine().split("\\s+");
            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);

            boolean[] currentParent;

            if (isAvailable(c, start, end)) {
                currentParent = c;
                sb.append('C');
            } else if (isAvailable(j, start, end)) {
                currentParent = j;
                sb.append('J');
            } else {
                for (int j = i + 1; j < lines; j++) {
                    br.readLine();
                }
                return IMPOSSIBLE;
            }

            markTimeSlots(currentParent, start, end);
        }
        return sb.toString();
    }

    private boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private void markTimeSlots(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}