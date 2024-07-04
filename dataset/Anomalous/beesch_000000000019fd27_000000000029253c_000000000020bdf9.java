import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_2020_3 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int[][] schedule = new int[1441][2];

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                try {
                    int n = scanner.nextInt();
                    boolean impossible = false;

                    // Reset the schedule array
                    for (int i = 0; i < schedule.length; i++) {
                        schedule[i][0] = 0;
                        schedule[i][1] = 0;
                    }

                    for (int task = 1; task <= n; task++) {
                        int start = scanner.nextInt();
                        int end = scanner.nextInt();

                        for (int time = start; time < end; time++) {
                            if (time >= schedule.length) break;

                            if (schedule[time][0] == 0) {
                                schedule[time][0] = task;
                            } else if (schedule[time][1] == 0) {
                                schedule[time][1] = task;
                            } else {
                                impossible = true;
                                break;
                            }
                        }

                        if (impossible) break;
                    }

                    if (impossible) {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    } else {
                        char[] result = new char[n];
                        for (int i = 1; i < schedule.length; i++) {
                            if (i - 1 < 0) continue;

                            if (schedule[i - 1][1] == schedule[i][0] && schedule[i][0] != 0) {
                                int temp = schedule[i][0];
                                schedule[i][0] = schedule[i][1];
                                schedule[i][1] = temp;
                            } else if (schedule[i - 1][0] == schedule[i][1] && schedule[i][1] != 0) {
                                int temp = schedule[i][1];
                                schedule[i][1] = schedule[i][0];
                                schedule[i][0] = temp;
                            }

                            if (schedule[i - 1][0] != schedule[i][0] && schedule[i - 1][0] != 0) {
                                result[schedule[i - 1][0] - 1] = 'C';
                            }
                            if (schedule[i - 1][1] != schedule[i][1] && schedule[i - 1][1] != 0) {
                                result[schedule[i - 1][1] - 1] = 'J';
                            }
                        }
                        System.out.println("Case #" + caseNumber + ": " + new String(result));
                    }
                } catch (Exception e) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
            }
        }
    }
}