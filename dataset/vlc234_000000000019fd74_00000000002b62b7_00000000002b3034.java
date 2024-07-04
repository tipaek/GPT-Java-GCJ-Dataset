import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        List<String> patterns = new ArrayList<>(Arrays.asList(
//                "*CONUTS",
//                "*S",
//                "*NUTS",
//                "*OCONUTS",
//                "*CONUTS"
//        ));
//        solve(1, patterns.size(), patterns);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String pattern = in.nextLine();
                patterns.add(pattern);
            }
            solve(i, n, patterns);
        }
    }

    private static void solve(int t, int n, List<String> patterns) {
        String patternsStart = "";
        String patternsEnd = "";
        String patternsContain = "";
        for (String pattern : patterns) {
            int asteriskIndex = pattern.indexOf("*");
            if (asteriskIndex < pattern.length()) {
                String patternEnd = pattern.substring(asteriskIndex + 1);
                if (patternEnd.contains(patternsEnd)) {
                    if (patternEnd.length() > 10000) {
                        System.out.println("Case #" + t + ": " + "*");
                        return;
                    }
                    patternsEnd = patternEnd;
                } else if(!patternsEnd.contains(patternEnd)) {
                    System.out.println("Case #" + t + ": " + "*");
                    return;
                }
            }
        }
        String result = (patternsStart + patternsContain + patternsEnd);
        if (result.length() > 10000) {
            System.out.println("Case #" + t + ": " + "*");
            return;
        } else if (result.isEmpty()) {
            System.out.println("Case #" + t + ": " + "A");
            return;
        }
        System.out.println("Case #" + t + ": " + result);
    }
}