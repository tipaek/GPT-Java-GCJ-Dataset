import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static class Task {
        int start;
        int end;
        int id;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; ++t) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                scanner.nextLine();

                StringBuilder result = new StringBuilder();
                boolean isPossible = true;

                while (x != 0 || y != 0) {
                    if (Math.abs(x % 2) == Math.abs(y % 2)) {
                        result = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    } else if (x % 2 != 0) {
                        y /= 2;
                        if (x > 0) {
                            result.append("E");
                            x = (x - 1) / 2;
                            if (x % 2 != 0 && x % 2 == Math.abs(y % 2)) {
                                x++;
                                x = -x;
                            }
                        } else {
                            result.append("W");
                            x = (x + 1) / 2;
                            if (x % 2 != 0 && Math.abs(x % 2) == Math.abs(y % 2)) {
                                x--;
                                x = -x;
                            }
                        }
                    } else {
                        x /= 2;
                        if (y > 0) {
                            result.append("S");
                            y = (y - 1) / 2;
                            if (y % 2 != 0 && Math.abs(x % 2) == Math.abs(y % 2)) {
                                y++;
                                y = -y;
                            }
                        } else {
                            result.append("N");
                            y = (y + 1) / 2;
                            if (y % 2 != 0 && Math.abs(x % 2) == Math.abs(y % 2)) {
                                y--;
                                y = -y;
                            }
                        }
                    }
                }

                if (isPossible) {
                    System.out.println("Case #" + t + ": " + result);
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }
    }
}