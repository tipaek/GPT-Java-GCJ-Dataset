import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            boolean possible = true;
            StringBuilder result = new StringBuilder("C");

            int start = scanner.nextInt();
            int end = scanner.nextInt();
            for (int time = start + 1; time < end; time++) {
                cameronSchedule[time] = true;
            }

            for (int i = 2; i <= n; i++) {
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                start = scanner.nextInt();
                end = scanner.nextInt();

                if (possible) {
                    for (int time = start + 1; time < end; time++) {
                        if (cameronSchedule[time]) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        for (int time = start + 1; time < end; time++) {
                            cameronSchedule[time] = true;
                        }
                        result.append("C");
                    } else {
                        for (int time = start + 1; time < end; time++) {
                            if (jamieSchedule[time]) {
                                canAssignToJamie = false;
                                break;
                            }
                        }

                        if (canAssignToJamie) {
                            for (int time = start + 1; time < end; time++) {
                                jamieSchedule[time] = true;
                            }
                            result.append("J");
                        }
                    }

                    if (!canAssignToCameron && !canAssignToJamie) {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}