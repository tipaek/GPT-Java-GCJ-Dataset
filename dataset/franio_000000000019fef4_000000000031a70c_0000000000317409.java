

import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int X_east = scanner.nextInt();
            int Y_north = scanner.nextInt();
            String path = scanner.next();
            sout(i, getPicureAt(X_east, Y_north, path));
        }
        scanner.close();
    }

    private static String getPicureAt(int X, int Y, String path) {
        int time = 0;
        int min_result = 0;
        boolean found = false;
        if (0 == X && 0 == Y) return "0";
        for (char d : path.toCharArray()) {
            time += 1;
            if (d == 'N') {
                Y += 1;
            } else if (d == 'S') {
                Y -= 1;
            } else if (d == 'E') {
                X += 1;
            } else {
                X -= 1;
            }

            int result = isAvailable(X, Y, time);
            if (result >= 0) {
                if (!found) {
                    min_result = time;
                    found = true;
                } else {
                    if (time < min_result) {
                        min_result = time;
                    }
                }
            }

        }

        if (!found) {
            return "IMPOSSIBLE";
        } else {
            return String.valueOf(min_result);
        }
    }

    private static int isAvailable(int catX, int catY, int t) {
        return t - ((Math.abs(catX) + Math.abs(catY)));
    }

    private static void sout(int x, String k) {
        System.out.println("Case #" + (x + 1) + ": " + k);
    }
}

