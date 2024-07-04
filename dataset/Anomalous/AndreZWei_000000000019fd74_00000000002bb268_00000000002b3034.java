import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int d = scanner.nextInt();
            String[] patterns = new String[d];
            
            for (int j = 0; j < d; j++) {
                patterns[j] = scanner.next();
            }
            
            System.out.println("Case #" + i + ": " + solve(patterns));
        }
    }

    public static String solve(String[] patterns) {
        String head = null;
        String tail = null;
        
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            
            if (pattern.charAt(0) != '*') {
                String currentHead = parts[0];
                
                if (head == null) {
                    head = currentHead;
                } else if (currentHead.length() > head.length() && currentHead.startsWith(head)) {
                    head = currentHead;
                } else if (!(currentHead.length() <= head.length() && head.startsWith(currentHead))) {
                    return "*";
                }
            }
            
            if (pattern.charAt(pattern.length() - 1) != '*') {
                String currentTail = parts[parts.length - 1];
                
                if (tail == null) {
                    tail = currentTail;
                } else if (currentTail.length() > tail.length() && currentTail.endsWith(tail)) {
                    tail = currentTail;
                } else if (!(currentTail.length() <= tail.length() && tail.endsWith(currentTail))) {
                    return "*";
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        if (head != null) {
            result.append(head);
        }
        
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            int start = pattern.charAt(0) == '*' ? 0 : 1;
            int end = pattern.charAt(pattern.length() - 1) == '*' ? parts.length - 1 : parts.length - 2;
            
            for (int i = start; i <= end; i++) {
                result.append(parts[i]);
            }
        }
        
        if (tail != null) {
            result.append(tail);
        }
        
        return result.toString();
    }
}