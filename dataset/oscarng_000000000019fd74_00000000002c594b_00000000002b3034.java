import java.util.Scanner;

//Pattern Matching
public class Solution {
    public static String solve(String[] patterns) {

        String candidate = patterns[0].substring(1);

        for (int i = 1; i < patterns.length; ++i) {
            String p = patterns[i].substring(1);

            int j = candidate.length()-1;
            int k = p.length()-1;

            while (j >= 0 && k >= 0) {
                if (candidate.charAt(j) != p.charAt(k)) {
                    return "*";
                }

                --j; --k;
            }

            candidate = candidate.length() > p.length()? candidate: p;
        }

        return candidate;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        // System.out.println("num of case: " + t);
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            String[] patterns = new String[n];
            for (int j = 0; j < n; ++j) {
                patterns[j] = in.nextLine();
            }

            String ans = solve(patterns);

            System.out.println(String.format("Case #%d: %s", i, ans));
        }
    }
}