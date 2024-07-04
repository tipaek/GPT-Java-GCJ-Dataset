import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int T;
	static String S;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			S = br.readLine();
			
			solution(testCase);
		}
		br.close();
	}
	
	private static void solution(int testCase) {
		char[] arrS = S.toCharArray();
		String resultS = "";
		int count = 0;
		
		char beforeC = 's';
		for (int i = 0; i < arrS.length; i++) {
			int digit = Character.getNumericValue(arrS[i]);
			
			if(beforeC == 's') {
				count = digit;
				for (int j = 0; j < digit; j++) {
					resultS += "(";
				}
			} else {
				int beforeDigit = Character.getNumericValue(beforeC);
				
				if(beforeC == arrS[i]) {
					
				} else { 
					int diff = beforeDigit - digit;
					if(diff > 0) {
						for (int j = 0; j < diff; j++) {
							resultS += ")";
							count--;
						}
					} else {
						int temp = diff;
						temp *= -1;
						for (int j = 0; j < temp; j++) {
							resultS += "(";
							count++;
						}
					}
				}
			}
			beforeC = arrS[i];
			resultS += arrS[i];
			if(i == arrS.length - 1) {
				for (int j = 0; j < count; j++) {
					resultS += ")";
				}
			}
		}
		
		// Case #1: 0000
		System.out.println("Case #" + testCase + ": " + resultS);
	}

}
