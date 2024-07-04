import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int a = in.nextInt();

			int[] cam = new int[a*2];
			int clen = 0;

			int[] jac = new int[a*2];
			int jlen = 0;
			
			String fin = "";
			boolean impos = false;

			for(int x = 0; x<a; x++) {
				int first = in.nextInt();
				int last = in.nextInt();
				if(first > last) {
					int n = last;
					last = first;
					first = n;
				}

				boolean fitsc = true;
				for(int y = 0; y < clen; y+=2) {
					if(first < cam[y+1] && last > cam[y])
						fitsc= false;
					
					
				}

				if(fitsc) {
					cam[clen] = first;
					cam[clen+1] = last;
					clen=+2;
					fin +="C";
				}

				else {
					boolean fitsj = true;
					for(int y = 0; y < jlen; y+=2) {
						if(first < jac[y+1] && last > jac[y])
							fitsj= false;
					}
					
					if(fitsj) {
						jac[jlen] = first;
						jac[jlen+1] = last;
						jlen=+2;
						fin +="J";
					}
					
					else
						impos = true;
				}
			}
			if(impos)
				System.out.println("Case #" + i + ": IMPOSSIBLE" );
			
			else
				System.out.println("Case #" + i + ": " + fin);
		}
	}
}