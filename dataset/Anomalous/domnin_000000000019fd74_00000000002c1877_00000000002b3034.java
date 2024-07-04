import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int tc = 1;
        
        while (t-- > 0) {
            int N = in.nextInt();
            String[] patterns = new String[N];
            
            for (int i = 0; i < N; i++) {
                patterns[i] = in.next();
            }
            
            Set<String> pref = new HashSet<>(), suf = new HashSet<>(), pSet = new HashSet<>();
            for (String s : patterns) {
                pSet.add(s);
                if (s.charAt(0) != '*') {
                    int p = s.indexOf('*');
                    if (p < 0) {
                        pref.add(s);
                    } else {
                        pref.add(s.substring(0, p));
                    }
                }
                if (s.charAt(s.length() - 1) != '*') {
                    int p = s.lastIndexOf('*');
                    if (p < 0) {
                        suf.add(s);
                    } else {
                        suf.add(s.substring(p + 1));
                    }
                }
            }

            String mPref = maxString(pref);
            String sPref = pSet.contains(mPref) ? mPref : null;

            if (!isValidPrefix(pref, mPref)) {
                System.out.println("Case #" + tc++ + ": *");
                continue;
            }

            String mSuf = maxString(suf);
            String sSuf = pSet.contains(mSuf) ? mSuf : null;

            if (!isValidSuffix(suf, mSuf)) {
                System.out.println("Case #" + tc++ + ": *");
                continue;
            }

            if (sSuf != null && sPref != null) {
                if (!sSuf.equals(sPref) || !areAllPatternsMatching(sPref, patterns)) {
                    System.out.println("Case #" + tc++ + ": *");
                    continue;
                }
                System.out.println("Case #" + tc++ + ": " + sPref);
                continue;
            }

            String result = buildResult(N, patterns, mPref, mSuf);
            System.out.println("Case #" + tc++ + ": " + result);
        }
        System.out.flush();
    }

    static boolean isValidPrefix(Set<String> pref, String mPref) {
        for (String s : pref) {
            if (!mPref.startsWith(s)) {
                return false;
            }
        }
        return true;
    }

    static boolean isValidSuffix(Set<String> suf, String mSuf) {
        for (String s : suf) {
            if (!mSuf.endsWith(s)) {
                return false;
            }
        }
        return true;
    }

    static boolean areAllPatternsMatching(String sPref, String[] patterns) {
        for (String p : patterns) {
            if (!isMatch(sPref, p)) {
                return false;
            }
        }
        return true;
    }

    static String buildResult(int N, String[] patterns, String mPref, String mSuf) {
        String result = mPref;
        while (!mPref.isEmpty()) {
            for (int i = 0; i < N; i++) {
                if (patterns[i].isEmpty()) {
                    return "*";
                }
                if (patterns[i].charAt(0) != '*') {
                    if (patterns[i].charAt(0) != mPref.charAt(0)) {
                        return "*";
                    }
                    patterns[i] = patterns[i].substring(1);
                }
            }
            mPref = mPref.substring(1);
        }

        boolean hasMore;
        do {
            hasMore = false;
            for (int i = 0; i < N; i++) {
                while (!patterns[i].isEmpty() && patterns[i].charAt(0) == '*') {
                    if (patterns[i].length() == 1) {
                        continue;
                    }
                    patterns[i] = patterns[i].substring(1);
                }
                if (patterns[i].isEmpty()) {
                    return "*";
                }
                int starIndex = patterns[i].indexOf("*");
                if (starIndex > 0) {
                    result += patterns[i].substring(0, starIndex);
                    patterns[i] = patterns[i].substring(starIndex);
                    hasMore = true;
                }
            }
        } while (hasMore);

        result += mSuf;
        return result;
    }

    static boolean isMatch(String s, String p) {
        int i = 0, j = 0, starIndex = -1, iIndex = -1;

        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }

    static String maxString(Set<String> set) {
        String result = "";
        for (String s : set) {
            if (s.length() > result.length()) {
                result = s;
            }
        }
        return result;
    }
}