import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Solution  {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNumber = in.nextInt();
		ArrayList<String> testCases = new ArrayList<String>();
		for (int i = 0; i < testCasesNumber; i++) {
			testCases.add(in.next());
		}
		int testCaseCounter = 1;
		for(String testCase: testCases) {
			int depth = 0;
			StringBuilder solution = new StringBuilder();
			for(int i =0; i< testCase.length(); i++) {
				int nmb = Integer.parseInt(testCase.substring(i, i + 1));
				if (nmb == depth) {
					solution.append(nmb);
				} else {
					if(nmb > depth) {
						for(int ind = 0; ind < (nmb-depth); ind++) {
							solution.append("(");
						}
						depth = nmb;
						solution.append(nmb);
					} else {
						for(int ind = 0; ind < (depth-nmb); ind++) {
							solution.append(")");
						}
						depth = nmb;
						solution.append(nmb);
					}
				}
			}
			for(int i = 0; i < depth; i++) {
				solution.append(")");
			}
			System.out.println("Case #" + testCaseCounter + ": " + solution.toString());
			testCaseCounter++;
		}
	}
}
