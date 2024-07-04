import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCaseCount = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = sc.nextInt();
            int[][] jTimes = new int[n][2];
            int[][] cTimes = new int[n][2];
            int jTop = 0, cTop = 0;
            StringBuilder result = new StringBuilder("J");
            
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                
                if (i == 0) {
                    jTimes[jTop][0] = start;
                    jTimes[jTop][1] = end;
                    jTop++;
                    continue;
                }
                
                boolean canAssignToJ = true;
                boolean canAssignToC = true;
                
                for (int[] time : jTimes) {
                    if (overlaps(start, end, time[0], time[1])) {
                        canAssignToJ = false;
                        break;
                    }
                }
                
                for (int[] time : cTimes) {
                    if (overlaps(start, end, time[0], time[1])) {
                        canAssignToC = false;
                        break;
                    }
                }
                
                if (!canAssignToJ && !canAssignToC) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else if (canAssignToC && !canAssignToJ) {
                    cTimes[cTop][0] = start;
                    cTimes[cTop][1] = end;
                    result.append("C");
                    cTop++;
                } else {
                    jTimes[jTop][0] = start;
                    jTimes[jTop][1] = end;
                    result.append("J");
                    jTop++;
                }
            }
            
            output.append("Case #").append(testCase).append(": ").append(result).append("\n");
        }
        
        System.out.print(output);
    }
    
    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}