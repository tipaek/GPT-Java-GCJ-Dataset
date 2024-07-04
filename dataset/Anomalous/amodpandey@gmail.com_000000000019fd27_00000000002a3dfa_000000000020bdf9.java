import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(System.out)) {
            int testCases = sc.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int n = sc.nextInt();
                int[] schedules = new int[24 * 60];
                StringBuilder result = new StringBuilder();
                boolean impossible = false;

                for (int i = 0; i < n; i++) {
                    int start = sc.nextInt();
                    int end = sc.nextInt();

                    if (impossible) {
                        continue;
                    }

                    boolean cConflict = false;
                    boolean jConflict = false;

                    for (int t = start; t < end; t++) {
                        if (schedules[t] == 1) {
                            cConflict = true;
                            break;
                        } else if (schedules[t] > 2) {
                            impossible = true;
                            break;
                        }
                    }

                    if (impossible) {
                        continue;
                    }

                    if (cConflict) {
                        for (int t = start; t < end; t++) {
                            if (schedules[t] == 2) {
                                jConflict = true;
                                break;
                            } else if (schedules[t] > 2) {
                                impossible = true;
                                break;
                            }
                        }
                    }

                    if (impossible) {
                        continue;
                    }

                    if (!cConflict) {
                        result.append("C");
                    } else if (!jConflict) {
                        result.append("J");
                    }

                    for (int t = start; t < end; t++) {
                        if (!cConflict) {
                            schedules[t] += 1;
                        } else if (!jConflict) {
                            schedules[t] += 2;
                        }
                    }
                }

                if (impossible) {
                    result = new StringBuilder("IMPOSSIBLE");
                }

                pw.printf("Case #%d: %s%n", testCase, result.toString());
            }
        }
    }
}