import java.util.*;
import java.io.*;

public class Solution {
    static class PuzzleMatrix {
        public boolean[][][] filled;
        public int[] count;
        public int N;
        public int[][] mat;
        public int[][] snapshot;
        public boolean solved;

        public PuzzleMatrix(int N) {
            this.N = N;
            this.count = new int[N];
            this.filled = new boolean[N][2][N];
            this.mat = new int[N][N];
            this.solved = false;
        }

        public boolean isSolved() {
            return this.solved;
        }

        private void refresh() {
            Arrays.fill(this.count, 0);
            this.filled = new boolean[N][2][N];
            this.mat = new int[N][N];
        }

        public boolean fill(int i, int j, int num) {
            if (this.mat[i][j] != 0) {
                return false;
            } else if (count[num - 1] >= N) {
                return false;
            } else if (this.filled[num - 1][0][i] || this.filled[num - 1][1][j]) {
                return false;
            } else {
                count[num - 1]++;
                this.filled[num - 1][0][i] = true;
                this.filled[num - 1][1][j] = true;
                this.mat[i][j] = num;
                return true;
            }
        }

        public boolean unfill(int i, int j) {
            if (this.mat[i][j] == 0) {
                return false;
            } else if (count[this.mat[i][j] - 1] <= 0) {
                return false;
            } else if (!(this.filled[this.mat[i][j] - 1][0][i] && this.filled[this.mat[i][j] - 1][1][j])) {
                return false;
            } else {
                count[this.mat[i][j] - 1]--;
                this.filled[this.mat[i][j] - 1][0][i] = false;
                this.filled[this.mat[i][j] - 1][1][j] = false;
                this.mat[i][j] = 0;
                return true;
            }
        }

        private boolean isFilled(int num) {
            return this.count[num - 1] == this.N;
        }

        public void printMat() {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    System.out.print(this.mat[i][j]);
                    if (j < N - 1) {
                        System.out.print(" ");
                    } else {
                        System.out.println();
                    }
                }
            }
        }

        public void solve(int[] dg) {
            if (this.hasOnlyOneDiffElms(dg)) {
                return;
            }
            for (int i = 0; i < N; ++i) {
                this.fill(i, i, dg[i]);
            }
            this.fillPuzzle(1, 0);
            this.refresh();
        }

        private boolean hasOnlyOneDiffElms(int[] arr) {
            int[] inner_counts = new int[N];
            for (int num : arr) {
                inner_counts[num - 1]++;
                if (inner_counts[num - 1] == N - 1) {
                    return true;
                }
            }
            return false;
        }

        public void fillPuzzle(int num, int row) {
            if (this.solved) {
                return;
            } else if (num > N) {
                this.solved = true;
                this.setSnapshot();
                return;
            } else if (this.isFilled(num)) {
                fillPuzzle(num + 1, 0);
            } else if (this.filled[num - 1][0][row]) {
                fillPuzzle(num, row + 1);
            } else {
                for (int col = 0; col < N; ++col) {
                    if (this.solved) {
                        continue;
                    }
                    if (this.fill(row, col, num)) {
                        fillPuzzle(num, row + 1);
                        this.unfill(row, col);
                    }
                }
            }
        }

        public void setSnapshot() {
            this.snapshot = new int[N][N];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    this.snapshot[i][j] = this.mat[i][j];
                }
            }
        }

        public void printSnapshot() {
            if (snapshot == null) {
                return;
            }
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    System.out.print(this.snapshot[i][j]);
                    if (j < N - 1) {
                        System.out.print(" ");
                    } else {
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            printResult(i, N, K);
        }
    }

    private static void printResult(int x, int N, int K) {
        List<int[]> res = new LinkedList<>();
        int[] dg = new int[N];
        getDiag(N, K, N, 0, dg, res);
        PuzzleMatrix M = new PuzzleMatrix(N);
        for (int i = res.size() - 1; i >= 0; --i) {
            M.solve(res.get(i));
            if (M.isSolved()) {
                System.out.println("Case #" + x + ": POSSIBLE");
                M.printSnapshot();
                return;
            }
        }
        System.out.println("Case #" + x + ": IMPOSSIBLE");
    }

    private static void getDiag(int N, int K, int max, int i, int[] dg, List<int[]> res) {
        if (i > N || K < 0) {
            return;
        } else if (i == N) {
            if (K <= 0) {
                res.add(dg.clone());
            }
            return;
        } else {
            for (int num = max; num > 0; --num) {
                dg[i] = num;
                getDiag(N, K - num, num, i + 1, dg, res);
                dg[i] = 0;
            }
        }
    }
}