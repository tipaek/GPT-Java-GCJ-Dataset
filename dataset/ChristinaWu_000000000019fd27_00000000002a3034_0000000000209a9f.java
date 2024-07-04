import java.util.*;
                 
public class Solution{
     public static void main(String[] args) {		 
     Scanner in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		 String s = in.next();
		 StringBuilder sb = new StringBuilder();
		 
		 for(char ch: s.toCharArray()){
			 int number = (int)(ch - '0');
			 for(int i = 1; i <= number; i++)
				 sb.append('(');
			 sb.append(number);
			 for(int i = 1; i <= number; i++)
				 sb.append(')');
		 }
		 

			 int p = -1;
			 int q = p+1;
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
		 
		 StringBuilder sb2 = new StringBuilder();
		 for(int i = 0; i < sb.length(); i++){
			 if(sb.charAt(i) != '*')
				 sb2.append(sb.charAt(i));
		 }
		 
		String ans = sb2.toString();  
		System.out.println("Case #"+cas+": "+ans);
	 }
	 }
}
	 