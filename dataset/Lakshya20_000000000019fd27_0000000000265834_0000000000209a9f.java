import java.util.*;
import java.io.*;

class Solution{
	static void nestDepth(String a){
		String ans="";
		int d=0;
		for (char ch:a.toCharArray()){
			int nd = ch - '0';
			while (nd>d){
				++d;
				ans=ans +"(";
			}
			while (nd<d){
				--d;
				ans=ans+")";
			}
			ans=ans+ch;
		}
		while (d>0){
			--d;
			ans+=")";
		}
		System.out.println(ans);
	}
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t=s.nextInt();
		for (int i=0;i<t;i++){
			String a=s.next();
			
			System.out.print("Case #"+(i+1)+": ");
			nestDepth(a);
		}
	}
}
		
		