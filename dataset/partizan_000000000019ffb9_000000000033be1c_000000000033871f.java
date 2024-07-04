import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution {

    public BufferedReader in;
    public PrintStream out;

    public boolean log_enabled = false;

    private class TestCase {

        int C, D;
        int[] X;
        
        int[][] connections;
        int[] con_count;
        
        int[][] com_by_number;
        int[] com_by_n_count;
        
        public Object solve() {
            
            C = readInt();
            D = readInt();
            
            X = new int[C];
            int i, x;
            for (i=1; i<C; i++)
            {
                x = -readInt();
                if (x<0) return 0;
                
                X[i] = x;
            }
            
            con_count = new int[C];
            Arrays.fill(con_count, 0);
            connections = new int[C][C];
            int[][] con_idx = new int[C][C];            
            int[] con_time = new int[D];
            
            int y;
            for (i=0; i<D; i++)
            {
                x = readInt()-1;
                y = readInt()-1;
                
                connections[x][con_count[x]] = y;
                con_idx[x][con_count[x]] = i;
                
                connections[y][con_count[y]] = x;
                con_idx[y][con_count[y]] = i;
                
                con_count[x] ++;
                con_count[y] ++;
            }
            
            int[] T = new int[C];            
            Arrays.fill(T, -1);
            T[0] = 0;
            
            int K = 1, t = 1, j, v, k2;
            while (K < C)
            {
                k2 = K;
                for (i=1; i<C; i++)
                {
                    if (X[i]==K)
                    {
                        k2 ++;
                        T[i] = t;
                        
                        for (j=0; j<con_count[i]; j++)
                        {
                            v = connections[i][j];
                            if (T[v]>-1)
                            {
                                con_time[  con_idx[i][j]  ] = (T[v] == T[i]) ? 1 : T[i]-T[v];
                            }
                        }
                    }
                }
                
                K = k2;
                t++;
            }
            
            
            out.printf("Case #%d:", caseNumber);
            for (i=0; i<D; i++)
            {
                out.printf(" %d", con_time[i]);
            }
            out.println();
            
            
            
            
                          
            
            return null;
            
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
