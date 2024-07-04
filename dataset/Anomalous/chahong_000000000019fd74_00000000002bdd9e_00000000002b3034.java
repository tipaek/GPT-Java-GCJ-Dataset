import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            String[] patterns = new String[num];
            
            for (int j = 0; j < num; j++) {
                patterns[j] = sc.next();
            }
            
            Arrays.sort(patterns, (a, b) -> b.length() - a.length());
            
            String finalResult = null;
            boolean isValid = true;
            
            for (int k = 1; k < patterns.length && isValid; k++) {
                int index1 = 0, index2 = 0;
                boolean hasAsterisk1 = false, hasAsterisk2 = false;
                String suffix1 = null, suffix2 = null;
                
                while (true) {
                    char char1 = patterns[0].charAt(index1);
                    char char2 = patterns[k].charAt(index2);
                    
                    if (hasAsterisk1 && hasAsterisk2) {
                        suffix1 = patterns[0].substring(index1);
                        suffix2 = patterns[k].substring(index2);
                        
                        if (!suffix1.contains(suffix2)) {
                            finalResult = "*";
                            isValid = false;
                            break;
                        } else {
                            break;
                        }
                    }
                    
                    if (char1 == '*') {
                        index1++;
                        hasAsterisk1 = true;
                    }
                    
                    if (char2 == '*') {
                        index2++;
                        hasAsterisk2 = true;
                    }
                }
                
                if (isValid) {
                    finalResult = suffix1;
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + (finalResult != null ? finalResult : "*"));
        }
    }
}