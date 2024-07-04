import java.util.*;

public class Solution {

    private void solve() {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        for (int c = 1; c <= N; c++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            char[] mv = sc.next().toCharArray();

            int dist = X + Y;
            int min = -1;

            for (int i = 0; i < mv.length; i++) {
                if (mv[i] == 'S') Y--;
                if (mv[i] == 'N') Y++;
                if (mv[i] == 'E') X++;
                if (mv[i] == 'W') X--;

                dist = Math.abs(X) + Math.abs(Y);
                if (dist - 1 <= i) {
                    min = i+1;
                    break;
                }
            }

            if (min == -1) System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
            else System.out.println(String.format("Case #%d: %d", c, min));
        }

    }
    
    public static void main(String[] args) {
        Solution a = new Solution();
        a.solve();
    }
}
