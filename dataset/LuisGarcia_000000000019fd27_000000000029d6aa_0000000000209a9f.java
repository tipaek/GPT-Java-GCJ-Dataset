import java.util.*;

public class nesting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i=0;i<T;i++) {
			String s = scan.next();
			scan.nextLine();
			int arr[] = new int[s.length()];
			for (int j=0;j<s.length();j++) {
				arr[j] = Integer.parseInt(s.substring(j, j+1));
			}
			String ans = "";
			for (int j=0;j<arr[0];j++) {
				ans += '(';
			}
			for (int j=0;j<s.length()-1;j++) {
				ans += arr[j];
				if (arr[j] >= arr[j+1]) {
					for (int k=0;k<(arr[j] - arr[j+1]);k++) {
						ans += ')';
					}
				}
				else {
					for (int k=0;k<(arr[j+1] - arr[j]);k++) {
						ans += '(';
					}
				}
			}
			ans += arr[s.length() - 1];
			for (int j=0;j<arr[s.length()-1];j++) {
				ans += ')';
			}
			System.out.println("Case #" + (i+1) + ": " + ans);
		}

	}

}