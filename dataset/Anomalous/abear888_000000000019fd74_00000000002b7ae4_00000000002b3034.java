import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int cases = 1; cases <= t; cases++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
            }
            
            int[] idxs = new int[n];
            StringBuilder prefix = new StringBuilder();
            boolean isValid = true;
            
            // Process prefixes
            while (true) {
                boolean allStars = true;
                char currentChar = 0;
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(idxs[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(idxs[i]);
                        } else if (currentChar != patterns[i].charAt(idxs[i])) {
                            isValid = false;
                            break;
                        }
                    }
                }
                
                if (!isValid || allStars) {
                    break;
                }
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(idxs[i]) == currentChar) {
                        idxs[i]++;
                    }
                }
                
                prefix.append(currentChar);
            }
            
            int[] endIdxs = new int[n];
            for (int i = 0; i < n; i++) {
                endIdxs[i] = patterns[i].length() - 1;
            }
            
            StringBuilder suffix = new StringBuilder();
            
            // Process suffixes
            while (true) {
                boolean allStars = true;
                char currentChar = 0;
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(endIdxs[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(endIdxs[i]);
                        } else if (currentChar != patterns[i].charAt(endIdxs[i])) {
                            isValid = false;
                            break;
                        }
                    }
                }
                
                if (!isValid || allStars) {
                    break;
                }
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(endIdxs[i]) == currentChar) {
                        endIdxs[i]--;
                    }
                }
                
                suffix.append(currentChar);
            }
            
            // Collect the middle parts
            for (int i = 0; i < n; i++) {
                for (int j = idxs[i] + 1; j < endIdxs[i]; j++) {
                    if (patterns[i].charAt(j) != '*') {
                        prefix.append(patterns[i].charAt(j));
                    }
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + cases + ": " + prefix + suffix.reverse());
            } else {
                System.out.println("Case #" + cases + ": *");
            }
        }
        
        sc.close();
    }
}