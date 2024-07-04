import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            int n = sc.nextInt();
            
            String[] patterns = new String[n];
            
            for(int i=0; i<n; i++)
                patterns[i] = sc.next();
            
            String result = solve(patterns);
            
            System.out.println("Case #" + tc + ": " + result);
        }
    }
    
    public static String solve(String[] patterns) {
        String result = "";
        
        String[] leftpatterns = new String[patterns.length];
        String[] rightpatterns = new String[patterns.length];
        
        for (int i=0; i<patterns.length; i++) {
            String[] chunks = patterns[i].split("\\*");
            leftpatterns[i] = (chunks.length > 0) ? chunks[0] : "";
            rightpatterns[i] = (chunks.length > 1) ? chunks[1] : "";
        }
        
        String leftmatch = solveLeft(leftpatterns);
        String rightmatch = solveRight(rightpatterns);
        
        if (leftmatch.length() > 0 || rightmatch.length() > 0)
        {
            result = leftmatch + rightmatch;
        }
        else
            result = "*";
        
        return result;
    }
    
    public static String solveLeft(String[] patterns) {
        String result = "";
        
        String maxString = "";
        
        for (String pattern : patterns) {
            if (maxString.length() < pattern.length())
                maxString = pattern;
        }
        
        boolean matches = true;
        for (String pattern : patterns) {
            String fromMaxString = maxString.substring(0, maxString.length() - (maxString.length() - pattern.length()));
            
            if (!fromMaxString.equals(pattern)) {
                matches = false;
                break;
            }
        }
        
        if (matches)
            result = maxString;
        
        return result;
    }
    
    public static String solveRight(String[] patterns) {
        String result = "";
        
        String maxString = "";
        
        for (String pattern : patterns) {
            if (maxString.length() < pattern.length())
                maxString = pattern;
        }
        
        boolean matches = true;
        for (String pattern : patterns) {
            String fromMaxString = maxString.substring(maxString.length() - pattern.length(), maxString.length());
            
            if (!fromMaxString.equals(pattern)) {
                matches = false;
                break;
            }
        }
        
        if (matches)
            result = maxString;
        
        return result;
    }
}