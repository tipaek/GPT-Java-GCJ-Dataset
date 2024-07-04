import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 1; i <= tests; i++) {
            String s = sc.next();
            System.out.print("Case #" + i + ": ");
            process(s);
        }
    }

    private static void process(String s) {
        Map<Integer, String> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == 0) {
                map.put(i, generateParen(max));
                max = 0;
                continue;
            }
            max = Math.max(s.charAt(i) - '0', max);
        }

        map.put(s.length(), generateParen(max));
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            String val = entry.getValue();
            int end = entry.getKey();
            boolean insertBefore = true;
            max = entry.getValue().length() / 2;
            for (; i < end; i++) {
                int num = s.charAt(i) - '0';
                if (num == 0) break;
                if (num == max) {
                    insertBefore = false;
                }
                if (insertBefore) {
                    int k = 0;
                    int pos = 0;
                    for (int j = 0; j < val.length(); j++) {
                        if (k == num) {
                            pos = j;
                            break;
                        }
                        if (val.charAt(j) == '(') {
                            k++;
                        }
                    }
                    val = val.substring(0, pos) + num + val.substring(pos);
                } else {
                    int k = 0;
                    int pos = 0;
                    for (int j = val.length() - 1; j >= 0; j--) {
                        if (k == num) {
                            pos = j;
                            break;
                        }
                        if (val.charAt(j) == ')') {
                            k++;
                        }
                    }
                    val = val.substring(0, pos + 1) + num + val.substring(pos + 1);
                }
            }
            sb.append(val);
            if (end != s.length()) {
                i++;
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }

    private static String generateParen(int max) {
        if (max == 0) {
            return "";
        }
        char[] c = new char[max * 2];
        for (int i = 0; i < max; i++) {
            c[i] = '(';
            c[2 * max - i - 1] = ')';
        }
        return new String(c);
    }
}
