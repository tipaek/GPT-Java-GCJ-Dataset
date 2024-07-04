import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            boolean isValid = true;
            
            for (int i = 0; i < n; i++) {
                String current = scanner.next();
                String[] parts = current.split("\\*");
                
                if (current.charAt(current.length() - 1) == '*') {
                    parts = Arrays.copyOf(parts, parts.length + 1);
                    parts[parts.length - 1] = "";
                }
                
                if (prefix.length() < parts[0].length()) {
                    if (prefix.toString().equals(parts[0].substring(0, prefix.length()))) {
                        prefix = new StringBuilder(parts[0]);
                    } else {
                        isValid = false;
                    }
                } else {
                    if (!prefix.toString().startsWith(parts[0])) {
                        isValid = false;
                    }
                }
                
                if (suffix.length() < parts[1].length()) {
                    if (suffix.toString().equals(parts[1].substring(parts[1].length() - suffix.length()))) {
                        suffix = new StringBuilder(parts[1]);
                    } else {
                        isValid = false;
                    }
                } else {
                    if (!suffix.toString().endsWith(parts[1])) {
                        isValid = false;
                    }
                }
            }
            
            if (isValid) {
                System.out.println("Case #" + t + ": " + merge(prefix.toString(), suffix.toString()));
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
        
        scanner.close();
    }
    
    public static String merge(String s1, String s2) {
        for (int i = Math.min(s1.length(), s2.length()); i >= 0; i--) {
            if (s1.endsWith(s2.substring(0, i))) {
                return s1.substring(0, s1.length() - i) + s2;
            }
        }
        return s1 + s2;
    }
}