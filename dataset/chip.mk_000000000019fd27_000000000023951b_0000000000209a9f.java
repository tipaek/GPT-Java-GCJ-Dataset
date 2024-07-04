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
				String S = sc.next();
				StringBuilder S1 = new StringBuilder();
				int i = 0;
				for (char c : S.toCharArray()) {
					int j = c - '0';
					while (i < j) {
						S1.append("(");
						i++;
					}
					while (i > j) {
						S1.append(")");
						i--;
					}
					S1.append(j);
				}
				while (i > 0) {
					S1.append(")");
					i--;
				}

				System.out.println(String.format("Case #%s: %s", t, S1));
				System.out.flush();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}