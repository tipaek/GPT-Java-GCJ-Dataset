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
        String res = "";
        int temp,temp2,temp3;
        while(t-- > 0)
        {
            res = "";
            String fres = "";
            int N = Integer.parseInt(br.readLine());
            int time[][] = new int[3][N];
            for(int i=0;i<N;i++)
            {
                fres += " ";
                String a[] = br.readLine().split(" ");
                time[0][i] = Integer.parseInt(a[0]);
                time[1][i] = Integer.parseInt(a[1]);
                time[2][i] = i;
            }
            //sorting
            for (int i = 0; i < N-1; i++)      
                for (int j = 0; j < N-i-1; j++)  
                    if (time[0][j] > time[0][j+1]) 
                    {
                        temp = time[0][j];
                        temp2 = time[1][j];
                        temp3 = time[2][j];
                        time[0][j] = time[0][j+1];
                        time[1][j] = time[1][j+1];
                        time[2][j] = time[2][j+1];
                        time[0][j+1] = temp;
                        time[1][j+1] = temp2;
                        time[2][j+1] = temp3;
                    }
            int ce = time[1][0], je = 0;
            res += "C";
            for(int i=1;i<N;i++)
            {
                if(time[0][i] >= ce)
                {
                    ce = time[1][i];
                    res += "C";
                }
                else if(time[0][i] >= je)
                {
                    je = time[1][i];
                    res += "J";
                }
                else 
                {
                    res = "IMPOSSIBLE";
                    break;
                }
            }
            for(int i=0;i<N;i++)
            {
                fres = fres.substring(0,time[2][i]) + res.charAt(i) + fres.substring(time[2][i]+1);
            }
            if(res == "IMPOSSIBLE")
                fres = "IMPOSSIBLE";
            System.out.println("Case #"+(T-t)+": "+fres);
        }
        br.close();
        isr.close();
    }
}