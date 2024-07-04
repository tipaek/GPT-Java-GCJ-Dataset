import java.io.*;
import java.util.*;
class Solution
{
    
    public static void solve(String s[][],int t)
    {
        int n=s.length;
        int trace=0,row=0,column=0;
		Hashtable<String,Integer> hc[]=new Hashtable[n];
        int a[]=new int[n];
        Arrays.fill(a,0);
        for(int i=0;i<n;i++)
        {
			Hashtable<String,Integer> hr=new Hashtable<String,Integer>();
            int row_flag=0;
            for(int j=0;j<n;j++)
            {
				if(i==0)
				{
					hc[j]=new Hashtable<String,Integer>();				
				}
				
				if(i==j)
                {
                    trace+=Integer.parseInt(s[i][j]);
                }
                
                if(!hr.containsKey(s[i][j]))
                {
					hr.put(s[i][j],1);
				}
                else
                    row_flag=1;
                
				if(!hc[j].containsKey(s[i][j]))
                {
				    hc[j].put(s[i][j],1);
				}
                else
                {
                    if(a[j]==0)
                    {
                        a[j]=1;
                        column++;   
                    }
					
                }
				
            }
            if(row_flag!=0)
                row++;
        }
        System.out.println("Case #"+t+": "+trace+" "+row+" "+column);
        
    }
    
    public static void main(String args[])throws Exception
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int T=Integer.parseInt(br.readLine());
            for(int t=1;t<=T;t++)
            {
                int n=Integer.parseInt(br.readLine());
                String s[][]=new String[n][];
                for(int i=0;i<n;i++)
                {
                    s[i]=br.readLine().split(" ");
                }
                solve(s,t);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}