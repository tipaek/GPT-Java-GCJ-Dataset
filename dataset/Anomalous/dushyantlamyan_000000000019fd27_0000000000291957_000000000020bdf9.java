import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int countN = scanner.nextInt();
            int[][] intervals = new int[countN][2];
            
            for (int j = 0; j < countN; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            StringBuilder output = new StringBuilder();
            boolean possible = true;
            int cEnd = 0, jEnd = 0;

            for (int j = 0; j < countN; j++) {
                int start = intervals[j][0];
                int end = intervals[j][1];

                if (start >= cEnd) {
                    output.append('C');
                    cEnd = end;
                } else if (start >= jEnd) {
                    output.append('J');
                    jEnd = end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? output.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + result);
        }
    }
}