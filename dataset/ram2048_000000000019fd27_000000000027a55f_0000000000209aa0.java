import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] latin = generateLatin(k, n);
            if (latin == null) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": POSSIBLE");
                for (int[] row: latin) {
                    for (int r: row) {
                        System.out.print(r + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int[][] generateLatin(int k, int n) {
        List<List<Integer>> traces = generateTraces(k, n);
        for (List<Integer> trace: traces) {
            int[][] matrix = new int[n][n];
            boolean[][] colUsed = new boolean[n][n+1];
            int i = 0;
            for (int t: trace) {
                matrix[i][i] = t;
                colUsed[i][t] = true;
                i++;
            }

            LinkedList<Integer> state = new LinkedList<>();
            int N = n*n;
            boolean back = false;
            while (state.size() < N) {
                if (back) {
                    if (state.isEmpty()) {
                        break;
                    }
                    int p = state.pollLast();
                    int s = state.size();
                    int v = (s/n)+1;
                    int r = s%n;
                    if (p != r) {
                        matrix[r][p] = 0;
                        colUsed[p][v] = false;
                        boolean placed = false;
                        for (p++; p < n; p++) {
                            if (matrix[r][p] == 0 && !colUsed[p][v]) {
                                matrix[r][p] = v;
                                state.add(p);
                                colUsed[p][v] = true;
                                placed = true;
                                break;
                            }
                        }
                        back = !placed;
                    }

                } else {
                    int s = state.size();
                    int v = (s/n)+1;
                    int r = s%n;
                    // we need to put v into r'th row
                    if (matrix[r][r] == v) {
                        state.add(r);
                    } else {
                        boolean placed = false;
                        for (int p = 0; p < n; p++) {
                            if (matrix[r][p] == 0 && !colUsed[p][v]) {
                                matrix[r][p] = v;
                                state.add(p);
                                colUsed[p][v] = true;
                                placed = true;
                                break;
                            }
                        }
                        back = !placed;
                    }
                }
            }
            if (state.size() == N) {
                return matrix;
            }
        }
        return null;
    }

    public static List<List<Integer>> generateTraces(int k, int n) {
        return partition(k, n, n);
    }

    public static List<List<Integer>> partition(int k, int s, int n) {
        if (s == 1) {
            return Collections.singletonList(Arrays.asList(k));
        }
        int min = Math.max(1, k-n*(s-1));
        int max = Math.min(n, k-s+1);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = min; i <= max; i++) {
            List<List<Integer>> sublists = partition(k-i, s-1, n);
            for (List<Integer> sublist: sublists) {
                List<Integer> l = new LinkedList<>();
                l.add(i);
                l.addAll(sublist);
                list.add(l);
            }
        }
        return list;
    }
}
