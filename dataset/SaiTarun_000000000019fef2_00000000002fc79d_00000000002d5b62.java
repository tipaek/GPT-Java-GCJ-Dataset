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
					if(localX<=100&&localX>=-100&&localY<=100&&localY>=-100) {
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