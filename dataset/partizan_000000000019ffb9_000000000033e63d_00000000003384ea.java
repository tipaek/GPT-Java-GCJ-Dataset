import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution {

    public BufferedReader in;
    public PrintStream out;

    public boolean log_enabled = false;

    
    
    private class TestCase {

        public long sum(long x)
        {
            long y = x+1;
            if (x%2==0) 
            {
                x/=2;
            }
            else
            {
                y/=2;
            }
                
            return x*y;
        }
        
        public long i1(long I, long S)
        {
            S += ((I-1)/2) * ((I-1)/2);
            
            return (long)(2*Math.sqrt(S)-1)-2;
        }
        
        public long i2(long I, long S)
        {
            S += ((I-2)/2) * ((I)/2);
            
            return (long)((Math.sqrt(16*S+4)-2)/2)-2;
        }
        
        public Object solve() {
            
            long L = readLong();
            long R = readLong();
            
            long d = L > R ? L - R : R - L;
            
            long x;
            if (d==0)
            {
                x = 1;
            }
            else
            {
                x = (long)Math.floor(((Math.sqrt(8*d)-1) / 2));
            }
            
            while (sum(x) <= d )
            {
                x ++;
            }
            
            x --;
            
            long I = x+1;
            
            if (L<R)
            {
                R -= sum(x);
            }
            else{
                L -= sum(x);
            }
            
            if ((L < I)&&(R<I))
            {
                return strf("%d %d %d", I-1, L, R);
            }
            
            if (R > L)
            {
                R -= I;
                I++;
            }
            
            long i_new;
            if (I%2==0)
            {
                i_new = Math.min( i2(I, L) , i1(I+1, R));
                
                if (i_new % 2 == 1) i_new --;
                
                if (i_new > I+2)
                {
                    L -= (i_new/2)*(i_new/2+1) - (I/2)*(I/2-1);
                    R -= ( i_new/2+1 ) * ( i_new/2+1 ) - (I/2)*(I/2);
                    
                    I = i_new;
                }
            }
            else
            {
                i_new = Math.min( i1(I, L) , i2(I+1, R));
                if (i_new % 2 == 1) i_new --;
                
                if (i_new > I+2)
                {
                    L -= (i_new/2)*(i_new/2+1) - (I/2)*(I/2-1);
                    R -= ( i_new/2+1 ) * ( i_new/2+1 ) - (I/2)*(I/2);
                    
                    I = i_new;
                }
            }
            
            while ((L>=I)||(R>=I))
            {
                if (R>L)
                {
                    R -= I;
                }
                else
                {
                    L -= I;
                }
                
                I++;
            }
                        
            
            return strf("%d %d %d", I-1, L, R);
            
            //return strf("%f", 0);
            
            //out.printf("Case #%d: \n", caseNumber);
            //return null;
        }
        
        public int caseNumber;
        
        TestCase(int number) {
            caseNumber = number;
        }
        
        public void run(){
            Object r = this.solve();
            
            if ((r != null))
            {
                outputCaseNumber(r);
            }
        }
        
        public String impossible(){
            return "IMPOSSIBLE";
        }
        
        public String strf(String format, Object... args)
        {
            return String.format(format, args);
        }
        
        public void outputCaseNumber(Object r){
            out.printf("Case #%d:", caseNumber);
            if (r != null)
            {
                out.print(" ");
                out.print(r);
            }
            out.print("\n");
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
    
    public long[] readLongArray(int n) {
        long[] x = new long[n];
        readLongArray(x, n);
        return x;
    }

    public void readLongArray(long[] x, int n) {
        for (int i = 0; i < n; i++) {
            x[i] = readLong();
        }
    }

    public void logWrite(String format, Object... args) {
        if (!log_enabled) {
            return;
        }

        out.printf(format, args);
    }
}
