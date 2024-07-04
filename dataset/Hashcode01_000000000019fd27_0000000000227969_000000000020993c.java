import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int T = Integer.parseInt(br.readLine());
        int t = T;
        while(t-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][N];
            int trace = 0;
            int r = 0, c = 0;
            Set<Integer> chk = new HashSet<Integer>();
            for(int i=0;i<N;i++)
            {
            	String a[] = br.readLine().split(" ");
                for(int j=0;j<N;j++)
                {
                    arr[i][j] = Integer.parseInt(a[j]);
                    chk.add(arr[i][j]);
                    if(i == j)
                        trace += arr[i][j];
                }
                r += (N == chk.size()?0:1);
                chk.clear();
            }
            chk.clear();
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    chk.add(arr[j][i]);
                }
                c += (N == chk.size()?0:1);
                chk.clear();
            }
            System.out.println("Case #"+(T-t)+": "+trace+" "+r+" "+c);
        }
        br.close();
        isr.close();
    }
}