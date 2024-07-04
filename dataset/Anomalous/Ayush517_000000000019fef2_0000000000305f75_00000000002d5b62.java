import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            boolean dirX = (x >= 0), dirY = (y >= 0);
            x = Math.abs(x);
            y = Math.abs(y);
            boolean possible = true;
            StringBuilder result = new StringBuilder();

            if ((x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0)) {
                while ((x != 0 || y != 0) && possible) {
                    if (x + y == 1) {
                        if (x == 0) {
                            result.append(dirY ? "N" : "S");
                        } else {
                            result.append(dirX ? "E" : "W");
                        }
                        x = 0;
                        y = 0;
                        break;
                    }
                    if (x % 2 == 0 || x == 0) {
                        if (canMove(x / 2, (y + 1) / 2)) {
                            result.append(dirY ? "S" : "N");
                            x /= 2;
                            y = (y + 1) / 2;
                        } else if (canMove(x / 2, (y - 1) / 2)) {
                            result.append(dirY ? "N" : "S");
                            x /= 2;
                            y = (y - 1) / 2;
                        }
                    } else if (y % 2 == 0 || y == 0) {
                        if (canMove(y / 2, (x + 1) / 2)) {
                            result.append(dirX ? "W" : "E");
                            y /= 2;
                            x = (x + 1) / 2;
                        } else if (canMove(y / 2, (x - 1) / 2)) {
                            result.append(dirX ? "E" : "W");
                            y /= 2;
                            x = (x - 1) / 2;
                        }
                    } else {
                        possible = false;
                    }
                }
            } else {
                possible = false;
            }

            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    static boolean canMove(long x, long y) {
        if (x + y == 0) {
            return true;
        }
        return (x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0);
    }
}