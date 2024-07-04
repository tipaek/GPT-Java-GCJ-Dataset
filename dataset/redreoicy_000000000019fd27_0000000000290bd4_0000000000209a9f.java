import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        for (int k = 0; k < t; k++) {
            //working code here
            String s = stdin.next();
            int curDepth = 0;
            String result = "";
            for(int i = 0; i<s.length();i++){
                int digit = Character.getNumericValue(s.charAt(i));
                while(curDepth < digit){
                    result += '(';
                    curDepth++;
                }
                while(curDepth > digit){
                    result += ')';
                    curDepth--;
                }
                result += s.charAt(i);
            }
            
            while(curDepth > 0){
                result += ')';
                curDepth--;
            }
            
            
            
            
            System.out.printf("Case #%d: %s\n", k+1, result);
        }

    }
    
}
