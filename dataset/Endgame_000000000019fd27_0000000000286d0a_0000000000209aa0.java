import java.util.*;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String POSSIBLE = "POSSIBLE";
    static String[] MY_SAVE_STORAGE_RESULTS = {
            "202$1221",
            "204$2112",
            "306$123231312",
            "303$123312231",
            "309$312231123",
            "404$1234214334124321",
            "406$1234214334214312",
            "408$1234234134124123",
            "410$1234241331424321",
            "409$1234241343213142",
            "407$1234314243212413",
            "412$1234341223414123",
            "411$1234342121434312",
            "413$2134342113424213",
            "414$3124143223414213",
            "416$4123143223413214",
            "514$1234521453345124523153124",
            "510$1234521453345125312445231",
            "505$1234521453351244351254231",
            "508$1234521453351245423143512",
            "509$1234521453451323452153214",
            "515$1234523154345124523151423",
            "512$1234523154345125142345231",
            "511$1234523154354124152354231",
            "513$1234523154514234523134512",
            "516$1234523451415235413235214",
            "517$1234524153435215143235214",
            "518$1234524513354214315251234",
            "519$1234525134345124325151423",
            "520$1234525413345214315251234",
            "507$1234531452452135312424531",
            "521$2134515423345124325152134",
            "522$3124515423245314315252314",
            "523$4123515342245133245153124",
            "525$5123415342245133245143125"
    };

    // Java implementation of the approach
    static class AllPermutation {

        // The input array for permutation
        private final int Arr[];

        // Index array to store indexes of input array
        private int Indexes[];

        // The index of the first "increase"
        // in the Index array which is the smallest
        // i such that Indexes[i] < Indexes[i + 1]
        private int Increase;

        // Constructor
        public AllPermutation(int arr[]) {
            this.Arr = arr;
            this.Increase = -1;
            this.Indexes = new int[this.Arr.length];
        }

        // Initialize and output
        // the first permutation
        public void GetFirst(int[] Printed) {

            // Allocate memory for Indexes array
            this.Indexes = new int[this.Arr.length];

            // Initialize the values in Index array
            // from 0 to n - 1
            for (int i = 0; i < Indexes.length; ++i) {
                this.Indexes[i] = i;
            }

            // Set the Increase to 0
            // since Indexes[0] = 0 < Indexes[1] = 1
            this.Increase = 0;

            // Output the first permutation
            this.Output(Printed);
        }

        // Function that returns true if it is
        // possible to generate the next permutation
        public boolean HasNext() {

            // When Increase is in the end of the array,
            // it is not possible to have next one
            return this.Increase != (this.Indexes.length - 1);
        }

        // Output the next permutation
        public void GetNext(int[] Printed) {

            // Increase is at the very beginning
            if (this.Increase == 0) {

                // Swap Index[0] and Index[1]
                this.Swap(this.Increase, this.Increase + 1);

                // Update Increase
                this.Increase += 1;
                while (this.Increase < this.Indexes.length - 1
                        && this.Indexes[this.Increase]
                        > this.Indexes[this.Increase + 1]) {
                    ++this.Increase;
                }
            } else {

                // Value at Indexes[Increase + 1] is greater than Indexes[0]
                // no need for binary search,
                // just swap Indexes[Increase + 1] and Indexes[0]
                if (this.Indexes[this.Increase + 1] > this.Indexes[0]) {
                    this.Swap(this.Increase + 1, 0);
                } else {

                    // Binary search to find the greatest value
                    // which is less than Indexes[Increase + 1]
                    int start = 0;
                    int end = this.Increase;
                    int mid = (start + end) / 2;
                    int tVal = this.Indexes[this.Increase + 1];
                    while (!(this.Indexes[mid] < tVal && this.Indexes[mid - 1] > tVal)) {
                        if (this.Indexes[mid] < tVal) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                        mid = (start + end) / 2;
                    }

                    // Swap
                    this.Swap(this.Increase + 1, mid);
                }

                // Invert 0 to Increase
                for (int i = 0; i <= this.Increase / 2; ++i) {
                    this.Swap(i, this.Increase - i);
                }

                // Reset Increase
                this.Increase = 0;
            }
            this.Output(Printed);
        }

        // Function to output the input array
        private void Output(int[] Printed) {
            for (int i = 0; i < this.Indexes.length; ++i) {

                // Indexes of the input array
                // are at the Indexes array
                Printed[i] = this.Arr[this.Indexes[i]];
//                System.out.print(this.Arr[this.Indexes[i]]);
//                System.out.print(" ");
            }
//            System.out.println();
        }

        // Swap two values in the Indexes array
        private void Swap(int p, int q) {
            int tmp = this.Indexes[p];
            this.Indexes[p] = this.Indexes[q];
            this.Indexes[q] = tmp;
        }
    }

