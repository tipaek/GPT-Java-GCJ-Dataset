import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            solve(i, scanner);
        }
    }

    private static void solve(int caseId, Scanner scanner) {
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        String path = "";
        String north = "N", south = "S", east = "E", west = "W";

        int x = X, y = Y;

        while (x != 0 || y != 0) {
            if (x < 0) {
                x = -x;
                String temp = north;
                north = south;
                south = temp;
            }
            if (y < 0) {
                y = -y;
                String temp = west;
                west = east;
                east = temp;
            }

            if (x % 2 == y % 2) {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
                return;
            }

            if (x == 1 && y == 0) {
                path += east;
                break;
            } else if (x == 0 && y == 1) {
                path += north;
                break;
            }

            if (x % 2 != 0) {
                if ((y / 2) % 2 == ((x + 1) / 2) % 2) {
                    x -= 1;
                    path += east;
                } else {
                    x += 1;
                    path += west;
                }
            } else {
                if ((x / 2) % 2 == ((y + 1) / 2) % 2) {
                    y -= 1;
                    path += north;
                } else {
                    y += 1;
                    path += south;
                }
            }

            x /= 2;
            y /= 2;
        }

        System.out.println("Case #" + caseId + ": " + path);
    }
}