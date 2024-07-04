import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= T; i++) {
            int numAct = Integer.parseInt(br.readLine().trim());
            int[] C = new int[1440];
            int[] J = new int[1440];
            boolean impossible = false;
            char[] activities = new char[numAct];
            
            for (int j = 0; j < numAct; j++) {
                String[] times = br.readLine().trim().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                
                activities[j] = assignActivity(C, J, start, end);
                
                if (activities[j] == 'N') {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                } else if (activities[j] == 'C') {
                    Arrays.fill(C, start, end, 1);
                } else {
                    Arrays.fill(J, start, end, 1);
                }
            }
            
            if (!impossible) {
                System.out.println("Case #" + i + ": " + new String(activities));
            }
        }
    }

    private static char assignActivity(int[] C, int[] J, int start, int end) {
        boolean cAvailable = isAvailable(C, start, end);
        boolean jAvailable = isAvailable(J, start, end);
        
        if (cAvailable) {
            return 'C';
        } else if (jAvailable) {
            return 'J';
        } else {
            return 'N';
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }
}