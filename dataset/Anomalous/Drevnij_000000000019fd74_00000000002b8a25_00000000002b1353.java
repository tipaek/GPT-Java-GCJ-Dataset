import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int[][] pascal = new int[500][500];
        initializePascalTriangle(pascal);
        
        int t = in.nextInt();  
        for (int x = 1; x <= t; x++) {
            int n = in.nextInt();
            String solution = findSolution(pascal, n);
            System.out.println("Case #" + x + ": " + solution);
        }
    }

    private static void initializePascalTriangle(int[][] pascal) {
        pascal[1][1] = 1;
        for (int i = 2; i < pascal.length; i++) {
            for (int j = 1; j < pascal[i].length; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }

    private static String findSolution(int[][] pascal, int n) {
        StringBuilder solution = new StringBuilder("\n");
        int curI = 1, curJ = 1;
        int sum = pascal[curI][curJ];
        solution.append(curI).append(" ").append(curJ).append("\n");

        if (sum < n) {
            curI = 2;
            curJ = 2;
            sum += pascal[curI][curJ];
            solution.append(curI).append(" ").append(curJ).append("\n");
        }

        if (sum < n) {
            curI = 3;
            curJ = 3;
            sum += pascal[curI][curJ];
            solution.append(curI).append(" ").append(curJ).append("\n");
        }

        while (sum < n) {
            curI++;
            if (curJ == 3 && sum + pascal[curI][curJ] + pascal[curI + 1][curJ] <= n) {
                sum += pascal[curI][curJ];
                solution.append(curI).append(" ").append(curJ).append("\n");
            } else if (sum + pascal[curI][curJ] <= n) {
                sum += pascal[curI][curJ];
                solution.append(curI).append(" ").append(curJ).append("\n");
            } else {
                curI--;
                curJ--;
                sum += pascal[curI][curJ];
                solution.append(curI).append(" ").append(curJ).append("\n");
            }
        }

        return solution.toString();
    }
}