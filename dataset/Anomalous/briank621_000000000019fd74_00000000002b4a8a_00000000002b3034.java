import java.util.*;
import java.io.*;

class Solution {

    public static boolean equalOrStart(String s, String add) {
        return s.isEmpty() || s.startsWith(add) || add.startsWith(s);
    }

    public static boolean equalOrEnd(String s, String add) {
        return s.isEmpty() || s.endsWith(add) || add.endsWith(s);
    }

    public static String attach(String s, String add) {
        return s.length() > add.length() ? s : add;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int numCases = 1; numCases <= t; numCases++) {
            String begin = "";
            StringBuilder mid = new StringBuilder();
            String end = "";
            int n = Integer.parseInt(br.readLine());
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                String[] parts = s.split("\\*");
                int start = s.charAt(0) != '*' ? 1 : 0;
                int endi = s.charAt(s.length() - 1) != '*' ? parts.length - 1 : parts.length;

                StringBuilder sb = new StringBuilder();
                for (int j = start; j < endi; j++) {
                    sb.append(parts[j]);
                }
                mid.append(sb);

                if (start == 1) {
                    String prefix = parts[0];
                    if (equalOrStart(begin, prefix)) {
                        begin = attach(begin, prefix);
                    } else {
                        valid = false;
                    }
                }

                if (endi == parts.length - 1) {
                    String suffix = parts[parts.length - 1];
                    if (equalOrEnd(end, suffix)) {
                        end = attach(end, suffix);
                    } else {
                        valid = false;
                    }
                }
            }

            if (!valid) {
                System.out.printf("Case #%d: *\n", numCases);
            } else {
                if (begin.isEmpty() && mid.length() == 0 && end.isEmpty()) {
                    begin = "a";
                }
                System.out.printf("Case #%d: %s%s%s\n", numCases, begin, mid.toString(), end);
            }
        }

        br.close();
    }
}