import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BalancedParenthesis {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tests = br.readLine();
        if (tests == null) return;

        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            if (str == null) return;

            int currentOpen = 0;
            int[] nums = str.chars().map(c -> c - '0').toArray();

            sb.append(open(nums[0])).append(nums[0]);
            currentOpen = nums[0];

            for (int k = 1; k < nums.length; k++) {
                if (currentOpen > nums[k]) {
                    sb.append(close(currentOpen - nums[k])).append(nums[k]);
                    currentOpen = nums[k];
                } else if (currentOpen < nums[k]) {
                    sb.append(open(nums[k] - currentOpen)).append(nums[k]);
                    currentOpen = nums[k];
                } else {
                    sb.append(nums[k]);
                }
            }

            sb.append(close(currentOpen));
        }

        System.out.println(sb.toString());
    }

    private static String close(int count) {
        return ")".repeat(Math.max(0, count));
    }

    private static String open(int count) {
        return "(".repeat(Math.max(0, count));
    }
}