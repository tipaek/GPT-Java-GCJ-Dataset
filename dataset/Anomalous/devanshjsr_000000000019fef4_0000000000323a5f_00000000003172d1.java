import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();

            int result = -1;
            Map<Long, Long> frequencyMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long angle = scanner.nextLong();
                frequencyMap.put(angle, frequencyMap.getOrDefault(angle, 0L) + 1);

                if (frequencyMap.get(angle) == d) {
                    result = 0;
                    break;
                }
            }

            if (result == 0) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                if (d == 2) {
                    System.out.println("Case #" + caseNumber + ": 1");
                } else {
                    List<Long> twiceOccurred = new ArrayList<>();
                    for (Map.Entry<Long, Long> entry : frequencyMap.entrySet()) {
                        if (entry.getValue() == 2) {
                            twiceOccurred.add(entry.getKey());
                        }
                    }

                    for (Long value : twiceOccurred) {
                        for (Long key : frequencyMap.keySet()) {
                            if (key > value) {
                                result = 1;
                                break;
                            }
                        }
                        if (result == 1) {
                            break;
                        }
                    }

                    if (result == 1) {
                        System.out.println("Case #" + caseNumber + ": 1");
                    } else {
                        List<Long> angles = new ArrayList<>(frequencyMap.keySet());
                        Collections.sort(angles);
                        long maxAngle = angles.get(angles.size() - 1);
                        long minAngle = angles.get(0);
                        long division = (minAngle > 0) ? (maxAngle / minAngle) : 0;

                        if (division >= 2) {
                            System.out.println("Case #" + caseNumber + ": 1");
                        } else {
                            System.out.println("Case #" + caseNumber + ": 2");
                        }
                    }
                }
            }
            caseNumber++;
        }
        scanner.close();
    }
}