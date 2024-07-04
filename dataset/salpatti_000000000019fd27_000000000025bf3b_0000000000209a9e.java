import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String lastAnswer = "Y";
        for (int t = 1; t <= T; ++t) {
            if (lastAnswer.equalsIgnoreCase("N")) {
                return;
            }
            int B = in.nextInt();
            StringBuilder res = new StringBuilder(new String(new char[B]));
            for (int i = 0; i < B; i++) {
                System.out.println("" + (i + 1));
                lastAnswer = in.next();
                if (lastAnswer.equalsIgnoreCase("N")) {
                    return;
                }
                res.setCharAt(i, lastAnswer.charAt(0));
            }
            System.out.println("" + res.toString());
        }
    }

    public static void activities(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();

            List<Integer>[] start = new List[24 * 60 + 10];
            List<Integer>[] end = new List[24 * 60 + 10];
            for (int min = 0; min <= 24 * 60 + 9; min++) {
                start[min] = new ArrayList<>();
                end[min] = new ArrayList<>();
            }

            for (int n = 0; n < N; n++) {
                int s = in.nextInt();
                int e = in.nextInt();
                start[s].add(n);
                end[e].add(n);
            }

            StringBuilder sol = new StringBuilder(new String(new char[N]));

            int j = -1;
            int c = -1;

            boolean imp = false;
            for (int min = 0; min <= 24 * 60 + 9; min++) {
                if (imp) {
                    break;
                }
                for (int e : end[min]) {
                    if (j == e) {
                        j = -1;
                    }
                    if (c == e) {
                        c = -1;
                    }
                }
                for (int s : start[min]) {
                    if (j != -1 && c != -1) {
                        sol = new StringBuilder("IMPOSSIBLE");
                        imp = true;
                        break;
                    } else {
                        if (j == -1) {
                            sol.setCharAt(s, 'J');
                            j = s;
                        } else {
                            sol.setCharAt(s, 'C');
                            c = s;
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ": " + sol.toString());
        }
    }

    public static void nestingdepth(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            String S = in.next();
            int n = 0;
            StringBuilder r = new StringBuilder();
            for (char c : S.toCharArray()) {
                int v = Character.getNumericValue(c);
                if (n == v) {
                    //Nothing to do
                } else if (n < v) {
                    int d = v - n;
                    for (int e = 0; e < d; e++)
                        r.append('(');
                    n += d;
                } else if (n > v) {
                    int d = n - v;
                    for (int e = 0; e < d; e++)
                        r.append(')');
                    n -= d;
                }
                r.append(c);
            }
            //close all
            for (int i = 0; i < n; i++) {
                r.append(')');
            }

            System.out.println("Case #" + t + ": " + r.toString());
        }
    }

    public static void vestigum(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    M[j][k] = in.nextInt();
                }
            }

            Set<Integer> rows = new HashSet<Integer>();
            Set<Integer> cols = new HashSet<Integer>();

            int[][] occorrenzeRows = new int[N][N];
            int[][] occorrenzeCols = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int v = M[j][k];
                    occorrenzeRows[j][v - 1] += 1;
                    occorrenzeCols[k][v - 1] += 1;
                    if (occorrenzeRows[j][v - 1] > 1) {
                        rows.add(j);
                    }
                    if (occorrenzeCols[k][v - 1] > 1) {
                        cols.add(k);
                    }
                }
            }

            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += M[j][j];
            }

            int r = rows.size();
            int c = cols.size();

            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}