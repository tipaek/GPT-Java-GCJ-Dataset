import java.io.*;
import java.util.*;

public class Solution {
    static int[][] currentGrid;
    static int N;
    static int K;

    public static int findR() {
        int problemCount = 0;
        for (int m = 0; m < N; m++) {
            boolean[] seen = new boolean[N + 1];
            for (int l = 0; l < N; l++) {
                int currentSquare = currentGrid[m][l];
                if (!seen[currentSquare]) {
                    seen[currentSquare] = true;
                } else {
                    problemCount++;
                    break;
                }
            }
        }
        return problemCount;
    }

    public static int findC() {
        int problemCount = 0;
        for (int m = 0; m < N; m++) {
            boolean[] seen = new boolean[N + 1];
            for (int l = 0; l < N; l++) {
                int currentSquare = currentGrid[l][m];
                if (!seen[currentSquare]) {
                    seen[currentSquare] = true;
                } else {
                    problemCount++;
                    break;
                }
            }
        }
        return problemCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(f.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            currentGrid = new int[N][N];

            List<Integer> available = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                available.add(j);
            }

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
                    sequence[j] = (j == K / N) ? N : j;
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
                            available.remove(Integer.valueOf(a));
                            available.remove(Integer.valueOf(c));
                            available.remove(Integer.valueOf(b));
                            for (int k = 2; k < N - 1; k++) {
                                sequence[k] = available.get(k - 2);
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
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int[] row : currentGrid) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }

                if (findR() > 0 || findC() > 0) {
                    System.out.println("Oh, no!");
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        f.close();
    }
}