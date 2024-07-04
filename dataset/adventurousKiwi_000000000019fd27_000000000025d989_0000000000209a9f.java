import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<T;i++) {
			
			String line = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			int unclosed = 0;
			
			for(int j=0;j<line.length();j++) {
				
				int digit = (int)line.charAt(j)-'0';
				
				if(unclosed<digit) {
					for(int k=0;k<digit-unclosed;k++) {
						sb.append("(");
						unclosed++;
					}
				}else if(unclosed>digit) {
					for(int k=0;k<unclosed-digit;k++) {
						sb.append(")");
						unclosed--;
					}
				}
				sb.append(digit);
			}
			for(int k=0;k<unclosed;k++) {
				sb.append(")");
			}
			
			System.out.println("Case #"+(i+1)+": "+sb.toString());

		}
		sc.close();
	}
}
