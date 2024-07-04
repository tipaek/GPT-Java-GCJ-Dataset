import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();

            int[][] schedule = new int[2000][2];
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                boolean impossible = false;

                // Initialize the schedule array
                for (int[] row : schedule) {
                    row[0] = 0;
                    row[1] = 0;
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

                    if (impossible) {
                        break;
                    }
                }

                if (impossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];
                    for (int x = 1; x < 1441; x++) {
                        if (schedule[x - 1][1] == schedule[x][0] && schedule[x][0] != 0) {
                            int tmp = schedule[x][0];
                            schedule[x][0] = schedule[x][1];
                            schedule[x][1] = tmp;
                        } else if (schedule[x - 1][0] == schedule[x][1] && schedule[x][1] != 0) {
                            int tmp = schedule[x][1];
                            schedule[x][1] = schedule[x][0];
                            schedule[x][0] = tmp;
                        }

                        if (schedule[x - 1][0] != schedule[x][0] && schedule[x - 1][0] != 0) {
                            result[schedule[x - 1][0] - 1] = 'C';
                        }
                        if (schedule[x - 1][1] != schedule[x][1] && schedule[x - 1][1] != 0) {
                            result[schedule[x - 1][1] - 1] = 'J';
                        }
                    }
                    System.out.println("Case #" + i + ": " + String.valueOf(result));
                }
            }
        }
    }
}