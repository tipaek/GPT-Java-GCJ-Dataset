import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int activities = scanner.nextInt();
            StringBuilder solution = new StringBuilder();
            boolean isImpossible = false;

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToCameron = true;

                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time] == 1) {
                        assignedToCameron = false;
                        break;
                    }
                }

                if (assignedToCameron) {
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = 1;
                    }
                    solution.append("C");
                } else {
                    boolean assignedToJamie = true;
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time] == 1) {
                            solution = new StringBuilder("IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) {
                        break;
                    }

                    for (int time = start; time < end; time++) {
                        jamieSchedule[time] = 1;
                    }
                    solution.append("J");
                }
            }

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}