import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int T;
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();	
		T = Integer.parseInt(s);
		for(int i=1;i<=T;i++) {
			s = in.nextLine();
			String ans = formatString(s.toCharArray() , i);
			System.out.println(ans);
		}
	}
	
	private static String formatString(char[] chArr, int testCaseNum) {
		Integer prev = 0 , next = 0;
		int i=0;
		StringBuilder sb = new StringBuilder("Case #");
		sb.append(testCaseNum);
		sb.append(": ");
		while(i<chArr.length) {
			int charNum = chArr[i] - '0';
			if(charNum > prev) {
				for(int j=0;j<charNum-prev;j++) {
					sb.append('(');
				}
			}
			sb.append(chArr[i]);
			next = (i == chArr.length-1) ? 0 : chArr[i+1] - '0';
			if(charNum > next) {
				for(int j=0;j<charNum-next;j++) {
					sb.append(')');
				}
			}
			prev = chArr[i++]-'0'; 
		}
		return sb.toString();
	}

}
