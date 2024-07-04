import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String[] directions = scanner.nextLine().split(" ");
            int x = Integer.parseInt(directions[0]);
            int y = Integer.parseInt(directions[1]);
            String result = findDirection(x, y);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String findDirection(int x, int y) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        StringBuilder result = new StringBuilder();
        int mod = 2;
        int rem = 1;

        while (absX != 0 || absY != 0) {
            if (absX == 0) {
                if (absY == rem) {
                    result.append(y > 0 ? "N" : "S");
                    return result.toString();
                }
            } else if (absY == 0) {
                if (absX == rem) {
                    result.append(x > 0 ? "E" : "W");
                    return result.toString();
                }
            }

            if (absX % mod == rem) {
                if (absY % mod == rem) {
                    return "IMPOSSIBLE";
                }
                if (absY % (mod * 2) == 0) {
                    if ((absX + rem) % (mod * 2) == 0) {
                        absX -= rem;
                        result.append(x > 0 ? "E" : "W");
                    } else {
                        absX += rem;
                        result.append(x > 0 ? "W" : "E");
                    }
                } else {
                    if ((absX + rem) % (mod * 2) == 0) {
                        absX += rem;
                        result.append(x > 0 ? "W" : "E");
                    } else {
                        absX -= rem;
                        result.append(x > 0 ? "E" : "W");
                    }
                }
            } else if (absY % mod == rem) {
                if (absX % (mod * 2) == 0) {
                    if ((absY + rem) % (mod * 2) == 0) {
                        absY -= rem;
                        result.append(y > 0 ? "N" : "S");
                    } else {
                        absY += rem;
                        result.append(y > 0 ? "S" : "N");
                    }
                } else {
                    if ((absY + rem) % (mod * 2) == 0) {
                        absY += rem;
                        result.append(y > 0 ? "S" : "N");
                    } else {
                        absY -= rem;
                        result.append(y > 0 ? "N" : "S");
                    }
                }
            } else {
                return "IMPOSSIBLE";
            }

            mod *= 2;
            rem *= 2;
        }

        return result.toString();
    }
}