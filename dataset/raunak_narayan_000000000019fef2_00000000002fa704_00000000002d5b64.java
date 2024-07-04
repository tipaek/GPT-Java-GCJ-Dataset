import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;

    private void run() throws Exception {
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            solve(i);
        }

        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

    
    long mul;
    Stack<Integer> values;

    private void solve(int t) {

        mul = (in.nextInt() - 1) * (in.nextInt() - 1);

        out.print("Case #" + t + ": " +mul);
        out.println();
    }



   

    static int modInverse(int a, int m) 
    { 
        int m0 = m; 
        int y = 0, x = 1; 
  
        if (m == 1) 
            return 0; 
  
        while (a > 1) 
        {  
            int q = a / m; 
  
            int t = m; 

            m = a % m; 
            a = t; 
            t = y; 
  
            // Update x and y 
            y = x - q * y; 
            x = t; 
        } 
  
        if (x < 0) 
            x += m0; 
  
        return x; 
    }
}
