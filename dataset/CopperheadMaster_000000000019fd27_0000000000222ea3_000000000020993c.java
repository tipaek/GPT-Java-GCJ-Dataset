
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();

            int n[][] = new int[N][N];
            int trace = 0;
            int c = 0;
            int r = 0;
            for (int k = 0; k < N; k++) {
                boolean checkedR = false;
                boolean[] existsR = new boolean[N];
                for (int j = 0; j < N; j++) {
                    int it = in.nextInt();
                    if (!checkedR) {
                        if (existsR[it - 1]) {
                            r++;
                            checkedR = true;
                        }
                        existsR[it - 1] = true;
                    }
                    n[k][j] = it;
                    if (k == j) {
                        trace += it;
                    }
                }
            }

            for (int k = 0; k < N; k++){
                boolean[] existsC = new boolean[N];
                int j = 0;
                while(j < N){
                    int it = n[j][k];
                    if (existsC[it - 1]){
                        c++;
                        break;
                    }
                    existsC[it - 1] = true;
                    j++;
                }

            }
            System.out.println("Case #" + i + ": " + (trace) + " " + (r) + " " + (c));
        }
    }
}
