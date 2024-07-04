import java.util.Scanner;

public class Solution{
    
    public static String L = "(";
    public static String R = ")";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int[] nums = makeNums(sc);

            String ans = makeAns(nums);

            System.out.println(String.format("Case #%s: %s", i, ans));
        }

    }

    private static String makeAns(int[] nums) {
        StringBuilder sb = new StringBuilder();
        
        int now = 0;
        for(int n : nums) {
            int diff = n - now;
            sb = append(sb, diff);
            sb = sb.append(n);
            now = n;
        }
        return append(sb, 0 - now).toString();
    }
    
    private static StringBuilder append(StringBuilder sb, int diff) {
        if(diff > 0) {
            return sb.append(multi(L, Math.abs(diff)));
        } else {
            return sb.append(multi(R, Math.abs(diff)));
        }
    }
    
    private static StringBuilder multi(String s, int cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb = sb.append(s);
        }
        return sb;
    }

    private static int[] makeNums(Scanner sc) {
        String line = sc.nextLine();
        char[] chs = line.toCharArray();
        int[] nums = new int[chs.length];


        for (int i = 0; i < chs.length; i++) {
                nums[i] =Integer.parseInt(String.valueOf(chs[i]));
        }
        return nums;
    }

}
