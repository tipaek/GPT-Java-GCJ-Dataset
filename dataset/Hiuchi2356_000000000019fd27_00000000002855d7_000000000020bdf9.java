import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] a= {"C","J"};
		int smp=sc.nextInt();
		for(int h=0; h<smp; h++) {
			int sch=sc.nextInt();
			int[][] JC=new int[2][24*60*2+2];
			for(int i=0; i<2; i++) {
				Arrays.fill(JC[i],0);
			}
			boolean ok=true;
			int[] tas=new int[sch];
			ArrayList<Pair> ss=new ArrayList<Pair>();
			for(int i=0; i<sch; i++) {
				int s=sc.nextInt();
				int g=sc.nextInt();
				ss.add(new Pair(s*10000+g,i));
			}
			ss.sort(Comparator.comparing(p -> p.s));
			for(int i=0; i<sch; i++) {
				int s=(ss.get(i).s)/10000;
				int g=(ss.get(i).s)%10000;
				int task = isok(JC,s,g);
				if(task>=0 && ok) {
					JC=filltasks(JC,s,g,task);
					tas[ss.get(i).g]=task;
				}
				else {
					ok=false;
				}
			}
			if(ok) {
				String ans="";
				for(int i=0; i<sch; i++) {
					ans+=a[tas[i]];
				}
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
					break;
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
	public static class Pair{
		int s,g;
		Pair(int a,int b){
			s=a;
			g=b;
		}
		Pair(Pair a){
			s=a.s;
			g=a.g;
		}
	}
}