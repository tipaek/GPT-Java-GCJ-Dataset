import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int q = reader.nextInt();
        
        for (int c = 1; c <= q; c++) {
            int n = reader.nextInt();
            String[] patterns = new String[n];
            
            for (int i = 0; i < n; i++) {
                patterns[i] = reader.next();
            }
            
            String suffix = "";
            String prefix = "";
            boolean possible = true;
            boolean[] considered = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                int starCount = 0;
                for (char ch : patterns[i].toCharArray()) {
                    if (ch == '*') starCount++;
                }
                
                if (starCount == 1) {
                    String[] parts = patterns[i].split("\\*");
                    String start = parts[0];
                    String end = parts.length == 1 ? "" : parts[1];
                    considered[i] = true;

                    if (end.length() > suffix.length() && end.contains(suffix)) {
                        suffix = end;
                    } else if (!suffix.contains(end)) {
                        possible = false;
                    }

                    if (start.length() > prefix.length() && start.contains(prefix)) {
                        prefix = start;
                    } else if (!prefix.contains(start)) {
                        possible = false;
                    }
                }
            }
            
            if (!possible) {
                System.out.printf("Case #%d: *\n", c);
                continue;
            }
            
            boolean allConsidered = true;
            for (boolean b : considered) {
                if (!b) {
                    allConsidered = false;
                    break;
                }
            }
            
            if (allConsidered) {
                System.out.printf("Case #%d: %s\n", c, prefix + suffix);
            }
        }
        
        reader.close();
    }
}