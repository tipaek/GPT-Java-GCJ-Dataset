import java.util.*;
public class Solution {
    
    private static String getMinBalancedSpecialString(String givenStr) {
        int curOpen = 0;
        String result = "";
        for(int idx = 0; idx < givenStr.length(); idx++) {
            int numOpenRequired = givenStr.charAt(idx) - '0';
            if(numOpenRequired > curOpen) {
                int extraBraces = numOpenRequired - curOpen;
                for(int open = 0; open < extraBraces; open++) {
                    result = result + '('; 
                    curOpen++;
                }
            } else if(numOpenRequired < curOpen) {
                int extraBraces = curOpen - numOpenRequired;
                for(int close = 0; close < extraBraces; close++) { 
                    result = result + ')';
                    curOpen--;
                }
            }
            result = result + givenStr.charAt(idx);
        }
        while(curOpen-->0)
            result = result + ')';
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestcases = scanner.nextInt();
        
        for(int testcase = 1; testcase <= numTestcases; testcase++) {
            String givenStr = scanner.next();
            String result = getMinBalancedSpecialString(givenStr);
            System.out.println("Case #" + testcase + ": " + result);
        }
    }
}