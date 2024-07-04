import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException,
    IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, t = 1;
		T = Integer.parseInt(br.readLine());
		String S;
		
        while (t <= T) {
            S = br.readLine();
            
            System.out.println(String.format("Case #%d: %s", t, solve(S)));
            t++;
        }
	}
	
	public static String solve(String s) {
		int opening, closing, si, sj;
		StringBuffer output = new StringBuffer("");
		char c[] = s.toCharArray();
		opening = Integer.parseInt(Character.toString(c[0]));
		closing = 0;
		output.append(generateOpeningBraces(opening));
		for(int i = 0; i < c.length - 1; i++) {
			si = Integer.parseInt(Character.toString(c[i]));
			sj = Integer.parseInt(Character.toString(c[i + 1]));
			if (opening == 0) {
				output.append(generateOpeningBraces(si));
				opening = si;
			}
			output.append(c[i]);
			if (si >= sj) {
				closing = si - sj;
				opening -= closing;
			} else {
				closing = opening;
				opening = 0;
			}
			output.append(generateClosingBraces(closing));
		}
		if (opening != 0) {
			output.append(c[c.length - 1]);
			output.append(generateClosingBraces(opening));			
		} else {
			si = Integer.parseInt(Character.toString(c[c.length - 1]));
			output.append(generateOpeningBraces(si));
			output.append(c[c.length - 1]);
			output.append(generateClosingBraces(si));
		}

		return output.toString();
	}
	
	public static String generateBraces(int n, String s) {
		if (n == 0) return "";
		return new String(new char[n]).replace("\0", s);
	}
	
	public static String generateOpeningBraces(int n) {
		return generateBraces(n, "(");
	}
	
	public static String generateClosingBraces(int n) {
		return generateBraces(n, ")");
	}
}
