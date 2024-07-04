import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int activities = scanner.nextInt();
            byte[] cSchedule = new byte[1441];
            byte[] jSchedule = new byte[1441];

            for (int i = 0; i < 1441; i++) {
                cSchedule[i] = 0;
                jSchedule[i] = 0;
            }

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int attempts = 0;

                try {
                    for (int time = start; time < end; time++) {
                        if (cSchedule[time] == 1) {
                            throw new Exception("C schedule conflict");
                        }
                        cSchedule[time] = 1;
                        attempts++;
                    }
                    result.append("C");
                } catch (Exception e) {
                    for (int time = start; time < start + attempts; time++) {
                        cSchedule[time] = 0;
                    }
                    attempts = 0;

                    try {
                        for (int time = start; time < end; time++) {
                            if (jSchedule[time] == 1) {
                                throw new Exception("J schedule conflict");
                            }
                            jSchedule[time] = 1;
                            attempts++;
                        }
                        result.append("J");
                    } catch (Exception ex) {
                        for (int time = start; time < start + attempts; time++) {
                            jSchedule[time] = 0;
                        }
                        result = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }

            if (impossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (testCase + 1) + ": " + result);
        }

        scanner.close();
    }
}