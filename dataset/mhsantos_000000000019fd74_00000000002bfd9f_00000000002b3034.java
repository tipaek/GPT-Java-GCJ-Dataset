import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        tlabel:
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            String start = "";
            String end = "";
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < n; x++) {
                String tmp = in.nextLine();
                int firstStar = tmp.indexOf('*');
                if (firstStar > 0) {
                    String prefix = getPrefix(tmp);
                    if (start.length() == 0) {
                        start = prefix;
                    }
                    else {
                        if (start.length() > prefix.length()) {
                            if (!start.startsWith(prefix)) {
                                System.out.println("Case #" + i + ": *");
                                continue tlabel;
                            }
                        }
                        else {
                            if (!prefix.startsWith(start)) {
                                System.out.println("Case #" + i + ": *");
                                continue tlabel;
                            }
                            start = prefix;
                        }
                    }
                }
                String suffix = getSuffix(tmp);
                if (suffix != null) {
                    if (end.length() == 0) {
                        end = suffix;
                    }
                    else {
                        if (end.length() > suffix.length()) {
                            if (!end.endsWith(suffix)) {
                                System.out.println("Case #" + i + ": *");
                                continue tlabel;
                            }
                        }
                        else {
                            if (!suffix.endsWith(end)) {
                                System.out.println("Case #" + i + ": *");
                                continue tlabel;
                            }
                            end = suffix;
                        }
                    }
                }
                List<String> middleStrings = middleStrings(tmp);
                for (String md : middleStrings) {
                    sb.append(md);
                }
            }
            sb.insert(0, start);
            sb.append(end);
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    private static String getPrefix(String tmp) {
        return tmp.substring(0, tmp.indexOf('*'));
    }

    private static String getSuffix(String tmp) {
        if (tmp.endsWith("*")) {
            return null;
        }
        String[] xx = tmp.split("\\*+");
        return xx[xx.length -1];
    }

    private static List<String> middleStrings(String tmp) {
        String[] xx = tmp.split("\\*+");
        List<String> result = new ArrayList<>();
        if (tmp.startsWith("*") && tmp.endsWith("*")) {
            for (int i = 0; i < xx.length; i++) {
                result.add(xx[i]);
            }
            return result;
        }
        if (tmp.startsWith("*")) {
            for (int i = 0; i < xx.length - 1; i++) {
                result.add(xx[i]);
            }
            return result;
        }
        else if (tmp.endsWith("*")) {
            for (int i = 1; i < xx.length ; i++) {
                result.add(xx[i]);
            }
            return result;
        }
        else {
            for (int i = 1; i < xx.length - 1 ; i++) {
                result.add(xx[i]);
            }
            return result;
        }
    }

}
