import java.util.*;
public class Solution{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine());
		int cases=1;
		while(cases<=t){
			Stack<Character> stack=new Stack<Character>();
			String str=sc.nextLine();
			int counter=0;
			int num=str.charAt(0)-'0';
				for(int j=0;j<num;j++){
					stack.push('(');
					counter++;
			}
			stack.push(str.charAt(0));
			//System.out.println(stack.toString()+ " " + stack.pop().toString().charAt(0));
			for(int i=1;i<str.length();i++){
				char c=stack.peek().toString().charAt(0);
				//System.out.println("after peek "+ stack.toString());
				int digit=(char)c -'0';
				int next=str.charAt(i)-'0';
				if(next<digit){
					for(int j=0;j<digit-next;j++){
						stack.push(')');
						counter--;
					}
				}
				else if(next>digit){
					for(int j=0;j<next-digit;j++){
						stack.push('(');
						counter++;
					}
				}
				stack.push(str.charAt(i));
			}
			while(counter>0){
				stack.push(')');
				counter--;
			}
			StringBuilder sb=new StringBuilder("");
			while(!stack.empty()){
				sb.append(stack.pop().toString().charAt(0));
			}
			System.out.println("Case #"+cases+": " +sb.reverse().toString());
			cases++;
		}
	}
}