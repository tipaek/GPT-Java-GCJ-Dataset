import java.io.*;
import java.util.Scanner;
class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int number_of_test_cases = scan.nextInt();
		scan.nextLine();
		for(int n = 1; n <= number_of_test_cases; n++) {
			int open = 0;
			String str = scan.nextLine();
			int length = str.length();
			int i = 0;
			int digit = 0;
			String str2 = "";
			while (i < length) {
				str2 = "";
				int added = 0;
				digit = Character.getNumericValue(str.charAt(i));
				if (open < digit) {
					for (int k = 0; k < (digit - open); k ++) {
						str2 = str2 + "(";
						added ++;
					}
					str = str.substring(0, i) + str2 + str.substring(i);
					length += added;
					i += added;
					open += added;
				} else if (open > digit) {
					for (int j = 0; j < open - digit; j++) {
						str2 = str2 + ")";
						added ++;
					}
					str = str.substring(0, i) + str2 + str.substring(i);
					length += added;
					i += added;
					open -= added;
				}
				i++;
			}
			str2 = "";
			for (int j = 0; j < open; j++) {
				str2 = str2 + ")";
			}
			str = str + str2;
			System.out.println("Case #"+n+": "+str);
		}

	}
}