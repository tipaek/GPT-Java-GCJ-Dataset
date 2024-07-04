import java.util.Scanner;
import java.util.Stack;

class NestingDepth {
	 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in); 
		
		int nbrTc = in.nextInt();
		
		for(int nbr =1; nbr <= nbrTc ; nbr++) {
		
		 String strIn = in.next(); 
		
		 Stack<String> bracketStack = new Stack<>();
		
		 StringBuilder sb = new StringBuilder();
		 
		 int prev =-1;
		 
		 for(int i =0; i< strIn.length();i++) {
			 
			int val = Integer.valueOf(strIn.substring(i, i+1));
			if(val>prev) {
				while(!bracketStack.isEmpty()) {
					sb.append(bracketStack.pop());
				}
				
				for(int count =0;count<val;count++) {
					sb.append("(");
					bracketStack.add(")");
				}
				sb.append(val);
				prev = val;
			}else {
				int diff = prev - val;
				for(int count =0;count<diff;count++) {
					if(!bracketStack.isEmpty()) {
						sb.append(bracketStack.pop());
					}
				}
				sb.append(val);
				prev = val;
			}
			
		 }
		 while(!bracketStack.isEmpty()) {
				sb.append(bracketStack.pop());
			}
		 
		 System.out.println("Case #"+nbr+": "+ sb.toString());
		}
		 in.close();
	 }

}