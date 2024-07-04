import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalCase = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= totalCase; i++) {

			String header = "";
			String footer = "";
			StringBuilder middle = new StringBuilder();
			
			
			int subCase = Integer.parseInt(sc.nextLine());
			String[] strList = new String[subCase];
			
			for(int j =0; j < subCase; j++) {
				strList[j] = sc.nextLine();				

				if(strList[j].charAt(0) != '*') {
					if(strList[j].length() > header.length())
						header = strList[j];
				}
				if (strList[j].charAt(strList[j].length() - 1) != '*') {
					if (strList[j].length() > footer.length())
						footer=strList[j];
				}
				middle.append(strList[j].replace("*", ""));
			}
			
			middle.insert(0, header.replace("*", ""));
			middle.append(footer.replace("*", ""));
			
			boolean fullMatch = true;
			for(int j =0; j < subCase; j++) {
				if (fullMatch) {
					fullMatch = matchRegex(strList[j] ,middle.toString() );					
				}
			}
			result.append("Case #" + i + ": " + ((fullMatch)?middle.toString(): "*") + "\n");
		}
		System.out.print(result.toString());
	}
	
	public static boolean matchRegex(String reg, String str) {
		String regex = reg.replace("*", ".*");
		return str.matches(regex);
	}
}
