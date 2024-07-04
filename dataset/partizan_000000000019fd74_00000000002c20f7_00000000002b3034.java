

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
            
            String[] pref = new String[N];
            String[] suf = new String[N];
            String middle = "";
            
            
            int j,i, first, last;
            
            String P;
            for (i=0; i<N; i++)
            {
                P = readLn();
                first = P.indexOf('*');
                last = P.lastIndexOf('*');
                
                if (last > first)
                {
                    middle = middle.concat(P.substring(first, last).replace("*", ""));
                }
                
                pref[i] = P.substring(0, first);
                suf[i] = "";
                
                for (j=P.length()-1; j>last; j--)
                {
                    suf[i] = suf[i] + P.charAt(j);
                }
            }
            
            String maxsuf = suf[0];
            String maxpref = pref[0];
            
            for (i=1; i<N; i++)
            {
                if (pref[i].length() > 0)
                {
                    if (pref[i].indexOf(maxpref)==0)
                    {
                        maxpref = pref[i];
                    }
                    else if (maxpref.indexOf(pref[i])==0)
                    {
                        
                    }
                    else
                    {
                        return "*";
                    }
                }
                
                if (suf[i].length() > 0)
                {
                    if (suf[i].indexOf(maxsuf)==0)
                    {
                        maxsuf = suf[i];
                    }
                    else if (maxsuf.indexOf(suf[i])==0)
                    {
                        
                    }
                    else
                    {
                        return "*";
                    }
                }
            }
            
            String R = maxpref.concat(middle);
            int n = maxsuf.length();
            for (i=0; i<n; i++)
            {
                R = R + maxsuf.charAt(n-i-1);
            }
            
            return R;
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
