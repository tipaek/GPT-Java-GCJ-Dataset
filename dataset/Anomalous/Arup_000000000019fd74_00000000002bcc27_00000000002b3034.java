import java.util.Scanner;

public class Solution {

    public static int n;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int nC = stdin.nextInt();

        // Process cases.
        for (int loop = 1; loop <= nC; loop++) {
            n = stdin.nextInt();
            String[] words = new String[n];
            String[] rev = new String[n];
            int[] starCnt = new int[n];

            for (int i = 0; i < n; i++) {
                words[i] = stdin.next();
                rev[i] = reverse(words[i]);
                starCnt[i] = countStars(words[i]);
            }

            String prefix = getPrefix(words);
            String suffix = getPrefix(rev);
            if (suffix != null) {
                suffix = reverse(suffix);
            }

            if (prefix == null || suffix == null) {
                System.out.println("Case #" + loop + ": *");
            } else {
                StringBuilder middle = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (starCnt[i] > 1) {
                        int startIdx = words[i].indexOf('*');
                        int endIdx = rev[i].length() - 1 - rev[i].indexOf('*');
                        for (int j = startIdx; j <= endIdx; j++) {
                            if (words[i].charAt(j) != '*') {
                                middle.append(words[i].charAt(j));
                            }
                        }
                    }
                }
                System.out.println("Case #" + loop + ": " + prefix + middle + suffix);
            }
        }
        stdin.close();
    }

    public static String getPrefix(String[] words) {
        String longestPrefix = "";

        for (int i = 0; i < n; i++) {
            if (words[i].charAt(0) == '*') continue;

            int j = 0;
            while (words[i].charAt(j) != '*') j++;

            String currentPrefix = words[i].substring(0, j);

            if (currentPrefix.length() > longestPrefix.length()) {
                if (!currentPrefix.startsWith(longestPrefix)) {
                    return null;
                } else {
                    longestPrefix = currentPrefix;
                }
            } else {
                if (!longestPrefix.startsWith(currentPrefix)) {
                    return null;
                }
            }
        }
        return longestPrefix;
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int countStars(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }
}