import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String path = in.next();

            Integer shortest = shortestPath(X, Y, path);

            if (shortest == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + shortest);
            }
        }
    }

    public static Integer shortestPath(int X, int Y, String path) {
        if (path.isEmpty()) return 0;
        int count = 0;
        for (char ch: path.toCharArray()) {
            switch (ch) {
                case 'S':
                    Y--;
                    break;
                case 'N':
                    Y++;
                    break;
                case 'E':
                    X++;
                    break;
                case 'W':
                    X--;
                    break;
                default:
                    break;
            }
            count++;
            if (Math.abs(X)+Math.abs(Y) <= count) return count;
        }
        return null;
    }
}