// Driver code

    public static void main(String args[]) {
//        saveMemory();
        solve();
    }

    private static void solve() {
        int T = in.nextInt();
        int[][] matrix = new int[50][50];

        Map<Integer, String> mapPairToMatrix = new HashMap<>();

        for (String pairToMatrix : MY_SAVE_STORAGE_RESULTS) {
            int indexDollar = pairToMatrix.indexOf('$');
            int keyMapper = Integer.parseInt(pairToMatrix.substring(0, indexDollar));

            mapPairToMatrix.put(keyMapper, pairToMatrix.substring(indexDollar + 1));
        }


        // TODO change uncomment this
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();

//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < N; c++) {
//                    matrix[r][c] = 0;
//                }
//            }


            int encodeIndex = N * 100 + K;

            boolean didSucceed = mapPairToMatrix.containsKey(encodeIndex);

            String toPrint =
                    didSucceed ? POSSIBLE : IMPOSSIBLE;

            System.out.println("Case #" + i + ": " + toPrint);

            if (didSucceed) {
                String matrixEncoded = mapPairToMatrix.get(N * 100 + K);
                getMatrixFromString(matrixEncoded, N, matrix);
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N - 1; c++) {
                        System.out.print(matrix[r][c] + " ");
                    }
                    System.out.println(matrix[r][N - 1]);
                }
            }
        }
    }

    private static void getMatrixFromString(String matrixEncoded, int N, int[][] matrix) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int location = r * N + c;
                matrix[r][c] = matrixEncoded.charAt(location) - '0';
            }
        }
    }

    // Every element 1 <= V <= N
    // 20 seconds per test
    // 1GB
    // N <= K <= N^2

    // T1 ::::::
    // 2 <= N <= 5
    // T = 44,

    // T2 ::::::
    // 1 <= T <= 100
    // 2 <= N <= 50


    private static class DataInside {
        int N;
        int[][] matrix;
        Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString;

        public DataInside(int N, int[][] matrix, Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString
        ) {
            this.N = N;
            this.matrix = matrix;
            this.pairNAndKToMatrixSolutionOrEmptyString = pairNAndKToMatrixSolutionOrEmptyString;
        }
    }

    private static void saveMemory() {
        int MIN_N = 2;
        int MAX_N = 5; // TODO change to 5
        int[][] MATRIX = new int[MAX_N][MAX_N];
        Set<Integer>[] mapColIndexToOptionsLeft = new Set[MAX_N];
        Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString = new HashMap<>();

        for (int i = 0; i < MAX_N; i++) {
            mapColIndexToOptionsLeft[i] = new HashSet<>();
        }
        // g:(N,K) --> (Z)
        // g-1: Z ---> (N,K)

        Set<Integer> ALL_VALS_IN_ZONE = new HashSet<>();
        ALL_VALS_IN_ZONE.add(1);

        DataInside dataInside = new DataInside(2, MATRIX, pairNAndKToMatrixSolutionOrEmptyString);

        for (int N = MIN_N; N <= MAX_N; N++) { // For every N, we loop!!!!!!!!!!!! :)
            int[] array = new int[N];
            int[] printedArray = new int[N];
            dataInside.N = N;
            ALL_VALS_IN_ZONE.add(N);

            int valInOptionIndex = 0;

            for (Integer valInOptions : ALL_VALS_IN_ZONE) {
                array[valInOptionIndex++] = valInOptions;
            }

            AllPermutation perm = new AllPermutation(array);

            perm.GetFirst(printedArray);
            tryPerMutation(printedArray, N, MATRIX, ALL_VALS_IN_ZONE, mapColIndexToOptionsLeft, dataInside);

            while (perm.HasNext()) {
                perm.GetNext(printedArray);
                tryPerMutation(printedArray, N, MATRIX, ALL_VALS_IN_ZONE, mapColIndexToOptionsLeft, dataInside);
            }
        }
    }

    private static void tryPerMutation(int[] firstRow, int N, int[][] MATRIX,
                                       Set<Integer> ALL_VALS_IN_ZONE, Set<Integer>[] mapColIndexToOptionsLeft,
                                       DataInside dataInside) {
        for (int colIndex = 0; colIndex < N; colIndex++) { // 4 Options per column remain!!!!!!!!!!!!!!!
            Set set = mapColIndexToOptionsLeft[colIndex];
            set.addAll(ALL_VALS_IN_ZONE);
            set.remove(firstRow[colIndex]);
            MATRIX[0][colIndex] = firstRow[colIndex];
        }

        // Enter backtracking!!
        tryGoEnd(mapColIndexToOptionsLeft, 1, 0, dataInside);

        // Clean backtracking!!
    }

    private static void tryGoEnd(Set<Integer>[] mapColIndexToOptionsLeft,
                                 int rowIndex, int colIndex, DataInside dataInside) {
        if (rowIndex == dataInside.N) { // Solution valid!!!!!, time to store in memory!!!!
            // TRACE calculation!!!!!!!!!
            int k = 0;

            for (int rowEqualColIndex = 0; rowEqualColIndex < dataInside.N; rowEqualColIndex++) {
                k += dataInside.matrix[rowEqualColIndex][rowEqualColIndex];
            }

//            System.out.println("@" + dataInside.matrix[0][0]);

            // save Matrix string to n+k
            savePairWithMatrix(dataInside.N, k, dataInside.pairNAndKToMatrixSolutionOrEmptyString, dataInside.matrix);

            return;
        }

        if (colIndex == dataInside.N) {
            tryGoEnd(mapColIndexToOptionsLeft, rowIndex + 1, 0, dataInside);

            return;
        }

        // Assume rowIndex < N, our work is not done yet!!!!!!

//        Integer[] possibleValuesInCurrentCol = mapColIndexToOptionsLeft[colIndex].toArray(new Integer[0]);
        List<Integer> optionsInCurrentCol = new LinkedList<>();

        optionsInCurrentCol.addAll(mapColIndexToOptionsLeft[colIndex]);

//        System.out.println("For N = " + dataInside.N +
//                " Options remain in col number: " + colIndex + " is: " + optionsInCurrentCol.size());

        for (int value : optionsInCurrentCol) {
            // Enter backtracking!!!!!
            boolean shouldSkip = false;

            for (int prevColIndex = 0; prevColIndex < colIndex; prevColIndex++) {
                if (dataInside.matrix[rowIndex][prevColIndex] == value) {
                    shouldSkip = true;
                    break;
                }
            }

            if (shouldSkip) // Save time for everyone :D
                continue;

            // Enter backtracking!!!
            mapColIndexToOptionsLeft[colIndex].remove(value);

            dataInside.matrix[rowIndex][colIndex] = value;

            tryGoEnd(mapColIndexToOptionsLeft, rowIndex, colIndex + 1, dataInside);

            // Release exiting backtracking!!!!!

            mapColIndexToOptionsLeft[colIndex].add(value);

//            MATRIX[0][colIndex] = firstRow[colIndex];
        }
    }

    private static void savePairWithMatrix(int N, int K, Map<
            Integer, String> pairNAndKToMatrixSolutionOrEmptyString,
                                           int[][] Matrix) {
        String resultToStore = "";

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                resultToStore += Matrix[r][c];
            }
        }

        int mappingPairOfNAndK = 100 * N + K; // Formula g reversable :)

//        System.out.println("###:" + mappingPairOfNAndK + " K: " + K);

        if (!pairNAndKToMatrixSolutionOrEmptyString.containsKey(mappingPairOfNAndK)) {
//            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
            pairNAndKToMatrixSolutionOrEmptyString.put(mappingPairOfNAndK, resultToStore);


            System.out.println("\"" + mappingPairOfNAndK + "$" + resultToStore + "\",");

//            System.out.println("N = " + N + ", K = " + K);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
//                    System.out.print(Matrix[r][c] + " ");
                }
//                System.out.println();
            }
//            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

}
