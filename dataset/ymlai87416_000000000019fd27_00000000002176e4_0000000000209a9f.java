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

            //IN = "C:\\GitProjects\\algorithm_practice\\src\\main\\java\\GoogleCodeJam\\Y2020\\Quali\\B\\B-test.in";
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

    private String solve(String input){
        StringBuilder sb = new StringBuilder();
        int curd = 0;

        for(int i=0; i<input.length(); ++i){
            char c = input.charAt(i);
            int a = c-'0';
            if(curd >a ){
                while(curd > a){
                    sb.append(')');
                    --curd;
                }
            }
            else if(curd < a){
                while(curd < a){
                    sb.append('(');
                    ++curd;
                }
            }
            sb.append(c);
        }

        while(curd > 0){
            sb.append(')');
            --curd;
        }

        return sb.toString();
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");

            String line = sc.nextLine();
            String result = solve(line);
            out.println(result);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
