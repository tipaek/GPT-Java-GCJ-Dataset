import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder rta = new StringBuilder();
            int casos = Integer.parseInt(bf.readLine().trim());

            for (int i = 0; i < casos; i++) {
                int n = Integer.parseInt(bf.readLine().trim());
                int[][] tabla = new int[n][n];

                for (int x = 0; x < n; x++) {
                    String[] fila = bf.readLine().split(" ");
                    for (int c = 0; c < n; c++) {
                        tabla[x][c] = Integer.parseInt(fila[c]);
                    }
                }

                int diagonalSum = calculateDiagonalSum(tabla, n);
                int repeatedRows = countRepeatedRows(tabla, n);
                int repeatedColumns = countRepeatedColumns(tabla, n);

                rta.append("Case #").append(i + 1).append(": ")
                   .append(diagonalSum).append(" ")
                   .append(repeatedRows).append(" ")
                   .append(repeatedColumns).append("\n");
            }

            System.out.println(rta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateDiagonalSum(int[][] tabla, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += tabla[i][i];
        }
        return sum;
    }

    private static int countRepeatedRows(int[][] tabla, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(tabla[i])) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedColumns(int[][] tabla, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = tabla[j][i];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}