import java.util.*;
import java.io.*;
public class Solution {

	static String solve(String[] p) {
		String result = "";
		int n = p.length;
		boolean stop = false;
		int[] index = new int[n];
		
		while(!stop) {
			stop = true;
			char lastCh = ' ';
			for(int i=0; i<n; i++) {
				char newCh = p[i].charAt(index[i]);
				if (newCh != '*') {
					if (lastCh != ' ' && newCh != lastCh) {
						return "*";
					}
					lastCh = newCh;
					index[i]++;
					stop = false;
				}
			}
			if (lastCh != ' ')
				result += lastCh;
		}

		for(int i=0; i<n; i++) {
			index[i] = p[i].length() - 1;
		}

		stop = false;
		while(!stop) {
			stop = true;
			char lastCh = ' ';
			for(int i=0; i<n; i++) {
				char newCh = p[i].charAt(index[i]);
				if (newCh != '*') {
					if (lastCh != ' ' && newCh != lastCh) {
						return "*";
					}
					lastCh = newCh;
					index[i]--;
					stop = false;
				}
			}
			if (lastCh != ' ')
				result = lastCh + result;
		}

		
		return result;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			String[] p = new String[n]; 
			for(int j=0; j<n; j++) {
				p[j] = in.next();
			}
			String result = solve(p);
			System.out.println("Case #" + i + ": " + result);
		}
		in.close();
	}

}
