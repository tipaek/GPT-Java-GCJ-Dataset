import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {
	static boolean a[][];
	static int []dir1=new int[] {-1,1,0,0};
	static int []dir2=new int[] {0,0,-1,1};
	static char[]x=new char[] {'W','E','S','N'};
	public static boolean isValid(int i,int j) {
		return (i>=0)&&(i<a.length)&&(j>=0)&&(j<a[0].length);
	}
	public static void main(String[]args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		//st=new StringTokenizer(br.readLine());
		//long l=Long.parseLong(br.readLine());
		//int []a=new int[n];
		//long []b=new long[n];
		//int[][]mat=new int[n][n];
		//long[][]longmat=new long[n][n];
		//br.readLine();
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
		
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			String o=doBFS(new Point(100,100), new Point(a+100,b+100));
			if(o.equals("-1")) {
				out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}else {
			out.println("Case #"+(i+1)+": "+o);
			}
		}
		out.close();
	}
	private static String doBFS(Point start, Point end) {
		if(start.x==end.x&&start.y==end.y)return "";
		String minCost="";
		a=new boolean[201][201];
		Queue<Pointx>q=new LinkedList<Pointx>();
		Hashtable<Point,String>cost=new Hashtable<Point,String>();
		int depth=0,sz=1;
		Point cur=start;
		q.add(new Pointx(cur,minCost));
		boolean cont =true;
		for(;!q.isEmpty()&&cont;depth++,sz=q.size()) {
			if(depth==8)break;
			while(sz-->0&&cont) {
				Pointx c=q.remove();
				cur=c.x;
				minCost=c.y;
				//if(cur.x+100>200||cur.y+100>200)continue;
				if(a[cur.x][cur.y])continue;
				
				a[cur.x][cur.y]=true;
			    
				for(int i=0;i<4;i++) {
					int nxtx=cur.x+(dir1[i]*((int)Math.pow(2, depth)));
					int nxty=cur.y+(dir2[i]*((int)Math.pow(2, depth)));
					if(!isValid(nxtx,nxty)) {
						continue;
					}
					Point next=new Point(nxtx,nxty);
					if(next.x==end.x&&next.y==end.y) {
						minCost+=x[i];
						cont=false;
						break;
					}
					q.add(new Pointx(next,minCost+x[i]));
				}
			}
		}
		if(cont)return "-1";
		return minCost;
	}
	static class Point{
		int x, y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	static class Pointx{
		Point x;
		String y;
		Pointx(Point x,String y){
			this.x=x;
			this.y=y;
		}
	}
}
