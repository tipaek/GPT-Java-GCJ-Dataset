import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int minRadius = scanner.nextInt();
        int maxRadius = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            if (!processTestCase(scanner, minRadius, maxRadius)) {
                System.exit(0);
            }
        }
    }

    private static boolean processTestCase(Scanner scanner, int minRadius, int maxRadius) {
        int[] center = new int[2];
        int left = Integer.MIN_VALUE, top = Integer.MIN_VALUE, right = Integer.MIN_VALUE, bottom = Integer.MIN_VALUE;

        int[] possibleLeft = {-1000000000, 1000000000};
        int[] possibleTop = {1000000000, -1000000000};
        int[] possibleRight = {1000000000, -1000000000};
        int[] possibleBottom = {-1000000000, 1000000000};

        for (int i = 0; i < 299; i++) {
            if (left != Integer.MIN_VALUE && top != Integer.MAX_VALUE && right != Integer.MAX_VALUE && bottom != Integer.MIN_VALUE) {
                center[0] = (left + right) / 2;
                center[1] = (top + bottom) / 2;
                break;
            }

            if (left == Integer.MIN_VALUE) {
                if (!processDirection(scanner, possibleLeft, 0, center, "left")) {
                    return false;
                }
                if (possibleLeft[1] - possibleLeft[0] == 1) {
                    left = possibleLeft[1];
                    possibleRight[0] = left + maxRadius + 1;
                    possibleRight[1] = left;
                }
            } else if (right == Integer.MIN_VALUE) {
                if (!processDirection(scanner, possibleRight, 0, center, "right")) {
                    return false;
                }
                if (possibleRight[1] - possibleRight[0] == -1) {
                    right = possibleRight[1];
                    center[0] = (left + right) / 2;
                }
            } else if (top == Integer.MIN_VALUE) {
                if (!processDirection(scanner, possibleTop, center[0], center, "top")) {
                    return false;
                }
                if (possibleTop[1] - possibleTop[0] == -1) {
                    top = possibleTop[1];
                    possibleBottom[0] = top - maxRadius - 1;
                    possibleBottom[1] = top;
                }
            } else if (bottom == Integer.MIN_VALUE) {
                if (!processDirection(scanner, possibleBottom, 0, center, "bottom")) {
                    return false;
                }
                if (possibleBottom[1] - possibleBottom[0] == 1) {
                    bottom = possibleBottom[1];
                    center[1] = (top + bottom) / 2;
                }
            }
        }
        return guess(scanner, center[0], center[1]).equals("CENTER");
    }

    private static boolean processDirection(Scanner scanner, int[] possible, int coordinate, int[] center, String direction) {
        String result = guess(scanner, (possible[0] + possible[1]) / 2, coordinate);
        switch (result) {
            case "MISS":
                possible[0] = (possible[0] + possible[1]) / 2;
                break;
            case "HIT":
                possible[1] = (possible[0] + possible[1]) / 2;
                break;
            case "CENTER":
                return true;
            default:
                return false;
        }
        return true;
    }

    private static String guess(Scanner scanner, int x, int y) {
        System.out.println(x + " " + y);
        System.out.flush();
        return scanner.next();
    }
}