/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c = 1; c <= t; c++) {
		    String str = sc.next();
            Stack<Character> stack = new Stack<>();
            int tmp = Character.getNumericValue(str.charAt(0));
            int brOpen = tmp;
            while(tmp-- > 0) {
                stack.push('(');
            }
            stack.push(str.charAt(0));
            for(int i = 1; i < str.length(); i++) {
                if((int) str.charAt(i) == (int)str.charAt(i - 1)) {
                    stack.push(str.charAt(i));
                }
                else if((int) str.charAt(i) > (int)str.charAt(i - 1)) {
                    tmp = Character.getNumericValue(str.charAt(i)) - Character.getNumericValue(str.charAt(i - 1));
                    brOpen += tmp;
                    while(tmp-- > 0){
                        stack.push('(');
                    }
                    stack.push(str.charAt(i));
                }
                else{
                    tmp = Character.getNumericValue(str.charAt(i - 1)) - Character.getNumericValue(str.charAt(i));
                    brOpen -= tmp;
                    while(tmp-- > 0){
                        stack.push(')');
                    }
                    stack.push(str.charAt(i));
                }
            }
            while(brOpen-- > 0) {
                stack.push(')');
            }
            String output = "";
            while(!stack.isEmpty()) {
                output = stack.pop() + output;
            }
		    System.out.println("Case #" + c + ": " + output);
		}
	}
}
