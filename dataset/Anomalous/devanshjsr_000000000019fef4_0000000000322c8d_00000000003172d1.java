import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int result = -1;

            Map<Long, Long> frequencyMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                long angle = sc.nextLong();
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
                    List<Long> twiceOccurredAngles = new ArrayList<>();
                    for (Map.Entry<Long, Long> entry : frequencyMap.entrySet()) {
                        if (entry.getValue() == 2) {
                            twiceOccurredAngles.add(entry.getKey());
                        }
                    }

                    outerLoop:
                    for (Long angle : twiceOccurredAngles) {
                        for (Long key : frequencyMap.keySet()) {
                            if (key > angle) {
                                result = 1;
                                break outerLoop;
                            }
                        }
                    }

                    if (result == 1) {
                        System.out.println("Case #" + caseNumber + ": 1");
                    } else {
                        List<Long> angles = new ArrayList<>(frequencyMap.keySet());
                        Collections.sort(angles);

                        long maxAngle = angles.get(angles.size() - 1);
                        long minAngle = angles.get(0);
                        long quotient = minAngle > 0 ? maxAngle / minAngle : 0;

                        if (quotient >= 2) {
                            System.out.println("Case #" + caseNumber + ": 1");
                        } else {
                            System.out.println("Case #" + caseNumber + ": 2");
                        }
                    }
                }
            }

            t--;
            caseNumber++;
        }
    }
}