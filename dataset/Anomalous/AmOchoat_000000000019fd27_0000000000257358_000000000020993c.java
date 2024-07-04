import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int cases = Integer.parseInt(bf.readLine().trim());
            
            for (int i = 0; i < cases; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                Integer[][] table = new Integer[n][n];

                for (int x = 0; x < n; x++) {
                    String[] row = bf.readLine().trim().split(" ");
                    for (int c = 0; c < n; c++) {
                        table[x][c] = Integer.parseInt(row[c]);
                    }
                }

                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += table[z][z];
                }

                int repeatedRows = 0;
                for (int a = 0; a < n; a++) {
                    if (hasDuplicates(table[a])) {
                        repeatedRows++;
                    }
                }

                int repeatedColumns = 0;
                for (int a = 0; a < n; a++) {
                    if (hasDuplicates(getColumn(table, a))) {
                        repeatedColumns++;
                    }
                }

                result.append("Case #").append(i + 1).append(": ")
                      .append(diagonalSum).append(" ")
                      .append(repeatedRows).append(" ")
                      .append(repeatedColumns).append("\n");
            }
            
            System.out.print(result);
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

    private static Integer[] getColumn(Integer[][] matrix, int columnIndex) {
        Integer[] column = new Integer[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}