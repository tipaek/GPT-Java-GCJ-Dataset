import java.io.*;
import java.util.*;

class Solution {
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
            int type = -1;
            boolean possible = false;

            int startA = Math.max((K / N) - 5, 1);
            int endA = Math.min((K / N) + 6, N);

            if (K % N == 0 && K / N <= N) {
                possible = true;
                type = 0;
                sequence[0] = K / N;
                for (int j = 1; j < N; j++) {
                    sequence[j] = j == K / N ? N : j;
                }
            }

            if (!possible && N != 2) {
                for (int a = startA; a <= endA; a++) {
                    int goal = K - a * (N - 2);
                    for (int j = 1; j <= goal / 2; j++) {
                        if (isValidCombination(a, j, goal)) {
                            possible = true;
                            type = 1;
                            sequence[0] = a;
                            sequence[1] = goal - j;
                            sequence[N - 1] = j;
                            removeFromAvailable(available, a, goal - j, j);
                            fillSequence(available, sequence);
                            break;
                        } else if (isSpecialCase(N, a, j, goal)) {
                            possible = true;
                            type = 2;
                            handleSpecialCase(N, a, j, available);
                            break;
                        }
                    }
                    if (possible) break;
                }
            }

            if (possible) {
                if (type == 0 || type == 1) {
                    fillGrid(sequence, type);
                }
                printResult(i, "POSSIBLE");
                printGrid();
            } else {
                printResult(i, "IMPOSSIBLE");
            }
        }
        f.close();
    }

    private static boolean isValidCombination(int a, int j, int goal) {
        return j != (goal - j) && j != a && (goal - j) != a && j > 0 && j < N && (goal - j) > 0 && (goal - j) < N;
    }

    private static boolean isSpecialCase(int N, int a, int j, int goal) {
        return (N == 4 || N == 5) && j != a && (goal - j) != a && j > 0 && j < N && (goal - j) > 0 && (goal - j) < N;
    }

    private static void removeFromAvailable(List<Integer> available, int a, int b, int c) {
        available.remove(Integer.valueOf(a));
        available.remove(Integer.valueOf(b));
        available.remove(Integer.valueOf(c));
    }

    private static void fillSequence(List<Integer> available, int[] sequence) {
        for (int k = 2; k < (N - 1); k++) {
            sequence[k] = available.get(k - 2);
        }
    }

    private static void handleSpecialCase(int N, int a, int j, List<Integer> available) {
        if (a > j) {
            available.remove(Integer.valueOf(a));
            available.remove(Integer.valueOf(j));
        } else {
            available.remove(Integer.valueOf(j));
            available.remove(Integer.valueOf(a));
        }

        if (N == 4) {
            fillGridForN4(a, j, available);
        } else if (N == 5) {
            fillGridForN5(a, j, available);
        }
    }

    private static void fillGridForN4(int a, int j, List<Integer> available) {
        currentGrid[0][0] = a;
        currentGrid[0][1] = j;
        currentGrid[1][0] = j;
        currentGrid[1][1] = a;
        currentGrid[2][2] = j;
        currentGrid[2][3] = a;
        currentGrid[3][2] = a;
        currentGrid[3][3] = j;

        currentGrid[0][2] = available.get(0);
        currentGrid[0][3] = available.get(1);
        currentGrid[1][2] = available.get(1);
        currentGrid[1][3] = available.get(0);
        currentGrid[2][0] = available.get(1);
        currentGrid[2][1] = available.get(0);
        currentGrid[3][0] = available.get(0);
        currentGrid[3][1] = available.get(1);
    }

    private static void fillGridForN5(int a, int j, List<Integer> available) {
        currentGrid[0][0] = a;
        currentGrid[1][1] = a;
        currentGrid[2][2] = a;
        currentGrid[3][4] = a;
        currentGrid[4][3] = a;
        currentGrid[3][3] = j;
        currentGrid[4][4] = j;
        currentGrid[2][0] = j;
        currentGrid[0][1] = j;
        currentGrid[1][2] = j;

        currentGrid[1][0] = available.get(0);
        currentGrid[4][1] = available.get(0);
        currentGrid[3][2] = available.get(0);
        currentGrid[2][3] = available.get(0);
        currentGrid[0][4] = available.get(0);

        currentGrid[1][3] = available.get(1);
        currentGrid[4][0] = available.get(1);
        currentGrid[3][1] = available.get(1);
        currentGrid[2][4] = available.get(1);
        currentGrid[0][2] = available.get(1);

        currentGrid[1][4] = available.get(2);
        currentGrid[4][2] = available.get(2);
        currentGrid[3][0] = available.get(2);
        currentGrid[2][1] = available.get(2);
        currentGrid[0][3] = available.get(2);
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

    private static void printResult(int caseNum, String result) {
        System.out.println("Case #" + (caseNum + 1) + ": " + result);
    }

    private static void printGrid() {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                System.out.print(currentGrid[j][k] + " ");
            }
            System.out.println();
        }
        if (findR() > 0 || findC() > 0) {
            System.out.println("Oh, no!");
        }
    }
}