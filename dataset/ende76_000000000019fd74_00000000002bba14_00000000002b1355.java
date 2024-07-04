import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int solve(int rows, int cols, int[][] skills) {
        int result = 0;

        boolean eliminated = true;

        while (eliminated) {
            eliminated = false;

            // for dancer in cell r, c, holds #neighbors, #sum neighbor skilly
            int[][][] neighbors = new int[rows][cols][2];

            for (int r = 0; r < rows; r += 1) {
                int west = 0;
                int east = 0;
                for (int c = 0; c < cols; c += 1) {
                    if (west > 0) {
                        neighbors[r][c][0] += 1;
                        neighbors[r][c][1] += west;
                    }
                    if (skills[r][c] > 0) west = skills[r][c];
                }

                for (int c = cols - 1; c >= 0; c -= 1) {
                    if (east > 0) {
                        neighbors[r][c][0] += 1;
                        neighbors[r][c][1] += east;
                    }
                    if (skills[r][c] > 0) east = skills[r][c];
                }
            }

//            for (int r = 0; r < rows; r += 1) {
//                for (int c = 0; c < cols; c += 1) {
//                    System.out.print(Arrays.toString(neighbors[r][c]));
//                }
//                System.out.println();
//            }
//            System.out.println();

            for (int c = 0; c < cols; c += 1) {
                int north = 0;
                int south = 0;
                for (int r = 0; r < rows; r += 1) {
                    if (north > 0) {
                        neighbors[r][c][0] += 1;
                        neighbors[r][c][1] += north;
                    }
                    if (skills[r][c] > 0) north = skills[r][c];
                }

                for (int r = rows - 1; r >= 0; r -= 1) {
                    if (south > 0) {
                        neighbors[r][c][0] += 1;
                        neighbors[r][c][1] += south;
                    }
                    if (skills[r][c] > 0) south = skills[r][c];
                }
            }

//            for (int r = 0; r < rows; r += 1) {
//                for (int c = 0; c < cols; c += 1) {
//                    System.out.print(Arrays.toString(neighbors[r][c]));
//                }
//                System.out.println();
//            }
//            System.out.println();

            for (int r = 0; r < rows; r += 1) {
                for (int c = 0; c < cols; c += 1) {
                    result += skills[r][c];
                    if (neighbors[r][c][0] == 0 || skills[r][c] == 0) continue;

                    if (skills[r][c] * neighbors[r][c][0] < neighbors[r][c][1]) {
                        skills[r][c] = 0;
                        eliminated = true;
                    }
                }
            }

//            for (int r = 0; r < rows; r += 1) {
//                System.out.println(Arrays.toString(skills[r]));
//            }
//
//            System.out.println("---");

        }

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int t = 1; t <= T; t += 1) {
            int R = s.nextInt();
            int C = s.nextInt();

            int[][] skills = new int[R][C];

            for (int r = 0; r < R; r += 1) {
                for (int c = 0; c < C; c += 1) {
                    skills[r][c] = s.nextInt();
                }
            }

            int result = solve(R, C, skills);


            System.out.printf("Case #%d: %d\n", t, result);
        }
    }
}
