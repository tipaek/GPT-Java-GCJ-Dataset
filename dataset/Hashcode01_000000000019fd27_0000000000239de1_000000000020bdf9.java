import java.io.*;
import java.util.*;

public class Solution
{
    public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          public int compare(final int[] entry1, final int[] entry2) 
        { 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        }); 
    }
    
    public static void main(String[] args)throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int T = Integer.parseInt(br.readLine());
        int t = T;
        int temp,temp2,temp3;
        while(t-- > 0)
        {
            String fres = "";
            int N = Integer.parseInt(br.readLine());
            int time[][] = new int[N][3];
            for(int i=0;i<N;i++)
            {
                fres += " ";
                String a[] = br.readLine().split(" ");
                time[i][0] = Integer.parseInt(a[0]);
                time[i][1] = Integer.parseInt(a[1]);
                time[i][2] = i;
            }
            //sorting
            sortbyColumn(time, 0);
            int ce = time[0][1], je = 0;
            fres = fres.substring(0,time[0][2]) + "C" + fres.substring(time[0][2]+1);
            for(int i=1;i<N;i++)
            {
                if(time[i][0] >= ce)
                {
                    ce = time[i][1];
                    fres = fres.substring(0,time[i][2]) + "C" + fres.substring(time[i][2]+1);
                }
                else if(time[i][0] >= je)
                {
                    je = time[i][1];
                    fres = fres.substring(0,time[i][2]) + "J" + fres.substring(time[i][2]+1);
                }
                else 
                {
                    fres = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+(T-t)+": "+fres);
        }
        br.close();
        isr.close();
    }
}