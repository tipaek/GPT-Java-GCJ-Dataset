import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        String[] tokens;

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            tokens = reader.readLine().trim().split(" ");
            int R = Integer.parseInt(tokens[0]);
            int C = Integer.parseInt(tokens[1]);

            int[][] danceFloor = new int[R][C];
            for (int i = 0; i < R; i++) {
                tokens = reader.readLine().trim().split(" ");
                
                for (int j = 0; j < C; j++) {
                    danceFloor[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            output.append(getCompetitionInterest(R, C, danceFloor)).append("\n");
        }

        System.out.print(output);
    }

    private static long getCompetitionInterest(int r, int c, int[][] danceFloor) {
        long skillTotal = getSkillTotal(danceFloor);

        long competitionInterest = 0;
        int eliminatedCount;
        boolean[][] fullProof = new boolean[r][c];

        do {
            competitionInterest += skillTotal;
            eliminatedCount = 0;

            boolean[][] eliminated = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (danceFloor[i][j] != 0 && !fullProof[i][j]) {
                        int[] compassCompetitors = new int[4];

                        for (int k = j - 1; k >= 0; k--) {
                            if (danceFloor[i][k] != 0) {
                                compassCompetitors[0] = danceFloor[i][k];
                                break;
                            }
                        }

                        for (int k = j + 1; k < c; k++) {
                            if (danceFloor[i][k] != 0) {
                                compassCompetitors[1] = danceFloor[i][k];
                                break;
                            }
                        }

                        for (int k = i - 1; k >= 0; k--) {
                            if (danceFloor[k][j] != 0) {
                                compassCompetitors[2] = danceFloor[k][j];
                                break;
                            }
                        }

                        for (int k = i + 1; k < r; k++) {
                            if (danceFloor[k][j] != 0) {
                                compassCompetitors[3] = danceFloor[k][j];
                                break;
                            }
                        }

                        int totalCompassCompetitors = 0;
                        int totalCompassCompetition = 0;
                        for (int skill : compassCompetitors) {
                            if (skill > 0) {
                                totalCompassCompetition += skill;
                                totalCompassCompetitors++;
                            }
                        }

                        if (totalCompassCompetitors == 0) {
                            fullProof[i][j] = true;
                            continue;
                        }

                        if (totalCompassCompetition / totalCompassCompetitors > danceFloor[i][j]) {
                            eliminatedCount++;
                            eliminated[i][j] = true;
                            skillTotal -= danceFloor[i][j];
                        }
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (eliminated[i][j]) {
                        danceFloor[i][j] = 0;
                    }
                }
            }
        } while (eliminatedCount > 0);

        return competitionInterest;
    }

    private static long getSkillTotal(int[][] danceFloor) {
        long skillTotal = 0;

        for (int[] row : danceFloor) {
            for (int skill : row) {
                skillTotal += skill;
            }
        }

        return skillTotal;
    }
}
