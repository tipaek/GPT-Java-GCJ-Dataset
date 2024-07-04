import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int slices = scanner.nextInt();
            int customers = scanner.nextInt();
            float[] angles = new float[slices];
            for (int i = 0; i < slices; i++) {
                angles[i] = scanner.nextFloat();
            }
            System.out.println("Case #" + caseNum + ": " + calculateCuts(slices, customers, angles));
        }
        scanner.close();
    }

    private static int calculateCuts(int slices, int customers, float[] angles) {
        Map<Float, Integer> angleFrequency = new HashMap<>();
        for (float angle : angles) {
            angleFrequency.put(angle, angleFrequency.getOrDefault(angle, 0) + 1);
        }

        if (angleFrequency.containsValue(customers)) {
            return 0;
        }

        List<Float> angleList = new ArrayList<>();
        for (float angle : angles) {
            angleList.add(angle);
        }

        int cutsRequired = 0;

        while (!angleFrequency.isEmpty() && customers > 0 && !angleList.isEmpty()) {
            Map.Entry<Float, Integer> maxEntry = Collections.max(angleFrequency.entrySet(), Map.Entry.comparingByValue());
            float maxAngle = maxEntry.getKey();
            int maxFrequency = maxEntry.getValue();
            angleFrequency.remove(maxAngle);
            
            if (maxFrequency == 0) {
                maxFrequency = 1;
            }

            for (int i = customers - maxFrequency; i > 1; i--) {
                for (int j = 0; j < angleList.size(); j++) {
                    if (j != angleList.indexOf(maxAngle) && (angleList.get(j) % i) == 0) {
                        customers -= i + maxFrequency;
                        cutsRequired += i - 1;
                        angleList.remove(angleList.indexOf(maxAngle));
                        angleList.remove(j > angleList.indexOf(maxAngle) ? j : j - 1);
                    }
                }
            }
        }

        return customers == 0 ? cutsRequired : customers - 1;
    }
}