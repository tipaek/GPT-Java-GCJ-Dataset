
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt(), k = s.nextInt();
            int[][] ans = check(n, k);
            if (ans==null){
                System.out.println("case #" + i + ": " + "IMPOSSIBLE");
            }else {
                System.out.println("case #" + i + ": " + "POSSIBLE");
                for (int a = 0; a < n; a++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(ans[a][j] + " ");
                    }
                    System.out.println();
                }

            }
        }
    }

    private static int[][] check(int n, int k) {
        int[][] matrix = new int[n][n];
        List<Integer> list = divide(n, k);
        for (int i = 0; i < list.size(); i++) {
            matrix[i][i] = list.get(i);
        }
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> fixed = new ArrayList<>();
                    for (int l = 1; l <=n ; l++) {
                        fixed.add(l);
                    }
                    //down
                    for (int l = 0; l < n; l++) {
                        int c = matrix[l][j];
                        if (fixed.contains(c)) {

                            fixed.remove(new Integer(c));
                        }
                    }
                    //right
                    for (int m = 0; m < n; m++) {
                        int d = matrix[i][m];
                        if (fixed.contains(d)) {
                            fixed.remove(new Integer(d));
                        }
                    }
                    if (fixed.size()==0)
                        return null;
                    int v = 0;
                    if (i % 2 == 0) {
                        v = fixed.get(0);
                    } else {
                        v = fixed.get(fixed.size() - 1);
                    }
                    matrix[i][j] = v;
                }
            }
        }

        return matrix;
    }

    static List<Integer> divide(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int v = k / n;
        int c = k % n;

        if (c != 0) {
            list.add(v + 1);
        }
        if (c == 0) {
            int a = k / v;
            while (a > 0) {
                list.add(v);
                a--;
            }
        } else {
            int a = v;
            while (a > 0) {
                list.add(v);
                a--;
            }
        }
        return list;
    }
}
