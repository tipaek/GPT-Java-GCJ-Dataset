import java.util.Scanner;

/**
 * Pascal Walk (3pts, 11pts, 21pts)
 */
public class Solution {

    public static void main(String args[]) {

        int LAYERS = 500;
        int[][] TRI = new int[LAYERS][LAYERS];
        for(int r = 0; r < LAYERS; r++) {
            TRI[r][0] = 1;
            TRI[r][r] = 1;
            for(int k = 1; k < r; k++) {
                TRI[r][k] = TRI[r-1][k-1] + TRI[r-1][k];
            }
        }

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            System.out.format("Case #%d:\n", N);

            int r = 0, k = 0;
            int step = 0, left = N;
            while(left > 0) {
                left -= TRI[r][k];
                // System.out.format("%d %d\n", r + 1, k + 1);
                System.out.format("%d %d: %d\n", r + 1, k + 1, TRI[r][k]);
                // next walk
                if(left == 0 || ++step > 500) {
                    break;
                } else if(left > r + 1){
                    r++;
                    if(k == 0) {
                        k++;
                    }
                } else {
                    if(k > 0) {
                        k--;
                    } else {
                        r++;
                    }
                }
            }
            // System.out.format("Case #%d: %s\n", t, "*");
        }
    }
}