import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static class Coord {
        final int x;
        final int y;
        final String path;

        Coord(String path, int x, int y) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            String result = findPath(x, y);

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findPath(int x, int y) {
        ArrayList<Coord> coords = new ArrayList<>();
        coords.add(new Coord("", 0, 0));
        int nextNum = 1;

        while (!coords.isEmpty()) {
            ArrayList<Coord> temp = new ArrayList<>();
            for (Coord now : coords) {
                if (now.x == x && now.y == y) {
                    return now.path;
                }

                int diffx = Math.abs(now.x - x);
                int diffy = Math.abs(now.y - y);

                if ((diffx != 0 && diffx < nextNum) || (diffy != 0 && diffy < nextNum)) {
                    continue;
                }

                temp.add(new Coord(now.path + "N", now.x, now.y + nextNum));
                temp.add(new Coord(now.path + "S", now.x, now.y - nextNum));
                temp.add(new Coord(now.path + "E", now.x + nextNum, now.y));
                temp.add(new Coord(now.path + "W", now.x - nextNum, now.y));
            }
            coords = temp;
            nextNum *= 2;
        }

        return (x != 0 || y != 0) ? "IMPOSSIBLE" : "";
    }
}