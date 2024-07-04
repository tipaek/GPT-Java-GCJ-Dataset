import java.util.*;
import java.io.*;

public class Solution {

    static int bestTime;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();

            List<PositionTime> peppersPositions = buildPositions(line);
            bestTime = -1;

            for (PositionTime pos : peppersPositions) {
                int myTime = goTo(pos);
                if (myTime > 0) {
                    bestTime = bestTime == -1 ? myTime : Math.min(myTime, bestTime);
                }
            }

            if (bestTime == -1) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + bestTime);
            }

        }
    }

    private static int goTo(PositionTime pos) {
        int myTime = 0;
        int myX = 0;
        int myY = 0;

        while (myX != pos.x) {
            if (myX < pos.x) {
                myX++;
            } else {
                myX--;
            }
            myTime++;
        }

        while (myY != pos.y) {
            if (myY < pos.y) {
                myY++;
            } else {
                myY--;
            }
            myTime++;
        }

        if (myTime > pos.t) {
            myTime = 0;
        } else {
            myTime = pos.t;
        }

        return myTime;
    }

    private static List<PositionTime> buildPositions(String line) {
        String[] parts = line.split(" ");

        int x = toInt(parts[0]);
        int y = toInt(parts[1]);
        int t = 0;
        String path = parts[2];

        List<PositionTime> peppers = new ArrayList<>();

        for (int i = 0; i < path.length(); i++) {
            String dir = String.valueOf(path.charAt(i));

            switch (dir) {
                case "E":
                    x++;
                    break;
                case "W":
                    x--;
                    break;
                case "N":
                    y++;
                    break;
                default:
                    y--;
            }

            t++;

            peppers.add(new PositionTime(x, y, t));
        }

        return peppers;
    }

    static int toInt(String v) {
        return Integer.parseInt(v);
    }
}

class PositionTime {
    int x;
    int y;
    int t;

    public PositionTime(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

}