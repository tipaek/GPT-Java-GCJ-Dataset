import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        List<String> patterns = new ArrayList<>(Arrays.asList(
//                "ABC*",
//                "ABCD*",
//                "ABC*EFGH",
//                "*ABCDEFGH",
//                "*CDEFGH",
//                "*FGH"
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
        List<String> patternStartList = new ArrayList<>();
        List<String> patternEndList = new ArrayList<>();
        for (String pattern : patterns) {
            int asteriskIndex = pattern.indexOf("*");
            
            //Process start
            if (asteriskIndex > 0) {
                String patternStart = pattern.substring(0, asteriskIndex - 1);
                patternStartList.add(patternStart);
                
                for (String pe : patternStartList) {
                    if (!patternStart.startsWith(pe) && !pe.startsWith(patternStart)) {
                        System.out.println("Break here: " + patternStart + " - " + pe);
                        System.out.println("Case #" + t + ": " + "*");
                        return;
                    }
                }
                if (patternStart.startsWith(patternsStart)) {
                    if (patternStart.length() > 10000) {
                        System.out.println("Case #" + t + ": " + "*");
                        return;
                    }
                    patternsStart = patternStart;
                } else if(!patternsStart.startsWith(patternStart)) {
                    System.out.println("Break here: " + patternStart + " - " + patternsStart);
                    System.out.println("Case #" + t + ": " + "*");
                    return;
                }
            }
            
            
            //Process end
            if (asteriskIndex < pattern.length()) {
                String patternEnd = pattern.substring(asteriskIndex + 1);
                patternEndList.add(patternEnd);
                
                for (String pe : patternEndList) {
                    if (!patternEnd.endsWith(pe) && !pe.endsWith(patternEnd)) {
                        System.out.println("Case #" + t + ": " + "*");
                        return;
                    }
                }
                if (patternEnd.endsWith(patternsEnd)) {
                    if (patternEnd.length() > 10000) {
                        System.out.println("Case #" + t + ": " + "*");
                        return;
                    }
                    patternsEnd = patternEnd;
                } else if(!patternsEnd.endsWith(patternEnd)) {
                    System.out.println("Case #" + t + ": " + "*");
                    return;
                }
            }
        }
        String result = combine(patternsStart, patternsContain, patternsEnd);
        if (result.length() > 10000) {
            System.out.println("Case #" + t + ": " + "*");
            return;
        }
        System.out.println("Case #" + t + ": " + result);
    }
    
    private static String combine(String patternsStart, String patternsContain, String patternsEnd) {
        String result = patternsStart;
        
        int resultEndIndex;
        
        if (!patternsContain.isEmpty()) {
            resultEndIndex = 0;
            for (int i = patternsContain.length(); i >= 0; i--) {
                if (i == 0) break;
                String check = patternsContain.substring(0, i);
                if (result.endsWith(check)) {
                    resultEndIndex = i;
                } 
            }
            result = result + patternsContain.substring(resultEndIndex);
        }
        
        if (!patternsEnd.isEmpty()) {
            resultEndIndex = 0;
            for (int i = patternsEnd.length(); i >= 0; i--) {
                if (i == 0) break;
                String check = patternsEnd.substring(0, i);
                if (result.endsWith(check)) {
                    resultEndIndex = i;
                } 
            }
            result = result + patternsEnd.substring(resultEndIndex);
        }
        return result;
    }
}