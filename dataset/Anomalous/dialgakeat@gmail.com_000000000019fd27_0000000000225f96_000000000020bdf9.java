import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = scanner.nextInt();
            boolean impossible = false;
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = true;
                boolean canAssignJ = true;
                
                for (int time = start; time < end; time++) {
                    if (cSchedule[time]) {
                        canAssignC = false;
                        break;
                    }
                }
                
                if (canAssignC) {
                    for (int time = start; time < end; time++) {
                        cSchedule[time] = true;
                    }
                    result.append('C');
                } else {
                    for (int time = start; time < end; time++) {
                        if (jSchedule[time]) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    if (canAssignJ) {
                        for (int time = start; time < end; time++) {
                            jSchedule[time] = true;
                        }
                        result.append('J');
                    } else {
                        impossible = true;
                    }
                }
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            if (impossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                System.out.print(result.toString());
            }
            System.out.println();
        }
    }
}