import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int size = scanner.nextInt();
            int diagonalSum = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = (col + row) % size + 1;
                }
            }

            ArrayList<ArrayList<int[]>> permutations = generatePermutations(matrix);

            boolean found = false;
            int permutationIndex = 0;
            while (permutationIndex < permutations.size() && !found) {
                if (calculateDiagonalSum(permutations.get(permutationIndex)) == diagonalSum) {
                    found = true;
                } else {
                    permutationIndex++;
                }
            }

            if (found) {
                System.out.println("Case #" + (caseIndex + 1) + ": POSSIBLE");
                printMatrix(permutations.get(permutationIndex));
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static ArrayList<ArrayList<int[]>> generatePermutations(int[][] matrix) {
        ArrayList<ArrayList<int[]>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int[] row : matrix) {
            ArrayList<ArrayList<int[]>> current = new ArrayList<>();

            for (ArrayList<int[]> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    list.add(j, row);
                    ArrayList<int[]> temp = new ArrayList<>(list);
                    current.add(temp);
                    list.remove(j);
                }
            }
            result = new ArrayList<>(current);
        }
        return result;
    }

    private static int calculateDiagonalSum(ArrayList<int[]> matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.size(); i++) {
            sum += matrix.get(i)[i];
        }
        return sum;
    }

    private static void printMatrix(ArrayList<int[]> matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}