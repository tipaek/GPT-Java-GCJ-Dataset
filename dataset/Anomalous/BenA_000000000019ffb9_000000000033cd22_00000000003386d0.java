import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numHoles = Integer.parseInt(scanner.nextLine());
            int[][] holes = new int[numHoles][2];

            for (int i = 0; i < numHoles; i++) {
                String[] coordinates = scanner.nextLine().split(" ");
                holes[i][0] = Integer.parseInt(coordinates[0]);
                holes[i][1] = Integer.parseInt(coordinates[1]);
            }

            int result = calculateMaxHoles(holes);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    public static int calculateMaxHoles(int[][] holes) {
        Map<Double, Integer> slopeCountMap = new HashMap<>();
        int maxHoles = 0;

        for (int i = 0; i < holes.length; i++) {
            Map<Double, Boolean> currentSlopes = new HashMap<>();

            for (int j = 0; j < holes.length; j++) {
                if (i == j) continue;

                double slope = (holes[i][0] == holes[j][0]) ? Double.POSITIVE_INFINITY :
                        (double) (holes[j][1] - holes[i][1]) / (holes[j][0] - holes[i][0]);

                if (!currentSlopes.containsKey(slope) || currentSlopes.get(slope)) {
                    slopeCountMap.putIfAbsent(slope, 0);

                    if (j < i) {
                        currentSlopes.put(slope, true);
                    } else {
                        currentSlopes.put(slope, false);
                        slopeCountMap.put(slope, slopeCountMap.get(slope) + 2);
                    }
                } else {
                    slopeCountMap.put(slope, slopeCountMap.get(slope) - 1);
                }
            }
        }

        for (int count : slopeCountMap.values()) {
            maxHoles = Math.max(maxHoles, count);
        }

        return Math.min(maxHoles + 2, holes.length);
    }
}