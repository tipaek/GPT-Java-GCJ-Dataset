import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

class Main {
    private static final boolean DEBUG = true;

    // Global variables
    private static int b;
    private static String[] states = new String[4];
    private static ArrayList<String> patterns;

    public static void main(String[] args) {
        Pattern regex0 = Pattern.compile("[01]{5}[x]{5}");
        Pattern regex1 = Pattern.compile("[x]{5}[01]{5}");
        Scanner sc = new Scanner(System.in);
        int t, ti;
        String mString;
        t = sc.nextInt();
        b = sc.nextInt();
        for (ti = 1; ti <= t; ti++) {
            mDebug("Test case #" + ti);
            // Test case begins
            // Initialize default states
            for (int i = 0; i < 4; i++)
                states[i] = "x".repeat(b);
            patterns = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            sb.append("x".repeat(b));

            // Get initial states

            for (int i = 0; i < 10; i++) {
                mPrintln(i + 1);
                int bit = sc.nextInt();
                mDebug(bit);
                sb.setCharAt(i, (char) ('0' + bit));
            }
            mString = sb.toString();
            transform(states, sb);
            int offset;

            for (offset = 10; offset + 10 <= b; offset += 10) {
                for (int i = 0; i < 10; i++) {
                    mPrintln(offset + i + 1);
                    int bit = sc.nextInt();
                    mDebug(bit);
                    sb.setCharAt(offset + i, (char) ('0' + bit));
                }
                String[] temp = new String[4];
                mString = sb.toString();
                transform(temp, sb);
                for (int x = 0; x < 4; x++)
                    patterns.add(temp[x]);
            }

            // Next states
            int r = 0;
            while (true) {
                if (!states[0].contains("x"))
                    break;
                r = (r + 1) % 4;
                Matcher matcher0 = regex0.matcher(states[r]);
                Matcher matcher1 = regex1.matcher(states[r]);
                if (matcher0.find()) {
                    offset = matcher0.start();
                } else if (matcher1.find()) {
                    offset = matcher1.start();
                }

                sb.delete(0, b);
                sb.append("x".repeat(b));
                for (int i = 0; i < 10; i++) {
                    mPrintln(offset + i + 1);
                    int bit = sc.nextInt();
                    mDebug(bit);
                    sb.setCharAt(offset + i, (char) ('0' + bit));
                }
                String[] temp = new String[4];
                mString = sb.toString();
                transform(temp, sb);
                for (int i = 0; i < 4; i++)
                    mergePatterns(temp[i]);
                for (String pattern : (ArrayList<String>) patterns.clone()) {
                    if (mergePatterns(pattern))
                        patterns.remove(pattern);
                }
            }
            mDebug(states[0]);
            mDebug(states[1]);
            mDebug(states[2]);
            mDebug(states[3]);

            // Guessing phase
            for (int i = 0; i < 4; i++) {
                if (isMatching(mString, states[i])) {
                    mPrintln(states[i]);
                    break;
                }
            }
            String status = sc.next();
            mDebug(status);
            if (status.equals("N"))
                return;
        }
        sc.close();

    }

    private static void mPrintln(Object o) {
        System.out.println(o);
        System.out.flush();
        if (DEBUG)
            System.err.println(o);
    }

    private static void mDebug(Object o) {
        if (DEBUG)
            System.err.println(">>>" + o);
    }

    private static void transform(String[] t, StringBuilder sb) {
        t[0] = sb.toString(); // Original String
        t[1] = sb.reverse().toString(); // Reverse
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0')
                sb.setCharAt(i, '1');
            else if (sb.charAt(i) == '1')
                sb.setCharAt(i, '0');
        }
        t[2] = sb.toString(); // Complemented and reversed
        t[3] = sb.reverse().toString(); // Complemented
    }

    private static boolean mergePatterns(String s) {
        boolean flag = false;
        for (int j = 0; j < 4; j++) {
            if (isMatching(s, states[j])) {
                states[j] = performMatch(s, states[j]);
                flag = true;
            }
        }
        return flag;
    }

    private static String performMatch(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < s1.length(); x++) {
            sb.append(s1.charAt(x) != 'x' ? s1.charAt(x) : (s2.charAt(x) != 'x' ? s2.charAt(x) : 'x'));
        }
        return sb.toString();
    }

    private static boolean isMatching(String s1, String s2) {
        int matches = 0;
        for (int i = 0; i < s1.length(); i++) {
            if ((s1.charAt(i) == s2.charAt(i)) && s1.charAt(i) != 'x')
                matches++;
            if ((s1.charAt(i) == '0' && s2.charAt(i) == '1') || (s1.charAt(i) == '1' && s2.charAt(i) == '0'))
                return false;
        }
        return matches >= 5;
    }
}