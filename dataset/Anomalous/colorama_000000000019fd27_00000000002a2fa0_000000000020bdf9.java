import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int[] C = new int[1440];
        int[] J = new int[1440];
        
        for (int i = 1; i <= T; i++) {
            int numAct = Integer.parseInt(br.readLine().trim());
            Arrays.fill(C, 0);
            Arrays.fill(J, 0);
            boolean isImpossible = false;
            char[] activities = new char[numAct];
            
            for (int j = 0; j < numAct; j++) {
                String[] times = br.readLine().trim().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                activities[j] = assignActivity(C, J, start, end);
                
                if (activities[j] == 'N') {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                } else if (activities[j] == 'C') {
                    Arrays.fill(C, start, end, 1);
                } else {
                    Arrays.fill(J, start, end, 1);
                }
            }
            
            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + new String(activities));
            }
        }
    }
    
    private static char assignActivity(int[] C, int[] J, int start, int end) {
        if (IntStream.range(start, end).anyMatch(idx -> C[idx] == 1)) {
            if (IntStream.range(start, end).anyMatch(idx -> J[idx] == 1)) {
                return 'N';
            } else {
                return 'J';
            }
        } else {
            return 'C';
        }
    }
}