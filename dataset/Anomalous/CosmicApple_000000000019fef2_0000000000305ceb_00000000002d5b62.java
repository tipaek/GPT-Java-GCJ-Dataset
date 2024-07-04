import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTests = scanner.nextInt();

        for (int testCase = 1; testCase <= numOfTests; testCase++) {
            Solver solver = new Solver(scanner);
            solver.solve();
            System.out.println("Case #" + testCase + ": " + solver.getOutput());
        }
    }
}

class Solver {
    private int x;
    private int y;
    private int[][] direction = new int[4][2];

    public Solver(Scanner scanner) {
        this.x = scanner.nextInt();
        this.y = scanner.nextInt();
    }

    public void solve() {
        if ((isEven(x) && !isEven(y)) || (!isEven(x) && isEven(y))) {
            int[] coords = {x, y};
            int evenIndex, oddIndex;

            if (isEven(x)) {
                evenIndex = 0;
                oddIndex = 1;
            } else {
                evenIndex = 1;
                oddIndex = 0;
            }

            if (checkVals(0, 1)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
            } else if (checkVals(0, 3)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
                direction[1][oddIndex] = getSign(coords[oddIndex]);
            } else if (checkVals(2, 1)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
                direction[1][evenIndex] = getSign(coords[evenIndex]);
            } else if (checkVals(2, 3)) {
                direction[0][oddIndex] = -getSign(coords[oddIndex]);
                direction[1][evenIndex] = getSign(coords[evenIndex]);
                direction[2][oddIndex] = getSign(coords[oddIndex]);
            } else if (checkVals(4, 1)) {
                direction[0][oddIndex] = -getSign(coords[oddIndex]);
                direction[1][oddIndex] = getSign(coords[oddIndex]);
                direction[2][evenIndex] = getSign(coords[evenIndex]);
            } else if (checkVals(4, 3)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
                direction[1][oddIndex] = getSign(coords[oddIndex]);
                direction[2][evenIndex] = getSign(coords[evenIndex]);
            }
        }
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            if (direction[i][0] == 0 && direction[i][1] == 0) {
                break;
            }
            if (direction[i][0] == 1) output.append("E");
            else if (direction[i][0] == -1) output.append("W");
            else if (direction[i][1] == 1) output.append("N");
            else if (direction[i][1] == -1) output.append("S");
        }

        return output.length() == 0 ? "IMPOSSIBLE" : output.toString();
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private boolean checkVals(int i, int j) {
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        return (i == absX && j == absY) || (i == absY && j == absX);
    }

    private int getSign(int num) {
        return num / Math.abs(num);
    }
}