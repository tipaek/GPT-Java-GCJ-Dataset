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

    static class AllPermutation {
        private final int[] arr;
        private int[] indexes;
        private int increase;

        public AllPermutation(int[] arr) {
            this.arr = arr;
            this.increase = -1;
            this.indexes = new int[this.arr.length];
        }

        public void getFirst(int[] printed) {
            this.indexes = new int[this.arr.length];
            for (int i = 0; i < indexes.length; ++i) {
                this.indexes[i] = i;
            }
            this.increase = 0;
            this.output(printed);
        }

        public boolean hasNext() {
            return this.increase != (this.indexes.length - 1);
        }

        public void getNext(int[] printed) {
            if (this.increase == 0) {
                this.swap(this.increase, this.increase + 1);
                this.increase += 1;
                while (this.increase < this.indexes.length - 1 && this.indexes[this.increase] > this.indexes[this.increase + 1]) {
                    ++this.increase;
                }
            } else {
                if (this.indexes[this.increase + 1] > this.indexes[0]) {
                    this.swap(this.increase + 1, 0);
                } else {
                    int start = 0;
                    int end = this.increase;
                    int mid = (start + end) / 2;
                    int tVal = this.indexes[this.increase + 1];
                    while (!(this.indexes[mid] < tVal && this.indexes[mid - 1] > tVal)) {
                        if (this.indexes[mid] < tVal) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                        mid = (start + end) / 2;
                    }
                    this.swap(this.increase + 1, mid);
                }
                for (int i = 0; i <= this.increase / 2; ++i) {
                    this.swap(i, this.increase - i);
                }
                this.increase = 0;
            }
            this.output(printed);
        }

        private void output(int[] printed) {
            for (int i = 0; i < this.indexes.length; ++i) {
                printed[i] = this.arr[this.indexes[i]];
            }
        }

        private void swap(int p, int q) {
            int tmp = this.indexes[p];
            this.indexes[p] = this.indexes[q];
            this.indexes[q] = tmp;
        }
    }

    public static void main(String args[]) {
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

        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int encodeIndex = N * 100 + K;
            boolean didSucceed = mapPairToMatrix.containsKey(encodeIndex);
            String toPrint = didSucceed ? POSSIBLE : IMPOSSIBLE;
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

    private static class DataInside {
        int N;
        int[][] matrix;
        Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString;

        public DataInside(int N, int[][] matrix, Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString) {
            this.N = N;
            this.matrix = matrix;
            this.pairNAndKToMatrixSolutionOrEmptyString = pairNAndKToMatrixSolutionOrEmptyString;
        }
    }

    private static void saveMemory() {
        int MIN_N = 2;
        int MAX_N = 5;
        int[][] MATRIX = new int[MAX_N][MAX_N];
        Set<Integer>[] mapColIndexToOptionsLeft = new Set[MAX_N];
        Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString = new HashMap<>();

        for (int i = 0; i < MAX_N; i++) {
            mapColIndexToOptionsLeft[i] = new HashSet<>();
        }

        Set<Integer> ALL_VALS_IN_ZONE = new HashSet<>();
        ALL_VALS_IN_ZONE.add(1);

        DataInside dataInside = new DataInside(2, MATRIX, pairNAndKToMatrixSolutionOrEmptyString);

        for (int N = MIN_N; N <= MAX_N; N++) {
            int[] array = new int[N];
            int[] printedArray = new int[N];
            dataInside.N = N;
            ALL_VALS_IN_ZONE.add(N);

            int valInOptionIndex = 0;
            for (Integer valInOptions : ALL_VALS_IN_ZONE) {
                array[valInOptionIndex++] = valInOptions;
            }

            AllPermutation perm = new AllPermutation(array);
            perm.getFirst(printedArray);
            tryPerMutation(printedArray, N, MATRIX, ALL_VALS_IN_ZONE, mapColIndexToOptionsLeft, dataInside);

            while (perm.hasNext()) {
                perm.getNext(printedArray);
                tryPerMutation(printedArray, N, MATRIX, ALL_VALS_IN_ZONE, mapColIndexToOptionsLeft, dataInside);
            }
        }
    }

    private static void tryPerMutation(int[] firstRow, int N, int[][] MATRIX, Set<Integer> ALL_VALS_IN_ZONE, Set<Integer>[] mapColIndexToOptionsLeft, DataInside dataInside) {
        for (int colIndex = 0; colIndex < N; colIndex++) {
            Set<Integer> set = mapColIndexToOptionsLeft[colIndex];
            set.addAll(ALL_VALS_IN_ZONE);
            set.remove(firstRow[colIndex]);
            MATRIX[0][colIndex] = firstRow[colIndex];
        }

        tryGoEnd(mapColIndexToOptionsLeft, 1, 0, dataInside);
    }

    private static void tryGoEnd(Set<Integer>[] mapColIndexToOptionsLeft, int rowIndex, int colIndex, DataInside dataInside) {
        if (rowIndex == dataInside.N) {
            int k = 0;
            for (int rowEqualColIndex = 0; rowEqualColIndex < dataInside.N; rowEqualColIndex++) {
                k += dataInside.matrix[rowEqualColIndex][rowEqualColIndex];
            }
            savePairWithMatrix(dataInside.N, k, dataInside.pairNAndKToMatrixSolutionOrEmptyString, dataInside.matrix);
            return;
        }

        if (colIndex == dataInside.N) {
            tryGoEnd(mapColIndexToOptionsLeft, rowIndex + 1, 0, dataInside);
            return;
        }

        List<Integer> optionsInCurrentCol = new LinkedList<>(mapColIndexToOptionsLeft[colIndex]);
        for (int value : optionsInCurrentCol) {
            boolean shouldSkip = false;
            for (int prevColIndex = 0; prevColIndex < colIndex; prevColIndex++) {
                if (dataInside.matrix[rowIndex][prevColIndex] == value) {
                    shouldSkip = true;
                    break;
                }
            }

            if (shouldSkip)
                continue;

            mapColIndexToOptionsLeft[colIndex].remove(value);
            dataInside.matrix[rowIndex][colIndex] = value;
            tryGoEnd(mapColIndexToOptionsLeft, rowIndex, colIndex + 1, dataInside);
            mapColIndexToOptionsLeft[colIndex].add(value);
        }
    }

    private static void savePairWithMatrix(int N, int K, Map<Integer, String> pairNAndKToMatrixSolutionOrEmptyString, int[][] Matrix) {
        StringBuilder resultToStore = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                resultToStore.append(Matrix[r][c]);
            }
        }

        int mappingPairOfNAndK = 100 * N + K;
        if (!pairNAndKToMatrixSolutionOrEmptyString.containsKey(mappingPairOfNAndK)) {
            pairNAndKToMatrixSolutionOrEmptyString.put(mappingPairOfNAndK, resultToStore.toString());
            System.out.println("\"" + mappingPairOfNAndK + "$" + resultToStore + "\",");
        }
    }
}