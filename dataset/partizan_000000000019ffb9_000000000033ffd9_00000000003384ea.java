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
        
        public long sum1(long I)
        {
            return ((I+1)/2)*((I+1)/2);
        }
        
        public long sum1x(long J, long I)
        {
            if (I%2==0)
            {
                I--;
            }
            
            return sum1(J) - sum1(I);
        }
        
        public long sum2(long I)
        {
            return I/2*(I+2)/2;
        }
        
        public long sum2x(long J, long I)
        {
            if (I%2==1)
            {
                I--;
            }
            return sum2(J)-sum2(I);
            
        }
        
        public Object solve() {
            
            long L = readLong();
            long R = readLong();
            long d;
            
            
            long I = 1;
            if (R>L)
            {
                d = R-L;
                while ( sum(I+1000) < d  )
                {
                    I += 1000;
                }
                
                R -= sum(I);                                
                I++;
                
                while (R-I>L)
                {
                    R -= I;
                    I++;
                }
            }
            else
            {
                d = L - R;
                
                while ( sum(I+1000) < d  )
                {
                    I += 1000;
                }
                
                L -= sum(I);                                
                I++;
                
                while (L-I>R)
                {
                    L -= I;
                    I++;
                }
            }
            
            if ((R<I)&&(L<I))
            {
                return strf("%d %d %d", I-1, L, R);
            }
            
            long J, L2, R2;
            while ((L>=I)||(R>=I))
            {
                if (R>L)
                {
                    R -= I;
                    I ++;
                }
                
                J = I + 1000;
                
                if (J%2==0)
                {
                    L2 = sum2x(J, I-1);
                    R2 = sum1x(J, I-1);
                }
                else
                {
                    L2 = sum1x(J, I-1);
                    R2 = sum2x(J, I-1);
                }
                
                if ((L2<L)&&(R2<R))
                {
                    L -= L2;
                    R -= R2;
                    I = J+1;
                }
                else{
                    break;
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
                
                I ++;
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
