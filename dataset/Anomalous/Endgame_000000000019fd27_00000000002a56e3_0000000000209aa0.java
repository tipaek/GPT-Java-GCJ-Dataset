import java.util.*;

public class Solution {
    static Scanner scanner = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String POSSIBLE = "POSSIBLE";
    static final List<String> savedResults = new LinkedList<>();
    static final char FIRST_COLOR = '0';
    static final Map<Integer, String> solutionsMap = new HashMap<>();
    static final int MIN_N = 2;
    static final int MAX_N = 50;

    public static void main(String[] args) {
        solve();
    }

    private static int encodePair(int N, int K) {
        return 10000 * N + K;
    }

    private static void solve() {
        int[][] matrix = new int[MAX_N][MAX_N];
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            for (int r = 0; r < N; r++) {
                Arrays.fill(matrix[r], 0);
            }

            boolean solutionExists = generateMatrix(matrix, N, K);
            System.out.println("Case #" + i + ": " + (solutionExists ? POSSIBLE : IMPOSSIBLE));

            if (solutionExists) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        System.out.print(matrix[r][c] + (c < N - 1 ? " " : ""));
                    }
                    System.out.println();
                }
            }
        }
    }

    private static boolean generateMatrix(int[][] matrix, int N, int K) {
        int baseValue = K / N;
        int remainder = K % N;

        for (int i = 0; i < N; i++) {
            matrix[i][i] = baseValue + (i < remainder ? 1 : 0);
        }

        if (!isValid(matrix, N)) {
            return false;
        }

        fillMatrix(matrix, N);
        return true;
    }

    private static boolean isValid(int[][] matrix, int N) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (int i = 0; i < N; i++) {
            uniqueValues.add(matrix[i][i]);
        }
        return uniqueValues.size() == N;
    }

    private static void fillMatrix(int[][] matrix, int N) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r != c) {
                    matrix[r][c] = (c + r) % N + 1;
                }
            }
        }
    }

    private static void saveResults(int N, int K, char[][] matrix) {
        StringBuilder result = new StringBuilder();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                result.append(matrix[r][c]);
            }
        }

        int key = encodePair(N, K);

        if (!solutionsMap.containsKey(key)) {
            solutionsMap.put(key, result.toString());
            System.out.println("\"" + key + "$" + result + "\",");
        }
    }

    private static class DiagonalAndLens {
        List<Integer> diagonalColors;
        List<Integer> lensPerColor;

        DiagonalAndLens(List<Integer> diagonalColors) {
            this.diagonalColors = diagonalColors;
            this.lensPerColor = new LinkedList<>();
        }
    }

    private static void exploreDiagonalOptions(DiagonalAndLens diagonalAndLens, int N, int diagIndex, int currentColor, int colorLength, List<DiagonalAndLens> options) {
        if (diagIndex == N) {
            List<Integer> colorsCopy = new LinkedList<>(diagonalAndLens.diagonalColors);
            List<Integer> lensCopy = new LinkedList<>(diagonalAndLens.lensPerColor);
            DiagonalAndLens copy = new DiagonalAndLens(colorsCopy);
            copy.lensPerColor = lensCopy;

            if (colorLength != N - 1) {
                options.add(copy);
            }
            return;
        }

        diagonalAndLens.diagonalColors.add(currentColor);
        diagonalAndLens.lensPerColor.set(diagonalAndLens.lensPerColor.size() - 1, colorLength + 1);

        exploreDiagonalOptions(diagonalAndLens, N, diagIndex + 1, currentColor, colorLength + 1, options);

        diagonalAndLens.diagonalColors.remove(diagonalAndLens.diagonalColors.size() - 1);
        diagonalAndLens.lensPerColor.set(diagonalAndLens.lensPerColor.size() - 1, colorLength);

        for (int i = 0; i < colorLength; i++) {
            diagonalAndLens.diagonalColors.add(currentColor + 1);
        }
        diagonalAndLens.lensPerColor.add(colorLength);

        if (diagonalAndLens.diagonalColors.size() <= N) {
            exploreDiagonalOptions(diagonalAndLens, N, diagIndex + colorLength, currentColor + 1, colorLength, options);
        }

        for (int i = 0; i < colorLength; i++) {
            diagonalAndLens.diagonalColors.remove(diagonalAndLens.diagonalColors.size() - 1);
        }
        diagonalAndLens.lensPerColor.remove(diagonalAndLens.lensPerColor.size() - 1);
    }

    private static void saveMemory() {
        for (int N = MIN_N; N <= MAX_N; N++) {
            List<DiagonalAndLens> options = new LinkedList<>();
            List<Integer> colors = new LinkedList<>();
            colors.add(1);
            DiagonalAndLens diagonalAndLens = new DiagonalAndLens(colors);
            diagonalAndLens.lensPerColor.add(1);
            exploreDiagonalOptions(diagonalAndLens, N, 1, 1, 1, options);

            System.out.println(N + ": " + options.size());

            for (DiagonalAndLens option : options) {
                assignValues(option, N);
            }
        }
    }

    private static void assignValues(DiagonalAndLens diagonalAndLens, int N) {
        int colorLength = diagonalAndLens.lensPerColor.get(0);
        int remainingLens = diagonalAndLens.lensPerColor.size() - 1;

        for (int value = 1; value <= N - remainingLens; value++) {
            evaluateValues(diagonalAndLens, colorLength, value + 1, N, value * colorLength, 1);
        }
    }

    private static void evaluateValues(DiagonalAndLens diagonalAndLens, int diagIndex, int currentValue, int N, int k, int repeatIndex) {
        if (diagIndex == N) {
            int key = encodePair(N, k);
            if (!solutionsMap.containsKey(key)) {
                solutionsMap.put(key, "");
            }
            return;
        }

        int colorLength = diagonalAndLens.lensPerColor.get(repeatIndex);
        int remainingLens = diagonalAndLens.lensPerColor.size() - 1 - repeatIndex;

        for (int newValue = currentValue; newValue <= N - remainingLens; newValue++) {
            evaluateValues(diagonalAndLens, diagIndex + colorLength, newValue, N, k + newValue * colorLength, repeatIndex + 1);
        }
    }
}