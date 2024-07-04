import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        String s = sc.next();
	        for(int i = 1; i <= 9; i++){
	            String digit = "";
	            digit += (char)(i + '0');
	            String digitWithParentheses = digit;
	            for(int j = 0; j < i; j++){
	                digitWithParentheses = digitWithParentheses.replace(digit, "(" + digit + ")");
	            }
	            s = s.replace(digit, digitWithParentheses);
	        }
	        while(s.indexOf(")(") >= 0){
	            s = s.replace(")(","");
	        }
	        System.out.println("Case #" + tt + ": " + s);
	    }
	}
}