import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int[] schedules = new int[24 * 60];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                boolean cAssigned = false;
                boolean jAssigned = false;

                for (int time = start; time < end; time++) {
                    if (schedules[time] == 1) {
                        cAssigned = true;
                        break;
                    } else if (schedules[time] > 2) {
                        impossible = true;
                        break;
                    }
                }

                if (impossible) break;

                if (cAssigned) {
                    for (int time = start; time < end; time++) {
                        if (schedules[time] == 2) {
                            jAssigned = true;
                            break;
                        } else if (schedules[time] > 2) {
                            impossible = true;
                            break;
                        }
                    }
                }

                if (impossible) break;

                if (!cAssigned) {
                    result.append("C");
                } else if (!jAssigned) {
                    result.append("J");
                }

                for (int time = start; time < end; time++) {
                    if (!cAssigned) {
                        schedules[time] += 1;
                    } else if (!jAssigned) {
                        schedules[time] += 2;
                    }
                }
            }

            if (impossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            pw.printf("Case #%d: %s\n", testCase, result.toString());
            pw.flush();
        }

        pw.close();
        sc.close();
    }
}