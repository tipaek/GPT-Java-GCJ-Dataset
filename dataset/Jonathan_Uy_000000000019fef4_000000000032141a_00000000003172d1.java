import java.io.*;
import java.util.*;

public class Solution {
    static long[] A;
    
    public static boolean exists(long x){
        int lo = 0; int hi = A.length - 1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(A[mid] == x)     return true;
            else if(A[mid] < x) lo = mid+1;
            else                hi = mid-1;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int ans = D-1;
            
            A = new long[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                A[i] = Long.parseLong(st.nextToken());
            Arrays.sort(A);
            
            if(D == 2){
                for(int i = 0; i < N-1; i++)
                    if(A[i] == A[i+1])
                        ans = 0;
            } else if(D == 3){
                for(long x : A)
                    if(exists(2 * x))
                        ans = 1;
                
                for(int i = 0; i < N-2; i++){
                    if(A[i] == A[i+1])
                        ans = Math.min(ans, 1);
                    if(A[i] == A[i+1] && A[i+1] == A[i+2])
                        ans = Math.min(ans, 0);
                }
            }
            
            System.out.printf("Case #%d: %d\n", t, ans);
        }
    }
}