import java.io.*;
import java.util.*;

public class Solution {
    
    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int rows = Integer.parseInt(tokenizer.nextToken());
            int cols = Integer.parseInt(tokenizer.nextToken());

            long[][] dancers = new long[rows][cols];
            boolean[][] eliminated = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < cols; j++) {
                    dancers[i][j] = Long.parseLong(tokenizer.nextToken());
                }
            }

            long totalSkill = 0;
            boolean continueElimination = true;

            while (continueElimination) {
                continueElimination = false;
                List<Position> toEliminate = new ArrayList<>();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!eliminated[i][j]) {
                            totalSkill += dancers[i][j];

                            long neighborCount = 0;
                            long neighborSkillSum = 0;

                            // Check above
                            for (int k = i - 1; k >= 0; k--) {
                                if (!eliminated[k][j]) {
                                    neighborCount++;
                                    neighborSkillSum += dancers[k][j];
                                    break;
                                }
                            }

                            // Check below
                            for (int k = i + 1; k < rows; k++) {
                                if (!eliminated[k][j]) {
                                    neighborCount++;
                                    neighborSkillSum += dancers[k][j];
                                    break;
                                }
                            }

                            // Check left
                            for (int k = j - 1; k >= 0; k--) {
                                if (!eliminated[i][k]) {
                                    neighborCount++;
                                    neighborSkillSum += dancers[i][k];
                                    break;
                                }
                            }

                            // Check right
                            for (int k = j + 1; k < cols; k++) {
                                if (!eliminated[i][k]) {
                                    neighborCount++;
                                    neighborSkillSum += dancers[i][k];
                                    break;
                                }
                            }

                            if (neighborCount * dancers[i][j] < neighborSkillSum) {
                                toEliminate.add(new Position(i, j));
                            }
                        }
                    }
                }

                for (Position pos : toEliminate) {
                    eliminated[pos.row][pos.col] = true;
                }

                continueElimination = !toEliminate.isEmpty();
            }

            System.out.println("Case #" + caseNum + ": " + totalSkill);
        }
        reader.close();
    }
}