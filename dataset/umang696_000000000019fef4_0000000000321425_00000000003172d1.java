import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int t0 = 1; t0 <= t; t0++)
        {
            String s1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int d = Integer.parseInt(s1[1]);
            String s2[] = br.readLine().trim().split(" ");
            long a[] = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = Long.parseLong(s2[i]);
            Arrays.sort(a);
            int cnt = 1;
            int max = 1;
            long el = a[0];
            
            for(int i = 1; i < n; i++)
            {
                if(a[i] == a[i-1])
                    cnt++;
                else
                    cnt = 1;
                if(max < cnt)
                {
                    max = cnt;
                    el = a[i];
                }
                
            }
            if(max >= d)
            {
                bw.write("Case #"+t0+": "+0+"\n");
                continue;
            }
            if(d == 2)
            {
                bw.write("Case #"+t0+": "+1+"\n");
                continue;
            }
            if(max == 2 && d == 3)
            {
                if(ceilSearch(a,0,n-1,el+1) != -1)
                {
                    bw.write("Case #"+t0+": "+1+"\n");
                    continue;
                }
            }
            boolean f = false;
            for(int i = 0; i < n; i++)
                if(Arrays.binarySearch(a,a[i]*2) > 0)
                    f = true;
            if(f)
                bw.write("Case #"+t0+": "+1+"\n");
            else
                bw.write("Case #"+t0+": "+2+"\n");
        }
	    bw.flush();
    }
    static int ceilSearch(long arr[], int low, int high, long x) 
    { 
      int i;     
       
      /* If x is smaller than or equal to first  
         element,then return the first element */
      if(x <= arr[low]) 
        return low;   
       
      /* Otherwise, linearly search for ceil value */
      for(i = low; i < high; i++) 
      { 
        if(arr[i] == x) 
          return i; 
       
        /* if x lies between arr[i] and arr[i+1]  
        including arr[i+1], then return arr[i+1] */
        if(arr[i] < x && arr[i+1] >= x) 
           return i+1; 
      }          
       
      /* If we reach here then x is greater than the  
      last element of the array,  return -1 in this case */
      return -1; 
    } 
}