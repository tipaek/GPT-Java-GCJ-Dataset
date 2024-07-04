import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] rowCounts = new int[n][n];
            int[][] colCounts = new int[n][n];
            boolean[] rowRepeats = new boolean[n];
            boolean[] colRepeats = new boolean[n];
            int[] results = new int[3]; // results[0] for trace, results[1] for row repeats, results[2] for column repeats

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = scanner.nextInt() - 1;
                    rowCounts[i][num]++;
                    colCounts[j][num]++;
                    
                    if (rowCounts[i][num] > 1) rowRepeats[i] = true;
                    if (colCounts[j][num] > 1) colRepeats[j] = true;
                    if (i == j) results[0] += num + 1;
                }
            }

            for (boolean rowRepeat : rowRepeats) {
                if (rowRepeat) results[1]++;
            }

            for (boolean colRepeat : colRepeats) {
                if (colRepeat) results[2]++;
            }

            System.out.println("Case #" + t + ": " + results[0] + " " + results[1] + " " + results[2]);
        }

        scanner.close();
    }
}