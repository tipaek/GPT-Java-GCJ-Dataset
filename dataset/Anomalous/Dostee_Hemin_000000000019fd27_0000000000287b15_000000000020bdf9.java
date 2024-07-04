import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder();
            boolean assignToC = true;
            boolean impossible = false;
            int lastEndTime = 0;
            
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                
                if (start < lastEndTime) {
                    assignToC = !assignToC;
                    int overlapCount = 1;
                    
                    for (int j = i - 2; j >= 0; j--) {
                        char expectedChar = assignToC ? 'C' : 'J';
                        
                        if (isOverlapping(start, end, intervals[j][0], intervals[j][1]) && schedule.charAt(j) == expectedChar) {
                            overlapCount++;
                        }
                        
                        if (overlapCount > 1) {
                            schedule = new StringBuilder("IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                    }
                }
                
                if (impossible) {
                    break;
                }
                
                schedule.append(assignToC ? 'C' : 'J');
                lastEndTime = end;
            }
            
            System.out.println("Case #" + t + ": " + schedule);
        }
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return start1 < end2 && end1 > start2;
    }
}