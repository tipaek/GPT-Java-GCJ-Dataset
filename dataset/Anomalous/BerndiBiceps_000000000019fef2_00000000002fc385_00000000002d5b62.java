import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            StringBuilder path = new StringBuilder();

            if (findPath(x, y, path)) {
                System.out.printf("Case #%d: %s%n", i + 1, path);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            }
        }
    }

    private static boolean findPath(int x, int y, StringBuilder path) {
        if (x == 0 && y == 1) {
            path.append("N");
            return true;
        } else if (x == 0 && y == -1) {
            path.append("S");
            return true;
        } else if (y == 0 && x == 1) {
            path.append("E");
            return true;
        } else if (y == 0 && x == -1) {
            path.append("W");
            return true;
        } else {
            if ((x + y) % 2 == 0) {
                return false;
            } else if (x % 2 != 0) {
                if ((y / 2) % 2 == 0) {
                    if (((x + 1) / 2) % 2 != 0) {
                        path.append("W");
                        return findPath((x + 1) / 2, y / 2, path);
                    } else {
                        path.append("E");
                        return findPath((x - 1) / 2, y / 2, path);
                    }
                } else {
                    if (((x + 1) / 2) % 2 == 0) {
                        path.append("W");
                        return findPath((x + 1) / 2, y / 2, path);
                    } else {
                        path.append("E");
                        return findPath((x - 1) / 2, y / 2, path);
                    }
                }
            } else {
                if ((x / 2) % 2 == 0) {
                    if (((y + 1) / 2) % 2 != 0) {
                        path.append("S");
                        return findPath(x / 2, (y + 1) / 2, path);
                    } else {
                        path.append("N");
                        return findPath(x / 2, (y - 1) / 2, path);
                    }
                } else {
                    if (((y + 1) / 2) % 2 == 0) {
                        path.append("S");
                        return findPath(x / 2, (y + 1) / 2, path);
                    } else {
                        path.append("N");
                        return findPath(x / 2, (y - 1) / 2, path);
                    }
                }
            }
        }
    }
}