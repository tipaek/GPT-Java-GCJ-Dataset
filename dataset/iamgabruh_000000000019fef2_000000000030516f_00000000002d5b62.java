import java.util.*;
import java.io.*;

public class Solution{
 
	static String anss="";
	static boolean done=false;
	static int nextPowerOf2(int n) 
	{ 
		n=Math.abs(n);
		int p = 1; 
		if (n > 0 && (n & (n - 1)) == 0) 
			return n; 

		while (p < n) 
			p <<= 1; 
	
		return p; 
	} 

	static void find(int a,int b,int i,int j,String ans,int l) {
		if(i==a && j==b) {
			if(done && ans.length()<anss.length()) {
				anss=ans;
				
			}
			else {
				anss=ans;
			}
			
			done=true;
			return;
		}
		if(done) {
			return;
		}
		int nxti=nextPowerOf2(a);
//		System.out.println(nxti);
		int nxtj=nextPowerOf2(b);
		if(a>=0) {
			if(i<-(nxti-a)  || i>a ){
				return;
			}
		}
		else {
			if(i<a || i>(nxti-Math.abs(a))) {
				return;
			}
		}
		if(b>=0) {
			 if(j<-(nxtj-b) || j>b) {
				 return;
			 }
		}
		else {
			if(j<b || j>(nxtj-Math.abs(b))) {
				return;
			}
		}
		
		find(a,b,i,j+(int)Math.pow(2,l-1),ans+"E",l+1);
		find(a,b,i-(int)Math.pow(2,l-1),j,ans+"S",l+1);
		find(a,b,i,j-(int)Math.pow(2,l-1),ans+"W",l+1);
		find(a,b,i+(int)Math.pow(2,l-1),j,ans+"N",l+1);
		
	}
public static void main (String[] args) throws java.lang.Exception
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int t=Integer.parseInt(br.readLine().trim());
	int ttt=1;
	while(t-->0)
	{
	
		StringTokenizer tok=new StringTokenizer(br.readLine()," ");
		int a=Integer.parseInt(tok.nextToken());
		int b=Integer.parseInt(tok.nextToken());
		anss="";
		done=false;
		find(b,a,0,0,"",1);
		if(anss=="") {
			System.out.println("Case #"+ttt+++": IMPOSSIBLE");
		}
		else {
			System.out.println("Case #"+ttt+++": "+anss);
		}
//		System.out.println(anss);
			

		
		
			
			
		}
		
		
		
		
		
		

		
	
}
	
}