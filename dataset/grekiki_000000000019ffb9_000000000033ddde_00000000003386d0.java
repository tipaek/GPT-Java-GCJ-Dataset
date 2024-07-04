import java.io.*;
import java.util.*;
class g2{
	ArrayList<Integer>[] E;
	public g2(int n){
		E=new ArrayList[n];
		for(int i=0;i<n;i++){
			E[i]=new ArrayList<Integer>();
		}
	}
}

public class Solution{
	//off by one warning !!!
//    static PrintWriter out = new PrintWriter(System.out);
	static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	public static int solveDesno(int[] x,int[] y){
		int n=x.length;
		int[] prev=new int[n];
		int[] next=new int[n];
		Arrays.fill(prev,-1);
		Arrays.fill(next,-1);
		for(int i=0;i<n;i++){
			//najblizji desno
			int px=x[i];
			int rx=Integer.MAX_VALUE;
			for(int j=0;j<n;j++){
				if(x[j]>px&&x[j]<rx&&y[i]==y[j]){
					next[i]=j;
					rx=x[j];
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(next[i]==j){
					prev[j]=i;
				}
			}
		}
		return s(prev,next);
	}
	public static int solveDol(int[] x,int[] y){
		int n=x.length;
		int[] prev=new int[n];
		int[] next=new int[n];
		Arrays.fill(prev,-1);
		Arrays.fill(next,-1);
		for(int i=0;i<n;i++){
			//najblizji desno
			int py=y[i];
			int ry=Integer.MAX_VALUE;
			for(int j=0;j<n;j++){
				if(y[j]>py&&y[j]<ry&&x[i]==x[j]){
					next[i]=j;
					ry=y[j];
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(next[i]==j){
					prev[j]=i;
				}
			}
		}

		return s(prev,next);
	}
	public static int solve2(int[] x,int[] y,int dx,int dy){
		int n=x.length;
		int[] prev=new int[n];
		int[] next=new int[n];
		Arrays.fill(prev,-1);
		Arrays.fill(next,-1);
		for(int i=0;i<n;i++){
			long d2=Long.MAX_VALUE;
			for(int j=0;j<n;j++){
				int ddx=x[j]-x[i];
				int ddy=y[j]-y[i];
				if(ddx%dx==0&&ddy%dy==0&&ddx/dx==ddy/dy){
					if(ddx*dx>0&&ddy*dy>0){//prava smer
						long d2c=ddx*ddx+ddy*ddy;
						if(d2c<d2){
							d2=d2c;
							next[i]=j;
						}
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(next[i]==j){
					prev[j]=i;
				}
			}
		}
		return s(prev,next);

	}
	public static int s(int[] prev,int[] next){
		ArrayList<Integer> lens=new ArrayList<Integer>();
		int n=prev.length;
		for(int i=0;i<n;i++){
			if(prev[i]==-1&&next[i]!=-1){//prvi v razredu
				int length=1;
				int p=i;
				while(next[p]!=-1){
					p=next[p];
					if(length>100){
						System.out.println("NAPAKA!!!!");
						return 1000000;
					}
					length++;
				}
				lens.add(length);
			}
		}
		int score=0;
		int countOdd=0;
		for(int i=0;i<lens.size();i++){
			int t=lens.get(i);
			if(t%2==1){
				countOdd++;
			}
			score+=t;
		}
		if(score<n){
			score++;
		}
		if(score<n-1&&countOdd%2==0){
			score++;
		}
//		System.out.println(lens+" "+score);
		return score;
	}
	public static long gcd(long a,long b){
		if(b>a){
			return gcd(b,a);
		}
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	public static void solve(int tcase) throws Exception{
		int n=Integer.parseInt(in.readLine());
		int[] x=new int[n];
		int[] y=new int[n];
		for(int i=0;i<n;i++){
			StringTokenizer st=new StringTokenizer(in.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
		}
		//smeri x,y
		int score=solveDesno(x,y);
		int score2=solveDol(x,y);
//		System.out.println(score+" "+score2);
		int best=Math.max(score,score2);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int dx=x[j]-x[i];
				int dy=y[j]-y[i];
				if(dx!=0&&dy!=0){
					int d=(int)gcd(Math.abs(dx),Math.abs(dy));
					dx/=d;
					dy/=d;
					int score3=solve2(x,y,dx,dy);
					if(score3>best){
//						System.out.println(dx+" "+dy+" "+score3);
						best=score3;
					}
				}
			}
		}
		System.out.println("Case #"+tcase+": "+best);
	}

	public static void main(String[] args) throws Exception{
		StringTokenizer st=new StringTokenizer(in.readLine());
		int t=Integer.parseInt(st.nextToken());
		for(int tcase=1;tcase<=t;tcase++){
			solve(tcase);
		}
	}

}
