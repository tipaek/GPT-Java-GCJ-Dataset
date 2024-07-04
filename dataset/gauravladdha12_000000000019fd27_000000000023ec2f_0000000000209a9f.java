import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		int q=1;
		while(t-->0){
			int i,j;
			String ans="";
			String s=sc.nextLine();
			int prev=0;
			int n=s.length();
			for(i=0;i<n;i++){
				if(s.charAt(i)-'0'==prev){
					ans=ans+s.substring(i,i+1);
				}
				else if(s.charAt(i)-'0'>prev){
					int diff=s.charAt(i)-'0'-prev;
					while(diff-->0){
						ans=ans+"(";
					}
					prev=s.charAt(i)-'0';
					ans=ans+s.substring(i,i+1);
				}
				else{
					int diff=-(s.charAt(i)-'0')+prev;
					while(diff-->0){
						ans=ans+")";
					}
					prev=s.charAt(i)-'0';
					ans=ans+s.substring(i,i+1);
				}
			}
			while(prev-->0){
				ans=ans+")";
			}
				System.out.println("Case #"+q+":"+" "+ans);
				q++;
		}
	}
}