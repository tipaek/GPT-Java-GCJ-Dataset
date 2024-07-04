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
				int d = sc.nextInt();
				
				long[] a = new long[n];
				
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextLong();
				}
				
				Arrays.sort(a);
				
				int result = -1;
				
				int cont = 0, maxCont = 0;
				
				for (int i = 0; i < n; i++) {
					if (i == n - 1 || a[i] != a[i + 1]) {
						if (cont > maxCont) maxCont = cont;
						cont = 0;
					} else {
						cont++;
					}
				}
				
				if (d == 2) {
					if (maxCont > 0) result = 0;
					else result = 1;
				} else if (d == 3) {
					if (maxCont > 1) result = 0;
					else if (maxCont > 0) result = 1;
					else {
						result = 2;
						for (int i = 0; i < n - 1; i++) {
							for (int j = i + 1; j < n; j++) {
								if (2 * a[i] == a[j]) {
									result = 1;
									i = j = n;
								}
							}
						}
					}
				} 
				
				
				System.out.println(String.format("Case #%s: %s", t, result));
				System.out.flush();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
