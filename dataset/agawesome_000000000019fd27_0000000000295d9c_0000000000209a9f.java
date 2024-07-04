import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		String str;
		int[] arr;
		String ans;
		
		for (int i = 0; i < n; i++) {
			
			ans = "";
			str = scanner.next();
			arr = new int[str.length()];
			
			for (int j = 0; j < str.length(); j++) {
				arr[j] = Integer.parseInt(str.substring(j, j + 1));
			}
			
			for (int j = 0; j < arr[0]; j++) {
				ans += "(";
			}
			ans += arr[0];
			
			for (int j = 1; j < str.length(); j++) {
				
				if (arr[j] > arr[j - 1]) {
					//System.out.println("(");
					for (int k = 0; k < (arr[j] - arr[j - 1]); k++) {
						ans += "(";
					}
					
				} else if (arr[j] < arr[j - 1]) {
					//System.out.println(")");
					for (int k = 0; k < (arr[j - 1] - arr[j]); k++) {
						ans += ")";
					}
					
				}
				
				//System.out.println("next val " + arr[j]);
				//System.out.println(ans);
				ans += arr[j];
				
				
				
			}
			
			for (int j = 0; j < arr[arr.length - 1]; j++) {
				ans += ")";
			}
			
			System.out.println("Case #" + (i + 1) + ": " + ans); 
			
		}
		
		
	}

}
