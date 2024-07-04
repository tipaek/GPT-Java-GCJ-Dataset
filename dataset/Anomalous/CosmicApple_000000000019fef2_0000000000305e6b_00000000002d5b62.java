import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            Solver solver = new Solver(scanner);
            solver.solve();
            System.out.println("Case #" + testIndex + ": " + solver.getResult());
        }
    }
}

class Solver {
    private int x;
    private int y;
    private int[][] directions = new int[4][2];

    public Solver(Scanner scanner) {
        this.x = scanner.nextInt();
        this.y = scanner.nextInt();
    }

    public void solve() {
        if (isEven(x) != isEven(y)) {
            int[] coordinates = {x, y};
            int evenIndex = isEven(x) ? 0 : 1;
            int oddIndex = isEven(x) ? 1 : 0;

            if (isValidMove(0, 1)) {
                directions[0][oddIndex] = getSign(coordinates[oddIndex]);
            } else if (isValidMove(0, 3)) {
                directions[0][oddIndex] = getSign(coordinates[oddIndex]);
                directions[1][oddIndex] = getSign(coordinates[oddIndex]);
            } else if (isValidMove(2, 1)) {
                directions[0][oddIndex] = getSign(coordinates[oddIndex]);
                directions[1][evenIndex] = getSign(coordinates[evenIndex]);
            } else if (isValidMove(2, 3)) {
                directions[0][oddIndex] = -getSign(coordinates[oddIndex]);
                directions[1][evenIndex] = getSign(coordinates[evenIndex]);
                directions[2][oddIndex] = getSign(coordinates[oddIndex]);
            } else if (isValidMove(4, 1)) {
                directions[0][oddIndex] = -getSign(coordinates[oddIndex]);
                directions[1][oddIndex] = getSign(coordinates[oddIndex]);
                directions[2][evenIndex] = getSign(coordinates[evenIndex]);
            } else if (isValidMove(4, 3)) {
                directions[0][oddIndex] = getSign(coordinates[oddIndex]);
                directions[1][oddIndex] = getSign(coordinates[oddIndex]);
                directions[2][evenIndex] = getSign(coordinates[evenIndex]);
            }
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();
        for (int[] direction : directions) {
            if (direction[0] == 0 && direction[1] == 0) break;
            if (direction[0] == 1) result.append("E");
            else if (direction[0] == -1) result.append("W");
            else if (direction[1] == 1) result.append("N");
            else if (direction[1] == -1) result.append("S");
        }
        return result.length() == 0 ? "IMPOSSIBLE" : result.toString();
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private boolean isValidMove(int i, int j) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        return (Math.abs(i) == absX && Math.abs(j) == absY) || (Math.abs(i) == absY && Math.abs(j) == absX);
    }

    private int getSign(int number) {
        return number / Math.abs(number);
    }
}