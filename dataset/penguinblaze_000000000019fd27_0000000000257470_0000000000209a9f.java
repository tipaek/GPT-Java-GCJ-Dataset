import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine(); // we didn't read the first line, just the number so throw it
		for(int t = 1; t<=T; t++){
			System.out.print("Case #" + t + ": ");
			String line = in.nextLine();
			line = "0" + line + "0";
			String solution = "";
			for(int i = 1; i < line.length()-1; i++){
				int prev = Character.getNumericValue(line.charAt(i-1));
				int num = Character.getNumericValue(line.charAt(i));
				int next = Character.getNumericValue(line.charAt(i+1));
				
				for(int j = 0; j < num-prev; j++){
					solution += "(";
				}
				solution += num;
				for(int j = 0; j < num-next; j++){
					solution += ")";
				}
			}
			System.out.println(solution);
		}
		in.close();
	}

}
