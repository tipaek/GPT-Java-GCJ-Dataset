import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                int[][] schedule = new int[1440][2];
                boolean isImpossible = false;

                for (int j = 0; j < n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    
                    for (int k = start; k < end; k++) {
                        if (schedule[k][0] == 0) {
                            schedule[k][0] = j + 1;
                        } else if (schedule[k][1] == 0) {
                            schedule[k][1] = j + 1;
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
                    for (int j = 0; j < 1440; j++) {
                        if (schedule[j][0] != 0) {
                            result[schedule[j][0] - 1] = 'C';
                        }
                        if (schedule[j][1] != 0) {
                            result[schedule[j][1] - 1] = 'J';
                        }
                    }
                    System.out.println("Case #" + i + ": " + new String(result));
                }
            }
        }
    }
}