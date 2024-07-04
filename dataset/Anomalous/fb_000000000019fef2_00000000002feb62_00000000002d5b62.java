import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();
        StringBuilder path = new StringBuilder();

        String up = "N";
        String down = "S";
        String right = "E";
        String left = "W";

        int x = targetX;
        int y = targetY;

        while (x != 0 || y != 0) {
            if (x < 0) {
                x = -x;
                String temp = up;
                up = down;
                down = temp;
            }
            if (y < 0) {
                y = -y;
                String temp = left;
                left = right;
                right = temp;
            }
            if (x % 2 == y % 2) {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
                return;
            }
            if (x == 1 && y == 0) {
                path.append(right);
                break;
            } else if (x == 0 && y == 1) {
                path.append(up);
                break;
            }
            if (x % 2 != 0) {
                if ((y / 2) % 2 == ((x + 1) / 2) % 2) {
                    x -= 1;
                    path.append(right);
                } else {
                    x += 1;
                    path.append(left);
                }
            } else {
                if ((x / 2) % 2 == ((y + 1) / 2) % 2) {
                    y -= 1;
                    path.append(up);
                } else {
                    y += 1;
                    path.append(down);
                }
            }
            x /= 2;
            y /= 2;
        }

        System.out.println("Case #" + caseId + ": " + path);
    }
}