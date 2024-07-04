import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int trial = 1; trial <= t; trial++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long L = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long diff = Math.abs(L-R);
            long start = (long)Math.sqrt(diff*2);
            long[] ans = new long[3];
            if(start*(start+1) > diff*2)
                start--;
            if(L >= R)
                L-=start*(start+1)/2;
            else
                R-=start*(start+1)/2;
            if(L >= R){
                long l = 0, r = (long)Math.sqrt(R), m = 0; 
                while (l <= r) { 
                    m = l + (r - l) / 2;
                    if (start*m + m*(m+1) == R) 
                        break;
                    if (start*m + m*(m+1) < R) 
                        l = m + 1; 
                    else
                        r = m - 1; 
                }
                if(start*m + m*(m+1) > R)
                    m--;
                ans[0] = start + 2*m;
                ans[1] = L - start*m - m*m;
                ans[2] = R - start*m - m*(m+1);
                if(ans[1] >= start + 2*m+1){
                    ans[0]++;
                    ans[1] -= start + 2*m+1;
                }
            }
            else{
                long l = 0, r = (long)Math.sqrt(L), m = 0; 
                while (l <= r) { 
                    m = l + (r - l) / 2;
                    if (start*m + m*(m+1) == L) 
                        break;
                    if (start*m + m*(m+1) < L) 
                        l = m + 1; 
                    else
                        r = m - 1; 
                }
                if(start*m + m*(m+1) > L)
                    m--;
                ans[0] = start + 2*m;
                ans[1] = L - start*m - m*(m+1);
                ans[2] = R - start*m - m*m;
                if(ans[2] >= start + 2*m+1){
                    ans[0]++;
                    ans[2] -= start + 2*m+1;
                }
            }
            System.out.println("Case #" + trial + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
}