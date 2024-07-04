import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

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

                for (int row = 0; row < n; row++) {
                    System.out.println("Fila");
                    String[] rowValues = bf.readLine().trim().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(rowValues[col]);
                    }
                }

                int diagonalSum = 0;
                for (int z = 0; z < n; z++) {
                    diagonalSum += matrix[z][z];
                }

                int duplicateColumns = 0;
                for (int col = 0; col < n; col++) {
                    boolean[] seen = new boolean[n + 1];
                    for (int row = 0; row < n; row++) {
                        if (seen[matrix[row][col]]) {
                            duplicateColumns++;
                            break;
                        }
                        seen[matrix[row][col]] = true;
                    }
                }

                int duplicateRows = 0;
                for (int row = 0; row < n; row++) {
                    boolean[] seen = new boolean[n + 1];
                    for (int col = 0; col < n; col++) {
                        if (seen[matrix[row][col]]) {
                            duplicateRows++;
                            break;
                        }
                        seen[matrix[row][col]] = true;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateColumns + " " + duplicateRows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}