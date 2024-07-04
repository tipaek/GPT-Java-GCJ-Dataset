import java.util.*;
import java.io.*;
public class Solution {
	static int A;
	static int B;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		A = in.nextInt();
		B = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			if (!query ()) break;
		}
		in.close();
	}
	public static boolean query () {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		int a=binSearchLeft1 (0, 1000000000);
		int b=binSearchLeft2 (-1000000000, 0);
		if (a==1000000001||b==1000000001) return true;
		else {
			int c=binSearchLeft3 (0, 1000000000);
			int d=binSearchLeft4 (-1000000000, 0);
			if (c==1000000001||d==1000000001) return true;
			else {
				out.println ((a+b)/2+" "+(c+d)/2);
				out.flush();//print before flush
				System.out.println ("DONE");
				String veridct=in.next();
				if (veridct.equals("WRONG")) return false;
				return true;
			}
		}
	}
	public static int binSearchLeft1 (int left, int right) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<3; i++) {
				col=1000000000-1000000000/2*i;
				out.println (mid+" "+col);
				out.flush();
				String verdict=in.next();
				if (verdict.equals("CENTER")) {
					return 1000000001;
				}
				else if (verdict.equals("HIT")) {
					hit=true;
					break;
				}
			}
			if (hit) {
				left=mid;
			}
			else {
				right=mid-1;
			}
		}
		return left;
	}
	public static int binSearchLeft2 (int left, int right) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<2; i++) {
				col=0-1000000000/2*i;
				out.println (mid+" "+col);
				out.flush();
				String verdict=in.next();
				if (verdict.equals("CENTER")) {
					return 1000000001;
				}
				else if (verdict.equals("HIT")) {
					hit=true;
					break;
				}
			}
			if (hit) {
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		return left;
	}
	public static int binSearchLeft3 (int left, int right) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<3; i++) {
				col=0-1000000000/2*i;
				out.println (col+" "+mid);
				out.flush();
				String verdict=in.next();
				if (verdict.equals("CENTER")) {
					return 1000000001;
				}
				else if (verdict.equals("HIT")) {
					hit=true;
					break;
				}
			}
			if (hit) {
				left=mid;
			}
			else {
				right=mid-1;
			}
		}
		return left;
	}
	public static int binSearchLeft4 (int left, int right) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<2; i++) {
				col=1000000000-1000000000/2*i;
				out.println (col+" "+mid);
				out.flush();
				String verdict=in.next();
				if (verdict.equals("CENTER")) {
					return 1000000001;
				}
				else if (verdict.equals("HIT")) {
					hit=true;
					break;
				}
			}
			if (hit) {
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		return left;
	}
}
