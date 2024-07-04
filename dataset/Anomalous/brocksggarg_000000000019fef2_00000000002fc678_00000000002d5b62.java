import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Solution solution = new Solution();
        for (int i = 1; i <= t; i++) {
            solution.solve(i, br);
        }
    }

    private void solve(int caseNumber, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        char[] directions = determineDirections(x, y);
        x = Math.abs(x);
        y = Math.abs(y);

        if (isImpossible(x, y)) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            int b = computeB(x + y);
            String path = calculatePath(x, y, b / 2, directions);
            if (path.equals("IMPOSSIBLE")) {
                path = calculatePath(x, y, b, directions);
                if (path.equals("IMPOSSIBLE")) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + path);
                }
            } else {
                System.out.println("Case #" + caseNumber + ": " + path);
            }
        }
    }

    private char[] determineDirections(int x, int y) {
        char[] directions = {'N', 'E', 'S', 'W'};
        if (x < 0) {
            directions[1] = 'W';
            directions[3] = 'E';
        }
        if (y < 0) {
            directions[0] = 'S';
            directions[2] = 'N';
        }
        return directions;
    }

    private boolean isImpossible(int x, int y) {
        return (x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1);
    }

    private int computeB(int sum) {
        int b = 1;
        while (b < sum) {
            b *= 2;
        }
        return b;
    }

    private String calculatePath(int x, int y, int b, char[] directions) {
        StringBuilder path = new StringBuilder();
        while (b != 1) {
            if (Math.abs(x) > Math.abs(y)) {
                if (x >= 0) {
                    x -= b;
                    path.insert(0, directions[1]);
                } else {
                    x += b;
                    path.insert(0, directions[3]);
                }
            } else {
                if (y >= 0) {
                    y -= b;
                    path.insert(0, directions[0]);
                } else {
                    y += b;
                    path.insert(0, directions[2]);
                }
            }
            b /= 2;
        }

        if (x == 0 && y == 1) {
            path.insert(0, directions[0]);
        } else if (x == 0 && y == -1) {
            path.insert(0, directions[2]);
        } else if (y == 0 && x == 1) {
            path.insert(0, directions[1]);
        } else if (y == 0 && x == -1) {
            path.insert(0, directions[3]);
        } else {
            return "IMPOSSIBLE";
        }
        return path.toString();
    }
}