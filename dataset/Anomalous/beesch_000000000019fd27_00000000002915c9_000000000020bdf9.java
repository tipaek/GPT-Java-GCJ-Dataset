import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int[][] schedule = new int[1441][2];
                boolean impossible = false;

                // Initialize the schedule array
                for (int i = 0; i < schedule.length; i++) {
                    schedule[i][0] = 0;
                    schedule[i][1] = 0;
                }

                for (int j = 1; j <= n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    for (int k = start; k < end; k++) {
                        if (schedule[k][0] == 0) {
                            schedule[k][0] = j;
                        } else if (schedule[k][1] == 0) {
                            schedule[k][1] = j;
                        } else {
                            impossible = true;
                            break;
                        }
                    }
                    if (impossible) break;
                }

                if (impossible) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];

                    for (int i = 1; i < schedule.length; i++) {
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
                    System.out.println("Case #" + t + ": " + String.valueOf(result).trim());
                }
            }
        }
    }
}