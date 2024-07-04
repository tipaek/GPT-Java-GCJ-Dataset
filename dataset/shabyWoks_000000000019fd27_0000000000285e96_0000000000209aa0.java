import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int t=0; t<T; t++) {
            String[] nk = br.readLine().trim().split(" ");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);
            
            double f = K / (double)N;
            int sum = (N * (N + 1)) / 2;
            
            if (f == (int)f) {
                if ((int)f <= N) {
                    System.out.println("Case #"+ (t+1) +": POSSIBLE");    
                } else {
                    System.out.println("Case #"+ (t+1) +": IMPOSSIBLE");
                }
                
            } else if (sum == K) {
                if (N > 2) {
                    System.out.println("Case #"+ (t+1) +": POSSIBLE");
                } else {
                    System.out.println("Case #"+ (t+1) +": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #"+ (t+1) +": IMPOSSIBLE");
            }
            
        }
    }
}