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

				int n = sc.nextInt();
				
				TimeSpan[] st = new TimeSpan[n], tasks = new TimeSpan[n];
				
				for (int i = 0; i < n; i++) {
					int s = sc.nextInt();
					int e = sc.nextInt();
					tasks[i] = new TimeSpan(s, e);
					st[i] = tasks[i];
				}
				
				Arrays.sort(st);
				
				int pos = 0;
				st[pos].to = "C";
				for (int i = 1; i < n; i++) {
					if (!st[pos].overlaps(st[i])) {
						pos = i;
						st[pos].to = "C";
					}
				}

				boolean impossible = false;
				pos = -1;
				for (int i = 0; i < n; i++) {
					if (st[i].to.equalsIgnoreCase("J")) {
						if (pos < 0) {
							pos = i;
						}  else if (st[pos].overlaps(st[i])) {
							impossible = true;
							break;
						}
					}
				}

				String answer;
				if (impossible) {
					answer = "IMPOSSIBLE";
				} else {
					StringBuilder sb = new StringBuilder();
					for (TimeSpan ts : tasks) sb.append(ts.to);
					answer = sb.toString();
				}
				
				System.out.println(String.format("Case #%s: %s ", t, answer));
				System.out.flush();

			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	static class TimeSpan implements Comparable<TimeSpan> {
		final Integer s, e;
		
		String to = "J";
		
		TimeSpan(int s, int e) {
			this.s = s;
			this.e = e;
		}
		
		@Override
		public int compareTo(TimeSpan arg0) {
			return s.compareTo(arg0.s);
		}
		
		boolean startsHere(TimeSpan ts) {
			return ts.s >= s && ts.s < e;
		}
		
		boolean overlaps(TimeSpan ts) {
			return startsHere(ts) || ts.startsHere(this);
		}
	}
}
