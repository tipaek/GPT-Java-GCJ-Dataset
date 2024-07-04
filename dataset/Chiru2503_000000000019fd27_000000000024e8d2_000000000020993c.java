import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution
{
public static void main(String[] args) throws IOException
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    int te=Integer.parseInt(br.readLine());
    int f=te;
    while(te-->0)
    {
        int n=Integer.parseInt(br.readLine());
        int r=0,c=0,t=0;
        int[][] ar=new int[n][n];
        int h=n,k=0;
        while(h-->0)
        {
            String[] s=br.readLine().split(" ");
            for(int i=0;i<s.length;i++)
            {
                ar[k][i]=Integer.parseInt(s[i]);
            }
            k++;
        }
        for(int i=0;i<n;i++)
        {
            t+=ar[i][i];
        }
        
        
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> h1=new HashSet<Integer>();
            for(int j=0;j<n;j++)
            {
                if(h1.contains(ar[i][j]))
                {
                    r++;
                   break;
                }
                
                else
                {
                    h1.add(ar[i][j]);
                   // bw.write(ar[i][j]+" ");
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> h2=new HashSet<Integer>();
            for(int j=0;j<n;j++)
            {
                if(h2.contains(ar[j][i]))
                {
                    c++;
                   break;
                }
                
                else
                {
                    h2.add(ar[j][i]);
                }
            }
        }
       bw.write("Case #"+(f-te)+":"+" "+t+" "+r+" "+c); 
    }
    bw.flush();
}
}
