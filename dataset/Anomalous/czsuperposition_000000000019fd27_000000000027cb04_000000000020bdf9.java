import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] results = new String[T];
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            String[] assignment = new String[N];
            Arrays.fill(assignment, "");
            
            boolean impossible = false;
            char[] schedule = new char[1441];
            Arrays.fill(schedule, ' ');
            
            for (int j = 0; j < N; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                if (isOverlapping(schedule, start, end)) {
                    impossible = true;
                    break;
                } else {
                    char assigned = assignActivity(schedule, start, end);
                    assignment[j] = String.valueOf(assigned);
                }
            }
            
            if (impossible) {
                results[i] = "IMPOSSIBLE";
            } else {
                results[i] = String.join("", assignment);
            }
        }
        
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
    
    private static boolean isOverlapping(char[] schedule, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (schedule[i] != ' ') {
                count++;
            }
        }
        return count > 1;
    }
    
    private static char assignActivity(char[] schedule, int start, int end) {
        boolean Cfree = true;
        boolean Jfree = true;
        
        for (int i = start; i < end; i++) {
            if (schedule[i] == 'C') {
                Cfree = false;
            }
            if (schedule[i] == 'J') {
                Jfree = false;
            }
        }
        
        char assigned;
        if (Cfree) {
            assigned = 'C';
            for (int i = start; i < end; i++) {
                schedule[i] = 'C';
            }
        } else {
            assigned = 'J';
            for (int i = start; i < end; i++) {
                schedule[i] = 'J';
            }
        }
        
        return assigned;
    }
}