import java.util.Scanner;

public class Solution {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int x = 1;
		while(T>0) {
			String answer = "*";
			int N = s.nextInt();
			int max = 0;
			int maxLength = Integer.MIN_VALUE;
			String[] arr = new String[N];
			for(int i = 0; i<arr.length; i++) {
				arr[i] = s.next();
				if(arr[i].length() > maxLength) {
					max = i;
					maxLength = arr[i].length();
				}
			}
			
			arr[max] = removeAst(arr[max]);
			int check = 1;
			for(int i = 0; i< arr.length; i++) {
				if(i != max) {
					if(match(arr[i], arr[max])) {
						check++;
					}
				}
			}
			if(check != arr.length - 1) {
				answer = arr[max];
			}
			System.out.println("Case #"+x+": "+answer);
			x++;
			T--;
		}
	}
	
	static private boolean match(String first, String second) {
		if(first.length() == 0 && second.length() == 0) {
			return true;
		}
		
		if(first == "*" && first.length() != 1 && second.length() == 0) {
			return false;
		}
		
		if (first == second) 
	        return match(first+1, second+1);
		
		if(first == "*") {
			return match(first+1, second) || match(first, second+1);
		}
		return false;
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
