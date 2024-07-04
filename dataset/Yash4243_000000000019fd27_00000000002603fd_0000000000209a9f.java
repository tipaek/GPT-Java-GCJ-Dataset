import java.util.*;

public class Solution
{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		in.nextLine();
		int c=1;
		while(t-->0){
			int flag=0;
			String s=in.nextLine();
			StringBuffer s1=new StringBuffer();
			for(int i=0;i<s.length();i++){
			if(flag==0){
				flag=1;
				int ch=s.charAt(0)-48;
				for(int j=0;j<ch;j++){
					s1.append("(");
				}
				s1.append(s.charAt(0));
				if(i==s.length()-1){
						for(int k=0;k<s.charAt(i)-48;k++){
							s1.append(")");
						}
					}
				}
			else{
					if(s.charAt(i)==s.charAt(i-1)){
						if(i==s.length()-1){
							s1.append(s.charAt(i));
						for(int k=0;k<s.charAt(i)-48;k++){
							s1.append(")");
						}
						}
						else{
							s1.append(s.charAt(i));
							continue;
						}
					
					}
					else if(s.charAt(i)<s.charAt(i-1)){
						int diff=s.charAt(i-1)-s.charAt(i);
						for(int j=0;j<diff;j++){
							s1.append(")");
						}
						s1.append(s.charAt(i));
						if(i==s.length()-1){
						for(int k=0;k<s.charAt(i)-48;k++){
							s1.append(")");
						}
					}
					}
					else if(s.charAt(i)>s.charAt(i-1)){
						int diff=s.charAt(i)-s.charAt(i-1);
						for(int j=0;j<diff;j++){
							s1.append("(");
						}
						s1.append(s.charAt(i));
						if(i==s.length()-1){
						for(int k=0;k<s.charAt(i)-48;k++){
							s1.append(")");
						}
					}
					}
			}
			}
			System.out.println("Case #"+c+": "+s1);	
			c++;
		}
	}
}