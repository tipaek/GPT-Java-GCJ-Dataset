import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            String res = calc(scanner);
            System.out.println("Case #" + testCase + ": " + res);
        }
    }

    public static String calc(Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] nums = new long[n];
        Map<Long, Integer> count = new HashMap();
        for(int i=0; i<n; i++) {
            nums[i] = scanner.nextLong();
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        // check if can do 0
        for(int i=0; i<n; i++) {
            if(count.get(nums[i]) >= d) return "0";
        }
        if(d==2) return "1";
        // check if can do 1
        int minCuts = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) if(nums[i]%2 == 0) {
            // find steps to make D of this number
            if(count.containsKey(nums[i]/2)) return "1";
        }
        // check if can do 2
        if(d==3) return "2";
        return "12";
    }

//    private static long dp(int d, Map<Long, Integer> count, long target) {
//        if(count.get(target) >= d) return 0;
//        long[] steps = new long[d+1-count.get(target)];
//        Arrays.fill(steps, Long.MAX_VALUE);
//        for(long num : count.keySet()) if(num > target) {
//            int cuts;
//            int slices = (int) (num/target);
//            if(num%target==0) {
//                cuts = (int) (num/target - 1);
//            } else {
//                cuts = (int) (num/target);
//            }
//            long totSlices = slices*count.get(num);
//            long totCuts = cuts*count.get(num);
//            for(int i=0; i<steps.length; i++) {
//                steps[i] = Math.min(totCuts, steps[i]);
//                if(i>=totCuts) {
//                    steps[i] = Math.min(steps[i], steps[i- (int)(totCuts)]+totCuts);
//                }
//            }
//        }
//        return steps[steps.length-1];
//    }

}
