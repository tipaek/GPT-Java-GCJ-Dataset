import java.util.*;

class Solution {
	public static boolean isOverlapping(int si, int ei, int s, int e) {
		if(e>si && e<=ei) return true;
		else if(s>=si && s<ei) return true;
		else if(s>=si && e<=ei) return true;
		else if(s<si && e>ei) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int T=1;T<=t;T++){
			int n=sc.nextInt();
			int[] start=new int[n];
			int[] end=new int[n];
			for(int i=0;i<n;i++) {
				start[i]=sc.nextInt();
				end[i]=sc.nextInt();
			}
			int[][] j=new int[n][2];
			int[][] c=new int[n][2];
			for(int i=0;i<n;i++) {
				for(int k=0;k<2;k++) {
					j[i][k]=-1;
					c[i][k]=-1;
				}
			}
			int f=1, zj=0, zc=0;
			String ans="", im="IMPOSSIBLE";
			boolean J=false, C=false;
			int js=-1, je=-1, cs=-1, ce=-1;
			for(int i=0;i<n;i++) {
				for(int k=0;k<n;k++) {
					if(isOverlapping(start[i], end[i], j[k][0], j[k][1])) {
						f=0;
						break;
					}else f=1;
				}
				if(f==0) {
					for(int k=0;k<n;k++) {
						if(!isOverlapping(start[i], end[i], c[k][0], c[k][1])) {
							f=2;
						}else {
							f=0;
							break;
						}
					}
				}
				if(f==1) {
					j[zj][0]=start[i];
					j[zj][1]=end[i];
					zj++;
					ans+='J';
				}else if(f==2) {
					c[zc][0]=start[i];
					c[zc][1]=end[i];
					zc++;
					ans+='C';
					f=1;
				}else {
					ans=im;
					break;
				}
			}
			System.out.println("Case #"+T+": "+ans);
		}
	}
}