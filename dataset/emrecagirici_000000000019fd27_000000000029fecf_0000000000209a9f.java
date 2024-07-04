import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int totalCase = scan.nextInt();
		for(int i=0; i<totalCase; i++) {
			String word = scan.next();
			StringBuilder sb = new StringBuilder();
			int temp = 0;
			for(int j=0; j<word.length(); j++) {
				int number = word.charAt(j) - 48;
				int dif = number - temp;
				if(dif==0) {
					sb.append(number);
				}
				else {
					String par = getParanthesis(dif);
					sb.append(par);
					sb.append(number);
				}
			
				temp = number;
			}
			
			if(temp>0) {
				sb.append(getParanthesis(temp*(-1)));
			}
			
			System.out.println("Case #" + (i+1) + ": " + sb.toString());
		}
	}
	
	private static String getParanthesis(int repeat) {
		String res = "";
		if(repeat>0) {
			for(int i=0; i<repeat; i++) {
				res = res + "(";
			}
		}
		else if(repeat<0) {
			repeat = Math.abs(repeat);
			for(int i=0; i<repeat; i++) {
				res = res + ")";
			}
		}
		
		return res;
	}
}
