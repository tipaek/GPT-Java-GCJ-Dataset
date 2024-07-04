import java.util.Scanner;

public class Solution {
    static String p = "";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for(int i = 1; i <= tests; i++){
            int X = input.nextInt();
            int Y = input.nextInt();
            p = "";
            String result = Solve(X, Y);

            System.out.println( String.format("Case #%d: %s", i, result) );
        }
    }

    static String Solve(int X, int Y){
        int x = 0;
        int y = 0;
        StringBuilder path = new StringBuilder();
        dfs(X, Y, 0, 0, 1, path);        
        return p.length() > 0 ? p : "IMPOSSIBLE";
    }

    static void dfs(int X, int Y, int x, int y, int step, StringBuilder path) {
        if (x == X && y == Y) { 
            if (p.length() == 0 || p.length() > path.length()) {
                p = path.toString();
            }
            return;
        }
        if (step > Math.abs(x - X) && step > Math.abs(y - Y)) {
            return;
        }

        if (Math.abs(x) > 1000000000) { return; }
        if (Math.abs(y) > 1000000000) { return; }
        if (step > 1000000000) { return; }
        path.append('E');
        dfs(X, Y, x + step, y, step * 2, path);
        path.deleteCharAt(path.length() - 1);

        path.append('W');
        dfs(X, Y, x - step, y, step * 2, path);
        path.deleteCharAt(path.length() - 1);

        path.append('S');
        dfs(X, Y, x, y - step, step * 2, path);
        path.deleteCharAt(path.length() - 1);

        path.append('N');
        dfs(X, Y, x, y + step, step * 2, path);
        path.deleteCharAt(path.length() - 1);
    }

    static int gcd(int a, int b) {
        if (a > 0) {
            return gcd(b % a, a);
        } else {
            return b;
        }
    }
}