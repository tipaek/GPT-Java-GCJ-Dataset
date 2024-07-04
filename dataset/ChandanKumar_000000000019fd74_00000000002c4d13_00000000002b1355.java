
import java.io.*;
import java.util.*;

class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        int[] solutionArray = new int[T];

        for (int i = 0; i < T; i++) {

            int R = in.nextInt();
            int C = in.nextInt();

            int[][] stage = new int[R][C];

            for (int j = 0; j < R; j++) {

                for (int k = 0; k < C; k++) {
                    stage[j][k] = in.nextInt();
                }
            }

            int competitionSkill = 0;

            while (true) {

                int roundSkill = 0;
                ArrayList<MatrixIndex> eliminateCell = new ArrayList<>();

                for (int j = 0; j < R; j++) {

                    for (int k = 0; k < C; k++) {

                        if (stage[j][k] != -1) {

                            roundSkill = roundSkill + stage[j][k];

                            if (toEleminate(stage, j, k, R, C)) {
                                eliminateCell.add(new MatrixIndex(j, k));
                            }
                        }
                    }
                }

                competitionSkill = competitionSkill + roundSkill;

                if (eliminateCell.isEmpty()) {
                    break;
                } else {
                    eliminateCell.forEach((ma) -> {
                        stage[ma.getRow()][ma.getCol()] = -1;
                    });
                }
            }

            solutionArray[i] = competitionSkill;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(String.format("Case #%d: %d", i + 1, solutionArray[i]));
        }
    }

    private static boolean toEleminate(int[][] stage, int j, int k, int R, int C) {

        int sum = 0;
        int count = 0;

        for (int i = k + 1; i < C; i++) {

            if (stage[j][i] != -1) {
                sum = sum + stage[j][i];
                count++;
                break;
            }
        }

        for (int i = k - 1; i > -1; i--) {

            if (stage[j][i] != -1) {
                sum = sum + stage[j][i];
                count++;
                break;
            }
        }

        for (int i = j + 1; i < R; i++) {

            if (stage[i][k] != -1) {
                sum = sum + stage[i][k];
                count++;
                break;
            }
        }

        for (int i = j - 1; i > -1; i--) {

            if (stage[i][k] != -1) {
                sum = sum + stage[i][k];
                count++;
                break;
            }
        }

        if (count == 0) {
            return false;
        } else {

            float avg = (float) sum / (float) count;
            return avg > stage[j][k];
        }
    }

    protected static class MatrixIndex<I, J> {

        private final I i;
        private final J j;

        protected MatrixIndex(I i, J j) {
            this.i = i;
            this.j = j;
        }

        protected int getRow() {
            return (Integer) i;
        }

        protected int getCol() {
            return (Integer) j;
        }
    }
}
