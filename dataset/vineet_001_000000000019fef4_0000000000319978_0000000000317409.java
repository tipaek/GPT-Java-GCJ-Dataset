import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

 class Solution implements Runnable {
    
    
      
    
    public void solve() throws Exception {
        int t=sc.nextInt();
    for(int xx=1;xx<=t;xx++)
    
    {
        int x=sc.nextInt();
        int y=sc.nextInt();
        String s=sc.nextToken();
        int arr[]=new int[10000];
        int time=0;
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='N')
            y++;
            if(s.charAt(i)=='S')
            y--;
            if(s.charAt(i)=='E')
            x++;
            if(s.charAt(i)=='W')
            x--;
            time++;
            int dist=Math.abs(x)+Math.abs(y);
            if(time>=dist)
            {
                ans=time;
                break;
            }
            
        }
        if(ans==0)
        System.out.println("Case #"+xx+": "+"IMPOSSIBLE");
        else
        System.out.println("Case #"+xx+": "+ans );
    }
 
    }
    
    static Throwable uncaught;

    BufferedReader in;
    FastScanner sc;
    PrintWriter out;

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            solve();
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

}

class FastScanner {

    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

}