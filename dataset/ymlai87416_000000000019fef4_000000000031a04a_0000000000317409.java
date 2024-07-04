import java.io.File;
import java.io.PrintStream;
import java.util.*;

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

            //IN = "C:\\GitProjects\\algorithm_practice\\temp\\src\\A\\A-test.in";
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

    private Integer solve(int X, int Y, String M){
        int[][] loc = new int[M.length()+1][2];
        loc[0][0] = X; loc[0][1] = Y;
        int nX, nY; nX = X; nY = Y;
        for(int i=0; i<M.length(); ++i){
            if(M.charAt(i) == 'N') nY += 1;
            else if (M.charAt(i) == 'S') nY -= 1;
            else if (M.charAt(i) == 'E') nX += 1;
            else if (M.charAt(i) == 'W') nX -= 1;

            int dist = Math.abs(nX) + Math.abs(nY);
            //System.out.println("Debug: " + dist);
            if(dist <= i+1)
                return i+1;
        }

        return null;
    }

    private String solveBig(int t, int b){

        return "";
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String M = sc.nextLine().trim();
            out.print("Case #" + i + ": ");
            Integer result = solve(X, Y, M);
            if(result == null)
                out.println("IMPOSSIBLE");
            else
                out.println(result);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
