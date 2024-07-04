import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static boolean found;
    static int[][] square;

    static void possibleSquares(int i, int v, int n, int sum, int t) {
        if(found) return;
        int x = i % n, y = i/n;
        square[y][x] = v;
        if(i == n*n - 1) {
            int s = 0;
            for(int j = 0; j < n; j++) s += square[j][j];
            if(s == sum) {
                System.out.println("Case #" + t + ": POSSIBLE");
                for(x = 0; x < n; x++) {
                    for(y = 0; y < n; y++) {
                        System.out.print(square[y][x]);
                        if(y < n - 1) System.out.print(" ");
                    }
                    System.out.println();
                }
                found = true;
            }
            return;
        }
        for(int q = 1; q <= n; q++) {
            x = (i + 1) % n; y = (i+1)/n;
            boolean valid = true;
            for(int p = x-1; p >= 0; p--)
                if(square[y][p] == q) {
                    valid = false;
                    break;
                }
            if(!valid) continue;
            for(int p = y-1; p >= 0; p--)
                if(square[p][x] == q) {
                    valid = false;
                    break;
                }
            if(!valid) continue;
            possibleSquares(i+1, q, n, sum, t);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(input.readLine());
        for(int t = 1; t <= tests; t++) {
            found = false;
            StringTokenizer data = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(data.nextToken()),
                    k = Integer.parseInt(data.nextToken());
            square = new int[n][n];
            int[] arr = new int[n];
            for(int i = 1; i <= n; i++) arr[i-1] = i;
            for(int v = 1; v <= n; v++) possibleSquares(0, v, n, k, t);
            if(!found) System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }

}
