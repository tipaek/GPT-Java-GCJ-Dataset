import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        StringBuilder ans = new StringBuilder();

        int t = scn.nextInt();
        for (int case_num = 1; case_num <= t; case_num++) {
            ans.append("Case #").append(t).append(": ");
            char[] given_string = scn.next().toCharArray();
            int n = given_string.length;
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = given_string[i] - '0';
            }

            ans.append(generate_open(array[0])).append(array[0]);

            for (int i = 1; i < n; i++) {
                if (array[i] > array[i - 1]) {
                    ans.append(generate_open(array[i] - array[i - 1])).append(array[i]);
                } else if (array[i] < array[i - 1]) {
                    ans.append(generate_close(array[i - 1] - array[i])).append(array[i]);
                } else {
                    ans.append(array[i]);
                }
            }

            ans.append(generate_close(array[n - 1]));

            ans.append("\n");

        }

        System.out.println(ans);

    }

    private static String generate_open(int n) {
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            ans.append("(");
        }
        return ans.toString();
    }

    private static String generate_close(int n) {
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            ans.append(")");
        }
        return ans.toString();
    }

}