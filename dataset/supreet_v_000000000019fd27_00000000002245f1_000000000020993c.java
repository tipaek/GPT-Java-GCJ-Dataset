import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int p=0;p<t;p++)
        {
            int n  =Integer.parseInt(br.readLine());
            int[][] a=new int[n][n];
            int trace=0,r=0,c=0;
            for(int i=0;i<n;i++)
            {
                String[] inp=br.readLine().split(" ");
                for(int j=0;j<n;j++)
                {
                    a[i][j]=Integer.parseInt(inp[j]);
                    if(i==j)
                    {
                        trace+=a[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> row_set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(row_set.contains(a[i][j]))
                    {
                        r++;
                        break;
                    }
                    row_set.add(a[i][j]);
                }
            }
            
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> col_set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(col_set.contains(a[j][i]))
                    {
                        c++;
                        break;
                    }
                    col_set.add(a[j][i]);
                }
            }
            System.out.println("Case #"+(p+1)+": "+trace+" "+r+" "+c);
        }
    } 
}