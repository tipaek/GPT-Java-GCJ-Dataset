import java.util.*;
import java.io.*;

public class Solution {

	public static void addBrackets(Stack<Character> parenthesis, char num) {
		int n = Character.getNumericValue(num);
		for(int i=0; i<n; i++) {
			parenthesis.add('(');
		}
		parenthesis.add(num);
		for(int i=0; i<n; i++) {
			parenthesis.add(')');
		}
		
	}
	
	public static void insertDigit(Stack<Character> parenthesis, char num) {
		int n = Character.getNumericValue(num);
		for(int i=0; i<n; i++) {
			parenthesis.pop();
		}
		parenthesis.add(num);
		for(int i=0; i<n; i++) {
			parenthesis.add(')');
		}
	}
	
	public static int checkLastDepth(Stack<Character> parenthesis) {
		Stack<Character> p = (Stack<Character>)parenthesis.clone();
	    if (p.isEmpty())  
	        return 0;  
	    
	    char top = p.peek(); 
	    while(top == ')') {
	    	p.pop();  
		    top = p.peek(); 
			  
	    }
	    
		return Character.getNumericValue(top);
	}
	
	public static void printStack(Stack<Character> parenthesis) {  
	    if (parenthesis.isEmpty())  
	        return;  
	      
	    char top = parenthesis.peek();  
	    parenthesis.pop();  
	  
	    printStack(parenthesis);  
	    System.out.print(top);  
	    parenthesis.push(top);  
	}  
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    for (int i = 1; i <= t; ++i) {
	    	String nums = in.next();
	    	Stack<Character> parenthesis = new Stack<>();
			for(int j = 0; j < nums.length(); j++) {
				char n = nums.charAt(j);
				int depth = checkLastDepth(parenthesis);
				if(depth < Character.getNumericValue(n)) {
					addBrackets(parenthesis, n);
				}
				else {
					insertDigit(parenthesis, n);
				}
				
			}
			System.out.print("Case #" + i + ": ");
			printStack(parenthesis);
			System.out.println();
			
	    }
		
	}

}
