import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] skill = new int[r][c];

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    skill[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            long overallSum = 0;

            List<List<Integer>> remove = new LinkedList<>();

            do {
                remove.clear();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (skill[i][j] < 1) continue;

                        overallSum += skill[i][j];

                        int neighbors = 0;
                        int offset = 0;
                        int up = -1, down = -1, left = -1, right = -1;

                        while (up == -1 || down == -1 || left == -1 || right == -1) {
                            offset++;

                            if (up == -1) {
                                if (i - offset < 0) {
                                    up = 0;
                                } else {
                                    if (skill[i - offset][j] > 0) {
                                        up = skill[i - offset][j];
                                        neighbors++;
                                    }
                                }
                            }

                            if (down == -1) {
                                if (i + offset >= r) {
                                    down = 0;
                                } else {
                                    if (skill[i + offset][j] > 0) {
                                        down = skill[i + offset][j];
                                        neighbors++;
                                    }
                                }
                            }

                            if (left == -1) {
                                if (j - offset < 0) {
                                    left = 0;
                                } else {
                                    if (skill[i][j - offset] > 0) {
                                        left = skill[i][j - offset];
                                        neighbors++;
                                    }
                                }
                            }

                            if (right == -1) {
                                if (j + offset >= c) {
                                    right = 0;
                                } else {
                                    if (skill[i][j + offset] > 0) {
                                        right = skill[i][j + offset];
                                        neighbors++;
                                    }
                                }
                            }
                        }

                        if (neighbors == 0) {
                            continue;
                        }

                        int neighborSum = up + down + left + right;

                        if (neighborSum > skill[i][j] * neighbors) {
                            // skill[i][j] = -1; // lose
                            remove.add(Arrays.asList(new Integer[]{i, j}));
                        }
                    }
                }

                for (List<Integer> removes : remove) {
                    skill[removes.get(0)][removes.get(1)] = -1;
                }
            } while(remove.size() > 0);

            System.out.printf("Case #%d: ", t);
            System.out.println(overallSum);
        }

    }
}
