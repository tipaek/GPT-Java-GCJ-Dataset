import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    static String   FILENAME;
    static Scanner sc;
    static String   IN;
    static String   OUT;
    static PrintStream out;

    static{
        try{
            /*
            FILENAME = "Solution-large";
            IN = FILENAME + ".in";
            OUT = FILENAME + ".out";
            sc = new Scanner(new File(IN));
            out      = new PrintStream(
                    new FileOutputStream(OUT, false));
                    */

            //IN = "C:\\GitProjects\\algorithm_practice\\java\\src\\main\\java\\GoogleCodeJam\\Y2020\\Quali\\E\\E-test.in";
            IN = null;
            if(IN == null)
                sc = new Scanner(System.in);
            else
                sc = new Scanner(new File(IN));
            out = new PrintStream(System.out);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printMatrix(int[][] result){
        int n = result[0].length;
        for(int p=0; p<n; ++p){
            for(int q=0; q<n-1; ++q){
                out.print(result[p][q] + " ");
            }
            out.println(result[p][n-1]);
        }
    }

    private int[][] solve(int n, int k){
        int[] diag = new int[n];
        for(int i=0; i<n; ++i) diag[i] = 0;
        return findSolution(diag, k, 0);
    }

    private int[][] findSolution(int[] diag, int k, int n){
        if(n == diag.length)
            if(k == 0)
                return fillLatinSquare(diag);
            else
                return null;

        int last;
        if(n == 0) last = diag.length;
        else last = diag[n-1];

        if(k == 0 && n < diag.length) return null;
        else{
            for(int i=last; i>0; --i){
                diag[n] = i;
                if(k-i < 0) continue;
                int[][] a = findSolution(diag, k-i, n+1);
                if(a != null)
                    return a;
            }
        }
        diag[n] = 0;
        return null;
    }

    private int[][] fillLatinSquare(int[] diag){

        int n = diag.length;
        int[][] result = new int[n][n];
        HashSet<Integer>[] row = new HashSet[n];
        HashSet<Integer>[] col = new HashSet[n];
        for(int i=0; i<n; ++i)
            row[i] = new HashSet<>();
        for(int i=0; i<n; ++i)
            col[i] = new HashSet<>();

        for(int i=0; i<n; ++i) {
            result[i][i] = diag[i];
            row[i].add(diag[i]);
            col[i].add(diag[i]);
        }

        boolean b = latinSquareSolver(result, row, col);
        if(b)
            return result;
        else
            return null;
    }

    private boolean latinSquareSolver(int[][] a, HashSet<Integer>[] row, HashSet<Integer>[] col){
        int n = a.length;

        int score = Integer.MAX_VALUE;
        int next_i = -1;
        int next_j = -1;
        HashSet<Integer> bb = null;
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(a[i][j] == 0) {
                    HashSet<Integer> b = new HashSet<>();
                    b.addAll(row[i]);
                    b.addAll(col[j]);
                    if (score > (n - b.size())) {
                        score = (n - b.size());
                        next_i = i;
                        next_j = j;
                        bb = b;
                    }
                }
            }
        }

        //all square is filled
        if(score == Integer.MAX_VALUE)
            return true;

        for(int i=1; i<=n; ++i){
            if(!bb.contains(i)) {
                a[next_i][next_j] = i;
                row[next_i].add(i);
                col[next_j].add(i);
                boolean r = latinSquareSolver(a, row, col);
                if (r) return true;
                a[next_i][next_j] = 0;
                row[next_i].remove(i);
                col[next_j].remove(i);
            }
        }

        return false;
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] result = solve(n, k);
            if(result == null)
                out.println("IMPOSSIBLE");
            else{
                out.println("POSSIBLE");
                printMatrix(result);
            }
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
