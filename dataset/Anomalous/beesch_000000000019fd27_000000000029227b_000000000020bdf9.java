import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                int[][] schedule = new int[1441][2];
                boolean isImpossible = false;

                for (int i = 0; i < schedule.length; i++) {
                    schedule[i][0] = 0;
                    schedule[i][1] = 0;
                }

                for (int j = 1; j <= n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    for (int k = start; k < end; k++) {
                        if (k >= schedule.length) break;

                        if (schedule[k][0] == 0) {
                            schedule[k][0] = j;
                        } else if (schedule[k][1] == 0) {
                            schedule[k][1] = j;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) break;
                }

                if (isImpossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];

                    for (int l = 1; l < schedule.length; l++) {
                        if (schedule[l - 1][1] == schedule[l][0] && schedule[l][0] != 0) {
                            int temp = schedule[l][0];
                            schedule[l][0] = schedule[l][1];
                            schedule[l][1] = temp;
                        } else if (schedule[l - 1][0] == schedule[l][1] && schedule[l][1] != 0) {
                            int temp = schedule[l][1];
                            schedule[l][1] = schedule[l][0];
                            schedule[l][0] = temp;
                        }

                        if (schedule[l - 1][0] != schedule[l][0] && schedule[l - 1][0] != 0) {
                            result[schedule[l - 1][0] - 1] = 'C';
                        }
                        if (schedule[l - 1][1] != schedule[l][1] && schedule[l - 1][1] != 0) {
                            result[schedule[l - 1][1] - 1] = 'J';
                        }
                    }
                    System.out.println("Case #" + caseNumber + ": " + new String(result));
                }
            }
        }
    }
}