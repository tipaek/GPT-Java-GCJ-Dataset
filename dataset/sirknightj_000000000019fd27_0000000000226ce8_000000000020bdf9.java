import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String solution = "";
            int[][] timeSlots = new int[scanner.nextInt()][2];
            for (int j = 0; j < timeSlots.length; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt() - timeSlots[j][0];
            }
            Arrays.sort(timeSlots, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int jaime = 0;
            int cameron = 0;
            int position = 0;
            for (int time = 0; time < 1440; time++) {
                if (timeSlots[position][0] == time && jaime < 1) {
                    solution += "J";
                    jaime = timeSlots[position][1];
                    position++;
                } else if (timeSlots[position][0] == time && cameron < 1) {
                    solution += "C";
                    cameron = timeSlots[position][1];
                    position++;
                } else if (timeSlots[position][0] == time) {
                    solution = "IMPOSSIBLE";
                    break;
                }
                if (jaime > 0) {
                    jaime--;
                }
                if (cameron > 0) {
                    cameron--;
                }

                if (position == timeSlots.length) {
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }
}
  