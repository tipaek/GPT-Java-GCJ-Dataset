import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); //Number of cases
        for (int i = 0; i <= t; ++i) {
        	String s = in.nextLine();
        	//System.out.println(s);
        	for(int j = 0; j < s.length(); j++){
        		//System.out.println(j+","+s.charAt(j));
        		if(s.charAt(j) == '('){
        			continue;
        		}
        		int parentheses = 0;
        		for(int k = 0; k < j; k++){
        			if(s.charAt(k) == '('){
        				parentheses++;
        			}
        		}
        		
        		int n = Integer.parseInt(""+s.charAt(j)) - parentheses;
        		if(n < 0){n = 0;}
        		s = s.substring(0,j) + new String(new char[n]).replace('\0', '(') + s.substring(j);
        		j += n;
        	}
        	//System.out.println(s);
        	
        	s = s + "0";
        	for(int j = 0; j < s.length(); j++){
        		if(s.charAt(j) == '('){
    				continue;
    			}
        		int parentheses = 0;
        		for(int k = 0; k < j; k++){
        			if(s.charAt(k) == '('){
        				parentheses++;
        			}
        			if(s.charAt(k) == ')'){
        				parentheses--;
        			}
        		}
        		//System.out.println(s.substring(0,j)+","+parentheses);
        		if(Integer.parseInt(""+s.charAt(j)) < parentheses){
        			s = s.substring(0,j) + ")" + s.substring(j);
        		}
        		if(s.charAt(j) != ')' && s.charAt(j) != '('){
        			if(Integer.parseInt(""+s.charAt(j)) > parentheses){
        				s = s.substring(0,j) + "(" + s.substring(j);
        			}
        		}
        	}
        	
        	if(i == 0){
        		continue;
        	}
        	System.out.println("Case #"+i+": "+s.substring(0,s.length()-1));
        }
	}
}