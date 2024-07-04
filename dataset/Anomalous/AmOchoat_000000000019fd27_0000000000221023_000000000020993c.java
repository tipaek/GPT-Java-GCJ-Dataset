import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            int cases = Integer.parseInt(bf.readLine().trim());
            for (int i = 1; i <= cases; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                Integer[][] matrix = new Integer[n][n];

                for (int row = 0; row < n; row++) {
                    String[] elements = bf.readLine().trim().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(elements[col]);
                    }
                }

                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += matrix[z][z];
                }

                int duplicateRows = 0;
                for (int row = 0; row < n; row++) {
                    if (hasDuplicates(matrix[row])) {
                        duplicateRows++;
                    }
                }

                int duplicateCols = 0;
                for (int col = 0; col < n; col++) {
                    Integer[] column = new Integer[n];
                    for (int row = 0; row < n; row++) {
                        column[row] = matrix[row][col];
                    }
                    if (hasDuplicates(column)) {
                        duplicateCols++;
                    }
                }

                System.out.println("Case #" + i + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicates(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}