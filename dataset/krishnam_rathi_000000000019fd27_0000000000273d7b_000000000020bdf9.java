import java.util.*;

class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int T=1;T<=t;T++){
			int n=sc.nextInt();
			int[] s=new int[1000000];
			int[] e=new int[1000000];
			int[] end=new int[n];
			char[] b=new char[1000000];
			for(int i=0;i<1000000;i++) b[i]='A';
			for(int i=0;i<1000000;i++) s[i]=-1;
			for(int i=0;i<n;i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				s[x]=x;
				s[y]=y;
				e[x]=y;
				end[i]=y;
			}
			String ans="", im="IMPOSSIBLE";
			int ce=-1, je=-1;
			boolean J=false, C=false;  // false = not busy
			for(int i=0;i<1000000;i++) {
				if(s[i]!=-1) {
					if(!J && s[i]!=ce) {
						je=e[i];
						J=true;
						//ans+='J';
						b[je]='J';
					}
					else if(!C && s[i]!=je ){
						ce=e[i];
						C=true;
						//ans+='C';
						b[ce]='C';
					}
					else if(s[i]==je) {
						J=false;
						je=-1;
						if(e[i]!=0) {
							je=e[i];
							J=true;
							//ans+='J';
							b[je]='J';
						}
					}
					else if(s[i]==ce) {
						C=false;
						ce=-1;
						if(e[i]!=0) {
							ce=e[i];
							C=true;
							//ans+='C';
							b[ce]='C';
						}
					}
					else if(J && C) {
						ans=im;
						break;
					}
				}
			}
			if(ans!=im) {
				for(int i=0;i<n;i++) {
					ans+=b[end[i]];
				}
			}
		    System.out.println("Case #"+T+": "+ ans);
		}
	}
}