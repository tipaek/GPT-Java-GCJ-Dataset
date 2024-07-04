import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {
    static MyScanner scanner;
    static PrintWriter writer;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int testCases = nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            writer.print("Case #" + caseNum + ": ");
            int n = nextInt(), m = nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    matrix[i][j] = nextInt();
                }
            }

            long sum = 0;
            while (true) {
                for (int[] row : matrix) {
                    for (int val : row) {
                        sum += val;
                    }
                }

                boolean[][] eliminate = new boolean[n][m];
                int count = 0;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < m; ++j) {
                        if (matrix[i][j] == 0) {
                            continue;
                        }
                        int left = 0, right = 0, top = 0, down = 0, neighbors = 0;

                        for (int row = i - 1; row >= 0; --row) {
                            if (matrix[row][j] != 0) {
                                top = matrix[row][j];
                                neighbors++;
                                break;
                            }
                        }

                        for (int row = i + 1; row < n; ++row) {
                            if (matrix[row][j] != 0) {
                                down = matrix[row][j];
                                neighbors++;
                                break;
                            }
                        }

                        for (int col = j - 1; col >= 0; --col) {
                            if (matrix[i][col] != 0) {
                                left = matrix[i][col];
                                neighbors++;
                                break;
                            }
                        }

                        for (int col = j + 1; col < m; ++col) {
                            if (matrix[i][col] != 0) {
                                right = matrix[i][col];
                                neighbors++;
                                break;
                            }
                        }

                        if (neighbors * matrix[i][j] < left + right + top + down) {
                            eliminate[i][j] = true;
                            count++;
                        }
                    }
                }

                if (count == 0) {
                    break;
                } else {
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < m; ++j) {
                            if (eliminate[i][j]) {
                                matrix[i][j] = 0;
                            }
                        }
                    }
                }
            }
            writer.println(sum);
        }
        writer.flush();
        writer.close();
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scanner = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            writer = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            writer = new PrintWriter(System.out, true);
        }
    }

    static int nextInt() throws IOException {
        return scanner.nextInt();
    }

    static long nextLong() throws IOException {
        return scanner.nextLong();
    }

    static double nextDouble() throws IOException {
        return scanner.nextDouble();
    }

    static String next() throws IOException {
        return scanner.next();
    }

    static String nextLine() throws IOException {
        return scanner.nextLine();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}