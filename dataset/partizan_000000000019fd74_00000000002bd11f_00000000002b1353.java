

import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution {

    public BufferedReader in;
    public PrintStream out;

    public boolean log_enabled = true;

    private class TestCase {

        public int caseNumber;

        TestCase(int number) {
            caseNumber = number;
        }
        
        public void run(){
            String r = this.solve();
            
            if ((r != null) && (r.compareTo("") > 0))
            {
                out.printf("Case #%d: %s\n", caseNumber, r);
            }
        }
        
        public String impossible(){
            return "IMPOSSIBLE";
        }
        
        public String strf(String format, Object... args)
        {
            return String.format(format, args);
        }

        public String solve() {
            
            int N = readInt();
            
            out.printf("Case #%d:\n", caseNumber);
            
            int i, r=0, k=1; ;
            if (N<33)
            {
                for (i=0; i<N; i++)
                {
                    r ++;
                    out.printf("%d %d\n", r, 1);
                }
                return null;
            }
            
            boolean bk = false;
            
            int n = N-32;
            
            int z = 0;
            
            
            while (n > 0)
            {
                r ++;
                k = bk ? r : 1;
                
                out.printf("%d %d\n", r, k);
                
                if (n % 2 == 1)
                {
                    for (i=1; i<r; i++)
                    {
                        k = bk ? k-1 : k+1;
                        out.printf("%d %d\n", r, k);
                    }
                    bk = !bk;
                }
                else{
                    z ++;
                }
                
                n = n >> 1;
            }
            
            for (i=0; i<32-z; i++)
            {
                r ++;
                k = bk ? r : 1;
                
                out.printf("%d %d\n", r, k);
            }
            
            return null;
        }

    }

    public void run() {
        //while (true)
        {
            int t = readInt();
            for (int i = 0; i < t; i++) {
                TestCase T = new TestCase(i + 1);
                T.run();
            }
        }
    }
    
    public Solution(BufferedReader _in, PrintStream _out){
        in = _in;
        out = _out;
    }
    

    public static void main(String args[]) {
        Locale.setDefault(Locale.US);
        Solution S;
        try {
            S = new Solution(
                        new BufferedReader(new InputStreamReader(System.in)),
                        System.out
                );
        } catch (Exception e) {
            return;
        }
        
        S.run();
        
    }

    private StringTokenizer tokenizer = null;

    public int readInt() {
        return Integer.parseInt(readToken());
    }

    public long readLong() {
        return Long.parseLong(readToken());
    }

    public double readDouble() {
        return Double.parseDouble(readToken());
    }

    public String readLn() {
        try {
            String s;
            while ((s = in.readLine()).length() == 0);
            return s;
        } catch (Exception e) {
            return "";
        }
    }

    public String readToken() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(in.readLine());
            }
            return tokenizer.nextToken();
        } catch (Exception e) {
            return "";
        }
    }

    public int[] readIntArray(int n) {
        int[] x = new int[n];
        readIntArray(x, n);
        return x;
    }

    public void readIntArray(int[] x, int n) {
        for (int i = 0; i < n; i++) {
            x[i] = readInt();
        }
    }

    public void logWrite(String format, Object... args) {
        if (!log_enabled) {
            return;
        }

        out.printf(format, args);
    }
}
