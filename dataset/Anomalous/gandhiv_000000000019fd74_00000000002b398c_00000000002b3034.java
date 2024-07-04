import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = sc.nextInt();
            List<String> substrings = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                substrings.add(input.substring(1));
            }
            
            Collections.sort(substrings);
            String firstSubstring = substrings.get(0);
            boolean isCommonSubstring = true;
            
            for (int i = 1; i < substrings.size(); i++) {
                if (!firstSubstring.contains(substrings.get(i))) {
                    isCommonSubstring = false;
                    break;
                }
            }
            
            System.out.print("Case #" + caseNum + ": ");
            if (isCommonSubstring) {
                System.out.println(firstSubstring);
            } else {
                System.out.println("*");
            }
        }
        
        sc.close();
    }
}