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
            int targetX = sc.nextInt();
            int targetY = sc.nextInt();

            String result = findPath(targetX, targetY);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findPath(int targetX, int targetY) {
        if (targetX == 0 && targetY == 0) {
            return "";
        }

        ArrayList<Coord> coords = new ArrayList<>();
        coords.add(new Coord("", 0, 0));
        int nextNum = 1;

        while (!coords.isEmpty()) {
            ArrayList<Coord> temp = new ArrayList<>();
            for (Coord now : coords) {
                if (now.x == targetX && now.y == targetY) {
                    return now.path;
                }

                int diffX = Math.abs(now.x - targetX);
                int diffY = Math.abs(now.y - targetY);

                if ((diffX != 0 && (diffX < nextNum * 2 && diffX != nextNum)) ||
                    (diffY != 0 && (diffY < nextNum * 2 && diffY != nextNum))) {
                    continue;
                }

                if (diffY != 0) {
                    temp.add(new Coord(now.path + "N", now.x, now.y + nextNum));
                    temp.add(new Coord(now.path + "S", now.x, now.y - nextNum));
                }
                if (diffX != 0) {
                    temp.add(new Coord(now.path + "E", now.x + nextNum, now.y));
                    temp.add(new Coord(now.path + "W", now.x - nextNum, now.y));
                }
            }
            coords = temp;
            nextNum *= 2;
        }

        return "IMPOSSIBLE";
    }
}