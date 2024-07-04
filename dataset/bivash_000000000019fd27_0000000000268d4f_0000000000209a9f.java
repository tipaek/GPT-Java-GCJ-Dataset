import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String[] ans = new String[t];
        String[] intermediate = new String[t];
        String[] modified = new String[t];
        input.nextLine();
        String[] nums = new String[t];
        for(int i=0; i<t; i++) {
            nums[i] = input.next();
        }
        for(int i=0; i<t;i++) {
            String str = nums[i];
            String result="";
            for(int j=0; j<str.length()-1; j++) {
                if(str.charAt(j)==str.charAt(j+1)) {
                    result += str.charAt(j);
                }
                else {
                    result += str.charAt(j)+" ";
                }  
            }
            result += str.charAt(str.length()-1);
            intermediate[i] = result;
        }
        
        for(int i=0; i<t; i++) {
            String str = intermediate[i];
            String bracket = "";
            if(str.length()==1) {
                bracket += openBracket(str.charAt(0))+str.charAt(0)+closeBracket(str.charAt(0));
            }
            else {
                for(int j=0; j<str.length(); j++) {
                    if(j==0) {
                        bracket += openBracket(str.charAt(j))+str.charAt(0);
                    }
                    else if(j==str.length()-1) {
                        bracket += str.charAt(j)+closeBracket(str.charAt(j));
                    }
                    else {
                        if(str.charAt(j)==' ') {
                            bracket += closeBracket(str.charAt(j-1));
                            bracket += openBracket(str.charAt(j+1));
                        }
                        else {
                            bracket += str.charAt(j);
                        }      
                    }
                }
            }
            modified[i] = bracket;
        }
        
        for(int i=0; i<t; i++) {
            String str = modified[i];
            String finalResult = str.replace(")(", "");
            ans[i] = finalResult;
        }
        for(int i=0; i<t; i++) {
            System.out.println("Case #"+(i+1)+": "+ans[i]);
        }
    }
    public static String openBracket(char c) {
        int n = Character.getNumericValue(c);
        String bracket = "";
        for(int i=0; i<n; i++) {
            bracket += "(";
        }
        return bracket;
    }
    public static String closeBracket(char c) {
        int n = Character.getNumericValue(c);
        String bracket = "";
        for(int i=0; i<n; i++) {
            bracket += ")";
        }
        return bracket;
    }
}