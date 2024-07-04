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
            ans[0] = 10;
            int k = 1;
            boolean flag = false;

            for (int i = 1; i < n; i++) {
                Set<Integer> assign = new HashSet<>(Arrays.asList(10, 11));
                for (int j = 0; j < k; j++) {
                    if ((S[i] < Earr[j] && S[i] >= Sarr[j]) || 
                        (E[i] <= Earr[j] && E[i] > Sarr[j]) || 
                        (S[i] >= Sarr[j] && E[i] <= Earr[j]) || 
                        (S[i] <= Sarr[j] && E[i] >= Earr[j])) {
                        
                        if (!assign.contains(ans[j])) {
                            flag = true;
                            break;
                        } else {
                            assign.remove(ans[j]);
                        }
                    }
                }
                if (flag || assign.isEmpty()) {
                    flag = true;
                    break;
                }
                Sarr[k] = S[i];
                Earr[k] = E[i];
                ans[k] = assign.iterator().next();
                k++;
            }
            if (flag) {
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
}