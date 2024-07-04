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
			var ch = 0;
			for(int i = 0; i<arr.length; i++) {
				arr[i] = s.next();
				if(arr[i].charAt(0) == '*') {
					ch++;
				}
				if(arr[i].charAt(arr[i].length() - 1) == '*') {
					ch++;
				}
				if(arr[i].length() > maxLength) {
					max = i;
					maxLength = arr[i].length();
				}
			}
			
			if(ch == arr.length) {
				for(int i = 0; i<arr.length; i++) {
					int val = 0;
					if(arr[i].charAt(0) == '*') {
						for(int j = 0; j<arr.length; j++) {
							if(arr[j].charAt(arr[j].length() - 1) == '*') {
								arr[j] = removeAst(arr[j]);
								arr[i] = removeAst(arr[i]);
								answer = arr[j] + arr[i];
								val = 1;
								break;
							}
						}
					}
					if(val == 1) {
						break;
					}
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
