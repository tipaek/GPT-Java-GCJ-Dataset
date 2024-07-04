import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    
    static PrintWriter out;
    static long[][] c;

    public static void main(String[] args)  {

        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {

        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] g = new int[r][c];
        long res = 0;
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        boolean[][] single = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        while(true) {
            res += score(g, r, c);
            boolean[][] eb = new boolean[r][c];
            int e = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j] == 0)
                        continue;
                    if (single[i][j])
                        continue;
                    int count = 0;
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        while (0 <= nx && nx < r && 0 <= ny && ny < c && g[nx][ny] == 0) {
                            nx += dx[k];
                            ny += dy[k];
                        }
                        if( nx == i && ny == j) continue;
                        if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                            sum += g[nx][ny];
                            count++;
                        }
                    }
                    if (count == 0) {
                        single[i][j] = true;
                    }
                    if (count > 0 && g[i][j] * count < sum) {
                        eb[i][j] = true;
                        e++;
                    }
                }
            }
            if (e == 0)
                break;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(eb[i][j]) g[i][j] = 0;
                }
            }
        }
        out.println(res);

    }

    static long score (int[][] g, int r, int c) {
        long res = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                res += g[i][j];
            }
        }
        return res;
    }


}