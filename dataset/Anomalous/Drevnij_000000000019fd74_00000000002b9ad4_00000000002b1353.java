import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int[][] pascal = new int[500][500];
        pascal[1][1] = 1;
        for (int i = 2; i < pascal.length; i++) {
            for (int j = 1; j < pascal[i].length; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        int t = scanner.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder("\n");

            int curI = 1, curJ = 1, sum = pascal[curI][curJ];
            solution.append(curI).append(" ").append(curJ).append("\n");

            if (sum < n) {
                curI = 2;
                curJ = 2;
                sum += pascal[curI][curJ];
                solution.append(curI).append(" ").append(curJ).append("\n");
            }

            while (sum < n) {
                curI++;
                if (sum + pascal[curI][curJ] <= n) {
                    sum += pascal[curI][curJ];
                    solution.append(curI).append(" ").append(curJ).append("\n");
                } else {
                    curI--;
                    curJ--;
                    sum += pascal[curI][curJ];
                    solution.append(curI).append(" ").append(curJ).append("\n");
                }
            }

            System.out.println("Case #" + x + ": " + solution);
        }
    }
}