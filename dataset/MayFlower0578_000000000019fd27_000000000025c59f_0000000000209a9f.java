import java.util.Scanner;
                 
public class Solution{
     public static void main(String[] args) {		 
     Scanner in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		 String s = in.next();
		 StringBuilder sb = new StringBuilder();
		 int maxDig = 0;
		 
		 for(char ch: s.toCharArray()){
			 int dig = (int)(ch - '0');
			 maxDig = Math.max(maxDig, dig);
			 for(int i = 0; i < dig; i++)
				 sb.append('(');
			 sb.append(dig);
			 for(int i = 0; i < dig; i++)
				 sb.append(')');
		 }
		 

			 int p = -1,  q = 0;
			 while(p < sb.length() - 2){
				 p++;  q = p+1;
			     while(sb.charAt(p) == ')' && sb.charAt(q) == '('){
					 sb.setCharAt(p,'*');
					 sb.setCharAt(q,'*');
					 p--;
					 q++;
				 }
				 p = q - 1;
			 }
		 
		 StringBuilder res = new StringBuilder();
		 for(int i = 0; i < sb.length(); i++){
			 if(sb.charAt(i) != '*')
				 res.append(sb.charAt(i));
		 }
		  
		System.out.println("Case #"+cas+": "+res.toString());
	 }
	 }
}
	 
	 