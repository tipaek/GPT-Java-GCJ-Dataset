import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            
            boolean impossible = false;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                boolean cAvailable = true;
                boolean jAvailable = true;
                
                for (int k = start; k < end; k++) {
                    if (cSchedule[k]) {
                        cAvailable = false;
                        break;
                    }
                }
                
                if (cAvailable) {
                    for (int k = start; k < end; k++) {
                        cSchedule[k] = true;
                    }
                    result.append("C");
                } else {
                    for (int k = start; k < end; k++) {
                        if (jSchedule[k]) {
                            jAvailable = false;
                            break;
                        }
                    }
                    
                    if (jAvailable) {
                        for (int k = start; k < end; k++) {
                            jSchedule[k] = true;
                        }
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}