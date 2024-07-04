import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k % n == 0) {
                int d = k / n;
                int[][] res = new int[n][n];
                int start = (n - d + 1) % n;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        res[i][(i + j + start) % n] = j + 1;
                    }
                }

                System.out.print("Case #" + t + ": POSSIBLE\n" + toString(res, n));
            } else if (n == 2 || n == 3 || k == n + 1 || k == n * n - 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                int[][] res = new int[n][n];
                int div1 = k / n;
                int div2 = div1 + 1;
                int count2 = k % n;
                int count1 = n - count2;

                int add = 0;
                if (count1 == n - 1) {
                    count1 -= 2;
                    count2++;
                    add = div1 - 1;
                } else if (count2 == n - 1) {
                    count2 -= 2;
                    count1++;
                    add = div2 + 1;
                }

                for (int i = 0; i < count1; i++) {
                    res[i][i] = div1;
                }
                for (int i = count1; i < count1 + count2; i++) {
                    res[i][i] = div2;
                }
                if (add > 0) {
                    res[n - 1][n - 1] = add;
                }
                solve(res, n);

                System.out.print("Case #" + t + ": POSSIBLE\n" + toString(res, n));
            }

        }
    }

    public static String toString(int[][] res, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(res[i][j]);
                if (j < n - 1) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void solve(int[][] res, int n) {
        HashSet<Integer>[][] possible = new HashSet[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    possible[i][j] = createNewSet(n);
                    removeMarks(res, possible, n, i, j);
                }
            }
        }

        boolean isEnd = false;
        while (!isEnd) {
            isEnd = true;
            if (soloMark(res, possible, n)) {
                isEnd = false;
            } else if (soloInRowOrColumn(res, possible, n)) {
                isEnd = false;
            } else if (putRandom(res, possible, n)) {
                isEnd = false;
            }

        }
    }

    public static HashSet<Integer> createNewSet(int n) {
        HashSet<Integer> res = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        return res;
    }

    public static boolean removeMarksRowColumn(int[][] res, HashSet<Integer>[][] possible, int n, int x, int y) {
        boolean b = false;
        for (int i = 0; i < n; i++) {
            b = removeMarks(res, possible, n, i, y) || b;
        }
        for (int i = 0; i < n; i++) {
            b = removeMarks(res, possible, n, x, i) || b;
        }
        return b;
    }

    public static boolean removeMarks(int[][] res, HashSet<Integer>[][] possible, int n, int x, int y) {
        boolean b = false;
        if (res[x][y] != 0) {
            return b;
        }
        for (int i = 0; i < n; i++) {
            if (res[x][i] != 0 && possible[x][y].contains(res[x][i])) {
                b = true;
                possible[x][y].remove(res[x][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i][y] != 0 && possible[x][y].contains(res[i][y])) {
                b = true;
                possible[x][y].remove(res[i][y]);
            }
        }
        return b;
    }

    public static boolean soloMark(int[][] res, HashSet<Integer>[][] possible, int n) {
        boolean b = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (!b) {
                for (int j = 0; j < n; j++) {
                    if (res[i][j] == 0) {
                        if (possible[i][j].size() == 1) {
                            res[i][j] = possible[i][j].iterator().next();
                            x = i;
                            y = j;
                            b = true;
                            break;
                        }
                    }
                }
            }
        }
        if (b) {
            removeMarksRowColumn(res, possible, n, x, y);
        }
        return b;
    }

    public static boolean putRandom(int[][] res, HashSet<Integer>[][] possible, int n) {
        boolean b = false;
        int x = 0;
        int y = 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    if (possible[i][j].size() > 0) {
                        if (possible[i][j].size() <= min) {
                            min = possible[i][j].size();
                            x = i;
                            y = j;
                            b = true;
                        }
                    }
                }
            }
        }
        if (b) {
            res[x][y] = possible[x][y].iterator().next();
            removeMarksRowColumn(res, possible, n, x, y);
        }
        return b;
    }

    public static boolean soloInRowOrColumn(int[][] res, HashSet<Integer>[][] possible, int n) {
        boolean b = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (!b) {
                for (int j = 0; j < n; j++) {
                    if (!b) {
                        if (res[i][j] == 0) {
                            for (int val : possible[i][j]) {
                                int k = 0;
                                for (int z = 0; z < n; z++) {
                                    if (res[i][z] == 0 && possible[i][z].contains(val)) {
                                        k++;
                                    }
                                }
                                if (k == 1) {
                                    res[i][j] = val;
                                    x = i;
                                    y = j;
                                    b = true;
                                    break;
                                }

                                k = 0;
                                for (int z = 0; z < n; z++) {
                                    if (res[z][j] == 0 && possible[z][j].contains(val)) {
                                        k++;
                                    }
                                }
                                if (k == 1) {
                                    res[i][j] = val;
                                    x = i;
                                    y = j;
                                    b = true;
                                    break;
                                }

                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        if (b) {
            removeMarksRowColumn(res, possible, n, x, y);
        }
        return b;
    }
}