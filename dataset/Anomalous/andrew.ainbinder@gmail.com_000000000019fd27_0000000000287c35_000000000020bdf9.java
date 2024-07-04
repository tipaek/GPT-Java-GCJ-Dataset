import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder solution = new StringBuilder();

            for (int activity = 0; activity < numberOfActivities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToCameron = true;

                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time] != 0) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                if (canAssignToCameron) {
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = 1;
                    }
                    solution.append("C");
                } else {
                    boolean canAssignToJamie = true;
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time] != 0) {
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

            System.out.println("Case #" + caseNumber + ": " + solution);
        }
    }
}