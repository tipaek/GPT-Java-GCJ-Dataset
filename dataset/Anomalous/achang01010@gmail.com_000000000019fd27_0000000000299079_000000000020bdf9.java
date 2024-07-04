import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt(); 
        
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();
            boolean[] cameronSchedule = new boolean[1440];
            boolean[] jamieSchedule = new boolean[1440];
            
            int numEvents = sc.nextInt();
            int[][] events = new int[numEvents][2];
            
            for (int i = 0; i < numEvents; i++) {
                events[i][0] = sc.nextInt();
                events[i][1] = sc.nextInt();
            }
            
            for (int[] event : events) {
                int start = event[0];
                int end = event[1];
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;
                
                for (int time = start; time < end; time++) {
                    if (cameronSchedule[time]) {
                        cameronAvailable = false;
                        break;
                    }
                }
                
                if (cameronAvailable) {
                    schedule.append("C");
                    for (int time = start; time < end; time++) {
                        cameronSchedule[time] = true;
                    }
                } else {
                    for (int time = start; time < end; time++) {
                        if (jamieSchedule[time]) {
                            jamieAvailable = false;
                            break;
                        }
                    }
                    
                    if (jamieAvailable) {
                        schedule.append("J");
                        for (int time = start; time < end; time++) {
                            jamieSchedule[time] = true;
                        }
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": " + schedule.toString());
            }
        }
    }
}