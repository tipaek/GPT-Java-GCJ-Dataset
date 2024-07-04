import java.util.*;
import java.io.*;

public class Solution {
    public static int x = 0, y = 0;
    public static String[] connect;

    public static void explorePath(int step, int distance, String path, int currentX, int currentY) {
        if (currentX == x && currentY == y) {
            connect[step] = path;
            return;
        }

        step++;
        if (step == 20) {
            return;
        }

        if ((x * currentX > 0 && Math.abs(currentX) > Math.abs(x)) || (y * currentY > 0 && Math.abs(currentY) > Math.abs(y))) {
            return;
        }

        if (currentX == x) {
            explorePath(step, distance * 2, path + "S", currentX, currentY - distance);
            explorePath(step, distance * 2, path + "N", currentX, currentY + distance);
        } else if (currentY == y) {
            explorePath(step, distance * 2, path + "E", currentX + distance, currentY);
            explorePath(step, distance * 2, path + "W", currentX - distance, currentY);
        } else {
            explorePath(step, distance * 2, path + "S", currentX, currentY - distance);
            explorePath(step, distance * 2, path + "N", currentX, currentY + distance);
            explorePath(step, distance * 2, path + "E", currentX + distance, currentY);
            explorePath(step, distance * 2, path + "W", currentX - distance, currentY);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");
            connect = new String[101];

            if ((x + y) % 2 == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                if (x % 2 == 0) {
                    explorePath(1, 2, "S", 0, -1);
                    explorePath(1, 2, "N", 0, 1);
                } else {
                    explorePath(1, 2, "E", 1, 0);
                    explorePath(1, 2, "W", -1, 0);
                }

                boolean foundPath = false;
                for (int j = 0; j < 101; j++) {
                    if (connect[j] != null) {
                        System.out.println(connect[j]);
                        foundPath = true;
                        break;
                    }
                }

                if (!foundPath) {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
        scanner.close();
    }
}