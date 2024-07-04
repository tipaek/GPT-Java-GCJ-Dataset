import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int z = 0; z < t; z++) {
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            char[] assigned = new char[n];
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
                char currentAssignment = 'C';
                boolean conflictFound = false;
                
                for (int j = 0; j < i; j++) {
                    if ((start[i] < end[j] && start[i] >= start[j]) || 
                        (end[i] <= end[j] && end[i] > start[j]) || 
                        (start[i] == start[j])) {
                        
                        if (!conflictFound) {
                            currentAssignment = assigned[j] == 'C' ? 'J' : 'C';
                            conflictFound = true;
                        } else if (assigned[j] != currentAssignment) {
                            isPossible = false;
                            break;
                        }
                    }
                }
                
                if (!isPossible) {
                    break;
                }
                
                result.append(currentAssignment);
                assigned[i] = currentAssignment;
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (z + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (z + 1) + ": " + result.toString());
            }
        }
        
        scanner.close();
    }
}