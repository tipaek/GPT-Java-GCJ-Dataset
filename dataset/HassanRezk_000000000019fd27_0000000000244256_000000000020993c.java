import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class Solution {

    static BufferedReader in;
    static BufferedWriter out;

    public static void main(String... args) throws IOException {
        String line;
        String[] splittedLine;
        int cases = Integer.parseInt(in.readLine());
        for(int caseI = 1; caseI <= cases; ++caseI) {
            int n = Integer.parseInt(in.readLine());
            int[][] m = new int[n][n];
            for(int r = 0; r < n; ++r) {
                line = in.readLine();
                splittedLine = line.split(" ");
                if(splittedLine.length != n) throw new IllegalStateException("Not Allowed");
                for(int c = 0; c < n; ++c) {
                    m[r][c] = Integer.parseInt(splittedLine[c]);
                }
            }
            Matrix mat = new Matrix(m);
            out.write(format("Case #%d: %d %d %d\n", caseI, mat.diagonalSum, mat.dubR, mat.dubC));
        }
        in.close();
        out.close();
    }

    static {
//        String FILE_IN = "v.in";
//        String FILE_OUT = "v.out";
        //            in = new BufferedReader(new FileReader(FILE_IN));
//            out  = new BufferedWriter(new FileWriter(FILE_OUT));

        in = new BufferedReader(new InputStreamReader(System.in));
        out  = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static class Matrix {
        int n;
        int[][] m;

        int diagonalSum;
        int dubR;
        int dubC;

        Matrix(int[][] m) {
            this.m = m;
            this.n = m.length;
            init();
        }

        void init() {
            for(int i = 0; i < n; ++i) {
                diagonalSum += m[i][i];
                Set<Integer> cntR = new HashSet<>();
                Set<Integer> cntC = new HashSet<>();
                boolean rDub = false;
                boolean cDub = false;
                for(int j = 0; j < n; ++j) {
                    int vR = m[i][j];
                    int vC = m[j][i];

                    if(cntR.contains(vR)) rDub = true;
                    if(cntC.contains(vC)) cDub = true;

                    cntR.add(vR);
                    cntC.add(vC);
                }
                if(rDub) ++dubR;
                if(cDub) ++dubC;
            }
        }
    }

}
