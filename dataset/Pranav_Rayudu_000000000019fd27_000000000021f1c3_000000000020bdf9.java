//package ParentingPartneringReturns;

import java.util.ArrayList;
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
    
                blocks[n] = new Block(s, e);
            }
    
            Arrays.sort(blocks);
            
            StringBuilder res = new StringBuilder();
            
            for (int n = 0; n < N; n++) {
                
                int s = blocks[n].start;
                int e = blocks[n].end;
                
                if (s < c && s < j) {
                    res.setLength(0);
                    res.append("IMPOSSIBLE");
                    break;
                } else if (s < c && s >= j) { // must choose J
                    res.append('J');
                    j = e;
                } else if (s >= c && s < j) { // must choose C
                    res.append('C');
                    c = e;
                } else { // can choose either
                    
                    if (c - s < j - s) { // choose C
                        res.append('C');
                        c = e;
                    } else {
                        res.append('J');
                        j = e;
                    }
                }
            }
            
            System.out.printf("Case #%d: %s\n", t + 1, res.toString());
        }
    }
    
    static class Block implements Comparable<Block> {
    
        int start, end;
        
        public Block(int s, int e) {
            this.start = s;
            this.end = e;
        }
        
        @Override
        public int compareTo(Block b) {
        
            return start - b.start;
        }
    }
}
