
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int N = in.nextInt();
            int K = in.nextInt();
            int expectedKCase1 = 0;
            boolean solved = false;
            for (int i = 1; i <= N; i++) {
                expectedKCase1 += i;
            }
            if (expectedKCase1 == K && N % 2 != 0) {
                System.out.println("Case #" + c + ": POSSIBLE");
                for (int i = 0; i < N; i++) {
                    String line = "";
                    for (int j = 0; j < N; j++) {
                        int number = i + j + 1;
                        number = number > N ? number - N : number;
                        line += number + " ";
                    }
                    System.out.println(line.trim());
                }
                continue;
            }
            for (int i = 1; i <= N; i++) {
                if (i * N == K) {
                    System.out.println("Case #" + c + ": POSSIBLE");
                    solveFor(i, N);
                    solved = true;
                }
            }

            if (!solved && N == 4) {
                int[][] solution = canBeSolveOnSquares(K, N);
                if (solution != null) {
                    solved = true;
                    System.out.println("Case #" + c + ": POSSIBLE");
                    printMatrix(createSquare(solution));
                }
            }
            if (!solved) {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }

        }
    }

    public static int[][] createSquare(int[][] solution) {
        int square[][] = {
            {solution[0][0], solution[0][1], solution[1][0], solution[1][1]},
            {solution[1][0], solution[1][1], solution[0][0], solution[0][1]},
            {solution[0][1], solution[0][0], solution[1][1], solution[1][0]},
            {solution[1][1], solution[1][0], solution[0][1], solution[0][0]}
        };
        return square;

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String line = "";
            for (int j = 0; j < matrix[i].length; j++) {
                line += matrix[i][j] + " ";
            }
            System.out.println(line.trim());
        }
    }

    public static int[][] canBeSolveOnSquares(int K, int N) {
        int square[][] = new int[2][2];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if ((i + j) * 2 == K) {
                    square[0][0] = i;
                    square[1][1] = j;
                    int unused = 0;
                    for (int l = 1; l <= N; l++) {
                        if (l != i && l != j) {
                            unused = l;
                        }
                    }
                    int unused2 = 0;
                    for (int l = 1; l <= N; l++) {
                        if (l != i && l != j && l != unused) {
                            unused2 = l;
                        }
                    }
                    square[0][1] = unused;
                    square[1][0] = unused2;
                    return square;
                }
            }
        }
        return null;
    }

    public static void solveFor(int startValue, int N) {
        int number = startValue;
        for (int i = 0; i < N; i++) {
            String line = "";
            for (int j = 0; j < N; j++) {
                line += number + " ";
                number++;
                number = number > N ? 1 : number;
            }
            number--;
            number = number == 0 ? N : number;
            System.out.println(line.trim());
        }
    }
}
