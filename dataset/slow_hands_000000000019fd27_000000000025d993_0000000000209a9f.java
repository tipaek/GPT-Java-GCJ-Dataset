
import java.util.*;
import java.io.*;


class pair{
	int a ;int b;
	public pair(int a,int b){
		this.a=a;
		this.b=b;
	}}
 class Solution { 
	
	public static String solve(String ss) {
		String ans="";
		boolean flag=false;
		int n=ss.length();int i=0;
		for ( i = 0; i < ss.length(); i++) {
			char temp=ss.charAt(i);
			if(!flag && temp=='1') {
				ans+='(';
				ans+='1';
				flag=true;
			}
			else if(flag && temp=='1') {
				ans+='1';
			}
			else if (flag && temp=='0') {
				flag=false;
				ans+=')';
				ans+='0';
			}
			else if(!flag && temp=='0') {
				
				ans+='0';
			}
		}
		if(i==n && flag) {
			ans+=')';
		}
		return ans;
	}


//
//	  
//	Case #1: 0000
//	Case #2: (1)0(1)
//	Case #3: (111)000
//	Case #4: (1)
	public static void main(String args[])throws IOException { 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] temp=reader.readLine().split(" ");	

		int t=Integer.parseInt(temp[0]);
		int c=1;
		while(t-->0) {
			String tem1=reader.readLine();	
		
		
		String ans=solve(tem1);
		System.out.println("Case #"+(c)+":"+" "+ans);
		c++;
		}

	} 
} 
