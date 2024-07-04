import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            StringBuilder finalAnswer = new StringBuilder();
            int n = scanner.nextInt();
            int[][] matrix = new int[n][2];

            for (int j = 0; j < n; j++) {
                matrix[j][0] = scanner.nextInt();
                matrix[j][1] = scanner.nextInt();
            }

            List<int[]> cameron = new ArrayList<>();
            List<int[]> james = new ArrayList<>();

            cameron.add(new int[]{matrix[0][0], matrix[0][1]});
            finalAnswer.append("C");
            boolean found;

            for (int j = 1; j < n; j++) {
                found = false;

                for (int[] interval : cameron) {
                    if ((matrix[j][0] >= interval[0] && matrix[j][0] < interval[1]) || 
                        (matrix[j][1] > interval[0] && matrix[j][1] <= interval[1])) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    finalAnswer.append("C");
                    cameron.add(new int[]{matrix[j][0], matrix[j][1]});
                } else {
                    found = false;
                    for (int[] interval : james) {
                        if ((matrix[j][0] >= interval[0] && matrix[j][0] < interval[1]) || 
                            (matrix[j][1] > interval[0] && matrix[j][1] <= interval[1])) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        finalAnswer.append("J");
                        james.add(new int[]{matrix[j][0], matrix[j][1]});
                    } else {
                        finalAnswer = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + finalAnswer);
        }
    }
}