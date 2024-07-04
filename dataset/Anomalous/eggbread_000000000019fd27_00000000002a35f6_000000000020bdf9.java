import java.util.Arrays;
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
            
            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
            
            boolean[] isOccupied = new boolean[2];
            int[] endTimes = new int[2];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            
            for (int j = 0; j < N; j++) {
                if (activities[j][0] >= endTimes[0]) {
                    isOccupied[0] = false;
                }
                if (activities[j][0] >= endTimes[1]) {
                    isOccupied[1] = false;
                }
                
                if (isOccupied[0] && isOccupied[1]) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                
                if (!isOccupied[0]) {
                    endTimes[0] = activities[j][1];
                    result.append('C');
                    isOccupied[0] = true;
                } else if (!isOccupied[1]) {
                    endTimes[1] = activities[j][1];
                    result.append('J');
                    isOccupied[1] = true;
                }
            }
            
            if (!impossible) {
                char[] output = new char[N];
                for (int j = 0; j < N; j++) {
                    output[activities[j][2]] = result.charAt(j);
                }
                System.out.println("Case #" + (i + 1) + ": " + new String(output));
            }
        }
        
        scanner.close();
    }
}