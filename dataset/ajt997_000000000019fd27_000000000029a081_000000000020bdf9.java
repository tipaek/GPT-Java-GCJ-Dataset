import java.util.*;
import java.io.*;

public class Solution {
    
    static class CostPair {
        public int first;
        public int second;
        public int orig;
        public CostPair(int f, int s, int o) {
            first = f;
            second = s;
            orig = o;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(f.readLine());
            
            CostPair[] cp = new CostPair[N];
            for(int j = 0; j < N; j++) {
                StringTokenizer p = new StringTokenizer(f.readLine());
                cp[j] = new CostPair(Integer.parseInt(p.nextToken()), Integer.parseInt(p.nextToken()), j);
            }
            
            Arrays.sort(cp, (CostPair o1, CostPair o2) -> {
                if(o1.first > o2.first) {
                    return 1;
                }
                else if(o1.first < o2.first) {
                    return -1;
                }
                else {
                    return o1.second - o2.second;
                }
            });
            
            StringBuilder sb = new StringBuilder();
            int occupiedtillc = -1;
            int occupiedtillr = -1;
            boolean broken = false;
            boolean[] isr = new boolean[N];
            for(int j = 0; j < N; j++) {
                if(cp[j].first >= occupiedtillc) {
                    occupiedtillc = cp[j].second;
                }
                else if(cp[j].first >= occupiedtillr) {
                    isr[j] = true;
                    occupiedtillr = cp[j].second;
                }
                else {
                    broken = true;
                    break;
                }
            }
            
            // System.out.println(Arrays.toString(isr));
            
            char[] ch = new char[N];
            for(int j = 0; j < N; j++) {
                if(isr[j]) {
                    ch[cp[j].orig] = 'J';
                }
                else {
                    ch[cp[j].orig] = 'C';
                }
            }
            
            if(broken) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + (i + 1) + ": " + new String(ch));
            }
            
        }
    }
}