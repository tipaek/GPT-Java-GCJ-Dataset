import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = t;

        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] intervals = new int[N][2];
            int[] cSchedule = new int[1441];
            int[] jSchedule = new int[1441];

            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                intervals[i][0] = Integer.parseInt(token.nextToken());
                intervals[i][1] = Integer.parseInt(token.nextToken());
            }

            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            outerLoop:
            for (int i = 0; i < N; i++) {
                int startTime = intervals[i][0];
                int endTime = intervals[i][1];
                boolean cFree = true;
                boolean jFree = true;

                for (int k = startTime; k < endTime; k++) {
                    if (cSchedule[k] != 0) {
                        cFree = false;
                        break;
                    }
                }

                if (cFree) {
                    for (int k = startTime; k < endTime; k++) {
                        cSchedule[k] = 1;
                    }
                    result.append('C');
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (jSchedule[k] != 0) {
                            jFree = false;
                            impossible = true;
                            break outerLoop;
                        }
                    }

                    if (jFree) {
                        for (int k = startTime; k < endTime; k++) {
                            jSchedule[k] = 1;
                        }
                        result.append('J');
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + (caseNumber - t) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseNumber - t) + ": " + result);
            }
        }
    }
}