import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeSet;
/*
4
1 1
15
3 3
1 1 1
1 2 1
1 1 1
1 3
3 1 2
1 3
1 2 3
 */
public class Solution {
	static TreeSet<Integer>[] aliveOnX;
	static TreeSet<Integer>[] aliveOnY;
	static ArrayDeque<Integer> xsToKill;
	static ArrayDeque<Integer> ysToKill;
	static ArrayDeque<Integer> xsToConsiderNext;
	static ArrayDeque<Integer> ysToConsiderNext;
	static boolean[][] dead;
	static int[][] timeDead;
	static long[][] value;
	static int curRound;
	static int w, h;
	static long sum=0;
	
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=1; tt<=T; tt++) {
			h=fs.nextInt();
			w=fs.nextInt();
			dead=new boolean[w][h];
			timeDead=new int[w][h];
			value=new long[w][h];
			aliveOnX=new TreeSet[w];
			aliveOnY=new TreeSet[h];
			for (int x=0; x<w; x++) {
				aliveOnX[x]=new TreeSet<>();
				for (int y=0; y<h; y++) aliveOnX[x].add(y);
			}
			for (int y=0; y<h; y++) {
				aliveOnY[y]=new TreeSet<>();
				for (int x=0; x<w; x++) aliveOnY[y].add(x);
			}
			xsToKill=new ArrayDeque<>();
			ysToKill=new ArrayDeque<>();
			xsToConsiderNext=new ArrayDeque<>();
			ysToConsiderNext=new ArrayDeque<>();
			sum=0;
			
			for (int y=0; y<h; y++)
				for (int x=0; x<w; x++) sum+=(value[x][y]=fs.nextLong());
			
//			System.out.println("Sum: "+sum);
			curRound=1;
			for (int x=0; x<w; x++)
				for (int y=0; y<h; y++) {
					xsToConsiderNext.add(x);
					ysToConsiderNext.add(y);
				}
			long ans=0;
			while (!xsToConsiderNext.isEmpty()) {
//				System.out.println("Trying round: "+curRound+" sum:"+sum);
				ans+=sum;
				ArrayDeque<Integer> curXs=xsToConsiderNext, curYs=ysToConsiderNext;
				xsToConsiderNext=new ArrayDeque<>();
				ysToConsiderNext=new ArrayDeque<>();
				while (!curXs.isEmpty()) {
					int nextX=curXs.remove();
					int nextY=curYs.remove();
					consider(nextX, nextY);
				}
				
				while (!xsToKill.isEmpty()) {
					int nextX=xsToKill.remove();
					int nextY=ysToKill.remove();
					kill(nextX, nextY);
				}
				curRound++;
			}
			System.out.println("Case #"+tt+": "+ans);
		}
	}
	
	static void consider(int x, int y) {
		if (dead[x][y]) return;
		long myVal=value[x][y];
		Integer leftX=aliveOnY[y].lower(x);
		Integer rightX=aliveOnY[y].higher(x);
		Integer lowerY=aliveOnX[x].lower(y);
		Integer higherY=aliveOnX[x].higher(y);
		long sum=0;
		sum+=(leftX==null?myVal:value[leftX][y]);
		sum+=(rightX==null?myVal:value[rightX][y]);
		sum+=(lowerY==null?myVal:value[x][lowerY]);
		sum+=(higherY==null?myVal:value[x][higherY]);
		if (sum>4*myVal) {
			xsToKill.add(x);
			ysToKill.add(y);
		}
	}
	
	static void kill(int x, int y) {
		if (dead[x][y]) return;
		dead[x][y]=true;
		aliveOnX[x].remove(y);
		aliveOnY[y].remove(x);
		timeDead[x][y]=curRound;
		sum-=value[x][y];
		
		Integer leftX=aliveOnY[y].lower(x);
		Integer rightX=aliveOnY[y].higher(x);
		Integer lowerY=aliveOnX[x].lower(y);
		Integer higherY=aliveOnX[x].higher(y);
		if (leftX!=null) { xsToConsiderNext.add(leftX); ysToConsiderNext.add(y);}
		if (rightX!=null) { xsToConsiderNext.add(rightX); ysToConsiderNext.add(y);}
		if (lowerY!=null) { xsToConsiderNext.add(x); ysToConsiderNext.add(lowerY);}
		if (higherY!=null) { xsToConsiderNext.add(x); ysToConsiderNext.add(higherY);}
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
