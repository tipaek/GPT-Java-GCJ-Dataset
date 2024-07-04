import java.util.*;
import java.io.*;

public class Solution {
    public static void solve(int ks, int N, int D, long [] A) {
        int cut =0;
        Arrays.sort(A);
        long tooBig = N>D ? A[A.length -D]: A[0];
        HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
        long mode = A[0];
        int modeCount=1;
        for(int i = 0; i < A.length; i++) {
            if (hm.get(A[i]) != null) {
                int count = hm.get(A[i]);
                count++;
                hm.put(A[i], count);
                if(count>modeCount && A[i]<tooBig){
                    mode = A[i];
                    modeCount = count;
                }
            }
            else
                hm.put(A[i],1);
        }
        cut = D > modeCount ? D-modeCount: 0;
        if(hm.getOrDefault(mode+mode, -1) >0 && cut>1) cut--;
        System.out.println("Case #" + ks + ": " + cut);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int D = input.nextInt();
            long [] A = new long[N];
            for(int i=0; i<N; i++) {
                A[i] = input.nextLong();
            }

            solve(ks, N, D, A);
        }
    }
}
