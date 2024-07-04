import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = true;
                boolean canAssignJ = true;
                
                for (int k = start; k < end; k++) {
                    if (cSchedule[k]) {
                        canAssignC = false;
                        break;
                    }
                }
                
                if (canAssignC) {
                    for (int k = start; k < end; k++) {
                        cSchedule[k] = true;
                    }
                    result.append("C");
                } else {
                    for (int k = start; k < end; k++) {
                        if (jSchedule[k]) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    
                    if (canAssignJ) {
                        for (int k = start; k < end; k++) {
                            jSchedule[k] = true;
                        }
                        result.append("J");
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            
            if (!possible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }
}