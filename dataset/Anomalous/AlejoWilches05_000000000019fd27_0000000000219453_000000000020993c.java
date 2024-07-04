import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
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
            int rowRepeats = 0;
            int colRepeats = 0;
            int diagonalSum = 0;
            Set<Integer>[] colSets = new Set[N];

            for (int i = 0; i < N; i++) {
                colSets[i] = new HashSet<>();
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer tk = new StringTokenizer(bf.readLine());
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;

                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(tk.nextToken());
                    mat[i][j] = num;

                    if (!rowHasRepeat && !rowSet.add(num)) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    }

                    if (!colSets[j].add(num)) {
                        colRepeats++;
                    }

                    if (i == j) {
                        diagonalSum += num;
                    }
                }
            }

            pw.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
        }

        bf.close();
        pw.flush();
        pw.close();
    }
}