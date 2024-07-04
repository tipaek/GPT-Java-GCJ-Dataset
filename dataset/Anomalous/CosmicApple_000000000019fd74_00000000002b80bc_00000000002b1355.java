import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            Solver solver = new Solver(scanner);
            solver.solve();
            System.out.println("Case #" + testCase + ": " + solver.getTotalInterest());
        }
    }
}

class Solver {
    private int rows;
    private int columns;
    private int[][] skills;
    private boolean[][] alive;
    private int totalInterest;

    public Solver(Scanner scanner) {
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        skills = new int[rows][columns];
        alive = new boolean[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                skills[i][j] = scanner.nextInt();
                alive[i][j] = true;
            }
        }
    }

    public void solve() {
        boolean eliminated;
        
        do {
            eliminated = false;
            double[][] averageSkills = calculateAverageSkills();
            totalInterest += calculateRoundInterest();
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (alive[i][j] && skills[i][j] < averageSkills[i][j]) {
                        alive[i][j] = false;
                        eliminated = true;
                    }
                }
            }
        } while (eliminated);
    }

    public int getTotalInterest() {
        return totalInterest;
    }

    private double[][] calculateAverageSkills() {
        double[][] averageSkills = new double[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (alive[i][j]) {
                    averageSkills[i][j] = calculateAverageSkill(i, j);
                }
            }
        }
        
        return averageSkills;
    }

    private double calculateAverageSkill(int row, int column) {
        double totalSkill = 0;
        int neighbors = 0;

        // North
        for (int i = row - 1; i >= 0; i--) {
            if (alive[i][column]) {
                totalSkill += skills[i][column];
                neighbors++;
                break;
            }
        }
        // South
        for (int i = row + 1; i < rows; i++) {
            if (alive[i][column]) {
                totalSkill += skills[i][column];
                neighbors++;
                break;
            }
        }
        // West
        for (int j = column - 1; j >= 0; j--) {
            if (alive[row][j]) {
                totalSkill += skills[row][j];
                neighbors++;
                break;
            }
        }
        // East
        for (int j = column + 1; j < columns; j++) {
            if (alive[row][j]) {
                totalSkill += skills[row][j];
                neighbors++;
                break;
            }
        }
        
        return neighbors > 0 ? totalSkill / neighbors : 0;
    }

    private int calculateRoundInterest() {
        int interest = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (alive[i][j]) {
                    interest += skills[i][j];
                }
            }
        }
        
        return interest;
    }
}