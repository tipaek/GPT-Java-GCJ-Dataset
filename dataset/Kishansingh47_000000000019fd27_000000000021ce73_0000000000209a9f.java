import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static String insertString(String originalString,String stringToBeInserted,int index) 
	{ 
		String newString = originalString.substring(0, index)+ stringToBeInserted+ originalString.substring(index); 
		return newString; 
	} 
	public static String myCopy(char s1[]) 
	{ 
		char s2[] = new char[s1.length];
	    int i = 0; 
	    for (i = 0; i < s1.length; i++) 
	         s2[i] = s1[i]; 
	    return String.valueOf(s2);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int cse = 1;
		String left ="(", right=")";
		while(t-->0){
			String s = sc.next();
			String s1 = myCopy(s.toCharArray());
			int l=0,r=0;
			int count=0;
			for(int i=0;i<s.length();i++) {
				int curr = Integer.parseInt(Character.toString(s.charAt(i)));
				if(l>curr) {
					r=l-curr;
					String repeated = new String(new char[r]).replace("\0", right);
					s1 = insertString(s1,repeated,i+count);
					count+=r;
					l=l-r;
					if(i==s.length()-1) {
						repeated = new String(new char[curr]).replace("\0", right);
						s1 = s1+repeated;
					}
				}
				else if(l<curr) {
					String repeated = new String(new char[curr-l]).replace("\0", left);
					s1 = insertString(s1,repeated,i+count);
					count+=curr-l;
					l=curr;
					if(i==s.length()-1) {
						repeated = new String(new char[curr]).replace("\0", right);
						s1 = s1+repeated;
					}
				}
				else if(l==curr && i==s.length()-1) {
					String repeated = new String(new char[curr]).replace("\0", right);
					s1 = s1+repeated;
				}
			}
			sb.append("Case #"+cse+": "+s1);
			sb.append("\n");
			cse++;
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
