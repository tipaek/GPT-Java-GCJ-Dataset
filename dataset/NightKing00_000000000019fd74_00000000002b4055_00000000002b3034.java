import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
public static void main(String[]args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st;
	//st=new StringTokenizer(br.readLine());
	//long l=Long.parseLong(br.readLine());
	//int []a=new int[n];
	//long []b=new long[n];
	//int[][]mat=new int[n][n];
	//long[][]longmat=new long[n][n];
	int t=Integer.parseInt(br.readLine());
	for(int i=0;i<t;i++) {
		int n=Integer.parseInt(br.readLine());
		StringBuilder []sb=new StringBuilder[n];
		for(int j=0;j<n;j++) {
			sb[j]=new StringBuilder(br.readLine());
		}
		int maxPos=-1;
		int maxLength=-1;
		for(int j=0;j<n;j++) {
			if(sb[j].length()>maxLength) {
				maxLength=sb[j].length();
				maxPos=j;
			}
}
		StringBuilder sb2=sb[maxPos];
		boolean[] sat=new boolean[n];sat[maxPos]=true;
	/*	for(int k=0;k<sb2.length();k++) {
			if(sb2.charAt(k)=='*') {
				boolean f=true;
				if(k==0)f=false;
		for(int j=0;j<n;j++) {
			if(j==maxPos)continue;
			for(int h=sb[j].length()-1;h>=0;h--) {
				
			}
			
		}
			}
		}*/
		boolean valid=true;
		for(int k=1;k<sb2.length();k++) {
			for(int j=0;j<n;j++) {
				if(j==maxPos)continue;
				for(int h=sb[j].length()-1,z=sb2.length()-1;h>=1;h--,z--) {
					if(sb2.charAt(z)!=sb[j].charAt(h)) {
						valid=false;
						break;
					}
				}
			}
		}
		String outp=(valid)?sb2.substring(1):"*";
		out.println("Case #"+(i+1)+": "+outp);
	}
	out.close();
}
}
