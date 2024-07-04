import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhxu
 */

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int testCases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < testCases; ++i) {
            final String S = in.nextLine();

            final int[] nums = new int[S.length()];
            for(int j = 0; j < nums.length; j++) {
                nums[j] = S.charAt(j) - '0';
            }

            System.out.println(String.format("Case #%d: %s", i + 1, build(nums, 0, nums.length - 1, 0)));
        }
    }

    private static String build(int[] nums, int start, int end, int decreased) {
        if(start > end) {
            return "";
        }
        int min = start;

        List<Integer> minIdx = new ArrayList<>();

        for(int i = start; i <= end; i++) {
            if (nums[i] < nums[min]) {
                minIdx.clear();
                minIdx.add(i);
                min = i;
            } else if (nums[i] == nums[min]) {
                minIdx.add(i);
            } else ;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < nums[min]; i++) {
            sb.append('(');
        }

        for(int i = start; i <= end; i++) {
            if(nums[i] > nums[min]) {
                nums[i] -= nums[min];
            }
        }

        int front = start;

        for(int pos : minIdx) {
            sb.append(build(nums, front, pos - 1, decreased + nums[min]));
            sb.append(nums[pos] + decreased);
            front = pos + 1;
        }

        sb.append(build(nums, front, end, decreased + nums[min]));

        for(int i = 0; i < nums[min]; i++) {
            sb.append(')');
        }

        return sb.toString();
    }
}
