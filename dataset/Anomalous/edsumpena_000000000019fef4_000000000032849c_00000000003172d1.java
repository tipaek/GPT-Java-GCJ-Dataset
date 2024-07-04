import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int slices = scanner.nextInt();
            int customers = scanner.nextInt();
            float[] angles = new float[slices];

            for (int i = 0; i < slices; i++) {
                angles[i] = scanner.nextFloat();
            }

            System.out.println("Case #" + testCase + ": " + calculateCuts(slices, customers, angles));
        }

        scanner.close();
    }

    private static int calculateCuts(int slices, int customers, float[] angles) {
        HashMap<Float, Integer> angleOccurrences = new HashMap<>();

        for (float angle : angles) {
            angleOccurrences.put(angle, angleOccurrences.getOrDefault(angle, 0) + 1);
        }

        if (angleOccurrences.containsValue(customers)) {
            return 0;
        }

        ArrayList<Float> angleList = new ArrayList<>();
        for (float angle : angles) {
            angleList.add(angle);
        }

        int cuts = 0;
        int index = 0;

        while (!angleOccurrences.isEmpty() && customers > 0 && !angleList.isEmpty()) {
            float maxAngle = angleList.get(index);
            int maxIndex = 0;

            for (int i = 0; i < angleList.size(); i++) {
                if (angleOccurrences.get(angleList.get(i)) > angleOccurrences.get(maxAngle)) {
                    maxAngle = angleList.get(i);
                    maxIndex = i;
                }
            }

            int occurrences = angleOccurrences.remove(maxAngle);
            index++;

            for (int i = customers - occurrences; i > 1; i--) {
                for (int j = 0; j < angleList.size(); j++) {
                    if (j != maxIndex && (angleList.get(j) % i) == 0) {
                        customers -= i + occurrences;
                        cuts += i - 1;
                        angleList.remove(maxIndex);

                        if (maxIndex > j) {
                            angleList.remove(j);
                        } else {
                            angleList.remove(j - 1);
                        }

                        index--;
                    }
                }
            }
        }

        return customers == 0 ? cuts : customers - 1;
    }
}