import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int[][] board;
    static Map<Integer, Integer> tracing = new HashMap<>();
    private static List<String> combinations = new ArrayList<>();
    static int VALUE;


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            String[] S = in.nextLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            compute(t, N, K);
        }
    }

    private static void compute(int t, int N, int K) {
        VALUE = K;
        if (K > N * N) {
            printImpossible(t);
            return;
        }
        combinations = new ArrayList<>();
        int[] arr = new int[N];
        for (int i=1; i<= N; i++) {
            arr[i-1] = i;
        }
        printAllKLengthRec(arr, "", N, N);
        board = new int[N][N];
        tracing = new HashMap<>();
        for (String combs : combinations) {
            if (combs.length() == N) {
                int index = 0;
                while (index < N) {
                    board[index][index] = Integer.parseInt(""+combs.charAt(index));
                    index++;
                }
            }
            if (solve()) {
                printPossible(t);
                return;
            }

        }

        printImpossible(t);

    }

    private static boolean solve() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 0) {

                    for (int num = 1; num <= board.length; num++) {
                        if (isValidInput(row, col, num)) {
                            board[row][col] = num;
                            if (row == col) {
                                tracing.put(row + col, num);
                            }

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                                tracing.put(row + col, 0);
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isValidInput(int row, int col, int value) {
        return !isInRow(row, value) && !isInCol(col, value);
    }

    private static boolean isInRow(int row, int value) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return true;
            }
        }

        return false;
    }

    private static boolean isInCol(int col, int value) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return true;
            }
        }
        return false;
    }

    private static void printImpossible(int t) {
        System.out.println("Case #" + t + ": IMPOSSIBLE");
    }

    private static void printPossible(int t) {
        System.out.println("Case #" + t + ": POSSIBLE");
        print();
    }

    private static void print() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (c < board.length - 1) {
                    System.out.print(board[r][c] + " ");
                } else {
                    System.out.print(board[r][c]);
                }
            }
            System.out.println();
        }
    }

    static void printAllKLengthRec(int[] set,
                                   String prefix,
                                   int n, int k)
    {

        // Base case: k is 0,
        // print prefix
        if (k == 0)
        {
            int index = 0;
            int trace = 0;
            while (index < n) {
                trace += Integer.parseInt(""+prefix.charAt(index));
                index++;
            }
            if (trace == VALUE)
                combinations.add(prefix);
            return;
        }

        // One by one add all characters
        // from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i)
        {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because
            // we have added a new character
            printAllKLengthRec(set, newPrefix,
                    n, k - 1);
        }
    }

}
