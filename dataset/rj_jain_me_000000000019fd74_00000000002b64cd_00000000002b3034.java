import java.util.Scanner;

public class Solution {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int x = 1;
		while(T>0) {
			String answer = "";
			int N = s.nextInt();
			int max = 0;
			int maxLength = Integer.MIN_VALUE;
			String[] arr = new String[N];
			for(int i = 0; i<arr.length; i++) {
				String str = s.next();
				arr[i] = removeAst(str);
				if(arr[i].length() > maxLength) {
					max = i;
					maxLength = arr[i].length();
				}
			}
			
			for(int i = 0; i< arr.length; i++) {
				if(i != max) {
					if(!arr[max].contains(arr[i])) {
						answer = "Case #"+x+": *";
						System.out.println(answer);
						return;
					}
				}
			}
			answer = arr[max];
			System.out.println("Case #"+x+": "+answer);
			x++;
			T--;
		}
	}
	
	private static String removeAst(String str) {
		String newStr = "";
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) != '*') {
				newStr = newStr + str.charAt(i);
			}
		}
		return newStr;
	}

}
