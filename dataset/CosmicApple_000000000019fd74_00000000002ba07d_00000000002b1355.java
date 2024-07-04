import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {
        Scanner input = new Scanner (System.in);
        int numOfTests = input.nextInt ();
        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            Solver solver = new Solver(input);
            solver.solve();
            
            System.out.println("Case #" + currentTest + ": " + solver.getInterest());
            
        }
    }
}

class Solver {
    
    int rows;
    int columns;
    int[][] skill;
    boolean[][] alive;
    int totalInterest = 0;
    
    public Solver (Scanner input) {
        rows = input.nextInt ();
        columns = input.nextInt();
        skill = new int[rows][columns];
        alive = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                skill[i][j] = input.nextInt();
                alive[i][j] = true;
            }
        }
    }
    public void solve () {
        boolean eliminated = true;
        while (eliminated) {
            eliminated = false;
            double[][] averageSkills = findAverageSkills();
            totalInterest += findRoundInterest();
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (alive[i][j]) {
                        if (skill[i][j] + 0.000001f < averageSkills[i][j]) {
                            alive[i][j] = false;
                            eliminated = true;
                        }
                    }
                }
            }   
        }
    }
    
    public int getInterest () {
        return totalInterest;
    }
    
    double[][] findAverageSkills () {
        double[][] averageSkills = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (alive[i][j]) {
                    averageSkills[i][j] = findAverageSkill (i, j);
                }
            }
        }   
        return averageSkills;
    }
    
    double findAverageSkill (int row, int column) {
        double totalSkill = 0f;
        int neighbors = 0;
        //north
        for (int i = row-1; i >= 0; i--) {
            if (alive[i][column]) {
                totalSkill += skill[i][column];
                neighbors++;
                break;
            }
        }
        //south
        for (int i = row+1; i < rows; i++) {
            if (alive[i][column]) {
                totalSkill += skill[i][column];
                neighbors++;
                break;
            }
        }
        //west
        for (int j = column-1; j >= 0; j--) {
            if (alive[row][j]) {
                totalSkill += skill[row][j];
                neighbors++;
                break;
            }
        }
        //east
        for (int j = column+1; j < columns; j++) {
            if (alive[row][j]) {
                totalSkill += skill[row][j];
                neighbors++;
                break;
            }
        }
        return ((float)totalSkill)/neighbors;
    }
    
    int findRoundInterest () {
        int interest = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (alive[i][j]) {
                    interest += skill[i][j];
                }
            }
        }
        return interest;
    }
}

