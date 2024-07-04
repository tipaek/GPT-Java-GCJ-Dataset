import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static class TourStop {
        public int x;
        public int y;
        public int step;

        public TourStop(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public TourStop(Point pos, int step) {
            this(pos.x, pos.y, step);
        }

        public int getDist() {
            return Math.abs(this.x) + Math.abs(this.y);
        }
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int px = in.nextInt();
            int py = in.nextInt();
            String ppath = in.next();
            runCase(i + 1, px, py, ppath);
        }
    }

    public static void runCase(int caseNum, int px, int py, String ppath) {
        Point currpos = new Point(px, py);
        TourStop[] tour = new TourStop[ppath.length() + 1];
        tour[0] = new TourStop(currpos, 0);
        for (int i = 0; i < ppath.length(); i++) {
            updatePos(currpos, ppath.charAt(i));
            tour[i + 1] = new TourStop(currpos, i + 1);
        }
        for (int i = 0; i < tour.length; i++) {
            if (tour[i].getDist() <= i) {
                printCaseResult(caseNum, Integer.toString(i));
                return;
            }
        }
        String failStr = "IMPOSSIBLE";
        printCaseResult(caseNum, failStr);
    }

    private static void updatePos(Point currpos, char dir) {
        switch (dir) {
            case 'N':
                currpos.y++;
                break;
            case 'S':
                currpos.y--;
                break;
            case 'E':
                currpos.x++;
                break;
            case 'W':
                currpos.x--;
                break;
        }
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}
