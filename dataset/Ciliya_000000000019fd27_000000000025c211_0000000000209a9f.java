import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		int T, N;

		StringBuffer match = new StringBuffer();
		
		Scanner br = new Scanner(System.in);
		T = Integer.parseInt(br.nextLine());
		StringBuffer output = new StringBuffer();
		for (int k = 1; k <= T; k++) {
			output.delete(0, output.length());
			
			String s = br.nextLine();
			int n = 0;
			for (int i = 0; i < s.length(); i++) {
				n = s.charAt(i) - '0';
				switch (n) {
				case 0:
					output.append("0");
					break;
				case 1:
					output.append("(1)");
					break;
				case 2:
					output.append("((2))");
					break;
				case 3:
					output.append("(((3)))");
					break;
				case 4:
					output.append("((((4))))");
					break;
				case 5:
					output.append("(((((5)))))");
					break;
				case 6:
					output.append("((((((6))))))");
					break;
				case 7:
					output.append("(((((((7)))))))");
					break;
				case 8:
					output.append("((((((((8))))))))");
					break;
				case 9:
					output.append("(((((((((9)))))))))");
					break;
				}				
			}
			
			String finalOut = output.toString();
			finalOut = finalOut.replaceAll("\\)\\)\\)\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\)\\)\\)\\(\\(\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\)\\)\\(\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\)\\(\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\)\\(\\(", "");
			finalOut = finalOut.replaceAll("\\)\\(", "");
		
			System.out.println("Case #" + k + ": " + finalOut);
		}

	}

}
