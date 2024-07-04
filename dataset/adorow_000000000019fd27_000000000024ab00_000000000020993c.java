
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/qualification/A/A.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_Vestigium.out"));

        int M[][] = new int[101][101];

        BitSet rowsWithDup = new BitSet();
        BitSet colsWithDup = new BitSet();

        BitSet[] row = new BitSet[101];
        BitSet[] col = new BitSet[101];
        for (int i = 0; i < 101; i++) {
            row[i] = new BitSet();
            col[i] = new BitSet();
        }

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int k = 0;
            int r, c;

            int N = in.nextInt();

            // clear bits
            rowsWithDup.clear();
            colsWithDup.clear();
            for (int i = 0; i <= N; i++) {
                row[i].clear();
                col[i].clear();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int v = in.nextInt();
                    if (row[i].get(v)) {
                        rowsWithDup.set(i);
                    }
                    row[i].set(v);
                    if (col[j].get(v)) {
                        colsWithDup.set(j);
                    }
                    col[j].set(v);

                    if (i == j) k += v; // trace
                    M[i][j] = v;
                }
            }

            r = rowsWithDup.cardinality();
            c = colsWithDup.cardinality();

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

            out.print(k);
            out.print(' ');
            out.print(r);
            out.print(' ');
            out.print(c);

            out.println();
        }
        out.flush();
    }

}
