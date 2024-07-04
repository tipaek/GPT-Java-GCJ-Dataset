import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int num) throws Exception {
        String s = reader.readLine();
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(s.charAt(i) - '0');
        }
        int depth = 0;
        StringBuilder builder = new StringBuilder();
        for (int a : nums) {
            while (a > depth) {
                builder.append('(');
                depth++;
            }
            while (a < depth) {
                builder.append(')');
                depth--;
            }
            builder.append(a);
        }
        while (depth > 0) {
            builder.append(')');
            depth--;
        }
        System.out.printf("Case #%d: %s%n", num, builder.toString());
    }
}