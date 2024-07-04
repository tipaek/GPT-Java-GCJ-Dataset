import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int j = 1; j <= t; ++j) {
			String next = in.next();
			StringBuilder sb = new StringBuilder();

			int curopen = 0;
			for (int i = 0; i < next.length(); i++) {
				int item = next.charAt(i) - '0';
				if(curopen == item) {
					sb.append(item);
				} else {
					if(curopen < item) {
						addParantheses(sb, true, item - curopen);
						curopen = item;
					} else {
						addParantheses(sb, false, curopen - item);
						curopen = item;
					}
					sb.append(item);
				}
			}

			if(curopen > 0) {
				addParantheses(sb, false, curopen);
			}
			
			System.out.println("Case #" + j + ": " + sb.toString());
			
			// System.out.println("Case #" + i + ": OK");
 			// NumberFormat formatter = new DecimalFormat("#0.000000");   
			// System.out.println("Case #" + i + ": " + formatter.format(D/max));
		}
		in.close();
	}

	private static void addParantheses(StringBuilder in, boolean open, int count) {
		String paran = ")";
		if(open) paran = "(";
		for(int i = 0; i < count; i++) {
			in.append(paran);
		}
	}
}