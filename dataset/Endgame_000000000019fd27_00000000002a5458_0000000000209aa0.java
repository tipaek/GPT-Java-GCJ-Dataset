import java.util.*;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String POSSIBLE = "POSSIBLE";
    static List<String> MY_SAVE_STORAGE_RESULTS = new LinkedList<>();// TODO save to storage results
    static final char FIRST_COLOR = '0';
    static Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString = new HashMap<>(); // TODO save to pairs
    static final int MIN_N = 2;
    static final int MAX_N = 50; // TODO: DANIEL, Check that 50

    public static void main(String args[]) {
//        saveMemory();
        solve();
    }

    // TODO TRUST YOUR FORMULA!!!!!!! DON"T CHANGE PLEASE :)
    private static int gFormulaMapper(int N, int K) {
        return 10000 * N + K;
    }

    private static void solve() {
//        for (int i = 1; i <= T; i++) {
//            System.out.println("Case #" + i + ": " + secret());
//        }
        int[][] matrix = new int[MAX_N][MAX_N];

//        Map<Integer, String> mapPairToMatrix = new HashMap<>();

//        for (String pairToMatrix : MY_SAVE_STORAGE_RESULTS) { // TODO Might take too long... too many solutions... + 4/5 seconds
//            int indexDollar = pairToMatrix.indexOf('$');
//            int keyMapper = Integer.parseInt(pairToMatrix.substring(0, indexDollar));
//
//            mapPairToMatrix.put(keyMapper, pairToMatrix.substring(indexDollar + 1));
//        }
        // TODO change uncomment this

        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();

//            int ENCODE_INDEX = gFormulaMapper(N, K);

            // TODO Done... clean Matrix for slution!!!!!
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = 0;
                }
            }

            // TODO: 2 things. 1. Is solution/Does exist, 2. return matrix... of solution K/N
            boolean didSucceed = longColorSecret(matrix, N, K);
            String toPrint =
                    didSucceed ? POSSIBLE : IMPOSSIBLE;

            System.out.println("Case #" + i + ": " + toPrint);

            if (didSucceed) {
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N - 1; c++) {
                        int numberToPrint = matrix[r][c];
                        System.out.print(numberToPrint + " ");
                    }
                    int numberToPrint = matrix[r][N - 1];
                    System.out.println(numberToPrint);
                }
            }
        }
    }

    private static boolean longColorSecret(int[][] matrix, int N, int K) {
        int longestValueColor = (int) Math.round((((double) K) / N));


        for (int i = 0; i < N - 1; i++) {
            matrix[i][i] = longestValueColor;
        }

        int LAST_COLOR_VALUE = K - (N - 1) * longestValueColor;
        matrix[N - 1][N - 1] = LAST_COLOR_VALUE;

        // Problem in N N-1, 1,2
        // TODO check if times of longestColor can save result, if not return
        // TODO: check last to tail, Math.round()
        // Please think about if, perhapsRound up longestValue, when 0.5 >=

//        if ((longestValueColor == 1 && LAST_COLOR_VALUE == 2) || (longestValueColor == N && LAST_COLOR_VALUE == N - 1))
//            return false;

        Set<Integer> allNumbersFrom1TON = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            allNumbersFrom1TON.add(i);
        }

        allNumbersFrom1TON.remove(longestValueColor);

        if (longestValueColor - LAST_COLOR_VALUE != 0) {
            if (!prepareDiagonalForLaunch(matrix, N, longestValueColor, LAST_COLOR_VALUE))
                return false;

            allNumbersFrom1TON.remove(matrix[N - 1][N - 1]); // Z
            allNumbersFrom1TON.remove(matrix[N - 2][N - 2]); // Y

            int valueZ = matrix[N - 1][N - 1];
            int valueY = matrix[N - 2][N - 2];

            int indexModel = 1; // Z
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][indexModel % N] = valueZ;
                    indexModel++; // TODO % N
                }
            }

            indexModel = N - 1; // Y

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][indexModel % N] = valueY;
                    indexModel++; // TODO % N
                }
            }

            indexModel = 2;
            int distToIndexModel = 0;
            for (int value : allNumbersFrom1TON) {
                indexModel = 2 + distToIndexModel;
                for (int r = 0; r < N; r++) {
//                    for (int c = 0; c < N; c++) {
                    matrix[r][indexModel % N] = value;
                    indexModel++; // TODO % N
//                    }
                }
                distToIndexModel++;
            }


            int[] temp = new int[N];

            for (int c = 0; c < N; c++) {
                temp[c] = matrix[N - 1][c];
                matrix[N - 1][c] = matrix[N - 2][c];
                matrix[N - 2][c] = temp[c];
            }

        } else {
            int indexModel = 1;
            int distToIndexModel = 0;
            for (int value : allNumbersFrom1TON) {
                indexModel = 1 + distToIndexModel;
                for (int r = 0; r < N; r++) {
//                    for (int c = 0; c < N; c++) {
                    matrix[r][indexModel % N] = value;
                    indexModel++; // TODO % N
//                    }
                }
                distToIndexModel++;

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
        }

        return false;
    }


    private static void solve1() {
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + secret());
        }
        char[][] matrix = new char[MAX_N][MAX_N];

        Map<Integer, String> mapPairToMatrix = new HashMap<>();

        for (String pairToMatrix : MY_SAVE_STORAGE_RESULTS) { // TODO Might take too long... too many solutions... + 4/5 seconds
            int indexDollar = pairToMatrix.indexOf('$');
            int keyMapper = Integer.parseInt(pairToMatrix.substring(0, indexDollar));

            mapPairToMatrix.put(keyMapper, pairToMatrix.substring(indexDollar + 1));
        }

        // TODO change uncomment this
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();

            int ENCODE_INDEX = gFormulaMapper(N, K);

            boolean didSucceed = mapPairToMatrix.containsKey(ENCODE_INDEX);

            String toPrint =
                    didSucceed ? POSSIBLE : IMPOSSIBLE;

            System.out.println("Case #" + i + ": " + toPrint);

            if (didSucceed) {
                String matrixEncoded = mapPairToMatrix.get(ENCODE_INDEX);
                getMatrixFromString(matrixEncoded, N, matrix);
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N - 1; c++) {
                        int numberToPrint = matrix[r][c] - FIRST_COLOR;
                        System.out.print(numberToPrint + " ");
                    }
                    int numberToPrint = matrix[r][N - 1] - FIRST_COLOR;
                    System.out.println(numberToPrint);
                }
            }
        }
    }

    private static void getMatrixFromString(String matrixEncoded, int N, char[][] matrix) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int location = r * N + c;
                matrix[r][c] = matrixEncoded.charAt(location);
            }
        }
    }

    private static void savePairWithMatrix(int N, int K, char[][] Matrix) {
        String resultToStore = "";

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                resultToStore += Matrix[r][c];
            }
        }

        int mappingPairOfNAndK = gFormulaMapper(N, K); // Formula g reversable :)

        if (!pairNAndKToMatrixSolutionOrEmptyString.containsKey(mappingPairOfNAndK)) {
            pairNAndKToMatrixSolutionOrEmptyString.put(mappingPairOfNAndK, resultToStore);

            System.out.println("\"" + mappingPairOfNAndK + "$" + resultToStore + "\","); // TODO, remove upon submission

//            System.out.println("N = " + N + ", K = " + K);
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < N; c++) {
//                    System.out.print(Matrix[r][c] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    // TODO Trust Matrix of colors, Having the values of result
    private static void invokeSavingPairWithMatrix(int N, char[][] matrix) {
        // TRACE calculation!!!!!!!!!
        int k = 0;

        for (int rowEqualColIndex = 0; rowEqualColIndex < N; rowEqualColIndex++) {
            k += (matrix[rowEqualColIndex][rowEqualColIndex] - FIRST_COLOR + 1);
        }

//            System.out.println("@" + dataInside.matrix[0][0]);

        // save Matrix string to n+k
        savePairWithMatrix(N, k, matrix);

        return;
    }

    // TODO Notice how int should become color
    private static void againOrNew(DiagonalAndLens digonalAndLens, int N,
                                   int diagRowColIndex, int currentValueWhichIsColor, int lengthOfCurrentColor,
                                   List<DiagonalAndLens> colorOptionsOnDiagonalByLength) {
        if (diagRowColIndex == N) { // TODO: Trust, Finished dividing colors, lets add a new option!
            List<Integer> copyColors = new LinkedList<>(digonalAndLens.diagonalColors);
            List<Integer> copyLensPerColor = new LinkedList<>(digonalAndLens.lensPerColor);
            DiagonalAndLens copyDiagonalAndLens = new DiagonalAndLens(copyColors);

            copyDiagonalAndLens.lensPerColor = copyLensPerColor;

            // TODO: Check is such solution even valid... Maybe N - 1... PLEASE THINK
            if (lengthOfCurrentColor != N - 1) {
                colorOptionsOnDiagonalByLength.add(copyDiagonalAndLens); // TODO: Think if copy constructor
            }
//            String result = "";
//
//            for (int value : copyColors) {
//                result += value;
//            }
//
//            System.out.println(result);

            return;
        }

        // TODO Trust same color, always option:
        digonalAndLens.diagonalColors.add(currentValueWhichIsColor);
        digonalAndLens.lensPerColor.set(digonalAndLens.lensPerColor.size() - 1, lengthOfCurrentColor + 1); // Set new len per color

        againOrNew(digonalAndLens, N, diagRowColIndex + 1, currentValueWhichIsColor,
                lengthOfCurrentColor + 1, colorOptionsOnDiagonalByLength);

        // TODO: Exit backtracking clean?
        digonalAndLens.diagonalColors.remove(digonalAndLens.diagonalColors.size() - 1); // TODO: Trust We add to end, so remove from end
        digonalAndLens.lensPerColor.set(digonalAndLens.lensPerColor.size() - 1, lengthOfCurrentColor); // Set new len per color

        // TODO Choose next color, always option:

        for (int i = 0; i < lengthOfCurrentColor; i++) {
            digonalAndLens.diagonalColors.add(currentValueWhichIsColor + 1); // TODO: TRUST Adding the next color, same time as before
        }
        digonalAndLens.lensPerColor.add(lengthOfCurrentColor); // Set new len per color

        if (digonalAndLens.diagonalColors.size() > N) {
            // Skip, Error solution out of bounds of MATRIX!!!!! :(
        } else {
            againOrNew(digonalAndLens, N, diagRowColIndex + lengthOfCurrentColor,
                    currentValueWhichIsColor + 1, lengthOfCurrentColor, colorOptionsOnDiagonalByLength);
        }

        // TODO: Exit backtracking clean?
        for (int i = 0; i < lengthOfCurrentColor; i++) {
            digonalAndLens.diagonalColors.remove(digonalAndLens.diagonalColors.size() - 1); // TODO: Trust We add to end, so remove from end
        }

        digonalAndLens.lensPerColor.remove(digonalAndLens.lensPerColor.size() - 1);
    }

    private static void saveMemory() {
        for (int N = MIN_N; N <= MAX_N; N++) {
            List<DiagonalAndLens> colorOptionsOnDiagonalByLength = new LinkedList<>();
            List<Integer> colors = new LinkedList<>();
            colors.add(1); // Where 1 is FIRST_COLOR
            DiagonalAndLens diagonalAndLens = new DiagonalAndLens(colors);
            diagonalAndLens.lensPerColor = new LinkedList<>();
            diagonalAndLens.lensPerColor.add(1);
            againOrNew(diagonalAndLens, N, 1, 1, 1, colorOptionsOnDiagonalByLength);

            System.out.println(N + ": " + colorOptionsOnDiagonalByLength.size()); // TODO: DANIEL turn this off

            tryPutNumbersOnColorsForNewSum(colorOptionsOnDiagonalByLength, N);
//            System.out.println(pairNAndKToMatrixSolutionOrEmptyString.size());
//            colorOptionsOnDiagonalByLength
        }


        System.out.println(MY_SAVE_STORAGE_RESULTS.size()); // TODO Daniel, Remove this before submit
    }

    private static void giveMeValueRankMeToSum(DiagonalAndLens diagonalColorsAndLens, int diagIndex, int currentValue,
                                               int N, int k, int repeatIndex) {
        if (diagIndex == N) { // k, if duplicate don't save!!!!
            // TODO Save + focus on k's value

//            System.out.println(N + ": " + k);

            int encodePairNAndK = gFormulaMapper(N, k);

//            System.out.println("N = " + N + " K = " + k);

            String encodedMatrixString = ""; // TODO calculate actual matrix

            if (!pairNAndKToMatrixSolutionOrEmptyString.containsKey(encodePairNAndK)) {
                pairNAndKToMatrixSolutionOrEmptyString.put(encodePairNAndK, encodedMatrixString);
            }

            return;
        }

        // We know jump by len... so we know how much to jump!, also we are not equal to previous value...

        // Color grows higher
        // No currentValue is bigger than N,
        int lengthRepeat = diagonalColorsAndLens.lensPerColor.get(repeatIndex);
        int countOfLensAfterMe = diagonalColorsAndLens.lensPerColor.size() - 1 - repeatIndex;

        for (int newValue = currentValue; newValue <= N - countOfLensAfterMe; newValue++) {

            giveMeValueRankMeToSum(diagonalColorsAndLens, diagIndex + lengthRepeat, newValue, N,
                    k + newValue * lengthRepeat,
                    repeatIndex + 1);
        }

    }

    private static class DiagonalAndLens {
        List<Integer> diagonalColors;
        List<Integer> lensPerColor;

        public DiagonalAndLens(List<Integer> diagonalColors) {
            this.diagonalColors = diagonalColors;
//            lensPerColor = new LinkedList<>();
        }

    }

    private static void tryPutNumbersOnColorsForNewSum(List<DiagonalAndLens> colorOptionsOnDiagonalByLength, int N) {
        for (DiagonalAndLens diagonalColorsAndLens : colorOptionsOnDiagonalByLength) {
            int lengthRepeat = diagonalColorsAndLens.lensPerColor.get(0);
            int countOflensAfterMe = diagonalColorsAndLens.lensPerColor.size() - 1;
            for (int value = 1; value <= N - countOflensAfterMe; value++) {

                giveMeValueRankMeToSum(diagonalColorsAndLens, lengthRepeat, value + 1, N,
                        value * lengthRepeat, 1);
            }
        }
    }


    private static String secret() {


        return "";
    }
}
