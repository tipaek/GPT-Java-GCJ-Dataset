import java.util.*;
public class Solution{
	
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		int t=in.nextInt();
		int ind=1;
		while(t-->0) {
		
			
		 String s=in.next();
		 StringBuilder sb=new StringBuilder();
		 int o=0;
		 for(int i=0;i<s.length();i++)
		 {
			 int p=s.charAt(i)-'0';
			 if(p>o) {
				 int k=p-o;
				 for(int j=0;j<k;j++)
				 {
					 sb.append('(');
					 o++;
				 }
				 
				 sb.append(p);
				 
			 }
			 
			 
			 else {
				 
				 if(o>p)
				 {
					 int k=o-p;
					for(int j=0;j<k;j++)
					{
						sb.append(')');
						o--;
						
					}
					sb.append(p);
					 
				 }
				 
				 else {
					 sb.append(p);
				 }
			 }
			 
		 }
			
		for(int i=0;i<o;i++)
			sb.append(')');
		
		
		
		System.out.println("Case"+" "+"#"+ind+":"+" "+sb.toString());
		ind++;
		
	}
	
	
	}
}