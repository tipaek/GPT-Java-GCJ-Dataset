import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String m = scanner.next();

            System.out.println("Case #" + (i + 1) + ": " + solve(x, y, m));
        }
    }

    private static String solve(int x, int y, String m) {
        Point current = new Point(0, 0);
        Point target = new Point(x, y);

        int steps = 0;

        for (int i = 0; i < m.length(); i++) {
            char direction = m.charAt(i);
            target.move(direction);

            if (current.x != target.x) {
                current.move('E');
                steps++;

                if (current.distanceTo(target) == 0) {
                    return String.valueOf(steps);
                }
            } else {
                if (current.distanceTo(target) == 0) {
                    return String.valueOf(steps + 1);
                } else if (current.y > target.y + 1) {
                    current.move('S');
                    steps++;
                } else if (current.y < target.y + 1) {
                    current.move('N');
                    steps++;
                } else {
                    steps++;
                }
            }
        }

        return "IMPOSSIBLE";
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceTo(Point other) {
        return Math.abs(other.x - this.x) + Math.abs(other.y - this.y);
    }

    public void move(char direction) {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
            default:
                break;
        }
    }
}