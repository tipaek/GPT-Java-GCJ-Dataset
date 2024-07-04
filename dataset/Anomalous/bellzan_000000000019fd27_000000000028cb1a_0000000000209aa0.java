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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());

        for (int testCase = 0; testCase < T; testCase++) {
            tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());
            currentGrid = new int[N][N];
            int[] sequence = new int[N];
            boolean possible = false;
            int type = -1;

            int startA = Math.max(1, (K / N) - 5);
            int endA = Math.min(N, (K / N) + 6);

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
                        int b = j;
                        int c = goal - j;
                        if (b != c && b != a && c != a && b > 0 && b < N && c > 0 && c < N) {
                            possible = true;
                            type = 1;
                            sequence[0] = a;
                            sequence[1] = c;
                            sequence[N - 1] = b;
                            for (int k = 2; k < N - 1; k++) {
                                sequence[k] = k;
                                if (k == a) {
                                    sequence[k] = N;
                                } else if (k == c) {
                                    sequence[k] = 1;
                                } else if (k == b) {
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
                System.out.println("Case #" + (testCase + 1) + ": POSSIBLE");
                for (int[] row : currentGrid) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            }
        }
        reader.close();
    }
}