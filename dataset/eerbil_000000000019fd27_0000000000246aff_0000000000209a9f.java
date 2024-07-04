import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = Integer.parseInt(in.nextLine());
	    String[] res = new String[numCases];
	    for(int i = 0; i < numCases; i++) {
	    	String str = in.nextLine();
	    	String newStr = "";
	    	for(int j=0; j<str.length(); j++) {
	    		int num = Integer.parseInt(str.substring(j, j+1));
	    		String newSubStr = "";
	    		for(int k=0; k<num; k++) {
	    			newSubStr+="(";
	    		}
	    		newSubStr+=num;
	    		for(int k=0; k<num; k++) {
	    			newSubStr+=")";
	    		}
	    		newStr+=newSubStr;
	    	}
	    	res[i] = newStr;
	    	res[i] = removeRedundantParanthesis(newStr);
	    } 
	    
	    for(int i = 0; i < numCases; i++) {
	    	System.out.println("Case #"+ (i+1) +": "+res[i]);
	    }
	    in.close();
	}
	
	public static String removeRedundantParanthesis(String str) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(str.charAt(0));
		for(int i=1; i<str.length(); i++) {
			if(stack.peek()==')' && str.charAt(i)=='(') {
				stack.pop();
			} else {
				stack.push(str.charAt(i));	
			}
		}
		String fin = "";
		for(int i=0; i<stack.size(); i++) {
			fin+=stack.get(i);
		}
		return fin;
	}
}
