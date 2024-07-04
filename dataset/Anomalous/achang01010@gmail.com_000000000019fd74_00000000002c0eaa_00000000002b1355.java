import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int hor = sc.nextInt();
            int ver = sc.nextInt();

            int[][] floor = new int[ver][hor];
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    floor[i][j] = sc.nextInt();
                }
            }

            int[][] floorElim = new int[ver][hor];
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    floorElim[i][j] = 1;
                }
            }

            int totalPeople = ver * hor + 1;
            int score = 0;

            while (true) {
                int people = 0;
                for (int[] row : floorElim) {
                    for (int cell : row) {
                        if (cell == 1) {
                            people++;
                        }
                    }
                }

                if (people == totalPeople) {
                    break;
                }

                totalPeople = people;

                for (int i = 0; i < ver; i++) {
                    for (int j = 0; j < hor; j++) {
                        score += floor[i][j] * floorElim[i][j];
                    }
                }

                ArrayList<Integer> rowsToEliminate = new ArrayList<>();
                ArrayList<Integer> colsToEliminate = new ArrayList<>();

                for (int i = 0; i < ver; i++) {
                    for (int j = 0; j < hor; j++) {
                        if (floorElim[i][j] == 1) {
                            int found = 0;
                            int runningSum = 0;

                            for (int k = i - 1; k >= 0 && floorElim[k][j] == 1; k--) {
                                found++;
                                runningSum += floor[k][j];
                            }

                            for (int k = i + 1; k < ver && floorElim[k][j] == 1; k++) {
                                found++;
                                runningSum += floor[k][j];
                            }

                            for (int k = j - 1; k >= 0 && floorElim[i][k] == 1; k--) {
                                found++;
                                runningSum += floor[i][k];
                            }

                            for (int k = j + 1; k < hor && floorElim[i][k] == 1; k++) {
                                found++;
                                runningSum += floor[i][k];
                            }

                            double average = found != 0 ? (double) runningSum / found : 0;

                            if (average > floor[i][j]) {
                                rowsToEliminate.add(i);
                                colsToEliminate.add(j);
                            }
                        }
                    }
                }

                for (int i = 0; i < rowsToEliminate.size(); i++) {
                    floorElim[rowsToEliminate.get(i)][colsToEliminate.get(i)] = 0;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + score);
        }
    }
}