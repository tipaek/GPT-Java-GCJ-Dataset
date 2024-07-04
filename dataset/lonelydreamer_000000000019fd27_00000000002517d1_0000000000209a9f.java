import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {			
		Scanner scan = new Scanner(System.in);		
		int t = scan.nextInt() , caseNum = 1;	
		while (t > 0) {
			String string = scan.next();
			int cnt = 0;
			StringBuilder builder = new StringBuilder();
			for (int i = 0;i < string.length();i ++) {
				int digit = string.charAt(i) - '0';
				if (digit > cnt) {
					for (int j = 0;j < digit - cnt;j ++) {
						builder.append("(");						
					}					
				} else if (digit < cnt) {					
					for (int j = 0;j < cnt - digit;j ++) {
						builder.append(")");						
					}
				}
				builder.append(digit);
				cnt = digit;				
			}
			if (cnt > 0) {
				for (int i = 0;i < cnt;i ++) {
					builder.append(")");
				}				
			}
			System.out.println(String.format("Case #%d: %s" , caseNum , builder.toString())); 
			t --;
			caseNum ++;
		}
	}    	
		
}





