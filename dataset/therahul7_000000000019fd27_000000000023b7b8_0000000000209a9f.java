import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); //test
        for (int i = 1; i <= t; ++i) {
           String str=in.next();
            int len = str.length();
            String out= getFormattedString(str);
            System.out.println("Case #"+i+": "+out);

        }
    }

    public static String getFormattedString(String s){
        int openParentheses = 0;
        int closingParentheses = 0;
        String formattedString = "";

        for(int i=0; i<s.length(); i++){
            int num = Integer.parseInt(String.valueOf(s.charAt(i)));

            int val = num;

            if(i == 0){
                String parentheses = "";
                while (num>0){
                    parentheses += "(";
                    openParentheses ++;
                    num--;
                }
                formattedString = formattedString + parentheses + val;
            }
            else{
                if(Integer.parseInt(String.valueOf(s.charAt(i-1))) < num){
                    int diff = num - Integer.parseInt(String.valueOf(s.charAt(i-1)));
                    String parentheses = "";
                    while(diff > 0){
                        parentheses += "(";
                        openParentheses ++;
                        diff--;
                    }
                    formattedString = formattedString + parentheses + num;
                }
                else{
                    int diff = Integer.parseInt(String.valueOf(s.charAt(i-1))) - num;
                    String parentheses = "";
                    while(diff > 0){
                        parentheses += ")";
                        openParentheses --;
                        diff --;
                    }
                    formattedString = formattedString + parentheses + num;
                }
            }
        }
        String Parentheses = "";
        while(openParentheses > 0){
            Parentheses += ")";
            openParentheses --;
        }

       return formattedString + Parentheses;
    }

}