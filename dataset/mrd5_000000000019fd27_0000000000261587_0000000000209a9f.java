import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));) {

			int t = Integer.parseInt(br.readLine());
			for (int x = 0; x < t; x++) {
				char[] ch = br.readLine().toCharArray();
				int n = ch.length;
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = ch[i] - '0';
				}

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < arr[0]; i++) {
					sb.append('(');
				}
				sb.append(arr[0]);

				for (int i = 1; i < n; i++) {
					if (arr[i - 1] == arr[i]) {
						sb.append(arr[i]);
					} else if (arr[i - 1] < arr[i]) {
						for (int j = 0; j < arr[i] - arr[i - 1]; j++) {
							sb.append('(');
						}
						sb.append(arr[i]);
					} else {
						for (int j = 0; j < arr[i - 1] - arr[i]; j++) {
							sb.append(')');
						}
						sb.append(arr[i]);
					}
				}

				for (int i = 0; i < arr[n - 1]; i++) {
					sb.append(')');
				}

				System.out.println("Case #" + (x + 1) + ": " + sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
