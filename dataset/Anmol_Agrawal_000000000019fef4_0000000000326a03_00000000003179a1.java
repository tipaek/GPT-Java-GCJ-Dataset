import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        int U = sc.nextInt();
	        HashMap<Character, Character> hm = new HashMap<>();
	        for(int i = 0; i < 10000; i++){
	            int A = sc.nextInt();
	            String S = sc.next();
	            if(hm.size() < 10){
    	            String num = Integer.toString(A);
    	            for(int j = 0; j < num.length(); j++){
    	                hm.put(num.charAt(j), S.charAt(j));
    	            }
	            }
	        }
	        String ans = "";
	        for(char i = '0'; i <= '9'; i++){
	            ans += hm.get(i);
	        }
	        System.out.println("Case #" + tt + ": " + ans);
	    }
	}
}