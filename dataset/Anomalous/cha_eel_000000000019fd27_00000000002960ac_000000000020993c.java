import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int n = sc.nextInt();
            sc.nextLine();  // Consume the newline character
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int rowRepeats = 0, colRepeats = 0, diagonalSum = 0;

            // Check for repeated elements in each row
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for repeated elements in each column and calculate diagonal sum
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
                diagonalSum += matrix[j][j];
            }

            out.println("Case #" + tt + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        out.flush();
        sc.close();
    }
}