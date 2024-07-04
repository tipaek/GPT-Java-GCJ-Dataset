import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String s = sc.next();
            System.out.println("Case #" + test_case + ": " + solve_set1(s));
        }
        sc.close();
    }

    public static String solve_set1(String s) {
        // s can contain only the characters 0 or 1
        if (s == null || s.length() == 0) return s;
        int n = s.length();

        StringBuilder result = new StringBuilder();
        int count0 = 0, count1 = 0;

        char previous = s.charAt(0);
        if (previous == '0') count0 = 1;
        else if (previous == '1') count1 = 1;

        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);

            if (current == previous) {
                if (previous == '0') {
                    count0++;
                } else if (previous == '1') {
                    count1++;
                }
            } else {
                if (previous == '0') {
                    while (count0-- > 0) {
                        result.append("0");
                    }
                    count1 = 1;
                } else if (previous == '1') {
                    result.append("(");
                    while (count1-- > 0) {
                        result.append("1");
                    }
                    result.append(")");
                    count0 = 1;
                }
            }
            previous = current;
        }
        if (previous == '0') {
            while (count0-- > 0) {
                result.append("0");
            }
        } else if (previous == '1') {
            result.append("(");
            while (count1-- > 0) {
                result.append("1");
            }
            result.append(")");
        }

        return result.toString();
    }

}
