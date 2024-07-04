import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int d = input.nextInt();
            long[] nums = new long[n];
            int max = 0;
            HashMap<Long, Integer> map = new HashMap<>();
            for(int k = 0; k < n; k++) {
                nums[k] = input.nextLong();
                if(map.containsKey(nums[k])) {
                    map.put(nums[k], map.get(nums[k]) + 1);
                    max = Math.max(max, map.get(nums[k]));
                } else {
                    map.put(nums[k], 1);
                    max = Math.max(max, map.get(nums[k]));
                }
            }
            if(max == d) {
                System.out.println("Case #" + (i + 1) + ": " + 0);
            } else {
                boolean work = false;
                for(Long l : map.keySet()) {
                    if(l % 2 == 0 && map.containsKey(l/2)) {
                        if(map.get(l/2) + 2 >= d) {
                            System.out.println("Case #" + (i + 1) + ": " + 1);
                            work = true;
                            break;
                        }
                    }
                }
                if(!work) {
                    System.out.println("Case #" + (i + 1) + ": " + 2);
                }
            }

        }
    }
}