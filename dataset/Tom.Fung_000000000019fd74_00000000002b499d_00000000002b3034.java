import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalCase = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= totalCase; i++) {
			int longestI = -1;
			String longest = "";
			int subCase = Integer.parseInt(sc.nextLine());
			String[] strList = new String[subCase];
			
			for(int j =0; j < subCase; j++) {
				strList[j] = sc.nextLine();				
				if(longestI <= strList[j].length()) {
					longest=strList[j];
					longestI = strList[j].length();
				}
			}
			
			boolean fullMatch = true;
			for(int j =0; j < subCase; j++) {
				if (fullMatch) {
					fullMatch = matchRegex(strList[j] ,longest.replace("\\*", "") );					
				}
			}
			result.append("Case #" + i + ": " + ((fullMatch)?longest.replace("*", ""): "*") + "\n");
		}
		System.out.print(result.toString());

	}

	
	public static boolean matchRegex(String reg, String str) {
		String regex = reg.replace("*", ".*");
		return str.matches(regex);
	}
}
