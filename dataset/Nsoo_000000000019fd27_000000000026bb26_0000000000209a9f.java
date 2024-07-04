import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		new Solution().solution();
//		System.out.println(answer);
		
		
	}

	public void solution() {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= tc; i++) {
			String str = sc.nextLine();
			String output = "";
			
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '1') {
					if (output.endsWith("1")) {
						output += str.charAt(j);
					} else {
						output += "("+str.charAt(j);
					}
				} else {
					if (output.endsWith("1")) {
						output += ")"+str.charAt(j);
					} else {
						output += str.charAt(j);
					}
				}
			}
			
			if (output.endsWith("1")) {
				output += ")";
			}
			
			System.out.println("Case #"+i+": "+output);
		}
		
		sc.close();
	}
}
