import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            findSolution(i, n, k);
        }
    }

    public static void findSolution(int index, int n, int k) {
        String result;
        Set<Integer> set = new HashSet<>();
        int t = 0;
        for (int i = 1; i <=n; i++) {
            set.add(i * n);
            t = t + i;
        }
        if (n % 2 != 0) {
            set.add(t);
        }
        if (!set.contains(k)) {
            System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + index + ": " + "POSSIBLE");
        List<HashSet<Integer>> r = new ArrayList<>();
        List<HashSet<Integer>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            r.add(new HashSet<>());
            c.add(new HashSet<>());
        }
        int d = n % 2;
        int[][] a = new int[n][n];

        if (k % n == 0) {
            int j = k / n;
            for (int i = 0; i < n; i++) {
                a[i][i] = j;
                r.get(i).add(j);
                c.get(i).add(j);
                if (i == n - 1) {
                    break;
                }
                if (d == 0) {
                    if (i % 2 == 0) {
                        int w = i;
                        for (int q = n; q >= 1; q--) {
                            if (w == n - 1) {
                                break;
                            }
                            if (!r.get(i).contains(q) && !c.get(w + 1).contains(q)) {
                                w++;
                                r.get(i).add(q);
                                a[i][w] = q;
                            }
                        }
                        int e = i;
                        for (int q = n; q >= 1; q--) {
                            if (e == n - 1) {
                                break;
                            }
                            if (!r.get(e + 1).contains(q) && !c.get(i).contains(q)) {
                                e++;
                                c.get(i).add(q);
                                a[e][i] = q;
                            }
                        }
                    } else {
                        int w = i;
                        for (int q = 1; q <= n; q++) {
                            if (w == n - 1) {
                                break;
                            }
                            if (!r.get(i).contains(q) && !c.get(w + 1).contains(q)) {
                                w++;
                                r.get(i).add(q);
                                a[i][w] = q;
                            }
                        }
                        int e = i;
                        for (int q = 1; q <= n; q++) {
                            if (e == n - 1) {
                                break;
                            }
                            if (!r.get(e + 1).contains(q) && !c.get(i).contains(q)) {
                                e++;
                                c.get(i).add(q);
                                a[e][i] = q;
                            }
                        }
                    }
                } else {
                    int w = i;
                    for (int q = n; q >= 1; q--) {
                        if (w == n - 1) {
                            break;
                        }
                        if (!r.get(i).contains(q) && !c.get(w + 1).contains(q)) {
                            w++;
                            r.get(i).add(q);
                            a[i][w] = q;
                        }
                    }
                    int e = i;
                    for (int q = 1; q <= n; q++) {
                        if (e == n - 1) {
                            break;
                        }
                        if (!r.get(e + 1).contains(q) && !c.get(i).contains(q)) {
                            e++;
                            c.get(i).add(q);
                            a[e][i] = q;
                        }
                    }
                }
            }
        } else if (t == k) {
            a = new int[n][n];
            int j = n;
            for (int i = 0; i < n; i++) {
                a[i][i] = j;
                r.get(i).add(j);
                c.get(i).add(j);
                if (i == n - 1) {
                    break;
                }
                int w = i;
                for (int q = 1; q <= n; q++) {
                    w++;
                    if (!r.get(i).contains(q) && !c.get(w).contains(q)) {
                        r.get(i).add(q);
                        a[i][w] = q;
                    }
                }
                int e = i;
                for (int q = 1; q <= n; q++) {
                    e++;
                    if (!r.get(e).contains(q) && !c.get(i).contains(q)) {
                        c.get(i).add(q);
                        a[e][i] = q;
                    }
                }
                j--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
