
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfTC = sc.nextInt();

		String oP = "(";
		String cP = ")";
		for (int tcI = 0; tcI < numberOfTC; tcI++) {
			String numStr = sc.next();
			StringBuffer ansStr = new StringBuffer();

			int openC = 0;
			for (int i = 0; i < numStr.length(); i++) {
				String cNumS = "" + numStr.charAt(i);
				int cNum = Integer.parseInt(cNumS);

				if (cNum > openC) {
					String repeatedOP = new String(new char[cNum - openC]).replace("\0", oP);
					ansStr.append(repeatedOP + cNumS);
					openC += (cNum - openC);
				} else if (cNum == openC) {
					ansStr.append(cNumS);
				} else {
					String repeatedCP = new String(new char[openC - cNum]).replace("\0", cP);
					ansStr.append(repeatedCP + cNumS);
					openC -= (openC - cNum);
				}

			}
			String repeatedCP = new String(new char[openC]).replace("\0", cP);
			ansStr.append(repeatedCP);
//			System.out.println("" + ansStr);
			System.out.println(String.format("Case #%d: %s", (tcI + 1), ansStr));
		}

		sc.close();
	}
}