import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		for (int i = 0; i < T; i++) {
			String test = input.nextLine();
			System.out.println("Case #"+(i+1)+": "+ANSWER(test));
		}
	}
	public static String ANSWER(String test) {
		String answer="";
		for (int j = 0; j < Integer.parseInt(test.substring(0,1));j++){
			answer+="(";
		}
		answer+=test.substring(0,1);
		for (int j = 0; j < test.length()-1; j++) {
			if (test.charAt(j)!=test.charAt(j+1)) {
				int a = Integer.parseInt(test.substring(j,j+1));
				int b = Integer.parseInt(test.substring(j+1,j+2));
				if (a>b) {
					for (int k = 0; k < a-b; k++) {
						answer+=")";
					}
				}else {
					for (int k = 0; k < b-a; k++) {
						answer+="(";
					}
				}
			}
			answer+=test.substring(j+1,j+2);
		}
		int last = Integer.parseInt(test.substring(test.length()-1,test.length()));
		for (int j = 0; j < last; j++) {
			answer+=")";
		}
		return answer;
	}
}