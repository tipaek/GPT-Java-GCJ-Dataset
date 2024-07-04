import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static final Scanner SCANNER = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream OUTPUT = System.out;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int patternsCount = SCANNER.nextInt();
            List<List<String>> patterns = new ArrayList<>();
            String result = "";
            
            for (int i = 0; i < patternsCount; i++) {
                String pattern = SCANNER.next();
                String[] parts = pattern.split("\\*");
                
                for (int j = 0; j < parts.length; j++) {
                    if (patterns.size() == j) {
                        patterns.add(new ArrayList<>());
                    }
                    patterns.get(j).add(parts[j]);
                }
                
                if (pattern.endsWith("*")) {
                    if (patterns.size() == parts.length) {
                        patterns.add(new ArrayList<>());
                    }
                    patterns.get(patterns.size() - 1).add("");
                }
            }
            
            for (List<String> partList : patterns) {
                partList.sort(new StringLengthComparator());
            }
            
            if (patterns.size() == 2) {
                if (patterns.get(0).get(0).isEmpty()) {
                    String candidate = patterns.get(1).get(0);
                    boolean isValid = true;
                    
                    for (int i = 1; i < patterns.get(1).size(); i++) {
                        if (!candidate.startsWith(patterns.get(1).get(i))) {
                            result = "*";
                            isValid = false;
                            break;
                        }
                    }
                    
                    if (isValid) {
                        result = candidate;
                    }
                } else {
                    result = "*";
                }
            } else {
                result = "*";
            }
            
            OUTPUT.println("Case #" + t + ": " + result);
        }
    }

    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return Integer.compare(s2.length(), s1.length());
        }
    }
}