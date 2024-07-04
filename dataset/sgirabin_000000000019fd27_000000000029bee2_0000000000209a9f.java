import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public  class Solution  {

	private Scanner scanner;
	private PrintWriter writer;
	
	public Solution(InputStream in, OutputStream out) {
		scanner = new Scanner(in);
		writer = new PrintWriter(out);		
	}
	

	private void solve() {
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {

			String S = scanner.next();

			StringBuffer sb = new StringBuffer();
			if (S.length() == 1) {
				int digit = Character.getNumericValue(S.charAt(0));
				for (int k = 0; k < digit; k++) {
					sb.append("(");
				}
				sb.append(digit);
				for (int k = 0; k < digit; k++) {
					sb.append(")");
				}
			} else {
				String temp = "";
				for (int j = 1; j < S.length(); j++) {
					int previous = Character.getNumericValue(S.charAt(j - 1));
					int digit = Character.getNumericValue(S.charAt(j));

					if (temp.isEmpty()) {
						temp = String.valueOf(previous);
					}

					if (digit != previous) {
						for (int k = 0; k < previous; k++) {
							sb.append("(");
						}
						sb.append(temp);
						for (int k = 0; k < previous; k++) {
							sb.append(")");
						}
						temp=String.valueOf(digit);
					} else {
						temp = temp.concat(String.valueOf(digit));
					}
					
					if (j == S.length() - 1) {
						for (int k = 0; k < digit; k++) {
							sb.append("(");
						}
						sb.append(temp);
						for (int k = 0; k < digit; k++) {
							sb.append(")");
						}
						temp = "";
					}
				}
			}

			writer.printf("Case #%d: %s%n", i + 1, sb.toString());
		}
		writer.flush();
		writer.close();
	}
	
	
	public static void main(String[] args) {
    	
    	Solution solution = new Solution(System.in, System.out);
        solution.solve();
    }


}
