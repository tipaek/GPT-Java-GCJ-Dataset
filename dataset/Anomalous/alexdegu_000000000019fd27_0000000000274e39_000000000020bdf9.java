import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int[] cameron = new int[24 * 60];
            int[] jamie = new int[24 * 60];
            StringBuilder sb = new StringBuilder();
            boolean notValid = false;

            Arrays.fill(cameron, 24 * 60);
            Arrays.fill(jamie, 24 * 60);

            for (int i = 0; i < n; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                
                if (!notValid) {
                    if (cameron[startTime] >= endTime - startTime) {
                        assignTask(cameron, startTime, endTime);
                        sb.append("C");
                    } else if (jamie[startTime] >= endTime - startTime) {
                        assignTask(jamie, startTime, endTime);
                        sb.append("J");
                    } else {
                        notValid = true;
                    }
                }
            }
            
            String result = notValid ? "IMPOSSIBLE" : sb.toString();
            System.out.println("Case #" + k + ": " + result);
        }
    }

    private static void assignTask(int[] schedule, int startTime, int endTime) {
        int temp = startTime - 1;
        int br = 1;
        while (temp >= 0 && schedule[temp] > 0) {
            schedule[temp] = br;
            br++;
            temp--;
        }

        for (int j = startTime; j < endTime; j++) {
            schedule[j] = 0;
        }
    }
}