import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int rr = 0; rr < t; rr++) {
            int n = in.nextInt();
            int[] S = new int[n];
            int[] E = new int[n];
            
            for (int i = 0; i < n; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }
            
            int[] Sarr = new int[n];
            int[] Earr = new int[n];
            int[] ans = new int[n];
            
            Sarr[0] = S[0];
            Earr[0] = E[0];
            ans[0] = 10; // Assign 'C' initially
            int k = 1;
            boolean isImpossible = false;
            
            for (int i = 1; i < n; i++) {
                Set<Integer> available = new HashSet<>(Arrays.asList(10, 11)); // 10 for 'C', 11 for 'J'
                
                for (int j = 0; j < k; j++) {
                    if (overlaps(S[i], E[i], Sarr[j], Earr[j])) {
                        available.remove(ans[j]);
                    }
                }
                
                if (available.isEmpty()) {
                    isImpossible = true;
                    break;
                }
                
                Sarr[k] = S[i];
                Earr[k] = E[i];
                ans[k] = available.iterator().next();
                k++;
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (rr + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (rr + 1) + ": ");
                for (int i = 0; i < k; i++) {
                    System.out.print(ans[i] == 10 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }

    private static boolean overlaps(int S1, int E1, int S2, int E2) {
        return (S1 < E2 && S1 >= S2) || (E1 <= E2 && E1 > S2) || (S1 >= S2 && E1 <= E2) || (S1 <= S2 && E1 >= E2);
    }
}