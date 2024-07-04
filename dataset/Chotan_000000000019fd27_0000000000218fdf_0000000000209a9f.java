import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		for(int t = 1; t <= T; t++) {
		    System.out.println("Case #" + t + ": " + insertParenthesis(String.valueOf(sc.next())));
		}
	}
	
	static String insertParenthesis(String S) {
	    char[] string = S.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    int count = 0;
	    for(int i = 0; i < string.length; i++) {
	        int N = string[i] - '0';
	        if(count < N) {
	            int total = N - count;
	            for(int j = 0; j < total; j++) {
	                sb.append('(');
	            }
	            count += total;
	        } else if(count == string[i] - '0'){
	            
	        } else {
	            int total = count - N;
	            for(int j = 0; j < total; j++) {
	                sb.append(')');
	            }
	            count -= total;
	        }
	        sb.append(string[i]);
	    }
	    for(int i = 0; i < count; i++) {
            sb.append(')');
        }
        return sb.toString();
	}
}
