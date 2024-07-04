import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] cameronSchedule = new int[n][2];
            int[][] jamieSchedule = new int[n][2];
            int cameronCount = 0, jamieCount = 0;
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                
                if (start == 1440) start = 0;
                if (end == 1440) end = 0;
                
                boolean cameronAvailable = true, jamieAvailable = true;

                for (int j = 0; j < cameronCount; j++) {
                    if ((cameronSchedule[j][1] > start && cameronSchedule[j][0] <= start) || 
                        (cameronSchedule[j][1] >= end && cameronSchedule[j][0] < end)) {
                        cameronAvailable = false;
                        break;
                    }
                }

                if (!cameronAvailable) {
                    for (int j = 0; j < jamieCount; j++) {
                        if ((jamieSchedule[j][1] > start && jamieSchedule[j][0] <= start) || 
                            (jamieSchedule[j][1] >= end && jamieSchedule[j][0] < end)) {
                            jamieAvailable = false;
                            break;
                        }
                    }
                }

                if (cameronAvailable) {
                    result.append('C');
                    cameronSchedule[cameronCount][0] = start;
                    cameronSchedule[cameronCount][1] = end;
                    cameronCount++;
                } else if (jamieAvailable) {
                    result.append('J');
                    jamieSchedule[jamieCount][0] = start;
                    jamieSchedule[jamieCount][1] = end;
                    jamieCount++;
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + (isPossible ? result.toString() : "IMPOSSIBLE"));
        }
    }
}