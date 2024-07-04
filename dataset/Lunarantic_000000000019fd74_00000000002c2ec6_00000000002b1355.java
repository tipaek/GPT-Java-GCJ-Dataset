import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	static int[][] mat;
	static int r,c;
	
	static int sum() {
		int s = 0;
		
		for (int j = 0; j < r; ++j) {
    		for (int k = 0; k < c; ++k) {
    			s += mat[k][j];
    		}
    	}
		
		return s;
	}
	
	static int avg(int i, int j) {
		float s = mat[i][j];
		int co = 1;
		
		int x = i-1;
		while (x >= 0) {
			if (mat[x][j] != 0) {
				++co;
				s += mat[x][j];
				break;
			} else {
				--x;
			}
		}
		
		x = i + 1;
		while (c > x) {
			if (mat[x][j] != 0) {
				++co;
				s += mat[x][j];
				break;
			} else {
				++x;
			}
		}
		
		x = j-1;
		while (x >= 0) {
			if (mat[i][x] != 0) {
				++co;
				s += mat[i][x];
				break;
			} else {
				--x;
			}
		}
		
		x = j + 1;
		while (r > x) {
			if (mat[i][x] != 0) {
				++co;
				s += mat[i][x];
				break;
			} else {
				++x;
			}
		}
		
		if (co == 1) return (int)s - 1;
		int rs =  ((int)Math.ceil((s / co)));
		return rs;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= t; ++i) {
        	int f = 0;
        	
        	String[] rc = in.nextLine().split(" ");
        	r = Integer.parseInt(rc[0]);
        	c = Integer.parseInt(rc[1]);
        	mat = new int[c][r];
        	
        	for (int j = 0; j < r; ++j) {
        		String[] temps = in.nextLine().split(" ");
        		for (int k = 0; k < c; ++k) {
        			mat[k][j] = Integer.parseInt(temps[k]);
        			f += mat[k][j];
        		}
        	}
        	
        	boolean change = false;
        	byte[][] st = new byte[c][r];
        	
        	do {
        		change = false;
        		for (int j = 0; j < r; ++j) {
            		for (int k = 0; k < c; ++k) {
            			if (mat[k][j] == 0) continue;
            			if (mat[k][j] < avg(k, j)) {
            				st[k][j] = 1;
            				change = true;
            			}
            		}
            	}
        		
        		for (int j = 0; j < r; ++j) {
            		for (int k = 0; k < c; ++k) {
            			if (st[k][j] == 1) {
            				mat[k][j] = 0;
            			}
            		}
            	}
        		
        		if (change) {
        			f += sum();
        		}
        	} while (change);
            
            System.out.println("Case #" + i + ": " + f);
        }
        in.close();

        System.exit(0);
    }
}
