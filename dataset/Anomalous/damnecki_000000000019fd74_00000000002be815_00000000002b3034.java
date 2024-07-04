import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    private static final PrintStream out = System.out;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<List<String>> patterns = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String pattern = scanner.next();
                String[] parts = pattern.split("\\*");
                
                for (int j = 0; j < parts.length; j++) {
                    if (patterns.size() <= j) {
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
                partList.sort((o1, o2) -> o2.length() - o1.length());
            }
            
            String result = determineResult(patterns);
            out.println("Case #" + t + ": " + result);
        }
    }

    private static String determineResult(List<List<String>> patterns) {
        if (patterns.size() == 2) {
            if (patterns.get(0).get(0).isEmpty()) {
                String basePattern = patterns.get(1).get(0);
                for (int i = 1; i < patterns.get(1).size(); i++) {
                    if (!basePattern.endsWith(patterns.get(1).get(i))) {
                        return "*";
                    }
                }
                return basePattern;
            } else {
                return "*";
            }
        } else {
            return "*";
        }
    }
}