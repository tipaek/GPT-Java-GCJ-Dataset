import java.io.File;
import java.io.PrintStream;
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

            //IN = "C:\\GitProjects\\algorithm_practice\\src\\main\\java\\GoogleCodeJam\\Y2020\\Quali\\E\\E-test.in";
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

        //init a matrix
        int[][] r = new int[n][n];
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                r[i][j] = ((j-i+n) % n) + 1;
            }
        }

        //printMatrix(r);
        int diff = k-n;
        int[] order = new int[n];
        for(int i=0; i<n; ++i){
            order[i] = i;
        }

        //swap row until everything is good, just keep swapping.
        //the best move is abs(diff) closer to zero...
        //terminate condition?
        while(diff != 0){
            //out.println("D " + diff);
            int best_val = 0;
            int best_from = -1;
            int best_to = -1;
            for(int i=0; i<n; ++i){
                for(int j=i+1; j<n; ++j){
                    //find the best move
                    int from_row = order[i];
                    int to_row = order[j];
                    int temp = r[from_row][from_row] + r[to_row][to_row] - r[from_row][to_row] - r[to_row][from_row];
                    if (Math.abs(diff + best_val) > Math.abs(diff + temp)) {
                        best_val = temp;
                        best_from = i;
                        best_to = j;
                    }
                }
            }

            //no move is better than no moving....
            if(best_val == 0)
                return null;

            int temp = order[best_from];
            order[best_from] = order[best_to];
            order[best_to] = temp;
            diff = diff + best_val;
        }

        //out.println("DE " + diff);

        for(int i=0; i<n; ++i){
            int oi = order[i];
            for(int j=0; j<n; ++j){
                r[i][j] = ((oi+j) % n) + 1;
            }
        }

        return r;
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