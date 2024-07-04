import java.io.*;
import java.util.*;
class solution
{
    
     static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
    public static void main(String args[])
    {
        int cnt=1,t, n, rowcount=0, colcount=0, trace=0,flag1=0,flag2=0;
        FastReader s = new FastReader(); 
        t= s.nextInt();
        while(t-->0)
        {
           
           
            n = s.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=s.nextInt();
                    
                }
            }
            for(int i = 0 ; i<n; i++)
            {
                trace+=arr[i][i];
            }
            outerr: for(int i=0;i<n;i++)
            {
                valuer: for(int val=1;val<=n;val++)
                {
                    innerr: for(int j=0;j<n;j++)
                    {
                        if(arr[i][j]==val)
                        {
                            flag1++;
                        }
						
                    }
					if(flag1>1)
					{
						rowcount++;
						flag1=0;
						continue outerr;
					}
					flag1=0;
                }
                
            }
            outerc: for(int i=0;i<n;i++)
            {
                valuec: for(int val=1;val<=n;val++)
                {
                    innerc: for(int j=0;j<n;j++)
                    {
                        if(arr[j][i]==val)
                        {
                            flag1++;
                        }
                    }
					if(flag1>1)
					{
						colcount++;
						flag1=0;
						continue outerc;
					}
					flag1=0;
                }
                
            }
            System.out.print("Case #"+cnt+": "+trace+" "+rowcount+" "+colcount);
            cnt++;
            while(t!=0)
            {
                System.out.println();
			}
			rowcount=0;
			colcount=0;
			trace=0;
            
            
        }
    }
}