
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String M = scanner.next();
            int re = get(x, y, M);
            System.out.println("Case #" + (i+1) + ": " + ((re == -1)? "IMPOSSIBLE" : re));
        }
    }
    private static int get(int x, int y, String M) {
        if (x == 0 && y == 0) return 0;
        for (int i = 0; i < M.length(); i++) {
            switch (M.charAt(i)) {
                case 'N': y++;
                break;
                case 'S': y--;
                break;
                case 'W': x--;
                break;
                case 'E': x++;
                break;
            }
            int dis = Math.abs(x) + Math.abs(y);
            if (dis <= i+1) return i+1;
        }

        return -1;
    }



}
