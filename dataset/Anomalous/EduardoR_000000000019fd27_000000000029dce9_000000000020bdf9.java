import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();
        
        for (int a = 0; a < tests; a++) {
            StringBuilder result = new StringBuilder();
            int N = input.nextInt();
            
            List<Integer> C = new ArrayList<>();
            List<Integer> J = new ArrayList<>();
            
            boolean isPossible = true;
            
            for (int b = 0; b < N; b++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                
                Set<Integer> cset = new HashSet<>(C);
                Set<Integer> jset = new HashSet<>(J);
                
                List<Integer> timeRange = new ArrayList<>();
                for (int i = start; i < finish; i++) {
                    timeRange.add(i);
                }
                
                cset.retainAll(timeRange);
                jset.retainAll(timeRange);
                
                if (cset.isEmpty()) {
                    C.addAll(timeRange);
                    result.append("C");
                } else if (jset.isEmpty()) {
                    J.addAll(timeRange);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + (a + 1) + ": " + result);
        }
    }
}