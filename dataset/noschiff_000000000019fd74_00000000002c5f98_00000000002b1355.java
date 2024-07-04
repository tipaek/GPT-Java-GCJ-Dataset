import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {

            //for creating a matrix of N by N
            String[] numbers = scanner.nextLine().split(" ");
            int R = Integer.valueOf(numbers[0]);
            int C = Integer.valueOf(numbers[1]);
            String[] input = new String[R];
            for (int j = 0; j < C; j++) {
                try {
                    input[j] = scanner.nextLine();
                } catch (Exception ignored) {}
            }
            int[][] matrix = new int[R][C];
            for (int j = 0; j < R; j++) {
                String[] inputs = input[j].split(" ");
                for (int k = 0; k < C; k++) {
                    matrix[j][k] = Integer.valueOf(inputs[k]);
                }
            }
            int answer = solve(matrix);
            System.out.println("Case #" + (i + 1) + ": " + answer);
        }
    }

    private static int solve(int[][] matrix) {
        int total = 0;
        while (true) {
            int currentInterest = 0;
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] != -1) {
                        currentInterest += matrix[row][col];
                    }
                }
            }
            total += currentInterest;

            boolean changedAny = false;
            ArrayList<int[]> redo= new ArrayList<>();
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col]==-1) {
                        continue;
                    }
                    int sum = 0 ;
                    int count = 0;
                    try {
                        if (matrix[row - 1][col] > 0) {
                            sum += matrix[row - 1][col];
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {
                        if (matrix[row][col-1] > 0) {
                            sum += matrix[row][col-1];
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {
                        if (matrix[row +1][col] > 0) {
                            sum += matrix[row +1][col];
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                    try {
                        if (matrix[row][col+1] > 0) {
                            sum += matrix[row][col+1];
                            count++;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}

                    double average = (double)sum / count;
                    if (average > matrix[row][col]) {
                        redo.add(new int[]{row,col});
                        changedAny = true;
                    }
                }
            }
            for (int[] pos : redo) {
                matrix[pos[0]][pos[1]] = -1;
            }
            if (!changedAny) {
                break;
            }
        }
        return total;
    }
}
