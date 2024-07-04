import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NestingDepth {

    public static void main(String[] args) {
        ArrayList<int[]> cases = readLines();

        for (int c = 1; c <= cases.size(); c++) {
            int[] line = cases.get(c - 1);

            StringBuilder sb = new StringBuilder();
            int[] digits = line;

            // opening case
            int preceding = digits[0];
            append(sb, '(', preceding);
            sb.append(preceding);

            // middle case
            for (int i = 1; i < line.length; i++) {
                int d = digits[i];
                if (d >= preceding) {
                    append(sb, '(', d - preceding);
                } else {
                    append(sb, ')', preceding - d);
                }
                sb.append(d);
                preceding = d;
            }

            // closing case
            append(sb, ')', preceding);

            print(String.format("Case #%d: %s", c, sb.toString()));
        }
    }

    static void append(StringBuilder sb, char c, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
    }

    static ArrayList<int[]> readLines() {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        ArrayList<int[]> cases = new ArrayList<>(T);

        for (int i = 0; i < T; i++) {
            char[] nums = in.nextLine().toCharArray();
            int[] line = new int[nums.length];
            cases.add(line);

            for (int j = 0; j < nums.length; j++) {
                line[j] = Character.getNumericValue(nums[j]);
            }
        }

        in.close();
        return cases;
    }

    static void print(String line) {
        System.out.println(line);
    }

    static void print(int[] line) {
        System.out.println(Arrays.toString(line));
    }

    static void print(int[][] lines) {
        for (int[] line : lines) {
            print(line);
        }
    }
}
