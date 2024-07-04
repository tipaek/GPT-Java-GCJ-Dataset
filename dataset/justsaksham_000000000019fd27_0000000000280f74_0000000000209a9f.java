//package dsalearning;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int tt=0;
		while(tt<t) {
			char a[]=s.next().toCharArray();
			String l=null;
			int open=a[0]-48;
			//System.out.println(open+" "+a.length);
			int ll[]=new int[a.length];
			ll[0]=open;
			String p="";
			for(int i=0;i<open;i++)
				p=p+'(';
			//p=p+a[0];
			//System.out.println(p);
			String h="";
			int f=0,ff=0;
			for(int i=1;i<a.length;i++) {
				int k=a[i];
				k=k-48;
				ll[i]=k;
				if(h=="") {
					h=h+a[i-1];
				//	System.out.println(a[i-1]+" "+h+" in h null");
					}
				if(ll[i-1]==ll[i]) {
					ff=1;
					h=h+a[i];
					//System.out.println(h+"printing h");
					continue;
				}
				else f=1;
				if(open>=ll[i]) {
					//System.out.println("i am here");
					int ss=open-ll[i];
					if(ff==1) {
					 p=p+h;
					 h="";
					 ff=0;
					}
					else {
						p=p+a[i-1];
						h="";
					}
					for(int j=0;j<ss;j++)
						p=p+")";
					open=open-ss;
				}
				else {
					//System.out.println("in else "+open);
					if(ff==1) {
					 p=p+h;
					 ff=0;
					 h="";
					}
					else {
						p=p+a[i-1];
						//System.out.println(p+"printing p");
						h="";
					}
					int ss=ll[i]-open;
					for(int j=0;j<ss;j++)
						p=p+"(";
					open=open+ss;
					//p=p+a[i];
				}
			}
//		if(p.length()==0) {
//				//System.out.println(h);
//				p=h;
//				System.out.println("Case #"+(tt+1)+": "+p);
//			}
//		else{
//			if(a[a.length-1]!='0')
//				p=p+a[a.length-1];
			if(ff==1)
			p=p+h;
			else p=p+a[a.length-1];
			for(int i=0;i<open;i++)
				p=p+")";
			
			System.out.println("Case #"+(tt+1)+": "+p);
			tt++;
		}
	}
}
