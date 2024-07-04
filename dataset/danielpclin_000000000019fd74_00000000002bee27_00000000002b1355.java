import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T;
            T = in.nextInt();
            for (int t = 1; t <= T; ++t) {
                System.out.print("Case #" + t + ": ");
                int R = in.nextInt(), C = in.nextInt();
                int[][] matrix = new int[R][C];
                int[][][] count = new int[R][C][2];
                int aliveCount = R * C, score = 0;
                Set<Integer> alive = IntStream.range(0, aliveCount).boxed().collect(Collectors.toSet());
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        matrix[i][j] = in.nextInt();
                        if (i - 1 >= 0){
                            count[i - 1][j][0] += matrix[i][j];
                            count[i - 1][j][1]++;
                        }
                        if (i + 1 < R){
                            count[i + 1][j][0] += matrix[i][j];
                            count[i + 1][j][1]++;
                        }
                        if (j - 1 >= 0){
                            count[i][j - 1][0] += matrix[i][j];
                            count[i][j - 1][1]++;
                        }
                        if (j + 1 < C){
                            count[i][j + 1][0] += matrix[i][j];
                            count[i][j + 1][1]++;
                        }
                    }
                }
                do {
                    aliveCount = alive.size();
                    Vector<Integer> toRemove = new Vector<>();
                    for (int i : alive) {
                        int r = i / C, c = i % C;
                        score += matrix[r][c];
                        if ((double) count[r][c][0] / count[r][c][1] > matrix[r][c]) {
                            toRemove.add(i);
                        }
                    }
                    for (int i : toRemove){
                        int r = i / C, c = i % C;
                        int idx = i;
                        while ((idx -= C) >= 0) {
                            if (alive.contains(idx)) {
                                count[idx / C][idx % C][0] -= matrix[r][c];
                                count[idx / C][idx % C][1]--;
                                int new_idx = i;
                                while ((new_idx += C) < R * C) {
                                    if (alive.contains(new_idx)) {
                                        count[idx / C][idx % C][0] += matrix[new_idx / C][new_idx % C];
                                        count[idx / C][idx % C][1]++;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        idx = i;
                        while ((idx += C) < R * C) {
                            if (alive.contains(idx)) {
                                count[idx / C][idx % C][0] -= matrix[r][c];
                                count[idx / C][idx % C][1]--;
                                int new_idx = i;
                                while ((new_idx -= C) >= 0) {
                                    if (alive.contains(new_idx)) {
                                        count[idx / C][idx % C][0] += matrix[new_idx / C][new_idx % C];
                                        count[idx / C][idx % C][1]++;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        int cidx = c;
                        while ((--cidx) >= 0) {
                            if (alive.contains(r * C + cidx)) {
                                count[r][cidx][0] -= matrix[r][c];
                                count[r][cidx][1]--;
                                int new_cidx = c;
                                while ((++new_cidx) < C) {
                                    if (alive.contains(r * C + new_cidx)) {
                                        count[r][cidx][0] += matrix[r][new_cidx];
                                        count[r][cidx][1]++;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        cidx = c;
                        while ((++cidx) < C) {
                            if (alive.contains(r * C + cidx)) {
                                count[r][cidx][0] -= matrix[r][c];
                                count[r][cidx][1]--;
                                int new_cidx = c;
                                while ((--new_cidx) >= 0) {
                                    if (alive.contains(r * C + new_cidx)) {
                                        count[r][cidx][0] += matrix[r][new_cidx];
                                        count[r][cidx][1]++;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    alive.removeAll(toRemove);
                } while (alive.size() != aliveCount);
                System.out.println(score);
            }
        }
    }
}