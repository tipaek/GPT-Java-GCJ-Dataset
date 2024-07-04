import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt(); 

        for (int c = 0; c < cases; c++) {
            int hor = sc.nextInt();
            int ver = sc.nextInt();
            int[][] floor = new int[ver][hor];
            int[][] floorElim = new int[ver][hor];

            // Read floor values
            for (int i = 0; i < ver; i++) {
                for (int j = 0; j < hor; j++) {
                    floor[i][j] = sc.nextInt();
                    floorElim[i][j] = 1; // Initialize floorElim with 1
                }
            }

            int totalPeople = ver * hor + 1;
            int score = 0;

            while (true) {
                int people = countPeople(floorElim);

                if (people == totalPeople) {
                    break;
                }

                totalPeople = people;
                score += calculateScore(floor, floorElim);

                ArrayList<Integer> one = new ArrayList<>();
                ArrayList<Integer> two = new ArrayList<>();

                // Check and mark the cells to be eliminated
                markCellsForElimination(floor, floorElim, ver, hor, one, two);

                // Eliminate marked cells
                for (int i = 0; i < one.size(); i++) {
                    floorElim[one.get(i)][two.get(i)] = 0;
                }
            }

            System.out.println("Case #" + (c + 1) + ": " + score);
        }

        sc.close();
    }

    private static int countPeople(int[][] floorElim) {
        int people = 0;
        for (int[] row : floorElim) {
            for (int cell : row) {
                if (cell == 1) {
                    people++;
                }
            }
        }
        return people;
    }

    private static int calculateScore(int[][] floor, int[][] floorElim) {
        int score = 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                score += floor[i][j] * floorElim[i][j];
            }
        }
        return score;
    }

    private static void markCellsForElimination(int[][] floor, int[][] floorElim, int ver, int hor, ArrayList<Integer> one, ArrayList<Integer> two) {
        for (int i = 0; i < ver; i++) {
            for (int j = 0; j < hor; j++) {
                if (floorElim[i][j] == 1) {
                    int found = 0;
                    int runningSum = 0;

                    // Check vertically and horizontally adjacent cells
                    found += checkAdjacentCells(floor, floorElim, i, j, ver, hor, runningSum);

                    double average = found != 0 ? (double) runningSum / found : 0;
                    if (average > floor[i][j]) {
                        one.add(i);
                        two.add(j);
                    }
                }
            }
        }
    }

    private static int checkAdjacentCells(int[][] floor, int[][] floorElim, int i, int j, int ver, int hor, int runningSum) {
        int found = 0;

        // Check upward
        for (int start = i - 1; start >= 0; start--) {
            if (floorElim[start][j] == 1) {
                found++;
                runningSum += floor[start][j];
                break;
            }
        }

        // Check downward
        for (int start = i + 1; start < ver; start++) {
            if (floorElim[start][j] == 1) {
                found++;
                runningSum += floor[start][j];
                break;
            }
        }

        // Check left
        for (int start = j - 1; start >= 0; start--) {
            if (floorElim[i][start] == 1) {
                found++;
                runningSum += floor[i][start];
                break;
            }
        }

        // Check right
        for (int start = j + 1; start < hor; start++) {
            if (floorElim[i][start] == 1) {
                found++;
                runningSum += floor[i][start];
                break;
            }
        }

        return found;
    }
}