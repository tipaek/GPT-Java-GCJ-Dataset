import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        int[] Ns = new int[testCases];
        int[] Ks = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            Ns[i] = reader.nextInt();
            Ks[i] = reader.nextInt();
        }
        
        for (int i = 0; i < testCases; i++) {
            int N = Ns[i];
            int K = Ks[i];

            if (K < N) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int X = findSuitableX(N, K);
                if (X == -1) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                } else {
                    int[][] board = new int[N][N];
                    for (int a = 0; a < N; a++) {
                        board[a][a] = X;
                    }
                    if (solveSudoku(board, N)) {
                        System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                        printBoard(board, N);
                    } else {
                        System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    }
                }
            }
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) break;
        }

        if (isEmpty) return true;

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void printBoard(int[][] board, int N) {
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }

    public static int findSuitableX(int N, int K) {
        for (int i = 1; i <= N; i++) {
            if (i * N == K) {
                return i;
            }
        }
        return -1;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}