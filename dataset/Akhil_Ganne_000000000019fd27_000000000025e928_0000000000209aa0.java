import java.io.*;
import java.util.*;


 class Solution {
     public static boolean check(int[] a,int n,int k)
     {
         int trace =0;
            for(int i=0;i<n*n;i=i+(n+1))
                trace+=a[i];
         if(trace!=k)
             return false;
            int rows = 0,columns=0;
            for(int i=0;i<n*n;i=i+n)
            {
            HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
            for(int j=i;j<i+n;j++)
            {
                if(h.containsKey(a[j]))
                {
                    rows++;
                    break;
                }
                h.put(a[j],1);
            }
            }
            for(int i=0;i<n;i++)
            {
            HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
            for(int j=i;j<n*n;j=j+n)
            {
                if(h.containsKey(a[j]))
                {
                    columns++;
                    break;
                }
                h.put(a[j],1);
            }
            }
         if(trace==k&&rows==0&&columns==0)
             return true;
         return false;
     }
    public static boolean generate(int[] a,int n,int k,int idx)
    {
        if(idx==n*n)
        {
            if(check(a,n,k))
            {
                System.out.println("POSSIBLE");
                for(int i=0;i<n*n;i=i+n)
                {
                    for(int j=i;j<i+n;j++)
                        System.out.print(a[j]+" ");
                    System.out.println();
                }
                return true;
            }
            return false;
        }
        for(int i=1;i<=n;i++)
        {
            a[idx] = i;
            boolean f = generate(a,n,k,idx+1);
            if(f)
                return true;
        }
        return false;
        
    }
    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        int x=1;
        while(t-->0)
        {
            System.out.print("Case #"+x+": ");
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);
            int[] a = new int[n*n];
            boolean f = generate(a,n,k,0);
            if(!f)
                System.out.println("IMPOSSIBLE");
            x++;
        }
        bw.flush();
    }
}
