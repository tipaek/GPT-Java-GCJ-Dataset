import java.io.*;
import java.util.*;

class Solution {
    static int[][] currentGrid;
    static int N;
    static int K;

    public static int findR() {
        int problemCount = 0;
        for (int row = 0; row < N; row++) {
            boolean[] seen = new boolean[N + 1];
            for (int col = 0; col < N; col++) {
                int currentSquare = currentGrid[row][col];
                if (seen[currentSquare]) {
                    problemCount++;
                    break;
                } else {
                    seen[currentSquare] = true;
                }
            }
        }
        return problemCount;
    }

    public static int findC() {
        int problemCount = 0;
        for (int col = 0; col < N; col++) {
            boolean[] seen = new boolean[N + 1];
            for (int row = 0; row < N; row++) {
                int currentSquare = currentGrid[row][col];
                if (seen[currentSquare]) {
                    problemCount++;
                    break;
                } else {
                    seen[currentSquare] = true;
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

            int[] sequence = new int[N];
            ArrayList<Integer> available = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                available.add(j);
            }

            int startA = Math.max((K / N) - 5, 1);
            int endA = Math.min((K / N) + 6, N);
            boolean possible = false;
            int type = -1;

            if (K % N == 0 && K / N <= N) {
                possible = true;
                type = 0;
                int quotient = K / N;
                sequence[0] = quotient;
                for (int j = 1; j < N; j++) {
                    sequence[j] = j;
                    if (j == quotient) {
                        sequence[j] = N;
                    }
                }
            }

            if (!possible && N != 2) {
                for (int a = startA; a <= endA; a++) {
                    int goal = K - a * (N - 2);
                    for (int j = 1; j <= goal / 2; j++) {
                        if (j != (goal - j) && j != a && (goal - j) != a && j > 0 && j < N && (goal - j) > 0 && (goal - j) < N) {
                            possible = true;
                            type = 1;
                            sequence[0] = a;
                            sequence[1] = goal - j;
                            sequence[N - 1] = j;
                            available.remove((Integer) a);
                            available.remove((Integer) (goal - j));
                            available.remove((Integer) j);
                            for (int k = 2; k < (N - 1); k++) {
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
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(currentGrid[j][k] + " ");
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