import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] intervals = new int[N][2];
            int[] cSchedule = new int[1441];
            int[] jSchedule = new int[1441];

            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                intervals[i][0] = Integer.parseInt(token.nextToken());
                intervals[i][1] = Integer.parseInt(token.nextToken());
            }

            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < N; i++) {
                int startTime = intervals[i][0];
                int endTime = intervals[i][1];
                boolean isCFree = true;
                boolean isJFree = true;

                for (int k = startTime; k < endTime; k++) {
                    if (cSchedule[k] != 0) {
                        isCFree = false;
                        break;
                    }
                }

                if (isCFree) {
                    for (int k = startTime; k < endTime; k++) {
                        cSchedule[k] = 1;
                    }
                    result.append('C');
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (jSchedule[k] != 0) {
                            isJFree = false;
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isJFree) {
                        for (int k = startTime; k < endTime; k++) {
                            jSchedule[k] = 1;
                        }
                        result.append('J');
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("CASE #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("CASE #" + caseNumber + ": " + result.toString());
            }

            caseNumber++;
        }
    }
}