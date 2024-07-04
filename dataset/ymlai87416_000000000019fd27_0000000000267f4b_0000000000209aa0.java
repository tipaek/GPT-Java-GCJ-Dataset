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
        int[] freq = new int[n];
        Integer[] order = new Integer[n];
        for(int i=0; i<n; ++i) {
            freq[i] = 0;
            order[i] = i+1;
        }

        for(int i=0; i<n; ++i){
            result[i][i] = diag[i];
            freq[diag[i]-1]++;
        }

        Arrays.sort(order, (a, b) -> freq[b-1] - freq[a-1]);

        for(int i=0; i<n; ++i){
            int next = order[i];

            //scan for each row
            HashSet<Integer> a = new HashSet<>();
            for(int j=0; j<n; ++j){
                for(int k=0; k<n; ++k){
                    if(result[j][k] == next)
                        a.add(k);
                }
            }

            //now fill in the row
            for(int j=0; j<n; ++j){
                int b = -1;
                boolean skipRow=false;
                for(int k=0; k<n; ++k){
                    if(result[j][k] == 0 && !a.contains(k)){
                        b = k;
                    }
                    if(result[j][k] == next){
                        skipRow = true;
                        break;
                    }
                }

                if(skipRow) continue;

                else {
                    if(b == -1) return null;
                    else {
                        result[j][b] = next;
                        a.add(b);
                    }
                }
            }
        }

        return result;
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
