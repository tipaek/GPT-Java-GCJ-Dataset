import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static int[][] latin(int n, int k) {
        if (n == 2 && k == 2) {
            return new int[][]{{1, 2}, {2, 1}};
        }
        if (n == 2 && k == 4) {
            return new int[][]{{2, 1}, {1, 2}};
        }
        if (n == 3 && k == 3) {
            return new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        }
        if (n == 3 && k == 6) {
            return new int[][]{{2, 3, 1}, {1, 2, 3}, {3, 1, 2}};
        }
        if (n == 3 && k == 9) {
            return new int[][]{{3, 1, 2}, {2, 3, 1}, {1, 2, 3}};
        }
        if (n == 4) {
            switch (k) {
                case 4:
                    return new int[][]{
                        {1, 2, 3, 4},
                        {4, 1, 2, 3},
                        {3, 4, 1, 2},
                        {2, 3, 4, 1}
                    };
                case 6:
                    return new int[][]{
                        {1, 2, 3, 4},
                        {2, 1, 4, 3},
                        {3, 4, 2, 1},
                        {4, 3, 1, 2}
                    };
                case 7:
                    return new int[][]{
                        {1, 3, 4, 2},
                        {2, 1, 3, 4},
                        {3, 4, 2, 1},
                        {4, 2, 1, 3}
                    };
                case 8:
                    return new int[][]{
                        {2, 1, 4, 3},
                        {4, 2, 3, 1},
                        {1, 3, 2, 4},
                        {3, 4, 1, 2}
                    };
                case 9:
                    return new int[][]{
                        {1, 3, 4, 2},
                        {4, 1, 2, 3},
                        {2, 4, 3, 1},
                        {3, 2, 1, 4}
                    };
                case 10:
                    return new int[][]{
                        {2, 4, 3, 1},
                        {4, 3, 1, 2},
                        {3, 1, 2, 4},
                        {1, 2, 4, 3}
                    };
                case 11:
                    return new int[][]{
                        {2, 3, 4, 1},
                        {4, 2, 1, 3},
                        {1, 4, 3, 2},
                        {3, 1, 2, 4}
                    };
                case 12:
                    return new int[][]{
                        {3, 1, 2, 4},
                        {4, 3, 1, 2},
                        {2, 4, 3, 1},
                        {1, 2, 4, 3}
                    };
                case 13:
                    return new int[][]{
                        {4, 2, 3, 1},
                        {3, 4, 1, 2},
                        {1, 3, 2, 4},
                        {2, 1, 4, 3}
                    };
                case 14:
                    return new int[][]{
                        {4, 2, 3, 1},
                        {2, 3, 1, 4},
                        {3, 1, 4, 2},
                        {1, 4, 2, 3}
                    };
                case 16:
                    return new int[][]{
                        {4, 3, 2, 1},
                        {1, 4, 3, 2},
                        {2, 1, 4, 3},
                        {3, 2, 1, 4}
                    };
            }
        }
        if (n == 5) {
            switch (k) {
                case 5:
                    return new int[][]{
                        {1, 2, 3, 4, 5},
                        {5, 1, 2, 3, 4},
                        {4, 5, 1, 2, 3},
                        {3, 4, 5, 1, 2},
                        {2, 3, 4, 5, 1}
                    };
                case 7:
                    return new int[][]{
                        {2, 5, 3, 4, 1},
                        {4, 1, 5, 2, 3},
                        {5, 2, 1, 3, 4},
                        {3, 4, 2, 1, 5},
                        {1, 3, 4, 5, 2}
                    };
                case 8:
                    return new int[][]{
                        {1, 2, 4, 3, 5},
                        {3, 1, 2, 5, 4},
                        {5, 3, 1, 4, 2},
                        {4, 5, 3, 2, 1},
                        {2, 4, 5, 1, 3}
                    };
                case 9:
                    return new int[][]{
                        {1, 2, 3, 4, 5},
                        {4, 1, 2, 5, 3},
                        {5, 4, 1, 3, 2},
                        {3, 5, 4, 2, 1},
                        {2, 3, 5, 1, 4}
                    };
                case 10:
                    return new int[][]{
                        {2, 1, 3, 4, 5},
                        {5, 2, 1, 3, 4},
                        {4, 5, 2, 1, 3},
                        {3, 4, 5, 2, 1},
                        {1, 3, 4, 5, 2}
                    };
                case 11:
                    return new int[][]{
                        {1, 3, 2, 5, 4},
                        {5, 1, 3, 4, 2},
                        {4, 5, 1, 2, 3},
                        {2, 4, 5, 3, 1},
                        {3, 2, 4, 1, 5}
                    };
                case 12:
                    return new int[][]{
                        {1, 4, 2, 5, 3},
                        {5, 1, 4, 3, 2},
                        {3, 5, 1, 2, 4},
                        {2, 3, 5, 4, 1},
                        {4, 2, 3, 1, 5}
                    };
                case 13:
                    return new int[][]{
                        {2, 3, 1, 4, 5},
                        {4, 2, 3, 5, 1},
                        {5, 4, 2, 1, 3},
                        {1, 5, 4, 3, 2},
                        {3, 1, 5, 2, 4}
                    };
                case 14:
                    return new int[][]{
                        {2, 3, 1, 5, 4},
                        {5, 2, 3, 4, 1},
                        {4, 5, 2, 1, 3},
                        {1, 4, 5, 3, 2},
                        {3, 1, 4, 2, 5}
                    };
                case 15:
                    return new int[][]{
                        {3, 1, 2, 4, 5},
                        {5, 3, 1, 2, 4},
                        {4, 5, 3, 1, 2},
                        {2, 4, 5, 3, 1},
                        {1, 2, 4, 5, 3}
                    };
                case 16:
                    return new int[][]{
                        {3, 5, 1, 2, 4},
                        {2, 3, 5, 4, 1},
                        {4, 2, 3, 1, 5},
                        {1, 4, 2, 5, 3},
                        {5, 1, 4, 3, 2}
                    };
                case 17:
                    return new int[][]{
                        {4, 3, 1, 2, 5},
                        {2, 4, 3, 5, 1},
                        {5, 2, 4, 1, 3},
                        {1, 5, 2, 3, 4},
                        {3, 1, 5, 4, 2}
                    };
                case 18:
                    return new int[][]{
                        {3, 4, 1, 5, 2},
                        {5, 3, 4, 2, 1},
                        {2, 5, 3, 1, 4},
                        {1, 2, 5, 4, 3},
                        {4, 1, 2, 3, 5}
                    };
                case 19:
                    return new int[][]{
                        {4, 5, 3, 2, 1},
                        {2, 4, 5, 1, 3},
                        {1, 2, 4, 3, 5},
                        {3, 1, 2, 5, 4},
                        {5, 3, 1, 4, 2}
                    };
                case 20:
                    return new int[][]{
                        {4, 3, 2, 1, 5},
                        {5, 4, 3, 2, 1},
                        {1, 5, 4, 3, 2},
                        {2, 1, 5, 4, 3},
                        {3, 2, 1, 5, 4}
                    };
                case 21:
                    return new int[][]{
                        {5, 4, 1, 2, 3},
                        {2, 5, 4, 3, 1},
                        {3, 2, 5, 1, 4},
                        {1, 3, 2, 4, 5},
                        {4, 1, 3, 5, 2}
                    };
                case 22:
                    return new int[][]{
                        {5, 4, 2, 3, 1},
                        {3, 5, 4, 1, 2},
                        {1, 3, 5, 2, 4},
                        {2, 1, 3, 4, 5},
                        {4, 2, 1, 5, 3}
                    };
                case 23:
                    return new int[][]{
                        {5, 2, 4, 1, 3},
                        {4, 5, 1, 3, 2},
                        {3, 4, 5, 2, 1},
                        {1, 3, 2, 4, 5},
                        {2, 1, 3, 5, 4}
                    };
                case 25:
                    return new int[][]{
                        {5, 4, 2, 1, 3},
                        {3, 5, 4, 2, 1},
                        {1, 3, 5, 4, 2},
                        {2, 1, 3, 5, 4},
                        {4, 2, 1, 3, 5}
                    };
            }
        }

        int[] comb = new int[n];
        int[][] ans = new int[n][n];
        int length = n;

        if (n % k == 0) {
            Arrays.fill(comb, k / n);
        } else {
            int pos = n;
            while (k <= (n - 1) * pos) {
                n--;
            }
            comb[0] = comb[1] = n;
            pos -= 2;
            k -= 2 * n;
            n--;
            while (pos != 0) {
                if (n * pos == k) {
                    for (int i = length - pos; i < length; i++) {
                        comb[i] = n;
                    }
                    break;
                } else if (pos * n < k) {
                    comb[length - pos] = n + 1;
                    k -= n + 1;
                    pos--;
                } else {
                    n--;
                }
            }
            if (comb[length - 1] != comb[length - 2]) {
                boolean same = true;
                for (int i = 0; i <= length - 3; i++) {
                    if (comb[i] != comb[i + 1]) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    comb[length - 3]--;
                    comb[length - 2]++;
                }
            }
        }

        n = length;
        for (int i = 0; i < n; i++) {
            ans[i][i] = comb[i];
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int k = Integer.parseInt(str.nextToken());
            boolean flag;

            if (n == 2) {
                flag = (k == 2 || k == 4);
            } else if (n == 3) {
                flag = (k == 3 || k == 6 || k == 9);
            } else {
                flag = !(k == n + 1 || k == (n * n - 1));
            }

            if (!flag) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + tc + ": POSSIBLE");
                int[][] ans = latin(n, k);
                for (int[] row : ans) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            }
        }

        out.flush();
        out.close();
    }
}