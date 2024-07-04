import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            String result = findDirection(a, b);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String findDirection(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        StringBuilder direction = new StringBuilder();
        int mod = 2;
        int rem = 1;

        while (x != 0 || y != 0) {
            if (x == 0) {
                if (y == rem) {
                    direction.append(b > 0 ? "N" : "S");
                    return direction.toString();
                }
            }
            if (y == 0) {
                if (x == rem) {
                    direction.append(a > 0 ? "E" : "W");
                    return direction.toString();
                }
            }

            if (x % mod == rem) {
                if (y % mod == rem) {
                    return "IMPOSSIBLE";
                }
                if (y % (mod * 2) == 0) {
                    if ((x + rem) % (mod * 2) == 0) {
                        x -= rem;
                        direction.append(a > 0 ? "E" : "W");
                    } else {
                        x += rem;
                        direction.append(a > 0 ? "W" : "E");
                    }
                } else {
                    if ((x + rem) % (mod * 2) == 0) {
                        x += rem;
                        direction.append(a > 0 ? "W" : "E");
                    } else {
                        x -= rem;
                        direction.append(a > 0 ? "E" : "W");
                    }
                }
            } else if (y % mod == rem) {
                if (x % (mod * 2) == 0) {
                    if ((y + rem) % (mod * 2) == 0) {
                        y -= rem;
                        direction.append(b > 0 ? "N" : "S");
                    } else {
                        y += rem;
                        direction.append(b > 0 ? "S" : "N");
                    }
                } else {
                    if ((y + rem) % (mod * 2) == 0) {
                        y += rem;
                        direction.append(b > 0 ? "S" : "N");
                    } else {
                        y -= rem;
                        direction.append(b > 0 ? "N" : "S");
                    }
                }
            } else {
                return "IMPOSSIBLE";
            }

            mod *= 2;
            rem *= 2;
        }

        return direction.toString();
    }
}