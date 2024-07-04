import java.util.HashSet;
import java.util.Scanner;

public class Solution {


    private static class Trace {

        private int k;
        private int r;
        private int c;

        public Trace(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }

        public int getK() {
            return k;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }


    private static Trace computeTrace(int[][] m, int n) {

        int k = 0;
        int r = 0;
        int c = 0;

        for(int i=0; i<n; i++) {
            k += m[i][i];
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0; j<n; j++) {
                int val = m[i][j];
                if(hs.contains(val)) {
                    r++;
                    break;
                }
                hs.add(val);
            }
        }

        for(int i=0; i<n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for(int j=0; j<n; j++) {
                int val = m[j][i];
                if(hs.contains(val)) {
                    c++;
                    break;
                }
                hs.add(val);
            }
        }

        return new Trace(k, r, c);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=1; i<=t; i++) {
            int n = in.nextInt();
            int m[][] = new int[n][n];
            for(int j=0; j<n; j++) {
                for (int k = 0; k < n; k++) {
                    m[j][k] = in.nextInt();
                }
            }
            Trace trace = computeTrace(m, n);
            System.out.printf("Case #%d: %d %d %d\n", i, trace.getK(), trace.getR(), trace.getC());
        }

    }

}
