import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int numberOfEvents = scanner.nextInt();
            int[][] cameronSchedule = new int[numberOfEvents][2];
            int[][] jamieSchedule = new int[numberOfEvents][2];
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            
            for (int event = 0; event < numberOfEvents; event++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (event == 0) {
                    cameronSchedule[0][0] = start;
                    cameronSchedule[0][1] = end;
                    result.append('C');
                } else {
                    boolean canAssignToCameron = true;
                    boolean canAssignToJamie = true;
                    
                    for (int i = 0; i < event; i++) {
                        if (isOverlapping(cameronSchedule[i], start, end)) {
                            canAssignToCameron = false;
                        }
                        if (isOverlapping(jamieSchedule[i], start, end)) {
                            canAssignToJamie = false;
                        }
                    }
                    
                    if (canAssignToCameron) {
                        cameronSchedule[event][0] = start;
                        cameronSchedule[event][1] = end;
                        result.append('C');
                    } else if (canAssignToJamie) {
                        jamieSchedule[event][0] = start;
                        jamieSchedule[event][1] = end;
                        result.append('J');
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            System.out.print("Case #" + (t + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result.toString());
            }
        }
        
        scanner.close();
    }
    
    private static boolean isOverlapping(int[] schedule, int start, int end) {
        return (schedule[0] < start && start < schedule[1]) ||
               (schedule[0] < end && end < schedule[1]) ||
               (start <= schedule[0] && end >= schedule[1]) ||
               (start == schedule[0] || end == schedule[1]);
    }
}