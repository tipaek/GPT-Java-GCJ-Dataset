import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(cin.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(cin.readLine());
            ArrayList<String> prefixes = new ArrayList<>();
            ArrayList<String> suffixes = new ArrayList<>();
            
            for (int n = 0; n < N; n++) {
                String s = cin.readLine();
                if (s.charAt(0) == '*') {
                    suffixes.add(s.substring(1));
                } else if (s.charAt(s.length() - 1) == '*') {
                    prefixes.add(s.substring(0, s.length() - 1));
                } else {
                    prefixes.add(s.substring(0, s.indexOf('*')));
                    suffixes.add(s.substring(s.indexOf('*') + 1));
                }
            }
            
            Collections.sort(prefixes, (s1, s2) -> s1.length() - s2.length());
            Collections.sort(suffixes, (s1, s2) -> s1.length() - s2.length());
            
            boolean isValid = true;
            
            while (prefixes.size() > 1 && isValid) {
                String last = prefixes.get(prefixes.size() - 1);
                String first = prefixes.get(0);
                if (last.startsWith(first)) {
                    prefixes.remove(0);
                } else {
                    isValid = false;
                }
            }
            
            while (suffixes.size() > 1 && isValid) {
                String last = suffixes.get(suffixes.size() - 1);
                String first = suffixes.get(0);
                if (last.endsWith(first)) {
                    suffixes.remove(0);
                } else {
                    isValid = false;
                }
            }
            
            if (isValid) {
                String prefix = prefixes.isEmpty() ? "" : prefixes.get(0);
                String suffix = suffixes.isEmpty() ? "" : suffixes.get(0);
                String shorter = prefix.length() < suffix.length() ? prefix : suffix;
                
                for (int i = 1; i <= shorter.length(); i++) {
                    if (prefix.endsWith(shorter.substring(0, i)) && suffix.startsWith(shorter.substring(shorter.length() - i))) {
                        suffix = suffix.substring(i);
                        break;
                    }
                }
                
                String solution = prefix + suffix;
                
                if (solution.length() > 10000) {
                    System.out.println("Case #" + t + ": *");
                } else {
                    System.out.println("Case #" + t + ": " + solution);
                }
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}