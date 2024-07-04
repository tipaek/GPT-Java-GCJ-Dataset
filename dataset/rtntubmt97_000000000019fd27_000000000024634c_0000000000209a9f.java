import java.util.*;
import java.io.*;

public class Solution  {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String allDigits = in.nextLine();

            int pos = 0;
            List<String> digitsList = new LinkedList<>();
            String nextDigits = getNextSameDigits(allDigits, pos);
            while (nextDigits != null) {
                digitsList.add(nextDigits);
                pos += nextDigits.length();
                nextDigits = getNextSameDigits(allDigits, pos);
            }

            StringBuilder sb = new StringBuilder();
            String currentDigits = digitsList.get(0);
            int currentDigit = getIntValue(currentDigits);
            sb.append(getSameChar('(', currentDigit));
            sb.append(currentDigits);

            for (int j = 1, preDigit, dif; j < digitsList.size(); j++) {
                currentDigits = digitsList.get(0);
                preDigit = currentDigit;
                currentDigit = getIntValue(currentDigits);
                dif = currentDigit - preDigit;
                if (dif > 0) {
                    sb.append(getSameChar('(', dif));
                } else {
                    sb.append(getSameChar(')', -dif));
                }
                sb.append(currentDigits);
            }

            currentDigits = digitsList.get(digitsList.size() - 1);
            currentDigit = getIntValue(currentDigits);
            sb.append(getSameChar(')', currentDigit));

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    public static int getIntValue(String s) {
        return Integer.valueOf(s.charAt(0)) - 48;
    }

    public static String getNextSameDigits(String s, int pos) {
        if (pos == s.length()) {
            return null;
        }
        if (pos == s.length() - 1) {
            return s.substring(pos, pos + 1);
        }
        int endPos = pos + 1;
        while (s.charAt(endPos) == s.charAt(pos))
            endPos++;
        return s.substring(pos, endPos);
    }

    public static char[] getSameChar(char c, int len) {
        char[] ret = new char[len];
        Arrays.fill(ret, c);
        return ret;
    }
}