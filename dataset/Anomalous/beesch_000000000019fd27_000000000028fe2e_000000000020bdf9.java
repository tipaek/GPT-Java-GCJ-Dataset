import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int[][] schedule = new int[1441][2];

            for (int t = 1; t <= testCases; t++) {
                int activities = scanner.nextInt();
                boolean impossible = false;

                // Reset schedule array
                for (int i = 0; i < 1441; i++) {
                    schedule[i][0] = 0;
                    schedule[i][1] = 0;
                }

                for (int i = 1; i <= activities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    for (int j = start; j < end; j++) {
                        if (schedule[j][0] == 0) {
                            schedule[j][0] = i;
                        } else if (schedule[j][1] == 0) {
                            schedule[j][1] = i;
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
                    char[] result = new char[activities * 2];
                    int temp;

                    for (int i = 1; i < 1441; i++) {
                        if (schedule[i - 1][1] == schedule[i][0] && schedule[i][0] != 0) {
                            temp = schedule[i][0];
                            schedule[i][0] = schedule[i][1];
                            schedule[i][1] = temp;
                        } else if (schedule[i - 1][0] == schedule[i][1] && schedule[i][1] != 0) {
                            temp = schedule[i][1];
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

                    System.out.println("Case #" + t + ": " + new String(result).trim());
                }
            }
        }
    }
}