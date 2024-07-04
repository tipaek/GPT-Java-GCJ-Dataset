import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

 class Solution implements Runnable {
    
    
      
    
    public void solve() throws Exception {
    int t=sc.nextInt();
    for(int q=0;q<t;q++)
    {
        int n=sc.nextInt();
        int d=sc.nextInt();
        long arr[]=new long[n];
        int flag=0;
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
        arr[i]=sc.nextLong();
        if(map.containsKey(arr[i]))
        {
            int temp=map.get(arr[i]);
            temp++;
            map.put(arr[i],temp);
            if(temp==d)
            flag=1;
        }
        else
        {
            map.put(arr[i],1);
        }
        }
        if(flag==1)
        System.out.println("Case #"+(q+1)+": "+0 );
        else
        {
            int p=0;
            if(d==2)
            System.out.println("Case #"+(q+1)+": "+1);
            else if(d==3)
            {
                for(int i=0;i<n;i++)
                {
                    long temp=arr[i];
                    long div=temp/2;
                    if(div*2==temp && map.containsKey(div))
                    p=1;
                }
                if(p==1)
                System.out.println("Case #"+(q+1)+": "+1);
                else 
                System.out.println("Case #"+(q+1)+": "+2);
            }
        
        
    }
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