import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            int maxElement = 0;
            int maxFrequency = 0;

            for (int i = 0; i < N; i++) {
                int element = sc.nextInt();
                frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
                maxFrequency = Math.max(maxFrequency, frequencyMap.get(element));
                maxElement = Math.max(maxElement, element);
            }

            if (D == 2) {
                if (maxFrequency >= 2) {
                    System.out.println("Case #" + tt + ": 0");
                } else {
                    System.out.println("Case #" + tt + ": 1");
                }
            } else if (D == 3) {
                if (maxFrequency >= 3) {
                    System.out.println("Case #" + tt + ": 0");
                } else if (maxFrequency == 1) {
                    System.out.println("Case #" + tt + ": 2");
                } else {
                    boolean found = false;
                    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                        int value = entry.getValue();
                        if (value == 2 && maxElement > entry.getKey()) {
                            System.out.println("Case #" + tt + ": 1");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Case #" + tt + ": 2");
                    }
                }
            }
        }
    }
}