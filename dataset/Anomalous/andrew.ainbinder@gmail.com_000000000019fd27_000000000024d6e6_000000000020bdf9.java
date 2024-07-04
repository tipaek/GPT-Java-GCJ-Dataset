import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            int activities = scanner.nextInt();
            boolean impossible = false;
            StringBuilder solution = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToCameron = true;

                // Check Cameron's availability
                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time] != 0) {
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

                    // Check Jamie's availability
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time] != 0) {
                            assignedToJamie = false;
                            break;
                        }
                    }

                    if (assignedToJamie) {
                        for (int time = start; time < end; time++) {
                            jamieSchedule[time] = 1;
                        }
                        solution.append("J");
                    } else {
                        solution = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + solution);
        }
    }
}