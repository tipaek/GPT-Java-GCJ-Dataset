import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];
            
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.next();
            }
            
            int[] startIndices = new int[patternCount];
            int[] endIndices = new int[patternCount];
            for (int i = 0; i < patternCount; i++) {
                endIndices[i] = patterns[i].length() - 1;
            }
            
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            
            while (true) {
                boolean allStars = true;
                char currentChar = 0;
                
                for (int i = 0; i < patternCount; i++) {
                    if (patterns[i].charAt(startIndices[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(startIndices[i]);
                        } else if (currentChar != patterns[i].charAt(startIndices[i])) {
                            isPossible = false;
                            break;
                        }
                    }
                }
                
                if (!isPossible || allStars) break;
                
                for (int i = 0; i < patternCount; i++) {
                    if (patterns[i].charAt(startIndices[i]) == currentChar) {
                        startIndices[i]++;
                    }
                }
                
                result.append(currentChar);
            }
            
            StringBuilder endResult = new StringBuilder();
            
            while (true) {
                boolean allStars = true;
                char currentChar = 0;
                
                for (int i = 0; i < patternCount; i++) {
                    if (patterns[i].charAt(endIndices[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(endIndices[i]);
                        } else if (currentChar != patterns[i].charAt(endIndices[i])) {
                            isPossible = false;
                            break;
                        }
                    }
                }
                
                if (!isPossible || allStars) break;
                
                for (int i = 0; i < patternCount; i++) {
                    if (patterns[i].charAt(endIndices[i]) == currentChar) {
                        endIndices[i]--;
                    }
                }
                
                endResult.append(currentChar);
            }
            
            for (int i = 0; i < patternCount; i++) {
                for (int j = startIndices[i]; j <= endIndices[i]; j++) {
                    if (patterns[i].charAt(j) != '*') {
                        result.append(patterns[i].charAt(j));
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + result + endResult.reverse());
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
        
        scanner.close();
    }
}