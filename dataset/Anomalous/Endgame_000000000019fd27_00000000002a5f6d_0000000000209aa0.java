import java.util.*;

public class Solution {
    static final Scanner in = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String POSSIBLE = "POSSIBLE";
    static final List<String> MY_SAVE_STORAGE_RESULTS = new LinkedList<>();
    static final char FIRST_COLOR = '0';
    static final Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString = new HashMap<>();
    static final int MIN_N = 2;
    static final int MAX_N = 50;

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

            for (int r = 0; r < N; r++) {
                Arrays.fill(matrix[r], 0);
            }

            boolean didSucceed = longColorSecret(matrix, N, K);
            String toPrint = didSucceed ? POSSIBLE : IMPOSSIBLE;
            System.out.println("Case #" + i + ": " + toPrint);

            if (didSucceed) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        System.out.print(matrix[r][c] + (c < N - 1 ? " " : "\n"));
                    }
                }
            }
        }
    }

    private static boolean longColorSecret(int[][] matrix, int N, int K) {
        int longestValueColor = N / K;
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
            if (!prepareDiagonalForLaunch(matrix, N, longestValueColor, LAST_COLOR_VALUE)) return false;

            allNumbersFrom1TON.remove(matrix[N - 1][N - 1]);
            allNumbersFrom1TON.remove(matrix[N - 2][N - 2]);

            fillMatrix(matrix, N, matrix[N - 1][N - 1], 1);
            fillMatrix(matrix, N, matrix[N - 2][N - 2], N - 1);

            int indexModel = 2;
            for (int value : allNumbersFrom1TON) {
                fillMatrix(matrix, N, value, indexModel++);
            }

            swapRows(matrix, N - 1, N - 2);
        } else {
            int indexModel = 1;
            for (int value : allNumbersFrom1TON) {
                fillMatrix(matrix, N, value, indexModel++);
            }
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

    private static void fillMatrix(int[][] matrix, int N, int value, int startIndex) {
        int indexModel = startIndex;
        for (int r = 0; r < N; r++) {
            matrix[r][indexModel % N] = value;
            indexModel++;
        }
    }

    private static void swapRows(int[][] matrix, int row1, int row2) {
        int[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private static void savePairWithMatrix(int N, int K, char[][] matrix) {
        StringBuilder resultToStore = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                resultToStore.append(matrix[r][c]);
            }
        }
        int mappingPairOfNAndK = gFormulaMapper(N, K);
        if (!pairNAndKToMatrixSolutionOrEmptyString.containsKey(mappingPairOfNAndK)) {
            pairNAndKToMatrixSolutionOrEmptyString.put(mappingPairOfNAndK, resultToStore.toString());
            System.out.println("\"" + mappingPairOfNAndK + "$" + resultToStore + "\",");
        }
    }

    private static void invokeSavingPairWithMatrix(int N, char[][] matrix) {
        int k = 0;
        for (int rowEqualColIndex = 0; rowEqualColIndex < N; rowEqualColIndex++) {
            k += (matrix[rowEqualColIndex][rowEqualColIndex] - FIRST_COLOR + 1);
        }
        savePairWithMatrix(N, k, matrix);
    }

    private static void againOrNew(DiagonalAndLens digonalAndLens, int N, int diagRowColIndex, int currentValueWhichIsColor, int lengthOfCurrentColor, List<DiagonalAndLens> colorOptionsOnDiagonalByLength) {
        if (diagRowColIndex == N) {
            List<Integer> copyColors = new LinkedList<>(digonalAndLens.diagonalColors);
            List<Integer> copyLensPerColor = new LinkedList<>(digonalAndLens.lensPerColor);
            DiagonalAndLens copyDiagonalAndLens = new DiagonalAndLens(copyColors);
            copyDiagonalAndLens.lensPerColor = copyLensPerColor;

            if (lengthOfCurrentColor != N - 1) {
                colorOptionsOnDiagonalByLength.add(copyDiagonalAndLens);
            }
            return;
        }

        digonalAndLens.diagonalColors.add(currentValueWhichIsColor);
        digonalAndLens.lensPerColor.set(digonalAndLens.lensPerColor.size() - 1, lengthOfCurrentColor + 1);

        againOrNew(digonalAndLens, N, diagRowColIndex + 1, currentValueWhichIsColor, lengthOfCurrentColor + 1, colorOptionsOnDiagonalByLength);

        digonalAndLens.diagonalColors.remove(digonalAndLens.diagonalColors.size() - 1);
        digonalAndLens.lensPerColor.set(digonalAndLens.lensPerColor.size() - 1, lengthOfCurrentColor);

        for (int i = 0; i < lengthOfCurrentColor; i++) {
            digonalAndLens.diagonalColors.add(currentValueWhichIsColor + 1);
        }
        digonalAndLens.lensPerColor.add(lengthOfCurrentColor);

        if (digonalAndLens.diagonalColors.size() <= N) {
            againOrNew(digonalAndLens, N, diagRowColIndex + lengthOfCurrentColor, currentValueWhichIsColor + 1, lengthOfCurrentColor, colorOptionsOnDiagonalByLength);
        }

        for (int i = 0; i < lengthOfCurrentColor; i++) {
            digonalAndLens.diagonalColors.remove(digonalAndLens.diagonalColors.size() - 1);
        }
        digonalAndLens.lensPerColor.remove(digonalAndLens.lensPerColor.size() - 1);
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

    private static void giveMeValueRankMeToSum(DiagonalAndLens diagonalColorsAndLens, int diagIndex, int currentValue, int N, int k, int repeatIndex) {
        if (diagIndex == N) {
            int encodePairNAndK = gFormulaMapper(N, k);
            if (!pairNAndKToMatrixSolutionOrEmptyString.containsKey(encodePairNAndK)) {
                pairNAndKToMatrixSolutionOrEmptyString.put(encodePairNAndK, "");
            }
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

        public DiagonalAndLens(List<Integer> diagonalColors) {
            this.diagonalColors = diagonalColors;
        }
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

    private static String secret() {
        return "";
    }
}