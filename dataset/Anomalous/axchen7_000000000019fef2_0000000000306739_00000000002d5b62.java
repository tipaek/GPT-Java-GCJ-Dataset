import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            while (true) {
                if (x == 0 && y == 0) break;
                if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
                    isPossible = false;
                    break;
                }

                if (x % 2 == 0) {
                    if ((x % 4 == 0) == ((y + (y > 0 ? 1 : -1)) % 4 != 0) && y != 1 && y != -1) {
                        result.append(y > 0 ? 'S' : 'N');
                        y += y > 0 ? 1 : -1;
                    } else {
                        result.append(y > 0 ? 'N' : 'S');
                        y -= y > 0 ? 1 : -1;
                    }
                } else {
                    if ((y % 4 == 0) == ((x + (x > 0 ? 1 : -1)) % 4 != 0) && x != 1 && x != -1) {
                        result.append(x > 0 ? 'W' : 'E');
                        x += x > 0 ? 1 : -1;
                    } else {
                        result.append(x > 0 ? 'E' : 'W');
                        x -= x > 0 ? 1 : -1;
                    }
                }

                x /= 2;
                y /= 2;
            }

            System.out.print("Case #" + caseNum + ": ");
            System.out.println(isPossible ? result : "IMPOSSIBLE");
        }
    }
}