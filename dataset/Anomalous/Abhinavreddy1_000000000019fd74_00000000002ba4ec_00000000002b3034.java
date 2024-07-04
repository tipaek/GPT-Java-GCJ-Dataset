import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] patterns = new String[n];
            int maxLength = -1;
            int indexOfMax = -1;
            
            for (int i = 0; i < n; i++) {
                patterns[i] = br.readLine();
                if (patterns[i].length() > maxLength) {
                    maxLength = patterns[i].length();
                    indexOfMax = i;
                }
            }
            
            StringBuilder targetBuilder = new StringBuilder();
            for (char c : patterns[indexOfMax].toCharArray()) {
                if (c != '*') {
                    targetBuilder.append(c);
                }
            }
            String target = targetBuilder.toString();
            boolean isValid = true;
            
            for (String pattern : patterns) {
                int startIndex = 0;
                int endIndex = 0;
                
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        endIndex = j;
                        if (endIndex > startIndex) {
                            if (!target.contains(pattern.substring(startIndex, endIndex))) {
                                isValid = false;
                                break;
                            }
                        }
                        startIndex = j + 1;
                    }
                    if (j == pattern.length() - 1 && pattern.charAt(j) != '*' && !target.contains(pattern.substring(startIndex, j + 1))) {
                        isValid = false;
                    }
                }
                if (!isValid) {
                    break;
                }
            }
            
            if (!isValid) {
                System.out.println("*");
            } else {
                System.out.println(target);
            }
        }
    }
}