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
            
            // Sort intervals by start times
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (S[j] > S[j + 1]) {
                        swap(S, j, j + 1);
                        swap(E, j, j + 1);
                    }
                }
            }
            
            Sarr[0] = S[0];
            Earr[0] = E[0];
            ans[0] = 10; // Assign first task to 'C'
            int k = 1;
            boolean flag = false;
            
            for (int i = 1; i < n; i++) {
                List<Integer> assign = new ArrayList<>(Arrays.asList(10, 11)); // 10 for 'C' and 11 for 'J'
                
                for (int j = 0; j < k; j++) {
                    if (overlaps(S[i], E[i], Sarr[j], Earr[j])) {
                        int assignedPerson = ans[j];
                        
                        if (assign.contains(assignedPerson)) {
                            assign.remove((Integer) assignedPerson);
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
                
                if (flag || assign.isEmpty()) {
                    flag = true;
                    break;
                }
                
                Sarr[k] = S[i];
                Earr[k] = E[i];
                ans[k] = assign.get(0);
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
        
        in.close();
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static boolean overlaps(int S1, int E1, int S2, int E2) {
        return (S1 < E2 && S1 >= S2) || (E1 <= E2 && E1 > S2) || (S1 >= S2 && E1 <= E2) || (S1 <= S2 && E1 >= E2);
    }
}