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
	public static double quadfinder(long one, long two) {
		if (one<two) return -99999999;
		double joeseph = -1+Math.sqrt(1+8*(one-two));
		return joeseph/2+0.00001;
	}
	public static void joestar(int kamamam) throws IOException {
		System.out.print("Case #"+kamamam+": ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		long L = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());
		long counter = Math.max((int)(quadfinder(L,R)), (int)(quadfinder(R,L)));
		if (L>=R)
		L-=counter*(counter+1)/2;
		else R-=counter*(counter+1)/2;
		if (Math.max(L, R)<counter+1) {
			System.out.println(counter+" "+L+" "+R);
			return;
		}
		if (Math.max(L, R)==counter+1) {
			if (L==counter+1) {
				counter++;
				L-=counter;
				System.out.println(counter+" "+L+" "+R);
				return;
			}
			if (R==counter+1) {
				counter++;
				R-=counter;
				System.out.println(counter+" "+L+" "+R);
				return;
			}
		}
		long kazuma = 90121310;
		if (L>=R) {
			kazuma = Math.max((int) supafinder(counter+1, L), (int) supafinder(counter+2, R)); 
			L-=(counter+1)*kazuma+kazuma*(kazuma-1);
			R-=(counter+2)*kazuma+kazuma*(kazuma-1);
			counter+=2*kazuma;
			if (L>counter) {
				counter++;
				L-=counter;
			}
			if (R>counter) {
				counter++;
				R-=counter;
			}
			if (L>counter) {
				counter++;
				L-=counter;
			}
			if (R>counter) {
				counter++;
				R-=counter;
			}
			System.out.println(counter+" "+L+" "+R);
			return;
		}
		else {
			kazuma = Math.max((int) supafinder(counter+1, R), (int) supafinder(counter+2, L)); 
			R-=(counter+1)*kazuma+kazuma*(kazuma-1);
			L-=(counter+2)*kazuma+kazuma*(kazuma-1);
			counter+=2*kazuma;
			if (L>counter) {
				counter++;
				L-=counter;
			}
			if (R>counter) {
				counter++;
				R-=counter;
			}
			if (L>counter) {
				counter++;
				L-=counter;
			}
			if (R>counter) {
				counter++;
				R-=counter;
			}
			System.out.println(counter+" "+L+" "+R);
			return;
		}
		
	}
	public static double supafinder(long countman, long supaman) {
		long oiy = countman-1;
		return (-oiy+Math.sqrt(oiy*oiy+4*supaman))/2+.00001;
	}
	/*long boabjoe = (long)(quadfinder(2*Math.max(L,R)+counter*(counter+1), 0)+.000001);
	System.out.println(counter+"adsf"+L+"afjsdk"+R);
	if (L>R) {
		L-=boabjoe*(boabjoe+1)/2-counter*(counter+1)/2;
	}
	else {
		R-=boabjoe*(boabjoe+1)/2-counter*(counter+1)/2;
	}
	counter=boabjoe;
	if (Math.max(L, R)<counter+1) {
		System.out.println(counter+" "+L+" "+R);
		return;
	}
	if (Math.max(L, R)==counter+1) {
		if (L==counter+1) {
			counter++;
			L-=counter;
			System.out.println(counter+" "+L+" "+R);
			return;
		}
		if (R==counter+1) {
			counter++;
			R-=counter;
			System.out.println(counter+" "+L+" "+R);
			return;
		}
	}*/
}
class Pair implements Comparable<Pair>{
	public int x;
	public int y;
	public Pair(int k, int v) {
		x=k;
		y=v;
	}
	@Override public boolean equals(Object other1) {
		Pair other = (Pair) other1;
		if(other.x==this.x&&other.y==this.y)return true;
		return false;
	}
	@Override public int hashCode() {
		return 10283*x+y;
	}
	public int compareTo(Pair other){
		double sugugu = other.x;
		double subaba = other.y;
		if (x>sugugu)return 1;
		return -1;
	}
}
