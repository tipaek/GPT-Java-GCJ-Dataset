import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][3];
            
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            boolean[] occupied = new boolean[2];
            int[] endTimes = new int[2];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            
            for (int j = 0; j < N; j++) {
                int start = activities[j][0];
                int end = activities[j][1];
                
                if (start >= endTimes[0]) {
                    occupied[0] = false;
                }
                if (start >= endTimes[1]) {
                    occupied[1] = false;
                }
                
                if (occupied[0] && occupied[1]) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                
                if (!occupied[0]) {
                    endTimes[0] = end;
                    result.append('C');
                    occupied[0] = true;
                } else {
                    endTimes[1] = end;
                    result.append('J');
                    occupied[1] = true;
                }
            }
            
            if (!impossible) {
                char[] schedule = new char[N];
                for (int j = 0; j < N; j++) {
                    schedule[activities[j][2]] = result.charAt(j);
                }
                System.out.println("Case #" + (i + 1) + ": " + new String(schedule));
            }
        }
        
        scanner.close();
    }
}