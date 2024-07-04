import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			joestar(asdfasdf);
		}
	}
	public static void joestar(int kamamam) throws IOException {
		System.out.print("Case #"+kamamam+": ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int  D= Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long[] cakes = new long[N];
		for (int i=0; i<N; i++) {
			cakes[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(cakes);
		HashSet<Pair> fakequeue = new HashSet();
		for (int i=0; i<cakes.length; i++) {
			for (long j=1; j<=D; j++) {
				fakequeue.add(new Pair(cakes[i], j));
			}
		}
		//Set<Pair> queue = (TreeSet)fakequeue.descendingSet();
		long mincuts = Long.MAX_VALUE;
		for (Pair p : fakequeue) {
			long counter = 0;
			long cuts = 0;
			for (long cake : cakes) {
				if ((cake*p.y)%p.x==0) {
					counter+=cake*p.y/p.x;
					cuts+=cake*p.y/p.x-1;
				}
				if (counter >= D) {
					//System.out.println(mincuts+" "+p.x+" "+p.y);
					mincuts = Math.min(cuts, mincuts);
					continue;
				}
			}
			for (long cake : cakes) {
				if (!((cake*p.y)%p.x==0)) {
					counter+=cake*p.y/p.x;
					cuts+=cake*p.y/p.x;
				}
				if (counter >= D) {
					//System.out.println(mincuts+" "+p.x+" "+p.y);
					mincuts = Math.min(cuts, mincuts);
					continue;
				}
			}
		}
		System.out.println(mincuts);
		return;
	}
}
class Pair /*implements Comparable<Pair>*/{
	public long x;
	public long y;
	public Pair(long k, long v) {
		x=k;
		y=v;
	}
	@Override public boolean equals(Object other1) {
		Pair other = (Pair) other1;
		if(other.x==this.x&&other.y==this.y)return true;
		return false;
	}
/*	public int compareTo(Pair other){
		double sugugu = x/((double)y);
		double subaba = other.x/((double)other.y);
		if (sugugu>subaba)return 1;
		return -1;
	}*/
}
