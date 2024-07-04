import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
public static void main(String[]args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int t=Integer.parseInt(br.readLine());
	for(int i=0;i<t;i++) {
		String s=br.readLine();
		String s2="",s3="";
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j)=='0') {
				s2+=process(s3)+"0";
				s3="";
			}	else  {
				s3+=s.charAt(j);
			}
		}
			s2+=process(s3);
		
		out.println("Case #"+(i+1)+": "+s2);
	}
	out.close();
}

private static String process(String s) {
	if(s.equals(""))return "";
	String s2="";
	if(s.length()==1) {
		s2+=s.charAt(0);
		int n=Integer.parseInt(s2);
		for(int i=0;i<n;i++) {
			s2="("+s2+")";
		}
		return s2;
	}

	String s3="";
	int t=0;
	int minN=10,maxN=-1,c=0,d=0;
	for(;t<s.length();t++) {
		if(s.charAt(t)-'0'<minN) {
			minN=s.charAt(t)-'0';
		    c=t;
		}
		if(s.charAt(t)-'0'>maxN) {
			maxN=s.charAt(t)-'0';
			d=t;
		}
			
	}
	int min2=Integer.parseInt(s.charAt(c)+"");
	for(int i=0;i<s.length()-1;i++) {
		if(s.charAt(i)==s.charAt(i+1)) {
			s2+=s.charAt(i+1);
		}else {
			s2+=s.charAt(i);
			int max=Integer.parseInt(s2.charAt(s2.length()-1)+"");
			//int min=Integer.parseInt(s.charAt(s.length()-1)+"");
			for(int j=0;j<max-min2;j++) {
				s2="("+s2+")";
			}
			s3+=s2;
			s2="";
		}
	}
	s2+=s.charAt(s.length()-1);
	int x=s2.charAt(0)-'0';
	for(int h=0;h<x-min2;h++) {
		s2="("+s2+")";
	}
	s3+=s2;
	for(int i=0;i<min2;i++) {
		s3="("+s3+")";
	}
	
	
	return s3;
}
}
