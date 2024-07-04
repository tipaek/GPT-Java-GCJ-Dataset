import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    class InputDataObj {
        int N, K;
        public InputDataObj(int N, int K) {
            this.N = N;
            this.K = K;
        }
    }

    class OutputObj {
        String possOrNot;
        int[][] matrix;
        public OutputObj(String possOrNot, int[][] matrix) {
            this.possOrNot = possOrNot;
            this.matrix = matrix;
        }
    }

    public static boolean isValidInRow(int[][] grid, int row, int num) {
        for (int i = 0; i < grid.length; i++)
            if (grid[row][i] == num) return false;

        return true;
    }

    public static boolean isValidInCol(int[][] grid, int col, int num) {
        for (int i = 0; i < grid.length; i++)
            if (grid[i][col] == num) return false;

        return true;
    }

    public static boolean isValidTrace(int[][] grid, int K) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) sum += grid[i][i];
        return (sum == K);
    }

    public static boolean isValid(int[][] grid, int row, int col, int num, int K) {
        return isValidInRow(grid, row, num) && isValidInCol(grid, col, num);
    }

    private static boolean solve(int[][] grid, int N, int K) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k <= N; k++) {
                        if (isValid(grid, i, j, k, K)) {
                            grid[i][j] = k;
                            if (solve(grid, N, K) && isValidTrace(grid, K)) return true;
                            else grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return isValidTrace(grid, K);
    }


    private static OutputObj findSolution(int N, int K) {
        int[][] matrix = new int[N][N];

        if (!solve(matrix, N, K)) {
            return new Solution(). new OutputObj("IMPOSSIBLE", matrix);
        } else {
            return new Solution(). new OutputObj("POSSIBLE", matrix);
        }
    }

    public static ArrayList<InputDataObj> getDataFromStdIn() {
        ArrayList<InputDataObj> input = new ArrayList<>();
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = 0;
        if (myReader.hasNextLine()) {
            T = Integer.valueOf(myReader.nextLine());
        }
        for (int i = 0; i < T; i++) {
            if (myReader.hasNextLine()) {
                String[] inp = myReader.nextLine().replace("\n", "").trim().split(" ");
                input.add(new Solution(). new InputDataObj(Integer.valueOf(inp[0]), Integer.valueOf(inp[1])));
            }
        }
        return input;
    }

    public static void printOutput(OutputObj outputObj, int testNum) {
        System.out.printf("Case #%d: %s\n", testNum, outputObj.possOrNot);
        if (outputObj.possOrNot.equals("POSSIBLE")) {
            int N = outputObj.matrix.length;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d ", outputObj.matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<InputDataObj> inputData = getDataFromStdIn();
        ArrayList<OutputObj> outputData = new ArrayList<>();
        int i = 0;
        for (InputDataObj input: inputData) {
            outputData.add(findSolution(input.N, input.K));
            printOutput(outputData.get(i), i+1);
            i++;
        }
    }
}
