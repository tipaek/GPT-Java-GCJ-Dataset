import java.util.*;
import java.io.*;

public class Solution {
    
    static Set<int[]> seen = new HashSet<>();
    
    public static int[] getArr(int[][] nums, int[][] sorted, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] == sorted[k][0] && nums[i][1] == sorted[k][1] && !seen.contains(nums[i])) {
                seen.add(nums[i]);
                return nums[i];
            }
        }
        return nums[0];
    }
    
    public static void schedule(int[][] nums, int caseNum) {
        int[][] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        
        Map<int[], String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        List<int[]> j = new ArrayList<>();
        List<int[]> c = new ArrayList<>();
        
        j.add(sorted[0]);
        int[] temp = getArr(nums, sorted, 0);
        map.put(temp, "J");
        
        int prevStart = temp[0];
        int prevEnd = temp[1];
        int start = 1;
        int end = 1;
        
        for (int i = 1; i < sorted.length; i++) {
            if (prevStart == sorted[i][0] && prevEnd == sorted[i][1]) {
                start++;
                end++;
                if (start > 2 && end > 2) {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    return;
                }
            } else {
                prevStart = sorted[i][0];
                prevEnd = sorted[i][1];
                start = 1;
                end = 1;
            }
            if (c.isEmpty()) {
                c.add(sorted[i]);
                temp = getArr(nums, sorted, i);
                map.put(temp, "C");
            } else if ((sorted[i][0] < j.get(j.size() - 1)[1]) && 
                       (sorted[i][0] < c.get(c.size() - 1)[1])) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            } else if (sorted[i][0] < j.get(j.size() - 1)[1]) {
                c.add(sorted[i]);
                temp = getArr(nums, sorted, i);
                map.put(temp, "C");
            } else {
                j.add(sorted[i]);
                temp = getArr(nums, sorted, i);
                map.put(temp, "J");
            }
        }
        
        for (int[] num : nums) {
            sb.append(map.get(num));
        }
        System.out.println("Case #" + caseNum + ": " + sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] nums = new int[n][2];
            for (int k = 0; k < n; k++) {
                nums[k][0] = in.nextInt();
                nums[k][1] = in.nextInt();
            }
            schedule(nums, i);
        }
        in.close();
    }
}