import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		for (int i = 0; i < numberOfCases; i++) {
			String s = in.next();
			String sNew = "";
			int counter = 1;
			int prevNumber = (int) (s.charAt(0) - 48);
			if (s.length() > 1) {
				for (int j = 1; j < s.length(); j++) {
					prevNumber = (int) (s.charAt(j-1) - 48);
					int actualNumber = (int) (s.charAt(j) - 48);
					if (!(j == s.length() - 1)) { // standard
						if (prevNumber == actualNumber) {
							counter++;
						} else {
							for (int k = 0; k < prevNumber; k++) {
								sNew += "(";
							}
							for (int k = 0; k < counter; k++) {
								sNew += prevNumber;
							}
							for (int k = 0; k < prevNumber; k++) {
								sNew += ")";
							}
							counter=1;
						}
					} else { // letzter durchlauf
						if (!(prevNumber == actualNumber)) {
							for (int k = 0; k < prevNumber; k++) {
								sNew += "(";
							}
							for (int k = 0; k < counter; k++) {
								sNew += prevNumber;
							}
							for (int k = 0; k < prevNumber; k++) {
								sNew += ")";
							}
							counter = 1;
							for (int k = 0; k < actualNumber; k++) {
								sNew += "(";
							}
							for (int k = 0; k < counter; k++) {
								sNew += actualNumber;
							}
							for (int k = 0; k < actualNumber; k++) {
								sNew += ")";
							}
						} else {
							counter++;
							for (int k = 0; k < prevNumber; k++) {
								sNew += "(";
							}
							for (int k = 0; k < counter; k++) {
								sNew += prevNumber;
							}
							for (int k = 0; k < prevNumber; k++) {
								sNew += ")";
							}
						}
					}
				}
			} else {
				for (int k = 0; k < prevNumber; k++) {
					sNew += "(";
				}
				for (int k = 0; k < counter; k++) {
					sNew += prevNumber;
				}
				for (int k = 0; k < prevNumber; k++) {
					sNew += ")";
				}
			}
			while(!(sNew.equals(fixBraces(sNew)))) {
				sNew = fixBraces(sNew);
			}
			System.out.println("Case #" + (i+1) + ": " + sNew);
		}
	}

	private static String fixBraces(String sNew) {
		String result = "";
		for (int i = 0; i < sNew.length()-1; i++) {
			if((sNew.charAt(i) == '(' && (sNew.charAt(i+1) == ')')) ||  (sNew.charAt(i) == ')' && (sNew.charAt(i+1) == '(') )) {
				i+=1;
			} else {
				result += sNew.charAt(i);
				if(i == sNew.length()-2) {
					result += sNew.charAt(i+1);
				}
			}
		}
		return result;
	}
}

