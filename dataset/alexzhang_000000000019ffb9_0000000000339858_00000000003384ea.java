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
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int counter = 0;
		for (int i=1; true ;i++) {
			if (L<R) {
				if (R>=i) {
					R-=i;
					counter++;
				}
				else {
					System.out.println(counter+" "+L+" "+R);
					return;
				}
			}
			else {
				if (L>=i) {
					L-=i;
					counter++;
				}
				else {
					System.out.println(counter+" "+L+" "+R);
					return;
				}
			}
		}
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
