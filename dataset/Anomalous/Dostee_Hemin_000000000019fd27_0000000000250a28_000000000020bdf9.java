import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int cs = 1; cs <= T; cs++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder();
            boolean isCameron = true;
            int previousEnd = 0;
            
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                
                if (start < previousEnd) {
                    isCameron = !isCameron;
                    
                    if (i > 1) {
                        int twoTasksAgoEnd = intervals[i - 2][1];
                        if (start < twoTasksAgoEnd && (schedule.charAt(i - 2) == 'C') == isCameron) {
                            schedule = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }

                if (isCameron) {
                    schedule.append("C");
                } else {
                    schedule.append("J");
                }

                previousEnd = end;
            }
            
            System.out.println("Case #" + cs + ": " + schedule.toString());
        }
        
        scanner.close();
    }
}