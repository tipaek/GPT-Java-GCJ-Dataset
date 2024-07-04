import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        
        int numOfTests = input.nextInt ();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            
            System.out.println("Case #" + currentTest + ": " + solver.getOutput());
            
        }
    }
}


class Solver  {
    int x;
    int y;
    public Solver(Scanner input) {
        x = input.nextInt();
        y = input.nextInt();
    }
    int[][] direction = new int[4][2];
    public void solve() {
        if ((isEven (x) && !isEven(y)) || (isEven(y) && !isEven(x))) {
            int[] coords = new int[] {x, y};
            int evenIndex, oddIndex;
            if (isEven(x)) {
                evenIndex = 0;
                oddIndex = 1;
            } else {
                evenIndex = 1;
                oddIndex = 0;
            }
            if (checkVals (0, 1)) {
                direction[0][oddIndex] = getSign (coords[oddIndex]);
            } else if (checkVals (0, 3)) {
                direction[0][oddIndex] = getSign (coords[oddIndex]);
                direction[1][oddIndex] = getSign (coords[oddIndex]);
            } else if (checkVals (2, 1)) {
                direction[0][oddIndex] = getSign (coords[oddIndex]);
                direction[1][evenIndex] = getSign (coords[evenIndex]);
            } else if (checkVals (2, 3)) {
                direction[0][oddIndex] = -getSign (coords[oddIndex]);
                direction[1][evenIndex] = getSign (coords[evenIndex]);
                direction[2][oddIndex] = getSign (coords[oddIndex]);
            } else if (checkVals (4, 1)) {
                direction[0][oddIndex] = -getSign (coords[oddIndex]);
                direction[1][oddIndex] = getSign (coords[oddIndex]);
                direction[2][evenIndex] = getSign (coords[evenIndex]);
            } else if (checkVals (4, 3)) {
                direction[0][oddIndex] = getSign (coords[oddIndex]);
                direction[1][oddIndex] = getSign (coords[oddIndex]);
                direction[2][evenIndex] = getSign (coords[evenIndex]);
            }
        }
    }
    
    public String getOutput () {
        String output = "";
        for (int i = 0; i < 4; i++) {
            if (direction[i][0] == 0 && direction[i][1] == 0) {
                break;
            }
            if (direction[i][0] == 1) output += "E";
            else if (direction[i][0] == -1) output += "W";
            else if (direction[i][1] == 1) output += "N";
            else if (direction[i][1] == -1) output += "S";
        }
        if (output.equals("")) output = "IMPOSSIBLE";
        return output;
    }
    
    boolean isEven (int i) {
        return (i%2 == 0);
    }
    boolean checkVals (int i, int j) {
        i = Math.abs(i);
        j = Math.abs(j);
        int x0 = Math.abs(x);
        int y0 = Math.abs(y);
        if (i == x0 && j == y0) return true;
        if (i == y0 && j == x0) return true;
        return false;
    }
    int getSign (int i) {
        return i / Math.abs(i);
    }
}
