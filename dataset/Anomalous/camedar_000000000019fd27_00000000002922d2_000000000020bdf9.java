import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int[] cameron = new int[2];
            int[] jamie = new int[2];
            StringBuilder schedule = new StringBuilder();
            int activities = scanner.nextInt();
            scanner.nextLine();
            
            boolean possible = true;
            
            for (int activity = 0; activity < activities; activity++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                
                if ((cameron[0] == 0 && cameron[1] == 0) || cameron[1] <= start || cameron[0] >= end) {
                    cameron[0] = start;
                    cameron[1] = end;
                    schedule.append("C");
                } else if ((jamie[0] == 0 && jamie[1] == 0) || jamie[1] <= start || jamie[0] >= end) {
                    jamie[0] = start;
                    jamie[1] = end;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNum + ": " + schedule);
        }
        
        scanner.close();
    }
}