import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int[][] timeSlots = new int[Integer.parseInt(scanner.nextLine())][2];
            int[] original = new int[timeSlots.length];
            for (int j = 0; j < timeSlots.length; j++) {
                String nextLine = scanner.nextLine();
                String[] split = nextLine.split(" ");
                timeSlots[j][0] = Integer.parseInt(split[0]);
                original[j] = timeSlots[j][0];
                timeSlots[j][1] = Integer.parseInt(split[1]) - timeSlots[j][0];
            }
            Arrays.sort(timeSlots, Comparator.comparingInt(o -> o[0]));
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
                    for(int k = 0; k < solution.size(); k++) {
                        if(original[j] == timeSlots[k][0]) {
                            solutionS += solution.get(k);
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solutionS);
        }
    }
}
  