import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String []args)throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int z=0;z<t;z++)
        {
           int n = Integer.parseInt(br.readLine()); 
           int A[][]=new int[n][n];
           for(int j=0;j<n;j++)
           A[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           int rows=0,cols=0,trace=0;
           for(int i=0;i<n;i++)
           {
               HashSet<Integer> hs =new HashSet<Integer>();
               for(int j=0;j<n;j++)
               {
                   hs.add(A[i][j]);
                   if(i==j)
                   trace+=A[i][j];
               }
               if(hs.size()!=n)
               rows++;
           }
           for(int i=0;i<n;i++)
           {
               HashSet<Integer> hs =new HashSet<Integer>();
               for(int j=0;j<n;j++)
               {
                   hs.add(A[j][i]);
               }
               if(hs.size()!=n)
               cols++;
           }
           bw.write("Case #"+Integer.toString(z+1)+": ");
           bw.write(Integer.toString(trace)+" "+Integer.toString(rows)+" "+Integer.toString(cols));
           bw.newLine();
        }
        br.close();
        bw.close();
    }
}