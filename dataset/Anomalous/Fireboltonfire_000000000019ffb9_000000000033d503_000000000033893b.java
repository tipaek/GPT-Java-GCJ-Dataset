import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int k = in.nextInt();
            int q = in.nextInt();
            String p = in.next();
            
            int[] lisp = new int[k];
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < k; j++) {
                if (p.charAt(j) == '(') {
                    stack.push(j);
                } else {
                    int openIndex = stack.pop();
                    lisp[openIndex] = j;
                    lisp[j] = openIndex;
                }
            }

            // Skip the next k integers as they are not used
            for (int j = 0; j < k; j++) {
                in.nextInt();
            }
            
            long res = 0L;
            int[] s = new int[q];
            int[] e = new int[q];
            for (int j = 0; j < q; j++) {
                s[j] = in.nextInt() - 1;   
            }
            for (int j = 0; j < q; j++) {
                e[j] = in.nextInt() - 1;   
            }
            for (int j = 0; j < q; j++) {
                res += calculateCost(lisp, s[j], e[j]);
            }
            System.out.println("Case #" + i + ": " + res);
        }
        in.close();
    }
    
    private static int calculateCost(int[] lisp, int s, int e) {
        int left = Math.min(s, e);
        int right = Math.max(s, e);
        int cost = 0;
        
        while (left != e && right != e) {
            List<Integer> nextPositions = new ArrayList<>();
            if (left != Integer.MIN_VALUE) {
                nextPositions.add(left + 1);
                nextPositions.add(lisp[left]);
            }
            if (right != Integer.MAX_VALUE) {
                nextPositions.add(right - 1);
                nextPositions.add(lisp[right]);
            }
            
            left = Integer.MIN_VALUE;
            right = Integer.MAX_VALUE;
            for (Integer pos : nextPositions) {
                if (pos <= e) {
                    left = Math.max(left, pos);
                } else {
                    right = Math.min(right, pos);
                }
            }
            cost++;
        }
        return cost;
    }
}