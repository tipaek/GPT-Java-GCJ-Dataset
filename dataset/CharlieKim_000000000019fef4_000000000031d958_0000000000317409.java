import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
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
        PeppurrPoint me = new PeppurrPoint(0, 0);
        PeppurrPoint peppurrPoint = new PeppurrPoint(x, y);

        int count = 0;

        for (int i = 0; i < m.length(); i++) {
            Character direction = m.charAt(i);
            peppurrPoint.move(direction);

            if (me.x != peppurrPoint.x) {
                me.move('E');
                count += 1;

                if (me.distance(peppurrPoint) == 0) {
                    return String.valueOf(count);
                }
            } else {
                if (me.distance(peppurrPoint) == 0) {
                    return String.valueOf(count + 1);
                } else if (me.y > peppurrPoint.y + 1) {
                    me.move('S');
                    count += 1;
                } else if (me.y < peppurrPoint.y + 1) {
                    me.move('N');
                    count += 1;
                } else {
                    count += 1;
                }
            }
        }

        return "IMPOSSIBLE";
    }
}

class PeppurrPoint {

    int x;
    int y;

    public PeppurrPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(PeppurrPoint p) {
        return Math.abs(p.x - x) + Math.abs(p.y - y);
    }

    public void move(Character direction) {
        switch (direction) {
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
            default:
                break;
        }
    }
}