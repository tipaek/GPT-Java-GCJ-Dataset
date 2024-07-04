
import java.util.Scanner;

public class Solution {
	static int min = Integer.MAX_VALUE;
	static String temp = "";
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if(in.hasNextInt()){
		    int t = in.nextInt();
			for(int tc=1;tc<=t;tc++) {
				 
				if(in.hasNextInt()){
					long x = in.nextInt();
					long y = in.nextInt();
					String s = "";
					long i=0;
					long j=0;
					int step = 0;
					solve(tc, s, x, y, i, j, step);
					if(temp.length()>0) {
						System.out.println("Case #"+tc+": "+temp );
					}else {
						System.out.println("Case #"+tc+": IMPOSSIBLE");
					}
					min = Integer.MAX_VALUE;
					temp = "";
					
					
				}
			}
		}
	}
	
	
	public static boolean solve(int t, String s, long x, long y, long row, long col, int step) {
		if(row == x && col== y) {
			if(s.length()<min) {
				min = s.length();
				temp = s;
				
			}
		}
		if(Math.abs(row) > Math.abs(x) && Math.abs(col) >Math.abs( y)) {
			return false;
		}
		int list[] = {0,1,2,3};
		char direction[] = {'N', 'W', 'S', 'E'};
		for(int i=0;i<4;i++) {
			long new_row = row;
			long new_col = col;
			if(i==0)
				new_col = (int) (col + Math.pow(2, step));
			else if(i==1)
				new_row = (int) (row - Math.pow(2, step));
			else if(i==2)
				new_col = (int) (col - Math.pow(2, step));
			else if(i==3)
				new_row = (int) (row + Math.pow(2, step));
			
			if((Math.abs(new_row) <= Math.abs(x) && Math.abs(new_col) <= Math.abs(y) )) {
				s = s+direction[i];
				if(solve(t, s, x, y, new_row, new_col, step + 1))
					return true;
				else {
					s = s.substring(0, s.length()-1);
				}
				
			}
		}
		return false;
		
	}
}
