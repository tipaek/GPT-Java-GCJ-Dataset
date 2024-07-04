import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] activities = new int[n][4];
            
            for (int j = 0; j < n; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                activities[j][0] = Integer.parseInt(tokenizer.nextToken());
                activities[j][1] = Integer.parseInt(tokenizer.nextToken());
                activities[j][2] = j;
            }
            
            Arrays.sort(activities, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            });
            
            int cEnd = 0;
            int jEnd = 0;
            boolean isPossible = true;
            
            for (int j = 0; j < n; j++) {
                if (cEnd <= activities[j][0]) {
                    cEnd = activities[j][1];
                    activities[j][3] = 0;
                } else if (jEnd <= activities[j][0]) {
                    jEnd = activities[j][1];
                    activities[j][3] = 1;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (i + 1) + ": ");
                Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));
                for (int j = 0; j < n; j++) {
                    System.out.print(activities[j][3] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
        
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
    }
}