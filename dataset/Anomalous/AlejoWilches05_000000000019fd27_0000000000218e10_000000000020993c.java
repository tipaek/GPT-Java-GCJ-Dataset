import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Vestigium {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;

                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(tokenizer.nextToken());
                    matrix[i][j] = num;

                    if (i == j) {
                        trace += num;
                    }

                    if (!rowSet.add(num) && !rowHasRepeat) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasRepeat = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j]) && !colHasRepeat) {
                        colRepeats++;
                        colHasRepeat = true;
                    }
                }
            }

            writer.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}