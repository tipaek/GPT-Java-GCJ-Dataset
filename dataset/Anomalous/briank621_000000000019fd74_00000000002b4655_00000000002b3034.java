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
            boolean noMid = false;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                String s = br.readLine();

                if (!s.contains("*")) {
                    noMid = true;
                    if (equalOrStart(begin, s) && equalOrEnd(end, s)) {
                        begin = attach(begin, s);
                        end = attach(end, s);
                    } else {
                        valid = false;
                    }
                } else {
                    if (noMid) {
                        valid = false;
                    } else {
                        String[] parts = s.split("\\*");
                        int start = 0;
                        int endi = parts.length;

                        if (s.charAt(0) != '*') start++;
                        if (s.charAt(s.length() - 1) != '*') endi--;

                        StringBuilder sb = new StringBuilder();
                        for (int j = start; j < endi; j++) {
                            sb.append(parts[j]);
                        }
                        mid.append(sb);

                        if (start == 1) {
                            String ss = parts[0];
                            if (equalOrStart(begin, ss)) {
                                begin = attach(begin, ss);
                            } else {
                                valid = false;
                            }
                        }

                        if (endi == parts.length - 1) {
                            String es = parts[parts.length - 1];
                            if (equalOrEnd(end, es)) {
                                end = attach(end, es);
                            } else {
                                valid = false;
                            }
                        }
                    }
                }
            }

            if (!valid) {
                System.out.printf("Case #%d: *\n", numCases);
            } else {
                System.out.printf("Case #%d: %s%s%s\n", numCases, begin, mid.toString(), end);
            }
        }

        br.close();
    }
}