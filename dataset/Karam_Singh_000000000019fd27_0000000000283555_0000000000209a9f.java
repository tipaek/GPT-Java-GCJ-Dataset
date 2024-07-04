import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt(),count=1;
		while(t-->0) {
		String s=scn.next();
		Final(s, "",count);
		count++;
//		String ans="";
//		for(int i=0;i<s.length();i++) {
//			int ch=(int)s.charAt(0)-48;
//			if(ch!=0) {
//				int j=i+1;
//				while(j<s.length()&&s.charAt(j)!=ch) {
//					j++;
//				}
//				
//				for(int k=0;k<ch;k++) {
//					ans=ans+"(";
//				}
//				ans=ans+s.substring(i, j);
//				for(int k=0;k<ch;k++) {
//					ans=ans+")";
//				}
//				i=j;
//			}
//		}
//		System.out.println(ans);
		}
	}
	public static void Final(String q,String ans,int count) {
		if(q.length()==0) {
			System.out.println("Case #"+count+ ": " +ans);
			return;
		}
		int ch=(int)q.charAt(0)-48;
		//System.out.println(ch);
		String r=q.substring(1);
		if(ch!=0) {
		String a="";
		for(int i=0;i<ch;i++) {
			a=a+"(";
		}
		int c=0,j=0;
		while(j<r.length()&&(r.charAt(j)-48)==ch) {
			c++;j++;
		}
		a=a+ch;
		if(c!=0){
			a=a+r.substring(0, c);
			r=r.substring(c);
		}
		for(int i=0;i<ch;i++) {
			a=a+")";
		}
		Final(r, ans+a,count);
		}else {
			Final(r,ans+ch,count);
		}
	}
	
	
	

}
