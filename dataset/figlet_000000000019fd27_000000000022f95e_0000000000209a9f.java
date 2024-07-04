
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	private static int getValue(char ch) {
		return (int) ch - 48;
	}

	private static String getStringVal(Stack<Character> exp) {
		StringBuilder sb = new StringBuilder();
		int len = exp.size();
		for (int i = 0; i < len; i++) {
			sb.append(exp.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			String digitsStr = "";
			Stack<Character> exp = new Stack<Character>();
			int val = 0, peranthisisCnt = 0, opCnt = 0;
			int len = 0;
			for (int i = 1; i <= t; i++) {
				exp.clear();
				digitsStr = br.readLine();
				len = digitsStr.length();
				val = getValue(digitsStr.charAt(0));
				for (int k = 0; k < val; k++) {
					exp.push('(');
				}
				exp.push(digitsStr.charAt(0));
				peranthisisCnt = val;

				for (int j = 1; j < len; j++) {
					val = getValue(digitsStr.charAt(j));
					if (peranthisisCnt < val) {
						opCnt = val - peranthisisCnt;
						for (int k = 0; k < opCnt; k++) {
							exp.push('(');
						}
						exp.push(digitsStr.charAt(j));
						peranthisisCnt += opCnt;
						continue;
					}

					if (peranthisisCnt > val) {
						opCnt = peranthisisCnt - val;
						peranthisisCnt = val;
						for (int k = 0; k < opCnt; k++) {
							exp.push(')');
						}
						exp.push(digitsStr.charAt(j));
						continue;
					}
					if (val == peranthisisCnt) {
						exp.push(digitsStr.charAt(j));
					}

				}
				for (int k = 0; k < peranthisisCnt; k++) {
					exp.push(')');
				}
				System.out.println("Case #"+i+": "+getStringVal(exp));
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
