import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] cSchedule = new boolean[24 * 60];
            boolean[] jSchedule = new boolean[24 * 60];
            int activitiesCount = Integer.parseInt(br.readLine());
            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < activitiesCount; activity++) {
                String[] times = br.readLine().split(" ");
                if (impossible) continue;

                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean canCameron = true;
                for (int t = start; t < end; t++) {
                    if (cSchedule[t]) {
                        canCameron = false;
                        break;
                    }
                }

                if (canCameron) {
                    result.append("C");
                    for (int t = start; t < end; t++) {
                        cSchedule[t] = true;
                    }
                } else {
                    boolean canJamie = true;
                    for (int t = start; t < end; t++) {
                        if (jSchedule[t]) {
                            canJamie = false;
                            break;
                        }
                    }

                    if (canJamie) {
                        result.append("J");
                        for (int t = start; t < end; t++) {
                            jSchedule[t] = true;
                        }
                    } else {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}