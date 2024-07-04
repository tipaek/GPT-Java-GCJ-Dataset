//package ParentingPartneringReturns;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for (int t = 0; t < T; t++) {
            
            final int N = sc.nextInt();
            
            int c = 0;
            int j = 0;
            
            Block[] blocks = new Block[N];
            
            for (int n = 0; n < N; n++) {
                
                int s = sc.nextInt();
                int e = sc.nextInt();
                
                blocks[n] = new Block(s, e, n);
            }
            
            Arrays.sort(blocks);
            
            char[] res = new char[N];
            boolean err = false;
            for (int n = 0; n < N; n++) {
                
                int s = blocks[n].start;
                int e = blocks[n].end;
                int i = blocks[n].ind;
                
                if (err = (s < c && s < j)) {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", t + 1);
                    break;
                } else if (s < c) { // must choose J
                    res[i] = 'J';
                    j = e;
                } else if (s < j) { // must choose C
                    res[i] = 'C';
                    c = e;
                } else { // can choose either
                    
                    if (c - s < j - s) { // choose C
                        res[i] = 'C';
                        c = e;
                    } else {
                        res[i] = 'J';
                        j = e;
                    }
                }
            }
    
            if (!err) {
                System.out.printf("Case #%d: %s\n", t + 1, new String(res));
            }
        }
    }
    
    static class Block implements Comparable<Block> {
        
        int start, end, ind;
        
        public Block(int s, int e, int i) {
            
            this.start = s;
            this.end = e;
            this.ind = i;
        }
        
        @Override
        public int compareTo(Block b) {
            
            return start - b.start;
        }
    }
}
