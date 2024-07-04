import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            String[] patterns = new String[n];
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.nextLine();
                prefixes[i] = patterns[i].substring(0, patterns[i].indexOf("*"));
                suffixes[i] = new StringBuilder(patterns[i].substring(patterns[i].lastIndexOf("*") + 1)).reverse().toString();
            }
            
            boolean isMismatch = false;
            ArrayList<Character> prefixList = new ArrayList<>();
            
            for (String prefix : prefixes) {
                if (isMismatch) break;
                char[] prefixChars = prefix.toCharArray();
                for (int i = 0; i < prefixChars.length; i++) {
                    if (i >= prefixList.size()) {
                        prefixList.add(prefixChars[i]);
                    } else if (prefixList.get(i) != prefixChars[i]) {
                        isMismatch = true;
                        break;
                    }
                }
            }
            
            StringBuilder prefixResult = new StringBuilder();
            for (char c : prefixList) {
                prefixResult.append(c);
            }
            
            ArrayList<Character> suffixList = new ArrayList<>();
            for (String suffix : suffixes) {
                if (isMismatch) break;
                char[] suffixChars = suffix.toCharArray();
                for (int i = 0; i < suffixChars.length; i++) {
                    if (i >= suffixList.size()) {
                        suffixList.add(suffixChars[i]);
                    } else if (suffixList.get(i) != suffixChars[i]) {
                        isMismatch = true;
                        break;
                    }
                }
            }
            
            StringBuilder suffixResult = new StringBuilder();
            for (int i = suffixList.size() - 1; i >= 0; i--) {
                suffixResult.append(suffixList.get(i));
            }
            
            if (isMismatch) {
                System.out.println("Case #" + (t + 1) + ": *");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + prefixResult.toString() + suffixResult.toString());
            }
        }
        
        scanner.close();
    }
}