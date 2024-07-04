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
            boolean possible = false;

            int startA = Math.max(1, (K / N) - 5);
            int endA = Math.min(N, (K / N) + 6);

            if (K % N == 0 && K / N <= N) {
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
                        if (isValidConfiguration(a, goal, j)) {
                            possible = true;
                            type = 1;
                            sequence[0] = a;
                            sequence[1] = goal - j;
                            sequence[N - 1] = j;
                            updateAvailableList(available, a, goal, j);
                            for (int k = 2; k < (N - 1); k++) {
                                sequence[k] = available.get(k - 2);
                            }
                            break;
                        } else if (isSpecialCase(N, a, goal, j)) {
                            possible = true;
                            type = 2;
                            handleSpecialCase(N, available, a, j);
                            break;
                        }
                    }
                    if (possible) break;
                }
            }

            if (possible) {
                fillGrid(sequence, type);
                printResult(i + 1, "POSSIBLE");
                printGrid();
                if (findR() > 0 || findC() > 0) {
                    System.out.println("Oh, no!");
                }
            } else {
                printResult(i + 1, "IMPOSSIBLE");
            }
        }
        f.close();
    }

    private static boolean isValidConfiguration(int a, int goal, int j) {
        return j != (goal - j) && j != a && (goal - j) != a && j > 0 && j < N && (goal - j) > 0 && (goal - j) < N;
    }

    private static boolean isSpecialCase(int N, int a, int goal, int j) {
        return (N == 4 || N == 5) && j != a && (goal - j) != a && j > 0 && j < N && (goal - j) > 0 && (goal - j) < N;
    }

    private static void updateAvailableList(ArrayList<Integer> available, int a, int goal, int j) {
        if (a > goal - j) {
            available.remove(a - 1);
            available.remove(goal - j - 1);
            available.remove(j - 1);
        } else if (a > j) {
            available.remove(goal - j - 1);
            available.remove(a - 1);
            available.remove(j - 1);
        } else {
            available.remove(goal - j - 1);
            available.remove(j - 1);
            available.remove(a - 1);
        }
    }

    private static void handleSpecialCase(int N, ArrayList<Integer> available, int a, int j) {
        if (N == 4) {
            handleSpecialCaseN4(available, a, j);
        } else if (N == 5) {
            handleSpecialCaseN5(available, a, j);
        }
    }

    private static void handleSpecialCaseN4(ArrayList<Integer> available, int a, int j) {
        updateAvailableListForSpecialCase(available, a, j);
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

    private static void handleSpecialCaseN5(ArrayList<Integer> available, int a, int j) {
        updateAvailableListForSpecialCase(available, a, j);
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
        fillRemainingGridN5(available);
    }

    private static void fillRemainingGridN5(ArrayList<Integer> available) {
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

    private static void updateAvailableListForSpecialCase(ArrayList<Integer> available, int a, int j) {
        if (a > j) {
            available.remove(a - 1);
            available.remove(j - 1);
        } else {
            available.remove(j - 1);
            available.remove(a - 1);
        }
    }

    private static void fillGrid(int[] sequence, int type) {
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
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
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