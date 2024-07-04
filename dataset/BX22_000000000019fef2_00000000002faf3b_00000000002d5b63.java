import java.util.*;
import java.io.*;
public class template_interactive {
	static int A;
	static int B;
	/*
	 * between A and B
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			A = in.nextInt();
			B = in.nextInt();
			query ();
		}
		in.close();
	}
	public static void query () {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		int row=binSearchLeftRow (-1*1000000000, 0);
		if (row==1000000001) return;
		else {
			int col=binSearchBottomCol (-1*1000000000, 0);
			if (col==1000000001) return;
			else {
				out.println (row+" "+col);
				out.flush();//print before flush
				String veridct=in.next();
			}
		}
		out.close();
	}
	//row
	public static int binSearchBottomCol (int left, int right) {//gives you the left row;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<5; i++) {
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
	public static int binSearchLeftRow (int left, int right) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		while (left<right) {
			int mid=(left+right)/2+1;
			int col=0;
			boolean hit=false;
			for (int i=0; i<5; i++) {
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
				right=mid;
			}
			else {
				left=mid+1;
			}
		}
		return left;
	}
}
