import java.util.*;

public class Solution {
    private static final Scanner in = new Scanner(System.in);
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String POSSIBLE = "POSSIBLE";
    private static final List<String> MY_SAVE_STORAGE_RESULTS = new LinkedList<>();
    private static final char FIRST_COLOR = '0';
    private static final Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString = new HashMap<>();
    private static final int MIN_N = 2;
    private static final int MAX_N = 50;

    public static void main(String[] args) {
        solve();
    }

    private static int gFormulaMapper(int N, int K) {
        return 10000 * N + K;
    }

    private static void solve() {
        int[][] matrix = new int[MAX_N][MAX_N];
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            clearMatrix(matrix, N);
            boolean didSucceed = longColorSecret(matrix, N, K);
            String result = didSucceed ? POSSIBLE : IMPOSSIBLE;
            System.out.println("Case #" + i + ": " + result);
            if (didSucceed) {
                printMatrix(matrix, N);
            }
        }
    }

    private static void clearMatrix(int[][] matrix, int N) {
        for (int r = 0; r < N; r++) {
            Arrays.fill(matrix[r], 0);
        }
    }

    private static void printMatrix(int[][] matrix, int N) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N - 1; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println(matrix[r][N - 1]);
        }
    }

    private static boolean longColorSecret(int[][] matrix, int N, int K) {
        int longestValueColor = (int) Math.round((double) K / N);
        for (int i = 0; i < N - 1; i++) {
            matrix[i][i] = longestValueColor;
        }
        int LAST_COLOR_VALUE = K - (N - 1) * longestValueColor;
        matrix[N - 1][N - 1] = LAST_COLOR_VALUE;

        Set<Integer> allNumbersFrom1TON = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            allNumbersFrom1TON.add(i);
        }
        allNumbersFrom1TON.remove(longestValueColor);

        if (longestValueColor != LAST_COLOR_VALUE) {
            if (!prepareDiagonalForLaunch(matrix, N, longestValueColor, LAST_COLOR_VALUE)) {
                return false;
            }
            allNumbersFrom1TON.remove(matrix[N - 1][N - 1]);
            allNumbersFrom1TON.remove(matrix[N - 2][N - 2]);
            fillMatrix(matrix, N, matrix[N - 1][N - 1], 1);
            fillMatrix(matrix, N, matrix[N - 2][N - 2], N - 1);
            fillRemainingValues(matrix, N, allNumbersFrom1TON, 2);
            swapLastTwoRows(matrix, N);
        } else {
            fillRemainingValues(matrix, N, allNumbersFrom1TON, 1);
        }
        return true;
    }

    private static boolean prepareDiagonalForLaunch(int[][] matrix, int N, int longestValueColor, int LAST_COLOR_VALUE) {
        if (longestValueColor + 1 <= N && LAST_COLOR_VALUE - 1 >= 1) {
            matrix[N - 2][N - 2] = longestValueColor + 1;
            matrix[N - 1][N - 1] = LAST_COLOR_VALUE - 1;
        } else if (longestValueColor - 1 >= 1 && LAST_COLOR_VALUE + 1 <= N) {
            matrix[N - 2][N - 2] = longestValueColor - 1;
            matrix[N - 1][N - 1] = LAST_COLOR_VALUE + 1;
        } else {
            return false;
        }
        return true;
    }

    private static void fillMatrix(int[][] matrix, int N, int value, int startIdx) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                matrix[r][(startIdx + c) % N] = value;
            }
        }
    }

    private static void fillRemainingValues(int[][] matrix, int N, Set<Integer> values, int startIdx) {
        int distToIndexModel = 0;
        for (int value : values) {
            int indexModel = startIdx + distToIndexModel;
            for (int r = 0; r < N; r++) {
                matrix[r][indexModel % N] = value;
                indexModel++;
            }
            distToIndexModel++;
        }
    }

    private static void swapLastTwoRows(int[][] matrix, int N) {
        int[] temp = new int[N];
        for (int c = 0; c < N; c++) {
            temp[c] = matrix[N - 1][c];
            matrix[N - 1][c] = matrix[N - 2][c];
            matrix[N - 2][c] = temp[c];
        }
    }

    private static void saveMemory() {
        for (int N = MIN_N; N <= MAX_N; N++) {
            List<DiagonalAndLens> colorOptionsOnDiagonalByLength = new LinkedList<>();
            List<Integer> colors = new LinkedList<>();
            colors.add(1);
            DiagonalAndLens diagonalAndLens = new DiagonalAndLens(colors);
            diagonalAndLens.lensPerColor = new LinkedList<>();
            diagonalAndLens.lensPerColor.add(1);
            againOrNew(diagonalAndLens, N, 1, 1, 1, colorOptionsOnDiagonalByLength);
            tryPutNumbersOnColorsForNewSum(colorOptionsOnDiagonalByLength, N);
        }
    }

    private static void againOrNew(DiagonalAndLens diagonalAndLens, int N, int diagRowColIndex, int currentValue, int lengthOfCurrentColor, List<DiagonalAndLens> colorOptionsOnDiagonalByLength) {
        if (diagRowColIndex == N) {
            List<Integer> copyColors = new LinkedList<>(diagonalAndLens.diagonalColors);
            List<Integer> copyLensPerColor = new LinkedList<>(diagonalAndLens.lensPerColor);
            DiagonalAndLens copyDiagonalAndLens = new DiagonalAndLens(copyColors);
            copyDiagonalAndLens.lensPerColor = copyLensPerColor;
            if (lengthOfCurrentColor != N - 1) {
                colorOptionsOnDiagonalByLength.add(copyDiagonalAndLens);
            }
            return;
        }

        diagonalAndLens.diagonalColors.add(currentValue);
        diagonalAndLens.lensPerColor.set(diagonalAndLens.lensPerColor.size() - 1, lengthOfCurrentColor + 1);
        againOrNew(diagonalAndLens, N, diagRowColIndex + 1, currentValue, lengthOfCurrentColor + 1, colorOptionsOnDiagonalByLength);
        diagonalAndLens.diagonalColors.remove(diagonalAndLens.diagonalColors.size() - 1);
        diagonalAndLens.lensPerColor.set(diagonalAndLens.lensPerColor.size() - 1, lengthOfCurrentColor);

        for (int i = 0; i < lengthOfCurrentColor; i++) {
            diagonalAndLens.diagonalColors.add(currentValue + 1);
        }
        diagonalAndLens.lensPerColor.add(lengthOfCurrentColor);
        if (diagonalAndLens.diagonalColors.size() <= N) {
            againOrNew(diagonalAndLens, N, diagRowColIndex + lengthOfCurrentColor, currentValue + 1, lengthOfCurrentColor, colorOptionsOnDiagonalByLength);
        }
        for (int i = 0; i < lengthOfCurrentColor; i++) {
            diagonalAndLens.diagonalColors.remove(diagonalAndLens.diagonalColors.size() - 1);
        }
        diagonalAndLens.lensPerColor.remove(diagonalAndLens.lensPerColor.size() - 1);
    }

    private static void tryPutNumbersOnColorsForNewSum(List<DiagonalAndLens> colorOptionsOnDiagonalByLength, int N) {
        for (DiagonalAndLens diagonalColorsAndLens : colorOptionsOnDiagonalByLength) {
            int lengthRepeat = diagonalColorsAndLens.lensPerColor.get(0);
            int countOflensAfterMe = diagonalColorsAndLens.lensPerColor.size() - 1;
            for (int value = 1; value <= N - countOflensAfterMe; value++) {
                giveMeValueRankMeToSum(diagonalColorsAndLens, lengthRepeat, value + 1, N, value * lengthRepeat, 1);
            }
        }
    }

    private static void giveMeValueRankMeToSum(DiagonalAndLens diagonalColorsAndLens, int diagIndex, int currentValue, int N, int k, int repeatIndex) {
        if (diagIndex == N) {
            int encodePairNAndK = gFormulaMapper(N, k);
            String encodedMatrixString = "";
            pairNAndKToMatrixSolutionOrEmptyString.putIfAbsent(encodePairNAndK, encodedMatrixString);
            return;
        }

        int lengthRepeat = diagonalColorsAndLens.lensPerColor.get(repeatIndex);
        int countOfLensAfterMe = diagonalColorsAndLens.lensPerColor.size() - 1 - repeatIndex;
        for (int newValue = currentValue; newValue <= N - countOfLensAfterMe; newValue++) {
            giveMeValueRankMeToSum(diagonalColorsAndLens, diagIndex + lengthRepeat, newValue, N, k + newValue * lengthRepeat, repeatIndex + 1);
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
}