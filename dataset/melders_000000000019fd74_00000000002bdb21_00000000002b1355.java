import java.io.*;
import java.util.*;

public class Solution {
    private static final boolean INTERACTIVE_PROBLEM = false;
    private static final String FILE_NAME = null;

    private static String solve(Scanner in) {
        int R = in.nextInt();
        int C = in.nextInt();

        int[][] danceFloor = new int[R][C];
        int[] upDancer = new int[C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                danceFloor[i][j] = in.nextInt();
            }
        }

        long interestLevel = 0;
        boolean quietRound = false;
        while (!quietRound) {
            int[][] netStrength = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i == 0) {
                        upDancer[j] = -1;
                    }
                    interestLevel += danceFloor[i][j];
                    netStrength[i][j] = 0;
                }
            }

            for (int i = 0; i < R; i++) {
                int leftDancer = -1;
                for (int j = 0; j < C; j++) {
                    if (danceFloor[i][j] != 0) {
                        if (upDancer[j] != -1) {
                            netStrength[i][j] += danceFloor[i][j] - danceFloor[upDancer[j]][j];
                            netStrength[upDancer[j]][j] += danceFloor[upDancer[j]][j] - danceFloor[i][j];
                        }
                        if (leftDancer != -1) {
                            netStrength[i][j] += danceFloor[i][j] - danceFloor[i][leftDancer];
                            netStrength[i][leftDancer] += danceFloor[i][leftDancer] - danceFloor[i][j];
                        }
                        upDancer[j] = i;
                        leftDancer = j;
                    }
                }
            }

            quietRound = true;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (netStrength[i][j] < 0) {
                        quietRound = false;
                        danceFloor[i][j] = 0;
                    }
                }
            }
        }

        return Long.toString(interestLevel);
    }

    private static void run() {
        try {
            Scanner in = new Scanner(new BufferedReader(FILE_NAME == null ? new InputStreamReader(System.in)
                    : new FileReader(new File(FILE_NAME + ".in"))));

            long tc = in.nextLong();
            for (long t = 1; t <= tc; t++) {
                final String solution = solve(in);
                if (INTERACTIVE_PROBLEM) {
                    System.out.println(solution);
                    if (in.next().equals("N")) {
                        break;
                    }
                } else {
                    System.out.println("Case #" + t + ": " + solution);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
