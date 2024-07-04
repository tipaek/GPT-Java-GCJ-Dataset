import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int ti = 1; ti <= t; ti++) {
            String[] s = in.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int diag = Integer.parseInt(s[1]);

            List<List<Integer>> rp = permute(n);
            int[][] a = init(n);
            calc(ti, n, diag, rp, a);
        }
    }

    private static void calc(int ti, int n, int diag, List<List<Integer>> rp, int[][] a) {
        for (int i = 0; i < rp.size(); i++) {
            for (int j = 0; j < rp.size(); j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    int r = rp.get(i).get(k);
                    int c = rp.get(j).get(k);
                    sum += a[r][c];
                }
                if (sum == diag) {
                    System.out.println("Case #" + ti + ": POSSIBLE");
                    printm(n, a, rp.get(i), rp.get(j));
                    return;
                }
            }
        }
        throw new RuntimeException("");
        //System.out.println("Case #" + ti + ": IMPOSSIBLE");
    }

    private static void printm(int n, int[][] a, List<Integer> r, List<Integer> c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[r.get(i)][c.get(j)]);
                if (j != n-1) System.out.print(' ');
            }
            System.out.println();
        }
    }

    static int[][] init(int n) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (j + i) % n + 1;
            }
        }
        return a;
    }


    static List<List<Integer>> permute(int nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            list.add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        next(0, list, result);
        return result;
    }

    static void next(int pos, List<Integer> list, List<List<Integer>> result) {
        if (pos == list.size()) {
            result.add(new ArrayList<>(list));
        }

        for (int i = pos; i < list.size(); i++) {
            Collections.swap(list, pos, i);
            next(pos + 1, list, result);
            Collections.swap(list, pos, i);
        }
    }
}
