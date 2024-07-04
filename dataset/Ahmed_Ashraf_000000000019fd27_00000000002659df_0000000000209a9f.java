import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
	     Scanner s = new Scanner(System.in);
		int t;
        t=s.nextInt();
        s.nextLine();
		for(int z=0;z<t;z++) {
		String a= new String();
		//s.nextLine();
		a=s.nextLine();
	    StringBuffer n=new StringBuffer(a);
		int first=(int)(n.charAt(0)-'0');
		
		while(first!=0) {
			n.insert(0, '(');
			first--;
		}
		
		int last=(int)(n.charAt(n.length()-1)-'0');
		while(last!=0) {
			n.insert(n.length(), ')');
			last--;
		}
		for (int i=0;i<n.length()-1;i++) {
			   if(n.charAt(i)==')' || n.charAt(i)=='(') {
				 continue;  
			   }
			   int size=(int)(n.charAt(i)-'0'); 
			   int j=i+1;
			   int sum =0;
			   while(j<n.length() &&  (n.charAt(j)==')' || n.charAt(j)=='(')) {
				   j++;
			   }
			   if (j<n.length() &&  n.charAt(j) < n.charAt(i)) {
				   size=(int)(n.charAt(i)-n.charAt(j)); 
				   while(sum!=size && sum < size) {
					   n.insert(i+1, ')');
					   sum++;
				   } 
			   }else if(j<n.length() &&  n.charAt(j) > n.charAt(i)) {
				   size=(int)(n.charAt(j)-n.charAt(i)); 
				   while(sum!=size && sum < size) {
					   n.insert(i+1, '(');
					   sum++;
				   } 
			   }}
		System.out.println("Case #"+(z+1)+": "+n);
	}}
	
}
