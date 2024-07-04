import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			String m = sc.next();
			System.out.println("Case #" + i2 + ": " + solution(x,y,m));
		}

		sc.close();
	}

	
	private static String solution(int x, int y, String m) {
		//System.out.println(x + " " + y + " [" +  m+ "]");

		int ty[] = new int [m.length()];
		
		int yy = y;
		for (int j = 0; j < m.length(); j++) {
			char c = m.charAt(j);
			if (c == 'S') {
				yy--;
			} else if (c == 'N') {
				yy++;
			}
			ty[j] = yy;
		}
		
		//System.out.println(Arrays.toString(ty));
		
		int time = x;
		int cy = 0;
		
		if (x > 0) {
			if (cy == ty[x-1]) 
				return "" + time;
		}
		for (int i = x; i < m.length(); i++) {
			//System.out.println(cy + " " + ty[i]);
			time++;
			if (cy < ty[i]) {
				cy++;
			} else if (cy > ty[i]) {
				cy--;
			} else if (cy == ty[i]) {
				return "" + time;
			}
			
		}
		
		
		
		return "IMPOSIBLE";
	}
	
	

	/*
	private static String solution(int x, int y, String m) {
		//System.out.println(x + " " + y + " [" +  m+ "]");

		int tx[] = new int [m.length()];
		int ty[] = new int [m.length()];
		
		int yy = y;
		int xx = x;
		for (int j = 0; j < m.length(); j++) {
			char c = m.charAt(j);
			if (c == 'S') {
				yy--;
			} else if (c == 'N') {
				yy++;
			} else if (c == 'E') {
				xx++;
			} else if (c == 'W') {
				xx--;
			}
			ty[j] = yy;
			tx[j] = xx;
		}
		
		System.out.println(Arrays.toString(tx));
		System.out.println(Arrays.toString(ty));
		
		int time = x;
		int cy = 0;
		
		if (x > 0) {
			if (cy == ty[x-1]) 
				return "" + time;
		}
		for (int i = x; i < m.length(); i++) {
			//System.out.println(cy + " " + ty[i]);
			time++;
			if (cy < ty[i]) {
				cy++;
			} else if (cy > ty[i]) {
				cy--;
			} else if (cy == ty[i]) {
				return "" + time;
			}
			
		}
		
		
		
		return "IMPOSIBLE";
	}
	*/



}
