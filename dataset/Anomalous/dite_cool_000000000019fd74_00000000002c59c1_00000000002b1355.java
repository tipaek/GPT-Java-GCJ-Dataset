import java.util.*;

class Dancer {
    int skill;
    int row;
    int column;
    List<Integer> cnrow;
    List<Integer> cncol;
    boolean eliminated;

    public Dancer(int skill, int row, int column) {
        this.skill = skill;
        this.row = row;
        this.column = column;
        this.cnrow = new ArrayList<>();
        this.cncol = new ArrayList<>();
        this.eliminated = false;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            Dancer[][] dancers = new Dancer[R][C];
            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int skill = sc.nextInt();
                    dancers[i][j] = new Dancer(skill, i, j);
                }
            }
            
            updateCompassNeighbours(dancers, R, C);
            int totalInterest = 0;
            int currentInterest = calculateRoundInterest(dancers, R, C);
            totalInterest += currentInterest;
            
            while (true) {
                int previousInterest = currentInterest;
                eliminateDancers(dancers, R, C);
                updateCompassNeighbours(dancers, R, C);
                currentInterest = calculateRoundInterest(dancers, R, C);
                
                if (currentInterest == previousInterest) {
                    break;
                }
                
                totalInterest += currentInterest;
            }
            
            System.out.println("Case #" + (t + 1) + ": " + totalInterest);
        }
        
        sc.close();
    }

    private static void updateCompassNeighbours(Dancer[][] dancers, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!dancers[i][j].eliminated) {
                    dancers[i][j].cnrow.clear();
                    dancers[i][j].cncol.clear();

                    addNeighbour(dancers, i, j, -1, 0, R, C);
                    addNeighbour(dancers, i, j, 1, 0, R, C);
                    addNeighbour(dancers, i, j, 0, -1, R, C);
                    addNeighbour(dancers, i, j, 0, 1, R, C);
                }
            }
        }
    }

    private static void addNeighbour(Dancer[][] dancers, int i, int j, int rowOffset, int colOffset, int R, int C) {
        int newRow = i + rowOffset;
        int newCol = j + colOffset;
        
        while (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C) {
            if (!dancers[newRow][newCol].eliminated) {
                dancers[i][j].cnrow.add(newRow);
                dancers[i][j].cncol.add(newCol);
                break;
            }
            newRow += rowOffset;
            newCol += colOffset;
        }
    }

    private static void eliminateDancers(Dancer[][] dancers, int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!dancers[i][j].eliminated) {
                    double averageSkill = calculateAverageSkill(dancers, dancers[i][j].cnrow, dancers[i][j].cncol);
                    if (dancers[i][j].skill < averageSkill) {
                        dancers[i][j].eliminated = true;
                    }
                }
            }
        }
    }

    private static double calculateAverageSkill(Dancer[][] dancers, List<Integer> rows, List<Integer> cols) {
        double totalSkill = 0;
        int count = rows.size();
        
        for (int k = 0; k < count; k++) {
            totalSkill += dancers[rows.get(k)][cols.get(k)].skill;
        }
        
        return count == 0 ? 0 : totalSkill / count;
    }

    private static int calculateRoundInterest(Dancer[][] dancers, int R, int C) {
        int totalSkill = 0;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!dancers[i][j].eliminated) {
                    totalSkill += dancers[i][j].skill;
                }
            }
        }
        
        return totalSkill;
    }
}