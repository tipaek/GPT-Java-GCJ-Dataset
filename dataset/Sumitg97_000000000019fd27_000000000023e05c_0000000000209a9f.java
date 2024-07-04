import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void appendStartParenthesis(StringBuilder s , int n) {
        for(int i = 0; i < n ; i++) {
            s = s.append("(");
        }
    }

    public static void appendEndParenthesis(StringBuilder s , int n) {
        for(int i = 0; i < n ; i++) {
            s = s.append(")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseCounter = 1;
        while(t-->0) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder("");
            int openParenthesis = 0;
            int i = 0, j = 0;
            for(i = 0; i < s.length() ; i++) {
                int d = s.charAt(i) - 48;
                if(openParenthesis == 0) {
                    appendStartParenthesis(sb , d);
                    openParenthesis = d;
                }
                else if(d < openParenthesis) {
                    appendEndParenthesis(sb , openParenthesis - d);
                    openParenthesis = openParenthesis - (openParenthesis - d);
                }
                else if(d > openParenthesis) {
                    appendStartParenthesis(sb , d - openParenthesis);
                    openParenthesis = d;
                }
                sb = sb.append(d);
            }
            appendEndParenthesis(sb , openParenthesis);
            System.out.println("Case #" + caseCounter + ": " + sb.toString());
            caseCounter++;
        }
    }
}
