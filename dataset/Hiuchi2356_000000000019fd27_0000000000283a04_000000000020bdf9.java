import java.util.Arrays;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int smp=sc.nextInt();
		for(int h=0; h<smp; h++) {
			int sch=sc.nextInt();
			int[][] JC=new int[2][24*60*2+2];
			for(int i=0; i<2; i++) {
				Arrays.fill(JC[i],0);
			}
			boolean ok=true;
			String ans="";
			String[] a= {"C","J"};
			for(int i=0; i<sch; i++) {
				int s=sc.nextInt();
				int g=sc.nextInt();
				int task = isok(JC,s,g);
				if(task>=0 && ok) {
					JC=filltasks(JC,s,g,task);
					ans=ans+a[task];
				}
				else {
					ok=false;
				}
			}
			if(ok) {
				System.out.println("Case #"+(h+1)+": "+ans);
			}
			else {
				System.out.println("Case #"+(h+1)+": IMPOSSIBLE");
			}
		}
	}
	public static int isok(int[][] a,int s,int g) {
		for(int i=0; i<2; i++) {
			boolean p=true;
			for(int j=s*2+1; j<=g*2; j++) {
				if(a[i][j]!=0) {
					p=false;
				}
			}
			if(p) {
				return i;
			}
		}
		return -1;
	}
	public static int[][] filltasks(int[][] a,int s,int g,int i){
		for(int j=s*2+1; j<=g*2; j++) {
			a[i][j]=1;
		}
		return a;
	}
}