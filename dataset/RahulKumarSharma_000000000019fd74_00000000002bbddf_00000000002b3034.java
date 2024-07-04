import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = Integer.parseInt(sc.nextLine().trim());

		for (int cs = 1; cs <= cases; cs++) {

			int n = Integer.parseInt(sc.nextLine().trim());

			String[] inputs = new String[n];

			for (int i = 0; i < n; i++) {
				inputs[i] = sc.nextLine().trim().replaceAll("\\*", "");
				
			}

			String result = "*";
			
			boolean found = true;
			
			for (int i = 0; i < n; i++) {
				found = true;
				for (int j = 0; j < n; j++) {
					if (!inputs[i].contains(inputs[j])) {
						found = false;
						break;
					}
				}
				
				if(found) {
					result = inputs[i];
				}
			}

			System.out.println("Case #" + cs + ": " + result);
		}
	}

}
