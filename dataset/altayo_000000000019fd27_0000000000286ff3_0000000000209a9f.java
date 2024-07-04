import java.util.*;


public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nCases; i++) {
            String curr = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            
            // Whats current number?
            // How many of concurrent occurences does it have?
            int level = 0;
            
            for (int l = 0; l < curr.length(); l++) {
                if (Character.getNumericValue(curr.charAt(l)) > level) {
                    sb.append('(');
                    level++;
                } else if (Character.getNumericValue(curr.charAt(l)) < level) {
                    sb.append(')');
                    level--;
                }
                sb.append(curr.charAt(l));
            }
            
            for (int j = 0; j < level; j++) {
                sb.append(')');
            }
            
            String result = sb.toString();
            
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}