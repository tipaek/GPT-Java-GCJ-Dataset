import java.io.*;
import java.util.*;


public class Solution {

    
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int tc = 1;
        int x=1;
        while(t-->0)
        {
            
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[n][n];
            for(int i=0;i<n;i++)
            {
                String[] inp = br.readLine().split(" ");
                for(int j=0;j<n;j++)
                    a[i][j] = Integer.parseInt(inp[j]);
            }
            int trace =0;
            for(int i=0;i<n;i++)
                trace+=a[i][i];
            int rows = 0,columns=0;
            for(int i=0;i<n;i++)
            {
            HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
            for(int j=0;j<n;j++)
            {
                if(h.containsKey(a[i][j]))
                {
                    rows++;
                    break;
                }
                h.put(a[i][j],1);
            }
            }
            for(int i=0;i<n;i++)
            {
            HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
            for(int j=0;j<n;j++)
            {
                if(h.containsKey(a[j][i]))
                {
                    columns++;
                    break;
                }
                h.put(a[j][i],1);
            }
            }
            bw.write("Case #"+x+": "+trace+" "+rows+" "+columns+"\n");
            x++;
            
        }
        bw.flush();
    }
}
