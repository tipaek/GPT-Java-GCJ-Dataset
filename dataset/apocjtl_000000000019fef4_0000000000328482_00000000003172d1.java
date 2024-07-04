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
                } else {
                    map.put(nums[k], 1);
                }
                max = Math.max(max, map.get(nums[k]));
            }
            if(max >= d) {
                System.out.println("Case #" + (i + 1) + ": 0");
            } else if(max == d - 1){
                System.out.println("Case #" + (i + 1) + ": 1");
            } else {
                boolean works = false;
                for(Long l : map.keySet()) {
                    if(l % 2 == 0 && map.containsKey(l/2)) {
                        works = true;
                        break;
                    }
                }
                if(works) {
                    System.out.println("Case #" + (i + 1) + ": 1");
                } else {
                    System.out.println("Case #" + (i + 1) + ": 2");
                }
            }
        }
    }
}