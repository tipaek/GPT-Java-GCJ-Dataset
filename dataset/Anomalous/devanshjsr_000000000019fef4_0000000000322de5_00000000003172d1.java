import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int result = -1;

            Map<Long, Long> frequencyMap = new HashMap<>();
            List<Long> angles = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                long angle = sc.nextLong();
                frequencyMap.put(angle, frequencyMap.getOrDefault(angle, 0L) + 1);

                if (frequencyMap.get(angle) == d) {
                    result = 0;
                    break;
                }

                if (frequencyMap.get(angle) == 1) {
                    angles.add(angle);
                }
            }

            if (result == 0) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                if (d == 2) {
                    System.out.println("Case #" + caseNumber + ": 1");
                } else {
                    boolean found = false;

                    for (Long angle : angles) {
                        if (frequencyMap.get(angle) == 2) {
                            for (Long otherAngle : angles) {
                                if (otherAngle > angle) {
                                    result = 1;
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                    }

                    if (result == 1) {
                        System.out.println("Case #" + caseNumber + ": 1");
                    } else {
                        System.out.println("Case #" + caseNumber + ": 2");
                    }
                }
            }

            t--;
            caseNumber++;
        }

        sc.close();
    }
}