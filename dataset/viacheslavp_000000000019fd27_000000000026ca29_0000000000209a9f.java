import java.util.Scanner;

public class Solution {

    private static String solve(String s) {
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            d[i] = s.charAt(i) - '0';
        }

        int braces = 0;
        for (int i = 0; i < d.length; ++i) {
            if (i == 0) braces += d[i];
            else braces += Math.abs(d[i] - d[i - 1]);
        }
        braces += d[d.length - 1];

        char[] result = new char[s.length() + braces];

        int j = 0;
        for(int i = 0; i < s.length(); ++i) {
            int prevD = i == 0 ? 0 : d[i - 1];
            int diff = d[i] - prevD;
            if (diff > 0) {
                for (int k = 0; k < diff; ++k) {
                    result[j++] = '(';
                }
            } else {
                for (int k = 0; k < -diff; ++k) {
                    result[j++] = ')';
                }
            }
            result[j++] = (char)(d[i] + '0');
        }
        for (int k = 0; k < d[d.length - 1]; ++k) {
            result[j++] = ')';
        }

        return new String(result);
    }

    public static void main(String[] params)  {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < t; ++i) {
            String s = scanner.nextLine();
            System.out.println(String.format("Case #%d: %s", i + 1, solve(s)));
        }
    }
}
