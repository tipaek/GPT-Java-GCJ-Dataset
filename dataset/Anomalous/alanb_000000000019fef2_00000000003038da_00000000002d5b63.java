import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            boolean hit = false;
            boolean center = false;
            int s1 = 0, s2 = 0;

            if (a == 999999995) {
                for (int i = -7; i <= 7; i++) {
                    for (int j = -7; j <= 7; j++) {
                        if (!center) {
                            int q = query(s1 + i, s2 + j);
                            if (q == 2) center = true;
                        }
                    }
                }
            }

            for (int i = -1000000000 + a / 2; i <= 1000000000 && !hit && !center; i += a) {
                for (int j = -1000000000 + a / 2; j <= 1000000000 && !hit && !center; j += a) {
                    int q = query(i, j);
                    if (q == 1) {
                        s1 = i;
                        s2 = j;
                        hit = true;
                    }
                    if (q == 2) center = true;
                }
            }

            double dist = Math.abs((s1 + 1000000000)) / 4.0;
            double x1 = (s1 - 1000000000) / 2.0, x2 = (s1 + 1000000000) / 2.0;
            double y1 = (s2 - 1000000000) / 2.0, y2 = (s2 + 1000000000) / 2.0;

            while (dist > 1 && !center) {
                int q = query(x1, s2);
                if (q == 0) {
                    x1 += Math.max(2.5, dist);
                } else if (q == 1) {
                    x1 -= Math.max(2.5, dist);
                } else {
                    center = true;
                }
                dist /= 2;
            }

            dist = Math.abs((1000000000 - s1)) / 4.0;
            while (dist > 1 && !center) {
                int q = query(x2, s2);
                if (q == 0) {
                    x2 -= Math.max(2.5, dist);
                } else if (q == 1) {
                    x2 += Math.max(2.5, dist);
                } else {
                    center = true;
                }
                dist /= 2;
            }

            dist = Math.abs((s2 + 1000000000)) / 4.0;
            while (dist > 1 && !center) {
                int q = query(s1, y1);
                if (q == 0) {
                    y1 += Math.max(2.5, dist);
                } else if (q == 1) {
                    y1 -= Math.max(2.5, dist);
                } else {
                    center = true;
                }
                dist /= 2;
            }

            dist = Math.abs((1000000000 - s2)) / 4.0;
            while (dist > 1 && !center) {
                int q = query(s1, y2);
                if (q == 0) {
                    y2 -= Math.max(2.5, dist);
                } else if (q == 1) {
                    y2 += Math.max(2.5, dist);
                } else {
                    center = true;
                }
                dist /= 2;
            }

            s1 = (int) ((x1 + x2) / 2);
            s2 = (int) ((y1 + y2) / 2);

            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    if (!center) {
                        int q = query(s1 + i, s2 + j);
                        if (q == 2) center = true;
                    }
                }
            }

            if (!center) {
                System.out.println("FAIL");
            }
        }
        scanner.close();
    }

    public static int query(double x, double y) {
        System.out.print(((int) x) + " " + ((int) y));
        String response = scanner.next();
        if (response.equals("MISS")) return 0;
        if (response.equals("HIT")) return 1;
        return 2;
    }
}