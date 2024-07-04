import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            List<Pattern> patterns = new ArrayList<>();
            
            for (int i = 0; i < patternCount; i++) {
                patterns.add(new Pattern(scanner.next()));
            }
            
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            StringBuilder result = new StringBuilder();
            boolean isFaulty = false;
            
            while (!isFaulty && !allPatternsReachedForwardStar(patterns)) {
                char currentChar = '_';
                boolean foundCharacter = false;
                
                for (Pattern pattern : patterns) {
                    if (!pattern.reachedForwardStar) {
                        foundCharacter = true;
                        char nextChar = pattern.getForward();
                        if (currentChar != '_' && currentChar != nextChar) {
                            isFaulty = true;
                            break;
                        }
                        currentChar = nextChar;
                    }
                }
                
                if (foundCharacter) {
                    prefix.append(currentChar);
                }
            }
            
            while (!isFaulty && !allPatternsReachedReverseStar(patterns)) {
                char currentChar = '_';
                boolean foundCharacter = false;
                
                for (Pattern pattern : patterns) {
                    if (!pattern.reachedReverseStar) {
                        foundCharacter = true;
                        char nextChar = pattern.getReverse();
                        if (currentChar != '_' && currentChar != nextChar) {
                            isFaulty = true;
                            break;
                        }
                        currentChar = nextChar;
                    }
                }
                
                if (foundCharacter) {
                    suffix.insert(0, currentChar);
                }
            }
            
            for (Pattern pattern : patterns) {
                result.append(pattern.getRemaining());
            }
            
            if (isFaulty) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                System.out.println("Case #" + caseNumber + ": " + prefix + result + suffix);
            }
        }
        
        scanner.close();
    }
    
    private static boolean allPatternsReachedForwardStar(List<Pattern> patterns) {
        for (Pattern pattern : patterns) {
            if (!pattern.reachedForwardStar) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean allPatternsReachedReverseStar(List<Pattern> patterns) {
        for (Pattern pattern : patterns) {
            if (!pattern.reachedReverseStar) {
                return false;
            }
        }
        return true;
    }
}

class Pattern {
    private final String string;
    private int beginIndex;
    private int endIndex;
    boolean reachedForwardStar;
    boolean reachedReverseStar;

    public Pattern(String string) {
        this.string = string;
        this.beginIndex = 0;
        this.endIndex = string.length() - 1;
        this.reachedForwardStar = string.charAt(beginIndex) == '*';
        this.reachedReverseStar = string.charAt(endIndex) == '*';
    }

    public char getForward() {
        return string.charAt(beginIndex++);
    }

    public char getReverse() {
        return string.charAt(endIndex--);
    }

    public String getRemaining() {
        StringBuilder remaining = new StringBuilder();
        for (int i = beginIndex; i <= endIndex; i++) {
            if (string.charAt(i) != '*') {
                remaining.append(string.charAt(i));
            }
        }
        return remaining.toString();
    }
}