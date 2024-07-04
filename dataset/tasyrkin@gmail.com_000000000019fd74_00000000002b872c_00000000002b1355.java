import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            final int X = scanner.nextInt();
            final int Y = scanner.nextInt();
            int[][] floor = new int[X][Y];
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    floor[i][j] = scanner.nextInt();
                }
            }
            int numEliminated = 0;
            long result = 0;
            do {
                Pair pair = eliminateCompetirors(floor);
                numEliminated = (int) pair.x;
                result += pair.y;
            } while (numEliminated > 0);

            System.out.println(
                    String.format(
                            "Case #%d: %s", caseNumber, result
                    )
            );
        }
    }

    private static class Pair {
        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Pair eliminateCompetirors(int[][] floor) {
        List<Pair> elim = new LinkedList<>();
        long score = 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[0].length; j++) {
                if (floor[i][j] != -1) {
                    score += floor[i][j];
                    int compNum = 0;
                    int compSum = 0;
                    for (int k = i - 1; k >= 0; --k) {
                        if (floor[k][j] != -1) {
                            ++compNum;
                            compSum += floor[k][j];
                            break;
                        }
                    }
                    for (int k = i + 1; k < floor.length; ++k) {
                        if (floor[k][j] != -1) {
                            ++compNum;
                            compSum += floor[k][j];
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0; --k) {
                        if (floor[i][k] != -1) {
                            ++compNum;
                            compSum += floor[i][k];
                            break;
                        }
                    }
                    for (int k = j + 1; k < floor[0].length; ++k) {
                        if (floor[i][k] != -1) {
                            ++compNum;
                            compSum += floor[i][k];
                            break;
                        }
                    }
                    if (compNum > 0) {
                        int currComp = floor[i][j] * compNum;
                        if (currComp < compSum) {
                            elim.add(new Pair(i, j));
                        }
                    }
                }
            }
        }
        for (Pair p : elim) {
            floor[(int) p.x][(int) p.y] = -1;
        }
        return new Pair(elim.size(), score);
    }

    private static long calculateScore(int[][] floor) {
        long score = 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[0].length; j++) {
                if (floor[i][j] != -1) {
                    score += floor[i][j];
                }
            }
        }
        return score;
    }

}
