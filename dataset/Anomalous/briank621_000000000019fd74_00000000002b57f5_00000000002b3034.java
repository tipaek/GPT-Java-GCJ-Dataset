import java.util.*;
import java.io.*;

class Solution {

    public static boolean isPrefixOrEqual(String s, String prefix) {
        return prefix.isEmpty() || s.isEmpty() || s.startsWith(prefix) || prefix.startsWith(s);
    }

    public static boolean isSuffixOrEqual(String s, String suffix) {
        return suffix.isEmpty() || s.isEmpty() || s.endsWith(suffix) || suffix.endsWith(s);
    }

    public static String getLongerString(String s1, String s2) {
        return s1.length() > s2.length() ? s1 : s2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            String begin = "";
            StringBuilder middle = new StringBuilder();
            String end = "";
            int n = Integer.parseInt(br.readLine());
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                String[] parts = s.split("\\*");
                
                int start = 0;
                int endIdx = parts.length;
                if (s.charAt(0) != '*') start++;
                if (s.charAt(s.length() - 1) != '*') endIdx--;

                StringBuilder middlePart = new StringBuilder();
                for (int j = start; j < endIdx; j++) {
                    middlePart.append(parts[j]);
                }
                middle.append(middlePart);

                if (start == 1) {
                    String prefix = parts[0];
                    if (isPrefixOrEqual(begin, prefix)) {
                        begin = getLongerString(begin, prefix);
                    } else {
                        isValid = false;
                    }
                }

                if (endIdx == parts.length - 1) {
                    String suffix = parts[parts.length - 1];
                    if (isSuffixOrEqual(end, suffix)) {
                        end = getLongerString(end, suffix);
                    } else {
                        isValid = false;
                    }
                }
            }

            if (!isValid) {
                System.out.printf("Case #%d: *\n", caseNum);
            } else {
                if (begin.isEmpty() && middle.length() == 0 && end.isEmpty()) {
                    begin = "a";
                }
                System.out.printf("Case #%d: %s%s%s\n", caseNum, begin, middle.toString(), end);
            }
        }

        br.close();
    }
}