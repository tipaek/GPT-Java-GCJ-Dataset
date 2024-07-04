import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int[][] timeSlots = new int[scanner.nextInt()][2];
            int[] original = new int[timeSlots.length];
            for (int j = 0; j < timeSlots.length; j++) {
                timeSlots[j][0] = scanner.nextInt();
                original[j] = timeSlots[j][0];
                timeSlots[j][1] = scanner.nextInt() - timeSlots[j][0];
            }
            Arrays.sort(timeSlots, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            List<String> solution = new ArrayList<>();
            String solutionS = "";
            int jaime = 0;
            int cameron = 0;
            int position = 0;
            for (int time = 0; time < 1440; time++) {
                if (timeSlots[position][0] == time && jaime < 1) {
                    solution.add("J");
                    jaime = timeSlots[position][1];
                    position++;
                } else if (timeSlots[position][0] == time && cameron < 1) {
                    solution.add("C");
                    cameron = timeSlots[position][1];
                    position++;
                } else if (timeSlots[position][0] == time) {
                    solutionS = "IMPOSSIBLE";
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
            if(solutionS.length() == 0) {
                for(int j = 0; j < original.length; j++) {
                    for(int k = 0; k < original.length; k++) {
                        if(original[j] == timeSlots[k][0]) {
                            solutionS += solution.get(k);
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solutionS);
        }
    }
}
  