import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int[][] currentGrid;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            currentGrid = new int[N][N];
            int[] sequence = new int[N];
            boolean possible = false;
            int type = -1;

            int startA = K / N - 5;
            int endA = K / N + 6;

            if (K % N == 0) {
                possible = true;
                type = 0;
                sequence[0] = K / N;
                for (int j = 1; j < N; j++) {
                    sequence[j] = j;
                    if (j == K / N) {
                        sequence[j] = N;
                    }
                }
            }

            if (!possible && N != 2) {
                for (int a = startA; a <= endA; a++) {
                    int goal = K - a * (N - 2);
                    for (int j = 1; j <= goal / 2; j++) {
                        if (isValidCombination(j, goal, a)) {
                            possible = true;
                            type = 1;
                            sequence[0] = a;
                            sequence[1] = goal - j;
                            sequence[N - 1] = j;
                            for (int k = 2; k < N - 1; k++) {
                                sequence[k] = k;
                                if (k == a) {
                                    sequence[k] = N;
                                } else if (k == goal - j) {
                                    sequence[k] = 1;
                                } else if (k == j) {
                                    sequence[k] = N - 1;
                                }
                            }
                            break;
                        }
                    }
                    if (possible) break;
                }
            }

            if (possible) {
                fillGrid(sequence, type);
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                printGrid();
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        reader.close();
    }

    private static boolean isValidCombination(int j, int goal, int a) {
        return j != (goal - j) && j != a && (goal - j) != a && j > 0 && j < N && (goal - j) > 0 && (goal - j) < N;
    }

    private static void fillGrid(int[] sequence, int type) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                currentGrid[j][k] = sequence[(k + N - j) % N];
            }
        }
        if (type == 1) {
            int[] temp = Arrays.copyOf(currentGrid[N - 1], N);
            currentGrid[N - 1] = currentGrid[N - 2];
            currentGrid[N - 2] = temp;
        }
    }

    private static void printGrid() {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                System.out.print(currentGrid[j][k] + " ");
            }
            System.out.println();
        }
    }
}