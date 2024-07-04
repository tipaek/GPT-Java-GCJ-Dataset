import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        
        for (int z = 1; z <= t1; z++) {
            StringBuilder output = new StringBuilder();
            int n = sc.nextInt();
            int[][] cameronActivities = new int[n][2];
            int[][] jamieActivities = new int[n][2];
            int cameronCount = 0, jamieCount = 0;
            boolean isPossible = true;
            
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                
                if (!isPossible) continue;
                
                boolean cameronConflict = false;
                for (int h = 0; h < cameronCount; h++) {
                    if ((cameronActivities[h][1] > start && cameronActivities[h][0] <= start) ||
                        (cameronActivities[h][1] >= end && cameronActivities[h][0] < end) ||
                        (start <= cameronActivities[h][0] && end >= cameronActivities[h][1])) {
                        cameronConflict = true;
                        break;
                    }
                }
                
                boolean jamieConflict = false;
                if (cameronConflict) {
                    for (int h = 0; h < jamieCount; h++) {
                        if ((jamieActivities[h][1] > start && jamieActivities[h][0] <= start) ||
                            (jamieActivities[h][1] >= end && jamieActivities[h][0] < end) ||
                            (start <= jamieActivities[h][0] && end >= jamieActivities[h][1])) {
                            jamieConflict = true;
                            break;
                        }
                    }
                }
                
                if (!cameronConflict) {
                    output.append('C');
                    cameronActivities[cameronCount][0] = start;
                    cameronActivities[cameronCount][1] = end;
                    cameronCount++;
                } else if (!jamieConflict) {
                    output.append('J');
                    jamieActivities[jamieCount][0] = start;
                    jamieActivities[jamieCount][1] = end;
                    jamieCount++;
                } else {
                    isPossible = false;
                }
            }
            
            System.out.println("Case #" + z + ": " + (isPossible ? output.toString() : "IMPOSSIBLE"));
        }
        
        sc.close();
    }
}