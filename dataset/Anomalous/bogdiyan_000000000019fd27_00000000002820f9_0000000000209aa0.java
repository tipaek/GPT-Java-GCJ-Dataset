import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            boolean possible = false;
            StringBuilder validMatrix = new StringBuilder();
            int n = sc.nextInt();
            int t = sc.nextInt();
            int sumDifferent = n * (n + 1) / 2;

            if (n > 2 && sumDifferent == t) {
                possible = true;
                for (int i = 0; i < n; i++) {
                    int startN = i + 1;
                    for (int j = 0; j < n; j++) {
                        validMatrix.append(startN).append(j + 1 < n ? " " : "");
                        startN = (startN % n) + 1;
                    }
                    if (i + 1 < n) validMatrix.append("\n");
                }
            } else {
                for (int i = 1; i <= n && !possible; i++) {
                    if (n * i == t) {
                        possible = true;
                        int startN = i;
                        for (int k = 0; k < n; k++) {
                            for (int j = 0; j < n; j++) {
                                startN = (startN - 1) % n + 1;
                                int num = (k == j) ? i : startN;
                                validMatrix.append(num).append(j + 1 < n ? " " : "");
                                startN++;
                            }
                            startN += i;
                            if (k + 1 < n) validMatrix.append("\n");
                        }
                    }
                }
            }

            out.append("Case #").append(testCase + 1).append(": ")
               .append(possible ? "POSSIBLE\n" + validMatrix : "IMPOSSIBLE")
               .append(testCase + 1 < testCases ? "\n" : "");
        }

        System.out.println(out);
    }
}