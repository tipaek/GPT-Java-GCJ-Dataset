import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[][] matrix;

        try {
            System.out.println("Casos");
            int cases = Integer.parseInt(bf.readLine().trim());

            for (int i = 0; i < cases; i++) {
                System.out.println("N");
                int n = Integer.parseInt(bf.readLine().trim());
                matrix = new Integer[n][n];

                for (int x = 0; x < n; x++) {
                    System.out.println("Fila");
                    String[] row = bf.readLine().trim().split(" ");
                    for (int c = 0; c < n; c++) {
                        matrix[x][c] = Integer.parseInt(row[c]);
                    }
                }

                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += matrix[z][z];
                }

                int duplicateColumns = countDuplicates(matrix, n, true);
                int duplicateRows = countDuplicates(matrix, n, false);

                System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateColumns + " " + duplicateRows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countDuplicates(Integer[][] matrix, int n, boolean checkColumns) {
        int duplicates = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                for (int e = b + 1; e < n; e++) {
                    if (checkColumns) {
                        if (matrix[a][b].equals(matrix[a][e])) {
                            duplicates++;
                        }
                    } else {
                        if (matrix[b][a].equals(matrix[e][a])) {
                            duplicates++;
                        }
                    }
                }
            }
        }
        return duplicates;
    }
}