import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner read=new Scanner(System.in);
		ArrayDeque<Integer> stack=new ArrayDeque();
		
		int loop=1;
		
		String s="";
		
		int testCase=Integer.parseInt(read.nextLine());
		while(loop<=testCase) {
			
			
			char[] e=read.nextLine().toCharArray();
			for(int i=0;i<e.length;i++) {
				
				if(stack.isEmpty()) {
					for(int j=0;j<Integer.parseInt(""+e[i]);j++) {
						s=s+"(";
					}
					stack.push(Integer.parseInt(""+e[i]));
					s=s+e[i];
				}
				else {
					if(Integer.parseInt(""+e[i])>stack.peek()) {
						int d=Integer.parseInt(""+e[i])-stack.peek();
						for(int j=0;j<d;j++) {
							s=s+"(";
						}
						stack.push(Integer.parseInt(""+e[i]));
						s=s+e[i];
					}
					else if(Integer.parseInt(""+e[i])<stack.peek()) {
						int d=stack.peek()-Integer.parseInt(""+e[i]);
						for(int j=0;j<d;j++) {
							s=s+")";
						}
						stack.push(Integer.parseInt(""+e[i]));
						s=s+e[i];
					}
					else {
						stack.push(Integer.parseInt(""+e[i]));
						s=s+e[i];
					}
				}
			}	
			
			if(!stack.isEmpty())
			for(int l=0;l<stack.peek();l++) {
				s=s+")";
			}
			
			System.out.println("Case #"+loop+": "+s);
			loop++;
			stack.clear();
			s="";
		}
		
		read.close();
		
		
	}

}
