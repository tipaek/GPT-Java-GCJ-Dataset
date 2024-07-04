import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            int e = sc.nextInt();
            int[][] N = new int[e][e];
            int k = 0;
            int r = 0;
            int c = 0;
            for (int x = 0; x < e; x++) {
                for (int y = 0; y < e; y++) {
                   N[x][y] = sc.nextInt();
                   if (x == y) {
                       k = k + N[x][y];
                    }
                }
            }
            for (int x = 0; x < e; x++) {
                boolean rig = false;
                for (int y = 0; y < e; y++) {
                    int n = N[x][y];
                    for (int y1 = y + 1;y1 < e; y1++){
                        if (n == N[x][y1]) {
                            rig = true;
                        }
                    }
                }
                if (rig) {
                   r++;
                }
            }
            for (int y = 0; y < e; y++) {
                boolean rig = false;
                for (int x = 0; x < e; x++) {
                    int n = N[x][y];
                    for (int x1 = x + 1; x1 < e; x1++){
                        if (n == N[x1][y]) {
                                rig = true;
                        }
                    }
                }
                if (rig) {
                    c++;
                }
            }
            System.out.println("Case #" + cas + ": " + k + " " + r + " " + c);
        }
    }
}
