import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
		for (int r = 0; r<recursive; r++) {
			int n = scanner.nextInt();
			Activity[] arSh = new Activity[n];
			StringBuilder sb = new StringBuilder("");
			for(int i=0;i<n;i++) {
					sb.append(" ");
					int a = scanner.nextInt();
					int b = scanner.nextInt();
					arSh[i] = new Activity(i,a,b);
			}
			Activity temp;
			for (int i = 1; i < n; i++) {
				for (int j = i; j > 0; j--) {
					if (arSh[j].getStart() < arSh[j - 1].getStart()) {
					  temp = arSh[j];
					  arSh[j] = arSh[j - 1];
					  arSh[j - 1] = temp;
					}
				}
	 	    }
			int C = -1;
			int J = -1;
			for (int i = 0; i < n; i++) {
				if (C<=arSh[i].getStart()) {
					C = arSh[i].getEnd();
					sb.setCharAt(arSh[i].getIndex(), 'C');
				} else if (J<=arSh[i].getStart()){
					J = arSh[i].getEnd();
					sb.setCharAt(arSh[i].getIndex(), 'J');
				} else {
					sb = new StringBuilder("IMPOSSIBLE");
					break;
				}
	 	    }
			System.out.println("Case #" + (r+1) + ": "+sb.toString());
		}
	}
}

class Activity {
	int index;
	int start;
	int end;
	public Activity() {
	}
	public Activity(int index, int start, int end) {
		this.index = index;
		this.start = start;
		this.end = end;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getIndex() {
		return this.index;
	}
	public int getStart() {
		return this.start;
	}
	public int getEnd() {
		return this.end;
	}
}
