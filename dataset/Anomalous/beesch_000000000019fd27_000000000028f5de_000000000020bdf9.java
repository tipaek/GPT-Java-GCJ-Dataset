import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            int[][] schedule = new int[1441][2];

            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                boolean impossible = false;

                for (int j = 0; j < 1441; j++) {
                    schedule[j][0] = 0;
                    schedule[j][1] = 0;
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
                    int temp;

                    for (int j = 1; j < 1441; j++) {
                        if (schedule[j - 1][1] == schedule[j][0] && schedule[j][0] != 0) {
                            temp = schedule[j][0];
                            schedule[j][0] = schedule[j][1];
                            schedule[j][1] = temp;
                        } else if (schedule[j - 1][0] == schedule[j][1] && schedule[j][1] != 0) {
                            temp = schedule[j][1];
                            schedule[j][1] = schedule[j][0];
                            schedule[j][0] = temp;
                        }

                        if (schedule[j - 1][0] != schedule[j][0] && schedule[j - 1][0] != 0) {
                            result[schedule[j - 1][0] - 1] = 'C';
                        }
                        if (schedule[j - 1][1] != schedule[j][1] && schedule[j - 1][1] != 0) {
                            result[schedule[j - 1][1] - 1] = 'J';
                        }
                    }

                    System.out.print("Case #" + i + ": ");
                    for (char c : result) {
                        System.out.print(c);
                    }
                    System.out.println();
                }
            }
        }
    }
}