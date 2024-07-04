import java.util.*;
import java.io.*;

public class Solution {
    private static int targetX = 0, targetY = 0;
    private static String[] paths;

    private static void findPath(int step, int jumpLength, String path, int currentX, int currentY) {
        if (currentX == targetX && currentY == targetY) {
            paths[step] = path;
            return;
        }
        if (step >= 30 || Math.abs(currentY) > Math.abs(targetY) || Math.abs(currentX) > Math.abs(targetX)) {
            return;
        }
        
        step++;
        findPath(step, jumpLength * 2, path + "S", currentX, currentY - jumpLength);
        findPath(step, jumpLength * 2, path + "N", currentX, currentY + jumpLength);
        findPath(step, jumpLength * 2, path + "E", currentX + jumpLength, currentY);
        findPath(step, jumpLength * 2, path + "W", currentX - jumpLength, currentY);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            targetX = scanner.nextInt();
            targetY = scanner.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");
            paths = new String[101];

            if ((targetX + targetY) % 2 == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                if (targetX % 2 == 0) {
                    findPath(1, 2, "S", 0, -1);
                    findPath(1, 2, "N", 0, 1);
                } else {
                    findPath(1, 2, "E", 1, 0);
                    findPath(1, 2, "W", -1, 0);
                }

                boolean foundPath = false;
                for (int j = 0; j < 101; j++) {
                    if (paths[j] != null) {
                        System.out.println(paths[j]);
                        foundPath = true;
                        break;
                    }
                }

                if (!foundPath) {
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }
}