import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P2 {
	static boolean a[][];
	static int []dir1=new int[] {0,-1,1,0,0};
	static int []dir2=new int[] {0,0,0,-1,1};
	static char[]x=new char[] {'W','E','S','N'};
	public static boolean isValid(int i,int j) {
		return (i>=0)&&(i<a.length)&&(j>=0)&&(j<a[0].length);
	}
	public static void main(String[]args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		//st=new StringTokenizer(br.readLine());
		//long l=Long.parseLong(br.readLine());
		//int []a=new int[n];
		//long []b=new long[n];
		//int[][]mat=new int[n][n];
		//long[][]longmat=new long[n][n];
		//br.readLine();
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			a=new boolean[1000][1000];
			int x=sc.nextInt(),y=sc.nextInt();
			String s=sc.next();
			int hh=search(0,0,x,y,s,0);
			if(hh>1000) {
				out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}else {
				out.println("Case #"+(i+1)+": "+hh);
			}
			
			
		}
		out.close();
	}
	private static int search(int x1,int y1,int x2, int y2,String s,int i) {
		if(x1==x2&&y1==y2)return 0;
		if(i==s.length()||Math.abs(y2-y1)+Math.abs(x2-x1)>2*(s.length()-i))return 10000;
		
		
		
		int res=Integer.MAX_VALUE;
		int cury=(s.charAt(i)=='N')?1:(s.charAt(i)=='S')?-1:0;
		int curx=(s.charAt(i)=='E')?1:(s.charAt(i)=='W')?-1:0;
		for(int j=0;j<5;j++) {
			if(Math.abs(x2+curx-x1-dir1[j])+Math.abs(y2+cury-y1-dir2[j])>
			Math.abs(x2-x1)+Math.abs(y2-y1)){
				continue;
			}
			res=Math.min(res, 1+search(x1+dir1[j],y1+dir2[j],x2+curx,y2+cury,s,i+1));
		}
		return res;
	}
	private static String doBFS(Point start, Point end) {
		if(start.x==end.x&&start.y==end.y)return "";
		String minCost="";
		a=new boolean[201][201];
		Queue<Pointx>q=new LinkedList<Pointx>();
	//	Hashtable<Point,String>cost=new Hashtable<Point,String>();
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
				//if(a[cur.x][cur.y])continue;
				
				//a[cur.x][cur.y]=true;
			    
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
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
			
		public boolean ready() throws IOException {return br.ready(); }


	}
	class Test implements Comparable<Test>{ //use arrays.sort
	    int x;
		@Override
		public int compareTo(Test t) {
			// TODO Auto-generated method stub
			return x-t.x;
		}
		public String toString() {
			return "("+x+")";
		}
	}
}
