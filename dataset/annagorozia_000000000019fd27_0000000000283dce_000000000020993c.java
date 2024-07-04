
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class Result {
        int k;
        int r;
        int c;

        @Override
        public String toString() {
            return k + " " + r + " " + c;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        short T = myReader.nextShort();
        for (int i = 0; i < T; i++) {
            short N = myReader.nextShort();
            short[][] m = new short[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    m[r][c] = myReader.nextShort();
                }
            }
            Result r = validateMatrix(m, N);
            System.out.println("Case #" + (i + 1) + ": " + r);
        }

        myReader.close();
    }

    private static Result validateMatrix(short[][] m, short n) {
        Result r = new Result();
        r.k = calculateDiagonal(m, n);
        r.r = calculateRepeatsInRow(m, n);
        r.c = calculateRepeatsInColumn(m, n);
        return r;
    }

    private static int calculateRepeatsInRow(short[][] m, short n) {
        int res = 0;
        Set<Short> set = new HashSet<>();
        for (int r = 0; r < n; r++) {
            set.clear();
            for (int c = 0; c < n; c++) {
                if (set.contains(m[r][c])) {
                    res++;
                    break;
                } else {
                    set.add(m[r][c]);
                }
            }
        }
        return res;
    }

    private static int calculateRepeatsInColumn(short[][] m, short n) {
        int res = 0;
        Set<Short> set = new HashSet<>();
        for (int c = 0; c < n; c++) {
            set.clear();
            for (int r = 0; r < n; r++) {
                if (set.contains(m[r][c])) {
                    res++;
                    break;
                } else {
                    set.add(m[r][c]);
                }
            }
        }
        return res;
    }

    private static int calculateDiagonal(short[][] m, short n) {
        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == c) res += m[r][c];
            }
        }
        return res;
    }


}
