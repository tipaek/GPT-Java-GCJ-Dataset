import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
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

            //IN = "C:\\GitProjects\\algorithm_practice\\src\\main\\java\\GoogleCodeJam\\Y2020\\Quali\\A\\A-test.in";
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

    private int[] solve(int[][] m){
        int trace = 0;
        int rleft = 0;
        int rRight = 0;

        HashSet<Integer> a = new HashSet<>();
        int size = m[0].length;
        for(int i=0; i<size; ++i){
            trace += m[i][i];

            a.clear();
            for(int j=0; j<size; ++j){
                if(a.contains(m[i][j])){
                    ++rleft;
                    break;
                }
                a.add(m[i][j]);
            }

            a.clear();
            for(int j=0; j<size; ++j){
                if(a.contains(m[j][i])){
                    ++rRight;
                    break;
                }
                a.add(m[j][i]);
            }
        }

        return new int[]{trace, rleft, rRight};
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");

            int size = sc.nextInt();
            int[][] m = new int[size][size];

            for(int p=0; p<size; ++p){
                for(int q=0; q<size; ++q){
                    m[p][q] = sc.nextInt();
                }
            }

            int[] result = solve(m);
            out.format("%d %d %d\n", result[0], result[1], result[2]);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
