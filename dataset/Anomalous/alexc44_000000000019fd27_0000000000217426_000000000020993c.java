import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < row.length; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + computeResult(matrix));
        }

        scanner.close();
    }

    public static String computeResult(int[][] matrix) {
        int trace = 0;
        int rowRep = 0;
        int colRep = 0;
        HashSet<String> colValues = new HashSet<>();
        HashSet<Integer> colCheck = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowValues = new HashSet<>();
            boolean foundRowRep = false;

            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];

                if (i == j) {
                    trace += current;
                }

                String colKey = j + "," + current;
                if (colValues.contains(colKey) && !colCheck.contains(j)) {
                    colRep++;
                    colCheck.add(j);
                } else {
                    colValues.add(colKey);
                }

                if (rowValues.contains(current) && !foundRowRep) {
                    rowRep++;
                    foundRowRep = true;
                } else {
                    rowValues.add(current);
                }
            }
        }

        return trace + " " + rowRep + " " + colRep;
    }
}