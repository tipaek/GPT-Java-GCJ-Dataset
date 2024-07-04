import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer testCount = Integer.parseInt(in.nextLine());
    
        for(int test = 1; test <= testCount; test++){
            String s = in.nextLine();
        
            String result = addParenthesis(s);

            System.out.println("Case #"+test+": "+result);
        }
    }
    
    private static String addParenthesis(String s){
        int open = 0;
        int close = 0;
        String result = "";
        for(int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);
            int current = Integer.parseInt(String.valueOf(curChar)); 
            int k = current - (open - close);
            while(k<0){
                result += ")";
                close++;
                k++;
            }
            while(k>0){
                result += "(";
                open++;
                k--;
            }
            result += curChar;
        }
        
        while(close<open){
            result += ")";
            close++;
        }
        
        return result;
    }
}