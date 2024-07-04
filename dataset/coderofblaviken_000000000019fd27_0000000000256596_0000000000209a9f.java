import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num_test_cases = in.nextInt();
		String s;
		int depth, pos, size, x, diff;
		
		for (int i = 1; i<=num_test_cases; i++) {
			s = in.next();
			StringBuilder builder = new StringBuilder(s);
			depth = pos = 0;
			size = s.length();
			
			while (pos < size) {			
				x = Integer.valueOf(builder.substring(pos, pos+1));
				diff = x-depth;
				if (diff > 0) {
					for (int j = 0; j<diff; j++) {
						builder.insert(pos, "(");
					}
					depth += diff;
				} else {
					diff = Math.abs(diff);
					for (int j = 0; j<diff; j++) {
						builder.insert(pos, ")");
					}
					depth -= diff;
					
				}
				pos += diff + 1;
				size += diff;
			}
			for (int j = 0; j<depth; j++) {
				builder.insert(pos, ")");
			}
			
			System.out.printf("Case #%d: %s\n", i, builder);
		}
		in.close();
	}
}
