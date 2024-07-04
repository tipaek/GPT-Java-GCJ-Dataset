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

        List<int[]> jActivities = new ArrayList<>();
        List<int[]> cActivities = new ArrayList<>();

        jActivities.add(sorted[0]);
        int[] temp = getArr(nums, sorted, 0);
        map.put(temp, "J");

        for (int i = 1; i < sorted.length; i++) {
            if (cActivities.isEmpty()) {
                cActivities.add(sorted[i]);
                temp = getArr(nums, sorted, i);
                map.put(temp, "C");
            } else if (overlaps(sorted[i], jActivities) && overlaps(sorted[i], cActivities)) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            } else if (overlaps(sorted[i], jActivities)) {
                cActivities.add(sorted[i]);
                temp = getArr(nums, sorted, i);
                map.put(temp, "C");
            } else {
                jActivities.add(sorted[i]);
                temp = getArr(nums, sorted, i);
                map.put(temp, "J");
            }
        }
        for (int[] num : nums) {
            sb.append(map.get(num));
        }
        System.out.println("Case #" + caseNum + ": " + sb.toString());
    }

    private static boolean overlaps(int[] interval, List<int[]> activities) {
        for (int[] activity : activities) {
            if (interval[0] < activity[1] && interval[1] > activity[0]) {
                return true;
            }
        }
        return false;
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
    }
}