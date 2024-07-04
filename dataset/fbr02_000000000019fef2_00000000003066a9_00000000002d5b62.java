
import java.util.Arrays;
import java.util.Scanner;

public class Solution {




    String dfs(int curX, int curY, int x, int y, int mul) {
        if (curX == x && curY == y) return "";
        if (curX > 100 || curY > 100 || curX < -100 || curY < -100) return infS;
        int jump = (int)Math.pow(2, mul);
        String Xplus = "E" +  dfs(curX + jump, curY, x, y, mul +1);
        String Xmin = "W" +  dfs(curX - jump, curY, x, y, mul +1);
        String Ymin =  "N"  + dfs(curX, curY - jump, x, y, mul +1);
        String Yplus = "S" +  dfs(curX, curY + jump, x, y, mul +1);

        if (Xmin.length() < Xplus.length() && Xmin.length() < Yplus.length() && Xmin.length() < Ymin.length()) return Xmin;
        if (Xplus.length() < Xmin.length() && Xplus.length() < Yplus.length() && Xplus.length() < Ymin.length()) return Xplus;
        if (Yplus.length() < Xmin.length() && Yplus.length() < Xplus.length() && Yplus.length() < Ymin.length()) return Yplus;
        if (Ymin.length() < Xmin.length() && Ymin.length() < Xplus.length() && Ymin.length() < Yplus.length()) return Ymin;
        return Xplus;

    }

    String infS = "";

    void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            sb.append('a');
        }
        infS = sb.toString();

        for (int t = 1; t <= T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            if (X % 2 != 0 && Y % 2 != 0) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            String res = dfs(0, 0, X, Y, 0);
            System.out.println(res);
        }

    }

    public static void main(String[] args) {
        Solution ex = new Solution();
        ex.solve();
    }
}