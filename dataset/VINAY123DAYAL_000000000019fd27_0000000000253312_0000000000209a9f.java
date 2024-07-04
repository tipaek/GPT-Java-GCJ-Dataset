import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Solution
{ 

        public static void main(String [] args) 
        { 
            Scanner input=new Scanner(System.in);
            int test=input.nextInt();
            for(int i=0;i<test;i++) {
            	String s=input.next();
            	Stack<String> stack1 = new Stack<>();
            	String str[] = s.split("");
            	for(int j=0;j<str.length;j++) {
            		//System.out.println(str[j]);
            		stack1.push(str[str.length-1-j]);
            	}
            	Stack<String> stack2=new Stack<>();
            	while(!stack1.isEmpty()) {
            		String a=stack1.peek();
            		//System.out.println(a);
            		if(a.equals("1")) {
            			if(stack2.isEmpty()) {
            				stack2.push("(");
                			stack2.push(stack1.pop());
            			}
            			else if(stack2.peek().equals("1")) {
            				stack2.push(stack1.pop());
            			}else if(stack2.peek().equals("0")) {
            				stack2.push("(");
            				stack2.push(stack1.pop());
            			} 
            		 }else if(a.equals("0")) {
            			if(stack2.isEmpty()) {
            				stack2.push(stack1.pop());
            			}
            			else if(stack2.peek().equals("1")) {
            				//System.out.println(") aana chahiye");
            				stack2.push(")");
            				stack2.push(stack1.pop());
            			}else {
            				stack2.push(stack1.pop());
            			}
            		}
            	}
            	if(stack2.peek().equals("1")) {
            		stack2.push(")");
            	}
            	while(!stack2.isEmpty()) {
            		stack1.push(stack2.pop());
            	}
            	System.out.print("Case #"+(i+1)+": ");
            	while(!stack1.isEmpty()) {
            		System.out.print(stack1.pop());
            	}
            	System.out.println();
            }
            }
 }


 