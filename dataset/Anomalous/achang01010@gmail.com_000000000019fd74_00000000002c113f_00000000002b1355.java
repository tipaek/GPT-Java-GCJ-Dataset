import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int[][] floor = new int[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }

            int[][] floorElim = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    floorElim[i][j] = 1;
                }
            }

            int totalPeople = height * width + 1;
            int score = 0;

            while (true) {
                int peopleCount = 0;
                for (int[] row : floorElim) {
                    for (int cell : row) {
                        if (cell == 1) {
                            peopleCount++;
                        }
                    }
                }

                if (peopleCount == totalPeople) {
                    break;
                }

                totalPeople = peopleCount;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        score += floor[i][j] * floorElim[i][j];
                    }
                }

                ArrayList<Integer> rowsToEliminate = new ArrayList<>();
                ArrayList<Integer> colsToEliminate = new ArrayList<>();

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (floorElim[i][j] == 1) {
                            int surroundingSum = 0;
                            int surroundingCount = 0;

                            if (i > 0 && floorElim[i - 1][j] == 1) {
                                surroundingSum += floor[i - 1][j];
                                surroundingCount++;
                            }
                            if (i < height - 1 && floorElim[i + 1][j] == 1) {
                                surroundingSum += floor[i + 1][j];
                                surroundingCount++;
                            }
                            if (j > 0 && floorElim[i][j - 1] == 1) {
                                surroundingSum += floor[i][j - 1];
                                surroundingCount++;
                            }
                            if (j < width - 1 && floorElim[i][j + 1] == 1) {
                                surroundingSum += floor[i][j + 1];
                                surroundingCount++;
                            }

                            double average = surroundingCount > 0 ? (double) surroundingSum / surroundingCount : 0;
                            if (average > floor[i][j]) {
                                rowsToEliminate.add(i);
                                colsToEliminate.add(j);
                            }
                        }
                    }
                }

                for (int k = 0; k < rowsToEliminate.size(); k++) {
                    floorElim[rowsToEliminate.get(k)][colsToEliminate.get(k)] = 0;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + score);
        }

        scanner.close();
    }
}