import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int t = 0; t < testCaseCount; t++) {
            int activityCount = scanner.nextInt();
            byte[] cSchedule = new byte[1441];
            byte[] jSchedule = new byte[1441];

            for (int k = 0; k < 1441; k++) {
                cSchedule[k] = 0;
                jSchedule[k] = 0;
            }

            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int a = 0; a < activityCount; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int attempts = 0;

                try {
                    for (int time = start; time <= end; time++) {
                        if (cSchedule[time] == 1 && cSchedule[time + 1] == 1) {
                            throw new Exception("C schedule conflict");
                        } else {
                            cSchedule[time] = 1;
                            attempts++;
                        }
                    }
                    result.append("C");
                } catch (Exception e) {
                    for (int time = start; time < start + attempts; time++) {
                        cSchedule[time] = 0;
                    }
                    attempts = 0;

                    try {
                        for (int time = start; time <= end; time++) {
                            if (jSchedule[time] == 1 && jSchedule[time + 1] == 1) {
                                throw new Exception("J schedule conflict");
                            } else {
                                jSchedule[time] = 1;
                                attempts++;
                            }
                        }
                        result.append("J");
                    } catch (Exception ex) {
                        for (int time = start; time < start + attempts; time++) {
                            jSchedule[time] = 0;
                        }
                        result.append("IMPOSSIBLE");
                        isImpossible = true;
                    }
                }
            }

            if (isImpossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}