import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            System.out.println("Case #" + currentTest + ": " + solver.getOutput());
        }
        input.close();
    }
}

class Solver {
    private int x;
    private int y;
    private int[][] direction = new int[4][2];

    public Solver(Scanner input) {
        this.x = input.nextInt();
        this.y = input.nextInt();
    }

    public void solve() {
        if ((isEven(x) && !isEven(y)) || (isEven(y) && !isEven(x))) {
            int[] coords = {x, y};
            int evenIndex = isEven(x) ? 0 : 1;
            int oddIndex = isEven(x) ? 1 : 0;

            if (checkVals(x, y, 0, 1)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
            } else if (checkVals(x, y, 0, 3)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
                direction[1][oddIndex] = getSign(coords[oddIndex]);
            } else if (checkVals(x, y, 2, 1)) {
                direction[0][oddIndex] = getSign(coords[oddIndex]);
                direction[1][evenIndex] = getSign(coords[evenIndex]);
            } else if (checkVals(x, y, 2, 3)) {
                direction[0][oddIndex] = -getSign(coords[oddIndex]);
                direction[1][evenIndex] = getSign(coords[evenIndex]);
                direction[2][oddIndex] = getSign(coords[oddIndex]);
            } else if (checkVals(x, y, 4, 1)) {
                direction[0][oddIndex] = -getSign(coords[oddIndex]);
                direction[1][oddIndex] = getSign(coords[oddIndex]);
                direction[2][evenIndex] = getSign(coords[evenIndex]);
            } else if (checkVals(x, y, 4, 3)) {
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
        return output.toString();
    }

    private boolean isEven(int i) {
        return (i % 2 == 0);
    }

    private boolean checkVals(int i, int j, int x, int y) {
        i = Math.abs(i);
        j = Math.abs(j);
        x = Math.abs(x);
        y = Math.abs(y);
        return (i == x && j == y) || (i == y && j == x);
    }

    private int getSign(int i) {
        return i / Math.abs(i);
    }
}