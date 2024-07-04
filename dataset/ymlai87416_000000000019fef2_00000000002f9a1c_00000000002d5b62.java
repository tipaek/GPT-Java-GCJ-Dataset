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

    private String solve(int x, int y){
        Queue<Object[]> stack= new ArrayDeque<Object[]>();
        stack.offer(new Object[]{0L, 0L, ""});
        while(!stack.isEmpty()){
            Object[] b = stack.poll();
            long tx = (long)b[0];
            long ty = (long)b[1];
            String ss = (String)b[2];
            if(tx == x && ty == y) return ss;

            int step = ss.length();
            if(step > 10) continue;
            long stepSize = (long)Math.pow(2, step);

            stack.offer(new Object[]{tx-stepSize, ty, ss+"W"});
            stack.offer(new Object[]{tx+stepSize, ty, ss+"E"});
            stack.offer(new Object[]{tx, ty-stepSize, ss+"S"});
            stack.offer(new Object[]{tx, ty+stepSize, ss+"N"});
        }
        return "IMPOSSIBLE";
    }

    private String solveBig(int t, int b){

        return "";
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            int _t = sc.nextInt();
            int _b = sc.nextInt();
            out.print("Case #" + i + ": ");
            String result = solve(_t, _b);
            out.println(result);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
