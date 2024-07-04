import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scanner.nextInt();
            Point[] points = new Point[2 * n];
            for (int i = 0; i < n; i++) {
                points[2 * i] = new Point(scanner.nextInt(), i, 1);
                points[2 * i + 1] = new Point(scanner.nextInt(), i, -1);
            }
            Arrays.sort(points, (point, t1) -> {
                if (point.number == t1.number) {
                    return point.type - t1.type;
                }
                return point.number - t1.number;
            });
            char[] chars = new char[n];
            boolean flag = false;
            int bal = 0;
            boolean[] inGame = new boolean[2];
            for (int i = 0; i < 2 * n; i++) {
                bal += points[i].type;
                if (bal >= 3) {
                    flag = true;
                }
                if (points[i].type == -1) {
                    if (chars[points[i].index] == 'C') {
                        inGame[0] = false;
                    } else {
                        inGame[1] = false;
                    }
                }
                if (bal == 1 && points[i].type == 1) {
                    if (!inGame[0]) {
                        chars[points[i].index] = 'C';
                        inGame[0] = true;
                    } else {
                        chars[points[i].index] = 'J';
                        inGame[1] = true;
                    }
                }
                if (bal == 2) {
                    if (!inGame[0]) {
                        chars[points[i].index] = 'C';
                        inGame[0] = true;
                    } else {
                        chars[points[i].index] = 'J';
                        inGame[1] = true;
                    }
                }
            }
            if (flag) {
                System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (q + 1) + ": " + new String(chars));
            }
        }
    }

    static class Point {
        int number;
        int index;
        int type;
        Point (int newNumber, int newIndex, int newType) {
            number = newNumber;
            index = newIndex;
            type = newType;
        }
    }
}
