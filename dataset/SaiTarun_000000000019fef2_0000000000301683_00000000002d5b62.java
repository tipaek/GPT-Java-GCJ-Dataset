import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int totalTestCases=in.nextInt();
		int count=0;
		//System.out.println(totalTestCases);
		while(count<totalTestCases) {
			count++;
			int x=in.nextInt();
			int y=in.nextInt();
			String res=helper(x, y);
			System.out.println("Case #"+count+": "+res);
		}
		
		//System.out.println(helper(-1,-1));
	}
	
	public static String helper(int finalX, int finalY) {
		Queue<Pair> qu=new LinkedList<Pair>();
		qu.add(new Pair(0, 0, "#"));
		int curTwoPow=1;
		int pow=1;
		char[] dir=new char[] {'E', 'S', 'W', 'N'};
		double finalRad=distance(finalX, finalY);
		while(!qu.isEmpty()) {
			int size=qu.size();
			while(size>0) {
				size--;
				Pair cur=qu.poll();
				//System.out.println(cur.x+" , "+cur.y+" , "+cur.path);
				if(cur.x==finalX&&cur.y==finalY) return cur.path.substring(1);
				for(char ch: dir) {
					long localX=cur.x, localY=cur.y;
					if(ch=='E') {
						localX+=curTwoPow;
					}
					else if(ch=='S') {
						localY-=curTwoPow;
					}
					else if(ch=='W') {
						localX-=curTwoPow;
					}
					else {
						localY+=curTwoPow;
					}
					double curRad=distance(localX, localY);
					double curDisBet=distanceBetween(localX, localY, finalX, finalY);
					if(curRad<=finalRad&&curDisBet<=2*finalRad) {
						String curDir=ch+"";
						qu.add(new Pair(localX, localY, cur.path+curDir));
					}
				}
			}
			curTwoPow=(int)(Math.pow(2, pow));
			pow++;
		}
		
		return "IMPOSSIBLE";
	}
	
	public static double distance(long x, long y) {
		return Math.sqrt(x*x+y*y);
	}
	
	public static double distanceBetween(long x1, long y1, long x2, long y2) {
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}
	
	public static class Pair{
		long x;
		long y;
		String path;
		public Pair(long x, long y, String path) {
			this.x=x;
			this.y=y;
			this.path=path;
		}
	}
}