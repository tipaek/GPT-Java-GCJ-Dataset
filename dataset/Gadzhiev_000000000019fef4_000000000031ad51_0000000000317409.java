import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i) {
            solvePath(in, i);
        }
    }

    private static void solvePath(Scanner in, int T) {
        int x = in.nextInt();
        int y = in.nextInt();
        String s = in.nextLine();
        s = s.trim();

        Map<Integer, Pair> map = new HashMap<>();
        map.put(0, new Pair(x, y));
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N':
                    y += 1;
                    break;
                case 'S':
                    y -= 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }
            map.put(i + 1, new Pair(x, y));
        }

        int ans = -1;
        for (int i = 1; i < map.size(); i++) {
            int xPos = 0, yPos = 0;
            Pair where = map.get(i);
            boolean ok = false;
            for (int j = 0; j < i; j++) {
                if (xPos < where.x) {
                    xPos++;
                } else if (xPos > where.x) {
                    xPos--;
                } else if (yPos < where.y) {
                    yPos++;
                } else if (yPos > where.y) {
                    yPos--;
                }
                if (xPos == where.x && yPos == where.y) {
                    ok = true;
                    ans = i;
                }
            }
            if (ok) {
                break;
            }
        }

        System.out.println("Case #" + T + ": " + (ans == -1 ? "IMPOSSIBLE" : ans));
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}