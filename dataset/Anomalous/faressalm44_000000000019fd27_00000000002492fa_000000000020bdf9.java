import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static class Time {
        int start;
        int end;
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        String[] results = new String[T];
        
        for (int i = 0; i < T; i++) {
            results[i] = scheduleElevator(i + 1);
        }
        
        for (int i = 0; i < T; i++) {
            System.out.print(results[i]);
            if (i != T - 1) {
                System.out.println();
            }
        }
    }

    public static String scheduleElevator(int testOrder) {
        int N = scanner.nextInt();
        Time[] times = new Time[N];
        
        for (int i = 0; i < N; i++) {
            times[i] = new Time();
            times[i].start = scanner.nextInt();
            times[i].end = scanner.nextInt();
        }
        
        StringBuilder result = new StringBuilder("Case #").append(testOrder).append(": ");
        List<Time> cameronSchedule = new ArrayList<>();
        List<Time> jamieSchedule = new ArrayList<>();
        
        cameronSchedule.add(times[0]);
        result.append('C');
        boolean isPossible = true;
        char lastAssigned = 'C';
        
        for (int i = 1; i < N; i++) {
            boolean canAssignToCameron = true;
            boolean canAssignToJamie = true;
            
            if (times[i].start < times[i - 1].end) {
                if (lastAssigned == 'C') {
                    for (Time t : jamieSchedule) {
                        if (times[i].start < t.end && times[i].end > t.start) {
                            canAssignToJamie = false;
                            break;
                        }
                    }
                    if (canAssignToJamie) {
                        jamieSchedule.add(times[i]);
                        lastAssigned = 'J';
                        result.append('J');
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    for (Time t : cameronSchedule) {
                        if (times[i].start < t.end && times[i].end > t.start) {
                            canAssignToCameron = false;
                            break;
                        }
                    }
                    if (canAssignToCameron) {
                        cameronSchedule.add(times[i]);
                        lastAssigned = 'C';
                        result.append('C');
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            } else {
                if (lastAssigned == 'C') {
                    cameronSchedule.add(times[i]);
                    result.append('C');
                } else {
                    jamieSchedule.add(times[i]);
                    result.append('J');
                }
            }
        }
        
        return isPossible ? result.toString() : "Case #" + testOrder + ": IMPOSSIBLE";
    }
}