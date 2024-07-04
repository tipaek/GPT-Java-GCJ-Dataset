import java.io.*;
import java.util.Scanner;
class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int number_of_test_cases = scan.nextInt();
		for(int n = 1; n <= number_of_test_cases; n++) {
			int open = 0;
			String str = Integer.toString(scan.nextInt());
			int length = str.length();
			int i = 0;
			int digit = 0;
			String str2 = "";
			while (i < length) {
				str2 = "";
				int added = 0;
				digit = Character.getNumericValue(str.charAt(i));
				if (open < digit) {
					for (int j = 0; j < digit - open; j++) {
						str2 = str2 + "(";
						open ++;
						added ++;
					}
					str = str.substring(0, i) + str2 + str.substring(i);
					length += added;
					i += added;
				} else if (open > digit) {
					for (int j = 0; j < open - digit; j++) {
						str2 = str2 + ")";
						open --;
						added ++;
					}
					str = str.substring(0, i) + str2 + str.substring(i);
					length += added;
					i += added;
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