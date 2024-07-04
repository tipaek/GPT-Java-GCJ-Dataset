import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		try {
			int T;
			String lineStr = in.nextLine();
			T = Integer.parseInt(lineStr);
//			System.out.println("T = " + T + "\n");

			/**************************************************************************************
			// Case
			 **************************************************************************************/
			long caseIndex = 1;
			for(int t=0; t < T; t++) {
				// Anser
				String caseAnserStr = "";

				lineStr = in.nextLine();

				String S = lineStr;

//				System.out.println(S);

				int[] s = new int[S.length()];
				for (int i = 0; i < S.length(); i++) {
				    s[i] = S.charAt(i)-'0';
				}

				int counter = 0;

				for (int i = 0; i < S.length(); i++) {

					int n = s[i];

					if(n > counter) {
						int jj = (n - counter);
						for (int j = 0; j < jj ; j++) {
							caseAnserStr = caseAnserStr + "(";
							counter++;
						}
						caseAnserStr = caseAnserStr + n;
					} else if(n == counter) {
						caseAnserStr = caseAnserStr + n;
					} else {
						int jj = (counter - n);
						for (int j = 0; j < jj ; j++) {
							caseAnserStr = caseAnserStr + ")";
							counter--;
						}
						caseAnserStr = caseAnserStr + n;
					}
				}

				for (int j = 0; j < counter ; j++) {
					caseAnserStr = caseAnserStr + ")";
				}

				/**************************************************************************************
				// Output Case Answer
				 **************************************************************************************/
				String output = "Case #" + caseIndex + ": " + caseAnserStr;
				caseIndex++;
				System.out.println(output);
			}
		} finally {
		}
	}
}
