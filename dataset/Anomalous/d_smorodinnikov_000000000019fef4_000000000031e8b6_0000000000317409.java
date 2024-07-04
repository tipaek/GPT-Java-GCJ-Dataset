import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    static void solve() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            String s = scan.next();
            solveCase(i, x, y, s);
        }
    }

    static void solveCase(int t, int x, int y, String m) {
        Coord init = new Coord(0, 0);
        Coord[] catCoord = new Coord[m.length() + 1];
        catCoord[0] = new Coord(-x, y);
        
        for (int i = 1; i <= m.length(); i++) {
            char ch = m.charAt(i - 1);
            if (ch == 'S') {
                catCoord[i] = new Coord(catCoord[i - 1].x, catCoord[i - 1].y - 1);
            } else if (ch == 'N') {
                catCoord[i] = new Coord(catCoord[i - 1].x, catCoord[i - 1].y + 1);
            }
            int res = minSteps(catCoord[i], init);
            if (res <= i) {
                System.out.println("Case #" + (t + 1) + ": " + i);
                return;
            }
        }
        
        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
    }

    static int minSteps(Coord c1, Coord c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }

    static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}