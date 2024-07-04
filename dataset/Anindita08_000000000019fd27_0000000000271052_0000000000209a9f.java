import java.lang.*;
import java.io.*;
import java.util.*;
class Solution{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader x= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(x.readLine());
		int T=Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			String s=x.readLine();
			String s2="";
			int open=0;
			for(int i=0;i<s.length();i++) {
				char ch=s.charAt(i);
				int n=Character. getNumericValue(ch);
				if(open==n) {
					s2=s2+ch;
				}
				if(open<n) {
					while(open!=n){
						s2=s2+'(';
						open++;
					}
					s2=s2+ch;
				}
				if(open>n) {
					while(open!=n){
						s2=s2+')';
						open--;
					}
					s2=s2+ch;
				}
			}
			while(open-->0) {
				s2=s2+')';
			}
			System.out.println("Case #"+t+": "+s2);
			
		}
	}
}
