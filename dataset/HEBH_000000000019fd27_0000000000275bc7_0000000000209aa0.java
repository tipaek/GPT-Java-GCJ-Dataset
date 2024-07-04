
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author houssem
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<List<Integer>> l = combinationSum(n, k);
            int[][] mat1 = createLatinSquare(n);
            int[][] matRes = new int[n][n];
            if (l.isEmpty()) {
                pw.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                break;
            }
           createMatrix(n, mat1, l, matRes,pw,t);
           

        }

        pw.close();
        // TODO code application logic here
    }

    public static void PrintMatrix(int[][] matRes,int n, PrintWriter pw) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(matRes[i][j]+" ");
            }
            pw.print("\n");
            
        }
    }

    public static void createMatrix(int n, int[][] mat1, List<List<Integer>> l, int[][] matRes,PrintWriter pw,int t) {
        for (List<Integer> elem : l) {
            int x = 0;
            boolean test = true;
            matRes = new int[n][n];
            for (Integer in : elem) {
                int index = getElementLineIndex(in, n, x, mat1);
                if (index >= 0) {
                    for (int i = 0; i < n; i++) {
                        matRes[x][i] = mat1[index][i];
                    }
                    mat1[index][n] = 1;
                    x++;
                } else {
                    test = false;
                    break;
                }
            }
            if (test) {
                pw.println("Case #" + (t + 1) + ": POSSIBLE");
                PrintMatrix(matRes, n, pw);
                return;
            }
            for (int i = 0; i < n; i++) {
                mat1[i][n] = 0;

            }

        }
        pw.println("Case #" + (t + 1) + ": IMPOSSIBLE");
        
    }

    public static int getElementLineIndex(int x, int n, int col, int[][] mat) {
        for (int i = 0; i < n; i++) {
            if ((mat[i][n] == 0) && (mat[i][col] == x)) {
                return i;
            }
        }
        return -1;
    }

    public static int[][] createLatinSquare(int n) {
        int[][] mat = new int[n][n + 1];
        int x;
        for (int i = 0; i < n; i++) {
            x = i + 1;
            for (int j = 0; j < n; j++) {
                if (x > n) {
                    x = 1;
                }
                mat[i][j] = x;
                x++;

            }
            mat[i][n] = 0;
        }
        return mat;
    }

    public static List<List<Integer>> combinationSum(int s, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> result2 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] candidates = new int[s];
        for (int i = 0; i < s; i++) {
            candidates[i] = i + 1;

        }
        helper(candidates, 0, target, 0, temp, result);
        for (List<Integer> re : result) {
            if (re.size() == s) {
                result2.add(re);
            }
        }
        return result2;
    }

    private static void helper(int[] candidates, int start, int target, int sum,
            List<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, i, target, sum + candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
