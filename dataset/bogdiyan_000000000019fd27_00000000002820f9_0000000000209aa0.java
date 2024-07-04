import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String out = "";
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            String validMatrix = "";
            boolean possible = false;

            int n = sc.nextInt();
            int t = sc.nextInt();

            int sumDifferent = n * (n + 1) / 2;

            if (n > 2 && sumDifferent == t) {
                possible = true;
                for (int i = 0; i < n; i++) {
                    int startN = i+1;
                    for (int j = 0; j < n; j++) {
                        validMatrix += startN + (j + 1 < n ? " " : "");
                        startN++;
                        startN = startN > n ? startN - n : startN;
                    }
                    validMatrix += (i + 1 < n ? "\n" : "");
                }
            } else {
                for (int i = 1; i <= n && !possible; i++) {
                    int nTimesI = n*i;
                    if (nTimesI == t) {
                        possible = true;

                        int startN = i;
                        for (int k = 0; k < n; k++) {
                            for (int j = 0; j < n; j++) {
                                startN = startN > n ? startN - n : startN;
                                int num = k == j ? i : startN;
                                validMatrix += num + (j + 1 < n ? " " : "");
                                startN++;
                            }
                            startN += i;
                            validMatrix += (k + 1 < n ? "\n" : "");
                        }
                    }
                }
            }


            out += "Case #" + (testCase+1) + ": " + (possible ? "POSSIBLE\n" + validMatrix : "IMPOSSIBLE") + (testCase + 1 < testCases ? "\n" : "");
        }

        System.out.println(out);
    }
}