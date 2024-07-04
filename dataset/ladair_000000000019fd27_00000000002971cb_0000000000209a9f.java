import java.util.*;
import java.io.*;
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // num test cases
        int testCaseCounter = 0;
        while (testCaseCounter < testCases) {
            testCaseCounter++;
            String input = in.next();
            String output = parenthesisString(input);
            System.out.println("Case #" + testCaseCounter + ": "+output );

        }
    }


    public static String parenthesisString(String s){
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length ; i++) {
            char c = charArray[i];
            if(c =='1'){
                if(i-1 < 0 || charArray[i-1] == '0'){
                    sb.append('(');
                    sb.append('1');
                }else{
                    sb.append(charArray[i]);
                }
                if(i+1 >= charArray.length || charArray[i+1] == '0'){
                    sb.append(')');
                }
            }else{
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
    
}