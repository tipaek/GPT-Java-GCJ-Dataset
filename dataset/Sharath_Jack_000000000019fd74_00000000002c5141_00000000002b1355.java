import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static boolean isElem(int m[][], boolean b[][], int r, int c, int i, int j) {
        int avg = 0;
        int co = 0;
        if (i - 1 >= 0) {
            int k = i - 1;
            while (b[k][j] && --k >= 0) ;
            if (k >= 0) {
                avg += m[k][j];
                co++;
            }
        }
        if (i + 1 < r) {
            int k = i + 1;
            while (b[k][j] && ++k < r) ;
            if (k < r) {
                avg += m[k][j];
                co++;
            }
        }
        if (j - 1 >= 0) {
            int k = j - 1;
            while (b[i][k] && --k >= 0) ;
            if (k >= 0) {
                avg += m[i][k];
                co++;
            }
        }
        if (j + 1 < c) {
            int k = j + 1;
            while (b[i][k] && ++k < c) ;
            if (k < c) {
                avg += m[i][k];
                co++;
            }
        }
        if ((m[i][j] * co) < avg) {
            return true;
        } else {
            return false;
        }
    }

    private static void p(int a[][], boolean b[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + "" + b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve2(Scanner scanner) {
        int r = scanner.nextInt(), c = scanner.nextInt();
        int[][] m = new int[r][c];
        boolean e[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = scanner.nextInt();
                e[i][j] = false;
            }
        }
        boolean done = false;
        int ans = 0;
        while (!done) {
            int curAns = 0;
            int curEle = 0;
            ArrayList<ArrayList<Integer>> presentE = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (!e[i][j]) {
                        curAns += m[i][j];
                    }
                    if (!e[i][j] && isElem(m, e, r, c, i, j)) {
                        curEle++;
                        ArrayList<Integer> pe = new ArrayList<>();
                        pe.add(i);
                        pe.add(j);
                        presentE.add(pe);
                    }
                }
            }
            ans += curAns;
//            p(m, e, r, c);
//            System.out.println(ans + " " + curEle);
            if (curEle == 0) {
                done = true;
            } else {
                for (ArrayList<Integer> ll : presentE) {
                    e[ll.get(0)][ll.get(1)] = true;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T;
        T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            solve2(s);
        }
    }
}
