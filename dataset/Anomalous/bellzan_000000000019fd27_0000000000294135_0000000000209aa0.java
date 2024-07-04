import java.io.*;
import java.util.*;

public class Solution {
    static int[][] currentGrid;
    static int N;
    static int K;

    public static int findR() {
        int problemCount = 0;
        for (int[] row : currentGrid) {
            boolean[] seen = new boolean[N + 1];
            for (int value : row) {
                if (seen[value]) {
                    problemCount++;
                    break;
                }
                seen[value] = true;
            }
        }
        return problemCount;
    }

    public static int findC() {
        int problemCount = 0;
        for (int col = 0; col < N; col++) {
            boolean[] seen = new boolean[N + 1];
            for (int row = 0; row < N; row++) {
                int value = currentGrid[row][col];
                if (seen[value]) {
                    problemCount++;
                    break;
                }
                seen[value] = true;
            }
        }
        return problemCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(f.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            currentGrid = new int[N][N];
            ArrayList<Integer> available = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                available.add(j);
            }

            int[] sequence = new int[N];
            int type = -1;
            int startA = Math.max((K / N) - 5, 1);
            int endA = Math.min((K / N) + 6, N);
            boolean possible = false;

            if (K % N == 0 && K / N <= N) {
                possible = true;
                type = 0;
                sequence[0] = K / N;
                for (int j = 1; j < N; j++) {
                    sequence[j] = j == K / N ? N : j;
                }
            }

            if (!possible && N != 2) {
                outerLoop:
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
                            available.remove((Integer) a);
                            available.remove((Integer) c);
                            available.remove((Integer) b);
                            for (int k = 2; k < N - 1; k++) {
                                sequence[k] = available.get(k - 2);
                            }
                            break outerLoop;
                        } else if (N == 4 && b != a && c != a && b > 0 && b < N && c > 0 && c < N) {
                            possible = true;
                            type = 2;
                            available.remove((Integer) a);
                            available.remove((Integer) b);

                            currentGrid[0][0] = a;
                            currentGrid[0][1] = b;
                            currentGrid[1][0] = b;
                            currentGrid[1][1] = a;
                            currentGrid[2][2] = b;
                            currentGrid[2][3] = a;
                            currentGrid[3][2] = a;
                            currentGrid[3][3] = b;

                            currentGrid[0][2] = available.get(0);
                            currentGrid[0][3] = available.get(1);
                            currentGrid[1][2] = available.get(1);
                            currentGrid[1][3] = available.get(0);
                            currentGrid[2][0] = available.get(1);
                            currentGrid[2][1] = available.get(0);
                            currentGrid[3][0] = available.get(0);
                            currentGrid[3][1] = available.get(1);
                            break outerLoop;
                        }
                    }
                }
            }

            if (possible) {
                if (type == 0 || type == 1) {
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
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int[] row : currentGrid) {
                    for (int value : row) {
                        System.out.print(value + " ");
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