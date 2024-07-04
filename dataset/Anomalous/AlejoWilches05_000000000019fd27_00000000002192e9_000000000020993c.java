import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(bf.readLine());
        int caseNumber = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(bf.readLine());
            int[][] mat = new int[N][N];
            int repeatedRows = 0;
            int repeatedCols = 0;
            int diagonalSum = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer tk = new StringTokenizer(bf.readLine());
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(tk.nextToken());
                    mat[i][j] = num;

                    // Check for duplicates in the row
                    if (!rowSet.add(num) && !rowHasDuplicate) {
                        repeatedRows++;
                        rowHasDuplicate = true;
                    }

                    // Check for duplicates in the column
                    for (int k = 0; k < i; k++) {
                        if (mat[k][j] == num) {
                            repeatedCols++;
                            break;
                        }
                    }

                    // Sum the diagonal
                    if (i == j) {
                        diagonalSum += num;
                    }
                }
            }

            pw.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
            caseNumber++;
        }

        bf.close();
        pw.flush();
        pw.close();
    }
}