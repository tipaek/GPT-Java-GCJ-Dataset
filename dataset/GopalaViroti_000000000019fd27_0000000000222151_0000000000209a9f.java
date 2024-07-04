import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);
        int testCount = sc.nextInt();
        for (int i = 1; i <= testCount; i++)
            solve(i, sc, w);
        w.close();		
	}
	public static void solve(int testNumber, Scanner sc, PrintWriter out) {
		String str = sc.next();
	    int size = str.length(); 
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<str.length();i++){
			int val= Character.getNumericValue(str.charAt(i));
			if(i==0){
				for(int j=0;j<val;j++){
					stack.push('(');
				}
				stack.push(str.charAt(i));
				if(i==size-1){
					for(int j=0;j<val;j++){
						stack.push(')');
					}
				}
			}
			else if(i<size-1){
				int popVal = Character.getNumericValue(stack.peek());
				push(val, popVal, stack, str.charAt(i));				
			}
			else{
				int popVal = Character.getNumericValue(stack.peek());
				push(val, popVal, stack, str.charAt(i));
				for(int k=0;k<val;k++){
					stack.push(')');
				}
			}
		}
		Stack<Character> backup = new Stack<Character>();
		while(!stack.isEmpty()){
			backup.push(stack.pop());
		}
		stack=null;
		StringBuilder ans = new StringBuilder();
		while(!backup.isEmpty()){
			ans.append(backup.pop());
		}
		out.println("Case #" + testNumber + ": " + ans.toString());
		
	}
	static void push(int val,int popVal,Stack<Character> stack, char ch){
		if(popVal<val){
			int diff = val-popVal;
			for(int j=0;j<diff;j++){
				stack.push('(');
			}
			stack.push(ch);
		}
		else if(popVal>val){
			int diff = popVal-val;
			for(int j=0;j<diff;j++){
				stack.push(')');
			}
			stack.push(ch);
		}
		else{
			stack.push(ch);
		}
	}
}