import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            int[] J = new int[1440];
            int[] C = new int[1440];
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
                intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
            }
            
            for (int i = 0; i < 1440; i++) {
                J[i] = 0;
                C[i] = 0;
            }
            
            boolean isPossible = true;
            
            for (int i = 0; i < n; i++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;
                
                for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                    if (C[j] != 0) {
                        canAssignC = false;
                        break;
                    }
                }
                
                if (canAssignC) {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        C[j] = 1;
                    }
                    result.append('C');
                } else {
                    for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                        if (J[j] != 0) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    
                    if (canAssignJ) {
                        for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                            J[j] = 1;
                        }
                        result.append('J');
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }
            
            System.out.print("Case #" + caseNumber + ": " + result);
            if (caseNumber != testCases) {
                System.out.println();
            }
        }
        
        scanner.close();
    }
}