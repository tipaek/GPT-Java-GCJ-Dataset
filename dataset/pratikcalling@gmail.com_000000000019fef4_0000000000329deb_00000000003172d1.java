import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Map<Double, Integer> angleFrequency = new HashMap<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfCases = in.nextInt();

        for (int caseNo = 1; caseNo <= noOfCases; ++caseNo) {
            int slices = in.nextInt();
            int dinners = in.nextInt();
            double[] angles = new double[slices];

            in.nextLine();

            for (int i = 0; i < slices; i++) {
                angles[i] = in.nextDouble();
            }

            Solution solution = new Solution();

            int steps = solution.findCuts(slices, dinners, angles);

            System.out.println("Case #" + caseNo + ": " + steps);
        }
    }

    public int findCuts(int slices, int dinners, double[] angles) {

        if (dinners == 0 || slices == 0) {
            return 0;
        }

        initialize(slices, angles);

        //
        int cuts = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < angles.length; i++) {
            double currentAngle = angles[i];
            
            if(currentAngle>360000000000.00) {
                return 0;
            }
            
            int frequency = angleFrequency.get(currentAngle);
            double expectedMinSize = (dinners - frequency) * currentAngle;

            if (expectedMinSize == 0) {
                return 0;
            }

            double foundValue = findSlice(angles, i, expectedMinSize);

            if (foundValue > -1) {
                int piecesNeeded = (dinners - frequency);
                int currentCuts = Integer.MAX_VALUE;

                if (expectedMinSize == foundValue) {
                    currentCuts = piecesNeeded-1;
                }
                else {
                    currentCuts = piecesNeeded;
                }

                cuts = Math.min(cuts, currentCuts);

                found = true;
            }
        }

        return found ? cuts : dinners - 1;
    }

    private void initialize(int slices, double[] angles) {
        for (int i = 0; i < slices; i++) {
            double angle = angles[i];

            if (angleFrequency.containsKey(angle)) {
                angleFrequency.put(angle, angleFrequency.get(angle) + 1);
            } else {
                angleFrequency.put(angle, 1);
            }
        }
    }

    private double findSlice(double[] angles, int currIndex, double expectedMinSize) {

        double valToSkip = angles[currIndex];

        for (int i = 0; i < angles.length; i++) {
            if (angles[i] == valToSkip) {
                continue;
            }

            if (angles[i] >= expectedMinSize) {
                return angles[i];
            }
        }

        return -1;
    }

}