import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            solve(i + 1, scanner);
        }
    }

    private static void solve(int caseId, Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        StringBuilder path = new StringBuilder();
        String north = "N";
        String south = "S";
        String east = "E";
        String west = "W";

        int currentX = x;
        int currentY = y;

        while (currentX != 0 || currentY != 0) {
            if (currentX < 0) {
                currentX = -currentX;
                String temp = east;
                east = west;
                west = temp;
            }
            if (currentY < 0) {
                currentY = -currentY;
                String temp = north;
                north = south;
                south = temp;
            }
            if (currentX % 2 == currentY % 2) {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
                return;
            }
            if (currentX == 1 && currentY == 0) {
                path.append(east);
                break;
            } else if (currentX == 0 && currentY == 1) {
                path.append(north);
                break;
            }
            if (currentX % 2 != 0) {
                if ((currentY / 2) % 2 == ((currentX + 1) / 2) % 2) {
                    currentX -= 1;
                    path.append(east);
                } else {
                    currentX += 1;
                    path.append(west);
                }
            } else {
                if ((currentX / 2) % 2 == ((currentY + 1) / 2) % 2) {
                    currentY -= 1;
                    path.append(north);
                } else {
                    currentY += 1;
                    path.append(south);
                }
            }
            currentX /= 2;
            currentY /= 2;
        }

        System.out.println("Case #" + caseId + ": " + path);
    }
}