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
			
			if(N == 2) {
				if(arr[0].charAt(0) == '*' && arr[1].charAt(arr[1].length() - 1) == '*') {
					arr[0] = removeAst(arr[0]);
					arr[1] = removeAst(arr[1]);
					answer = arr[1] + arr[0];
				}
				if(arr[1].charAt(0) == '*' && arr[0].charAt(arr[0].length() - 1) == '*') {
					arr[0] = removeAst(arr[0]);
					arr[1] = removeAst(arr[1]);
					answer = arr[0] + arr[1];
				}
			}
			
			arr[max] = removeAst(arr[max]);
			int check = 0;
			for(int i = 0; i< arr.length; i++) {
				if(i != max) {
					if(match(arr[i], arr[max])) {
//						System.out.println("YES I MATCHED");
						check++;
					} else {
//						System.out.println("No for: "+arr[i]);
					}
				}
			}
			if(check == arr.length - 1) {
				answer = arr[max];
			}
			
			System.out.println("Case #"+x+": "+answer);
			x++;
			T--;
		}
	}
	
	static boolean match(String first, String second)  
	{ 
	    if (first.length() == 0 && second.length() == 0) 
	        return true; 
	  
	    if (first.length() > 1 && first.charAt(0) == '*' &&  
	                              second.length() == 0) 
	        return false; 
	    if ((first.length() > 1 && first.charAt(0) == '?') ||  
	        (first.length() != 0 && second.length() != 0 &&  
	         first.charAt(0) == second.charAt(0))) 
	        return match(first.substring(1),  
	                     second.substring(1)); 
	  
	    if (first.length() > 0 && first.charAt(0) == '*') 
	        return match(first.substring(1), second) ||  
	               match(first, second.substring(1)); 
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
