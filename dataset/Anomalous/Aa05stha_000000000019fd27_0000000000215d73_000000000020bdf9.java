import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            Set<Integer> cameron = new HashSet<>();
            Set<Integer> jamie = new HashSet<>();
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            int n = scanner.nextInt();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isAvailable(jamie, start, end)) {
                    schedule.append("J");
                    addToSet(jamie, start, end);
                } else if (isAvailable(cameron, start, end)) {
                    schedule.append("C");
                    addToSet(cameron, start, end);
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + t + ": " + schedule);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
    
    private static boolean isAvailable(Set<Integer> set, int start, int end) {
        for (int i = start; i < end; i++) {
            if (set.contains(i)) {
                return false;
            }
        }
        return true;
    }
    
    private static void addToSet(Set<Integer> set, int start, int end) {
        for (int i = start; i < end; i++) {
            set.add(i);
        }
    }
}