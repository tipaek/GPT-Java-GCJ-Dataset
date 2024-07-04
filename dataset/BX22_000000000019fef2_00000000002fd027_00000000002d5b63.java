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
		int row=binSearchLeftRow (-1*1000000000, 0);
		if (row==1000000001) return true;
		else if (row==-1000000001) return false;
		else {
			int col=binSearchBottomCol (-1*1000000000, 0);
			if (col==1000000001) return true;
			else if (col==-1000000001) return false;
			else {
				out.println (row+" "+col);
				out.flush();//print before flush
				String veridct=in.next();
				if (veridct.equals("WRONG")) return false;
				return true;
			}
		}
	}
	//row
	public static int binSearchBottomCol (int left, int right) {//gives you the left row;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<3; i++) {
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
				else {
					return -1000000001;
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
	public static int binSearchLeftRow (int left, int right) {
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
				else {
					return -1000000001;
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
