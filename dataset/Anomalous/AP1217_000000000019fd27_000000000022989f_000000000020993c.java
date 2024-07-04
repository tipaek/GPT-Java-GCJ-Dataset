import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        ArrayList<Integer[][]> matrices = new ArrayList<>();

        for (int i = 0; i < testCase; i++) {
            int size = sc.nextInt();
            Integer[][] matrix = new Integer[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            matrices.add(matrix);
        }

        for (int i = 0; i < matrices.size(); i++) {
            Integer[][] matrix = matrices.get(i);

            int trace = calculateTrace(matrix);
            int rowDuplicates = countRowDuplicates(matrix);
            int colDuplicates = countColumnDuplicates(matrix);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(Integer[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(Integer[][] matrix) {
        int rowDuplicates = 0;
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < matrix[row].length; col++) {
                if (!seen.add(matrix[row][col])) {
                    rowDuplicates++;
                    break;
                }
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(Integer[][] matrix) {
        int colDuplicates = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!seen.add(matrix[row][col])) {
                    colDuplicates++;
                    break;
                }
            }
        }
        return colDuplicates;
    }
}