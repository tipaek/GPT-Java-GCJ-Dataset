import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[][] matrix;
        if (N == 2) {
            if (K != 2 && K != 4) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        } else if (N == 3) {
            if (K != 3 && K != 6 && K != 9) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        } else if (K == N+1 || K == N*N - 1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println("POSSIBLE");
        if (N == 4 && K == 10) {
            matrix = getMatrix410();
        } else {
            if (N > 3 && (K == N + 2 || K == N*N - 2)) {
                matrix = getSpecialMatrix(N);
            } else {
                matrix = getNormalMatrix(N);
            }
            if (K % N != 0) {
                swap2(matrix);
            }
            adjustTrace(matrix, K);
        }
        validate(matrix, K);
        print(matrix);
    }

    private void adjustTrace(int[][] matrix, int K) throws Exception {
        int N = matrix.length;
        if (K % N == 0) {
            swap(matrix, 1 , K / N);
            return;
        }
        if (K == N + 2) {
            return;
        }
        if (K == N*N - 2) {
            swap(matrix, 2, N - 1);
            swap(matrix, 1, N);
            return;
        }
        int min = Math.max(1, (K - N - (N - 1)) / (N - 2));
        int max = Math.min(N, (K - 3) / (N - 2) + 1);
        for (int one = min; one <= max; one++) {
            for (int two = 1; two <= N; two++) {
                if (two == one) continue;
                for (int enn = 1; enn <= N; enn++) {
                    if (enn == one || enn == two) continue;
                    if ((N-2)*one + two + enn == K) {
                        swap(matrix, 1, one);
                        if (one == 2) {
                            swap(matrix, 1, two);
                        } else {
                            swap(matrix, 2, two);
                        }
                        if (one == N) {
                            swap(matrix, 1, enn);
                        } else if (one == 2 && two == N) {
                            swap(matrix, 1, enn);
                        } else if (two == N) {
                            swap(matrix, 2, enn);
                        } else {
                            swap(matrix, N, enn);
                        }
                        return;
                    }
                }
            }
        }
        print(matrix);
        throw new Exception("Never found K");
    }

    private void swap(int[][] matrix, int one, int two) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == one) matrix[i][j] = two;
                else if (matrix[i][j] == two) matrix[i][j] = one;
            }
        }
    }

    private int[][] getNormalMatrix(int N) {
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][(i + j) % N] = j + 1;
            }
        }
        return matrix;
    }

    private int[][] getSpecialMatrix(int N) {
        int[][] matrix = getNormalMatrix(N);
        matrix[1][0] = 2;
        matrix[1][2] = N;
        matrix[N-1][0] = 4;
        matrix[N-1][1] = 3;
        matrix[N-1][2] = 2;
        matrix[N-2][0] = 3;
        matrix[N-2][1] = 5;
        matrix[N-2][2] = 4;
        if (N == 5) {
            matrix[2][0] = 5;
            matrix[2][1] = 4;
            return matrix;
        }
        matrix[2][0] = N - 1;
        matrix[2][1] = N;
        for (int i = 3; i < N-3; i++) {
            if (i % 2 == 1) {
                matrix[i][0] = N + 3 - i;
                matrix[i][1] = N + 2 - i;
                matrix[i][2] = N + 1 - i;
            } else {
                matrix[i][0] = N + 1 - i;
                matrix[i][1] = N + 2 - i;
                matrix[i][2] = N + 3 - i;
            }
        }
        if (N % 2 == 0) {
            matrix[N-3][0] = 6;
            matrix[N-3][1] = 4;
            matrix[N-3][2] = 5;
        } else {
            matrix[N-3][0] = 5;
            matrix[N-3][1] = 4;
            matrix[N-3][2] = 6;
        }
        return matrix;
    }

    private void print(int[][] matrix) {
        for (int[] line : matrix) {
            System.out.println(Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }

    }

    private void swap2(int[][] matrix) {
        int[] tmp = matrix[0];
        matrix[0] = matrix[1];
        matrix[1] = tmp;
    }

    private int[][] getMatrix410() {
        return new int[][] {
            { 2, 3, 1, 4 },
            { 3, 2, 4, 1 },
            { 1, 4, 3, 2 },
            { 4, 1, 2, 3 }
        };
    }

    private void validate(int[][] matrix, int expectedTrace) throws Exception {
        int N = matrix.length;
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }
        try {
            if (rowCount != 0 || colCount != 0) throw new Exception("Not Latin");
            if (trace != expectedTrace) throw new Exception("Bad trace " + trace);
        } catch (Exception e) {
            print(matrix);
            throw e;
        }
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
