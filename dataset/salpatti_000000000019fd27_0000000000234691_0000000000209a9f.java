import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            String S = in.next();
            int n = 0;
            StringBuilder r = new StringBuilder();
            for (char c : S.toCharArray()) {
                int v = Character.getNumericValue(c);
                if (n == v) {
                    //Nothing to do
                } else if (n < v) {
                    int d = v-n;
                    for(int e=0;e<d;e++)
                        r.append('(');
                    n+=d;
                } else if (n > v) {
                    int d = n-v;
                     for(int e=0;e<d;e++)
                        r.append(')');
                     n-=d;
                }
                r.append(c);
            }
            //close all
            for (int i = 0; i < n; i++) {
                r.append(')');
            }

            System.out.println("Case #" + t + ": " + r.toString());
        }
    }

    public static void vestigum(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    M[j][k] = in.nextInt();
                }
            }

            Set<Integer> rows = new HashSet<Integer>();
            Set<Integer> cols = new HashSet<Integer>();

            int[][] occorrenzeRows = new int[N][N];
            int[][] occorrenzeCols = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int v = M[j][k];
                    occorrenzeRows[j][v - 1] += 1;
                    occorrenzeCols[k][v - 1] += 1;
                    if (occorrenzeRows[j][v - 1] > 1) {
                        rows.add(j);
                    }
                    if (occorrenzeCols[k][v - 1] > 1) {
                        cols.add(k);
                    }
                }
            }

            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += M[j][j];
            }

            int r = rows.size();
            int c = cols.size();

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
