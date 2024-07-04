import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

public class Solution {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		int T = s.nextInt();
		int x = 1;
		while(T>0) {
			String str = s.next();
			String myResult = generateString(str);
			System.out.println("Case #"+x+": "+myResult);
			x++;
			T--;
		}
	}
	
	private static String generateString(String str) {
		ArrayList<Character> arr = new ArrayList<Character>();
		
		for(int i = 0; i<str.length(); i++) {
			if(i == 0) {
				if(str.charAt(i) == '0') {
					arr.add(str.charAt(i));
				} else {
					int num = (int)str.charAt(i) - 48;
					while(num>0) {
						arr.add('(');
						num--;
					}
					arr.add(str.charAt(i));
				}
			} else {
				if((int)str.charAt(i) < (int)str.charAt(i-1)) {
					int num = Math.abs((int)str.charAt(i) - (int)str.charAt(i-1));
					while(num>0) {
						arr.add(')');
						num--;
					}
					arr.add(str.charAt(i));
				} else if((int)str.charAt(i) > (int)str.charAt(i-1)) {
					int num = Math.abs((int)str.charAt(i) - (int)str.charAt(i-1));
					while(num>0) {
						arr.add('(');
						num--;
					}
					arr.add(str.charAt(i));
				} else {
					arr.add(str.charAt(i));
				}
			}
		}
		
		if(str.charAt(str.length() - 1) != '0') {
			int num = (int) str.charAt(str.length() - 1) - 48;
			while(num>0) {
				arr.add(')');
				num--;
			}
		}
		
		
		StringBuilder builder = new StringBuilder(arr.size());
	    for(Character ch: arr)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}

}
