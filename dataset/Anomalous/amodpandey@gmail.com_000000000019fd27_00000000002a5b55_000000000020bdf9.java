import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int[] schedules = new int[24 * 60];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (isImpossible) continue;

                boolean cExists = false;
                boolean jExists = false;

                for (int t = start; t < end; t++) {
                    if (schedules[t] == 1 || schedules[t] == 3) {
                        cExists = true;
                        break;
                    }
                }

                if (cExists) {
                    for (int t = start; t < end; t++) {
                        if (schedules[t] == 2 || schedules[t] == 3) {
                            jExists = true;
                            break;
                        }
                    }
                }

                if (!cExists) {
                    result.append("C");
                } else if (!jExists) {
                    result.append("J");
                } else {
                    isImpossible = true;
                    continue;
                }

                for (int t = start; t < end; t++) {
                    if (!cExists) {
                        schedules[t] += 1;
                    } else if (!jExists) {
                        schedules[t] += 2;
                    }
                }
            }

            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            pw.printf("Case #%d: %s\n", testCase, result.toString());
            pw.flush();
        }

        pw.close();
        sc.close();
    }
}