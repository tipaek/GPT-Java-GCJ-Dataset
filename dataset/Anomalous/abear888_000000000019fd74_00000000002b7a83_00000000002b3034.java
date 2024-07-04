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
            
            int[] startIndexes = new int[n];
            StringBuilder prefix = new StringBuilder();
            boolean isValid = true;
            boolean allStars = false;
            
            while (!allStars) {
                allStars = true;
                char currentChar = 0;
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(startIndexes[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(startIndexes[i]);
                        } else if (currentChar != patterns[i].charAt(startIndexes[i])) {
                            isValid = false;
                            break;
                        }
                    }
                }
                
                if (!isValid) break;
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(startIndexes[i]) == currentChar) {
                        startIndexes[i]++;
                    }
                }
                
                if (!allStars) {
                    prefix.append(currentChar);
                }
            }
            
            int[] endIndexes = new int[n];
            for (int i = 0; i < n; i++) {
                endIndexes[i] = patterns[i].length() - 1;
            }
            
            allStars = false;
            StringBuilder suffix = new StringBuilder();
            
            while (!allStars) {
                allStars = true;
                char currentChar = 0;
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(endIndexes[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(endIndexes[i]);
                        } else if (currentChar != patterns[i].charAt(endIndexes[i])) {
                            isValid = false;
                            break;
                        }
                    }
                }
                
                if (!isValid) break;
                
                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(endIndexes[i]) == currentChar) {
                        endIndexes[i]--;
                    }
                }
                
                if (!allStars) {
                    suffix.append(currentChar);
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = startIndexes[i] + 1; j < endIndexes[i]; j++) {
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
    }
}