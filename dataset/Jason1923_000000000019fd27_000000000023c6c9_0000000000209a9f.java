import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(in.nextLine()); // # of test cases
        for (int t = 1; t <= tests; t++) {
            String input = in.nextLine();

            // Create num array
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < input.length(); i++)
                nums.add(Integer.parseInt("" + input.charAt(i)));

            // Construct output
            StringBuilder output = new StringBuilder();
            int close = nums.get(0);
            output.append("(".repeat(close)).append(nums.get(0));
            for (int i = 1; i < nums.size(); i++) {
                int num = nums.get(i);
                int diff = num - nums.get(i - 1);
                if (diff < 0) {
                    diff = Math.abs(diff);
                    output.append(")".repeat(diff));
                    close -= diff;
                } else if (diff > 0) {
                    output.append("(".repeat(diff));
                    close += diff;
                }
                output.append(num);
            }
            output.append(")".repeat(close));
            System.out.println("Case #" + t + ": " + output);
        }
    }
}