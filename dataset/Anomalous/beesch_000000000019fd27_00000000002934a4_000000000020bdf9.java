import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int i = 1; i <= testCases; i++) {
                int n = scanner.nextInt();
                int[][] schedule = new int[1441][2];
                boolean isImpossible = false;
                scanner.nextLine();

                for (int j = 0; j < 1441; j++) {
                    schedule[j][0] = 0;
                    schedule[j][1] = 0;
                }

                for (int j = 1; j <= n; j++) {
                    String[] times = scanner.nextLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);

                    for (int k = start; k < end; k++) {
                        if (schedule[k][0] == 0) {
                            schedule[k][0] = j;
                        } else if (schedule[k][1] == 0) {
                            schedule[k][1] = j;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) {
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];
                    for (int j = 1; j < 1441; j++) {
                        if (schedule[j - 1][1] == schedule[j][0] && schedule[j][0] != 0) {
                            int temp = schedule[j][0];
                            schedule[j][0] = schedule[j][1];
                            schedule[j][1] = temp;
                        } else if (schedule[j - 1][0] == schedule[j][1] && schedule[j][1] != 0) {
                            int temp = schedule[j][1];
                            schedule[j][1] = schedule[j][0];
                            schedule[j][0] = temp;
                        }

                        if (schedule[j - 1][0] != 0 && schedule[j - 1][0] != schedule[j][0]) {
                            result[schedule[j - 1][0] - 1] = 'C';
                        }
                        if (schedule[j - 1][1] != 0 && schedule[j - 1][1] != schedule[j][1]) {
                            result[schedule[j - 1][1] - 1] = 'J';
                        }
                    }
                    System.out.println("Case #" + i + ": " + new String(result));
                }
            }
        } catch (Exception e) {
            System.out.println("Case #: IMPOSSIBLE");
        }
    }
}