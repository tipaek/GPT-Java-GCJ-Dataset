import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		int xyz=1;
		while(n>0) {
			//System.out.println(n);
			StringBuilder sb=new StringBuilder();
			//String garbage=in.nextLine();
			String s=in.nextLine();
			
			int open=0;
			for(int i=0;i<s.length();i++) {
				if(s.length()==1) {
					int num=Character.getNumericValue(s.charAt(i));
					//System.out.println(num);
					if(num>0) {
					for(int j=0;j<num;j++) {
						sb.append('(');
						open++;
					}
					}
					sb.append(s.charAt(i));
					if(open!=0) {
						for(int j=open;j>0;j--) {
							sb.append(')');
						}
					}
					break;
				}
				if(i==0) {
					int num=Character.getNumericValue(s.charAt(i));
					if(num>0) {
					for(int j=0;j<num;j++) {
						sb.append('(');
						open++;
					}
					}
					sb.append(s.charAt(i));
				}else if(i>0&&i<s.length()-1) {
					int num=Character.getNumericValue(s.charAt(i));
					if(open<num) {
						for(int j=0;j<num-open;j++) {
							sb.append('(');
							open++;
						}
					}else if(open>num) {
						for(int j=0;j<open-num;j++) {
							sb.append(')');
							open--;
						}
					}
					sb.append(s.charAt(i));
				}else {
					int num=Character.getNumericValue(s.charAt(i));
					if(open<num) {
						for(int j=0;j<num-open;j++) {
							sb.append('(');
							open++;
						}
					}else if(open>num) {
						for(int j=0;j<open-num;j++) {
							sb.append(')');
							open--;
						}
					}
					sb.append(s.charAt(i));
					if(open!=0) {
						for(int j=open;j>0;j--) {
							sb.append(')');
						}
					}
				}
			}
			System.out.println("Case #"+xyz+": "+sb);
			xyz++;
			n--;
		}
	}

}
