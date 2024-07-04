import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
public static void main(String[]args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int t=Integer.parseInt(br.readLine());
	for(int i=0;i<t;i++) {
		String s=br.readLine();
		out.println("Case #"+(i+1)+": "+funct(s));
	}
	out.close();
}

private static String funct(String s) {
	int min=getMin(s);
	int max=getMax(s);
	return process(s,0,min,max);
}

private static String process(String s,int prevMin, int min,int max) {
	if(s.equals(""))return "";
	String s2="",s3="";
	if(allSame(s,0)) {
		for(int j=0;j<min-prevMin;j++) {
			s="("+s+")";
		}
		return s;
	}
	for(int i=0;i<s.length()-1;i++) {
		if(s.charAt(i)-'0'==min) {
			s2+=s.charAt(i);
			if(i==s.length()-2) {
				s3+=s.charAt(i+1);
			}
		}
		else if(s.charAt(i)==s.charAt(i+1)) {
			s3+=s.charAt(i);
			if(i==s.length()-2) {
				s3+=s.charAt(i+1);
			}
		}
		else {
			while(i<s.length()&&(s.charAt(i)-'0')!=min) {
			   s3+=s.charAt(i);
			   i++;
			}i--;
			int mn=getMin(s3);
			int mx=getMax(s3);
			s2+=process(s3,min,mn,mx);
			s3="";
			if(i==s.length()-2) {
				s3+=s.charAt(i+1);
			}
		}
	}
	if(s3.length()>0) {
	 // s3+=s.charAt(s.length()-1);
	  int mn=getMin(s3);
	  int mx=getMax(s3);
      s2+=process(s3,min,mn,mx);
	}
//	int minimumNext=getMin(s2);
	for(int i=0;i<min-prevMin;i++)
		  s2="("+s2+")";
	     
	return s2;
}

private static boolean allSame(String s3, int i) {
	if(s3.length()==0)return false;
	if(i==s3.length()-1)return true;
	return s3.charAt(i)==s3.charAt(i+1)&&allSame(s3,i+1);
}

private static int getMax(String s) {
	int t=0;
	int minN=10,maxN=-1,c=0,d=0;
	for(;t<s.length();t++) {
		if(s.charAt(t)-'0'>maxN) {
			maxN=s.charAt(t)-'0';
		}
	}
	return maxN;
}

private static int getMin(String s) {
	int t=0;
	int minN=10,maxN=-1,c=0,d=0;
	for(;t<s.length();t++) {
		if(s.charAt(t)-'0'<minN) {
			minN=s.charAt(t)-'0';
		    c=t;
		}
	}
	return minN;
}
}
