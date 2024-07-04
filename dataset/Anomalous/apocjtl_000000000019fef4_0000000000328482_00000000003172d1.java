import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int d = input.nextInt();
            long[] nums = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            int maxFrequency = 0;

            for (int j = 0; j < n; j++) {
                nums[j] = input.nextLong();
                frequencyMap.put(nums[j], frequencyMap.getOrDefault(nums[j], 0) + 1);
                maxFrequency = Math.max(maxFrequency, frequencyMap.get(nums[j]));
            }

            if (maxFrequency >= d) {
                System.out.println("Case #" + (i + 1) + ": 0");
            } else if (maxFrequency == d - 1) {
                System.out.println("Case #" + (i + 1) + ": 1");
            } else {
                boolean canAchieve = false;
                for (long num : frequencyMap.keySet()) {
                    if (num % 2 == 0 && frequencyMap.containsKey(num / 2)) {
                        canAchieve = true;
                        break;
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + (canAchieve ? 1 : 2));
            }
        }
    }
}