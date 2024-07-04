
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		for(int t=1;t<=x;t++) {
			StringBuffer st=new StringBuffer(s.next());
			String str=st.toString();
			int len1=st.length();
			int len2=len1;
			int zCount=0;
			while(zCount<len1) {
				zCount=0;
				int first=-1;
			for(int i=0;i<len2;i++) {
				if(first==-1&&st.charAt(i)>'0'&&st.charAt(i)<='9')
				{
					first=1;
					st.replace(i,i+1,((char)((int)st.charAt(i)-1))+"");
					st.insert(i, "(");
					len2++;
					i++;
					
				}
				else
				if(st.charAt(i)=='0'&&first==1) {
					first=-1;
					st.insert(i, ")");
					len2++;
					i++;
				}
				else
				if(first==1&&st.charAt(i)>'0'&&st.charAt(i)<='9') {
					st.replace(i,i+1,((char)((int)st.charAt(i)-1))+"");
				}
				
				if(first==1&&i==len2-1) {
					st.append(")");
					len2++;
					i++;
				}
				
				if(st.charAt(i)=='0')
					zCount++;
			}
		}
			int count=0;
			for(int i=0;i<len2;i++) {
				if(st.charAt(i)=='0') {
					st.replace(i,i+1, str.charAt(count)+"");
					count++;
				}
			}
			System.out.println("Case #"+t+": "+st.toString());
	}
		
	}
}
