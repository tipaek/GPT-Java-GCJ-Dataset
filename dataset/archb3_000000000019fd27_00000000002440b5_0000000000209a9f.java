import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String tsStr = in.nextLine();
        int testcases = Integer.valueOf(tsStr);
        for (int i = 0; i < testcases; ++i) {
            String value = in.nextLine();
            String message = null;
            message = new Solution().minParenthesesString(value);
            System.out.println("Case #" + (i+1) + ": " +message);
        }
        in.close();
    }
    
    private String minParenthesesString(String input) {
        StringBuilder output = new StringBuilder();
        String[] inputArr = input.split("");
        int countOpeningBrackets =0;
        int lastChar = 0;
        for(int j=0; j<inputArr.length;j++) {
            int ch = Integer.valueOf(inputArr[j]);
            for(int cnt=0; cnt < Math.abs(ch-lastChar); cnt++) {
                if(lastChar < ch) {
                    output.append('(');
                    countOpeningBrackets++;
                } else if (lastChar > ch) {
                    output.append(')');
                    countOpeningBrackets--;
                } 
            } 
            output.append(ch);
            if(j==inputArr.length-1) {
                for(int cnt=0; cnt < countOpeningBrackets; cnt++) {
                    output.append(')'); 
                    
                }
            }
            lastChar = ch;
            
        }
        
        return output.toString();
    }
    
}
