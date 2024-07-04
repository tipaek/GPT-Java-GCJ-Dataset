import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            Solver solver = new Solver(scanner);
            solver.solve();
            System.out.println("Case #" + test + ": " + solver.getTotalInterest());
        }
    }
}

class Solver {
    private int rows;
    private int columns;
    private int[][] skills;
    private boolean[][] isAlive;
    private int totalInterest;

    public Solver(Scanner scanner) {
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        skills = new int[rows][columns];
        isAlive = new boolean[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                skills[i][j] = scanner.nextInt();
                isAlive[i][j] = true;
            }
        }
    }

    public void solve() {
        boolean hasEliminations;
        
        do {
            hasEliminations = false;
            double[][] avgSkills = calculateAverageSkills();
            totalInterest += calculateRoundInterest();
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (isAlive[i][j] && skills[i][j] < avgSkills[i][j]) {
                        isAlive[i][j] = false;
                        hasEliminations = true;
                    }
                }
            }
        } while (hasEliminations);
    }

    public int getTotalInterest() {
        return totalInterest;
    }

    private double[][] calculateAverageSkills() {
        double[][] avgSkills = new double[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (isAlive[i][j]) {
                    avgSkills[i][j] = calculateAverageSkill(i, j);
                }
            }
        }
        
        return avgSkills;
    }

    private double calculateAverageSkill(int row, int col) {
        double totalSkill = 0;
        int neighborCount = 0;

        // Check north
        for (int i = row - 1; i >= 0; i--) {
            if (isAlive[i][col]) {
                totalSkill += skills[i][col];
                neighborCount++;
                break;
            }
        }

        // Check south
        for (int i = row + 1; i < rows; i++) {
            if (isAlive[i][col]) {
                totalSkill += skills[i][col];
                neighborCount++;
                break;
            }
        }

        // Check west
        for (int j = col - 1; j >= 0; j--) {
            if (isAlive[row][j]) {
                totalSkill += skills[row][j];
                neighborCount++;
                break;
            }
        }

        // Check east
        for (int j = col + 1; j < columns; j++) {
            if (isAlive[row][j]) {
                totalSkill += skills[row][j];
                neighborCount++;
                break;
            }
        }

        return neighborCount == 0 ? 0 : totalSkill / neighborCount;
    }

    private int calculateRoundInterest() {
        int roundInterest = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (isAlive[i][j]) {
                    roundInterest += skills[i][j];
                }
            }
        }
        
        return roundInterest;
    }
}