import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for (int x = 0; x < t; x++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] timeSlots = new int[n][3];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().trim().split(" ");
                timeSlots[i][0] = Integer.parseInt(input[0]);
                timeSlots[i][1] = Integer.parseInt(input[1]);
                timeSlots[i][2] = i;
            }

            Arrays.sort(timeSlots, Comparator.comparingInt(a -> a[0]));

            int endCameron = 0, endJamie = 0;
            char[] schedule = new char[n];
            boolean isImpossible = false;

            for (int[] slot : timeSlots) {
                if (endCameron <= slot[0]) {
                    endCameron = slot[1];
                    schedule[slot[2]] = 'C';
                } else if (endJamie <= slot[0]) {
                    endJamie = slot[1];
                    schedule[slot[2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + (x + 1) + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(schedule));
            }
        }
    }
}