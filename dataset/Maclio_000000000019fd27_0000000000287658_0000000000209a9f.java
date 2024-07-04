import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i<=T; i++){
			
			String input = scanner.nextLine() + "0";
			int L = input.length();
			StringBuffer answer = new StringBuffer();
		
			int dLast, d = 0;
			for(int j=0; j<L; j++){
				char x = input.charAt(j);
				dLast = d;
				d = Integer.parseInt(Character.toString(x));
				if(d>dLast){
					for(int k=0; k<d-dLast; k++){
						answer.append('(');
					}
				}
				if(d<dLast){
					for(int k=0; k<dLast-d; k++){
						answer.append(')');
					}
				}
				answer.append(x);
			}
			answer.deleteCharAt(answer.length()-1);
			System.out.println("Case #" + i + ": " + answer);
		}
		
	}
}