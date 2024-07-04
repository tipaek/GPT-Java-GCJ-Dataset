import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            boolean[] cMins = new boolean[24 * 60];
            boolean[] jMins = new boolean[24 * 60];

            int N = Integer.parseInt(br.readLine());

            boolean isPossible = true;

            StringBuilder resultRow = new StringBuilder();

            for (int curActivity = 0; curActivity < N; curActivity++) {
                String[] activityBoundaries = br.readLine().split(" ");
                int start = Integer.parseInt(activityBoundaries[0]);
                int end = Integer.parseInt(activityBoundaries[1]);

                boolean cIsAble = false;
                for (int i = 0; i < end - start; i++) {
                    if (!cMins[start + i]) {
                        cIsAble = true;
                    } else {
                        cIsAble = false;
                        break;
                    }
                }
                if (cIsAble) {
                    resultRow.append("C");
                    for (int i = 0; i < end - start; i++) {
                        cMins[start + i] = true;
                    }
                } else {
                    boolean jIsAble = false;
                    for (int i = 0; i < end - start; i++) {
                        if (!jMins[start + i]) {
                            jIsAble = true;
                        } else {
                            jIsAble = false;
                            break;
                        }
                    }

                    if (jIsAble) {
                        resultRow.append("J");
                        for (int i = 0; i < end - start; i++) {
                            jMins[start + i] = true;
                        }
                    } else {
                        isPossible = false;
                    }
                }


            }

            if (isPossible) {
                System.out.println("Case #" + (testCase + 1) + ": " + resultRow);
            } else {
                System.out.println("Case #" + (testCase + 1) + ": " + "IMPOSSIBLE");
            }

        }
    }
}
