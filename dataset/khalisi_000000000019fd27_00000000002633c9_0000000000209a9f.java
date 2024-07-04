

import java.util.Arrays;
import java.util.Scanner;

 public class Solution{
	
	
	public static StringBuilder parent(String str) {
		StringBuilder str1 =new StringBuilder();
		char[] st=(str.toCharArray());
		int s[]=new int[st.length];
		for(int i=0;i<st.length;i++) {
			s[i]=(int)(st[i]-48);
			
		}
		
		if(str.length()==1) {
			return str1.append('(').append(str).append(')');
			//System.out.println("("+str+")");
		}
		else {
		for(int j=str.length()-1;j>=0;j--) {
			if(j==str.length()-1) {
				for(int z=s[j];z>0;z--) {
					str1.append(')');
				}
				str1.append(s[j]);
			}
			
			else if(j==0) {
				
				if(s[j]<s[j+1]) {
					int rx=0;
					rx=s[j+1]-s[j];
					for(int z=rx;z>0;z--) {
						str1.append('(');
					}
				}
				
				else if(s[j]>s[j+1]) {
					int rx=0;
					rx=s[j]-s[j+1];
					for(int z=rx;z>0;z--) {
						str1.append(')');
					}
				}
				
				str1.append(s[j]);
				
				for(int z=s[j];z>0;z--) {
					str1.append('(');
				}
			}
			else {
				int rx=0;
				if(s[j]<s[j+1]) {
					rx=s[j+1]-s[j];
					for(int z=rx;z>0;z--) {
						str1.append('(');
					}
				}
				
				if(s[j]>s[j+1]) {
					rx=s[j]-s[j+1];
					for(int z=rx;z>0;z--) {
						str1.append(')');
					}
					
				}
				
				
				str1.append(s[j]);
			}
		}
		return str1.reverse();
		
		//System.out.println(str1.reverse());
		}
		
	}
	
	public static void main(String[] args) {
		
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0;i<t;i++) {
			String str=sc.next();
			System.out.println("Case #"+(i+1)+": "+parent(str));
		}
		
	}

}
