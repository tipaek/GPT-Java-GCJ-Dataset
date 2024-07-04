import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    private static Point finalPos;

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int x = in.nextInt();
            int y = in.nextInt();

            finalPos = new Point(x, y);

            String result = go(new Point(0, 0), 1, "");

            System.out.println(String.format("Case #%s: %s", caseIndex, result));
        }
    }

    public static String go(Point currentPos, int curStep, String path) {
        if (currentPos.equals(finalPos)) {
            return path;
        }
        if (curStep > 200) {
            return "IMPOSSIBLE";
        }
        String eastPath = go(new Point(currentPos.x + curStep, currentPos.y), curStep * 2, path + "E");
        String westPath = go(new Point(currentPos.x - curStep, currentPos.y), curStep * 2, path + "W");
        String northPath = go(new Point(currentPos.x, currentPos.y + curStep), curStep * 2, path + "N");
        String southPath = go(new Point(currentPos.x, currentPos.y - curStep), curStep * 2, path + "S");
        String curMin = eastPath;
        if (westPath.length() < curMin.length()) {
            curMin = westPath;
        }
        if (northPath.length() < curMin.length()) {
            curMin = northPath;
        }
        if (southPath.length() < curMin.length()) {
            curMin = southPath;
        }
        return curMin;
    }

    private static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            final Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}