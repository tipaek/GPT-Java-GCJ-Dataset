import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		try (
			//BufferedReader ibr = new BufferedReader(new FileReader("D:/codejam_in.txt"));
			BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(ibr)
			)
		{
			sc.useLocale(new Locale("US"));
			int parT = sc.nextInt();
			
			for (int t = 1; t <= parT; t++) {

				int x = sc.nextInt();
				int y = sc.nextInt();
				String m = sc.next();
				
				char[] path = m.toCharArray();
				
				int d = Integer.MAX_VALUE;
				int v = 0;
				
				if (x != 0 || y != 0) {
					for (char c : path) {
						v++;
						
						switch (c) {
						case 'N': y++; break;
						case 'E': x++; break;
						case 'S': y--; break;
						case 'W': x--; break;
						}

						int td = Math.abs(x) + Math.abs(y);
						if (td <= v && v < d) {
							d = v;
							if (td == d) break;
						}
					}
				} else {
					d = v;
				}
				
				
				
				String answer = d < Integer.MAX_VALUE ? String.valueOf(d) : "IMPOSSIBLE";
				
				System.out.println(String.format("Case #%s: %s", t, answer));
				System.out.flush();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
