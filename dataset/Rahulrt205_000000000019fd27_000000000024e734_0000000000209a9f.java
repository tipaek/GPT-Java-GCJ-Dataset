import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= T; i++) {
			String s = sc.nextLine();
			StringBuilder sb = new StringBuilder();

			int j = 0;
			int p = -1;
			while (j < s.length()) {

				if (s.charAt(j) == '0') {
					if (j - p > 1)
						sb.append(process(s.substring(p + 1, j)));
					sb.append('0');
					p = j;
				}
				j++;
			}
			if (j - p > 1)
				sb.append(process(s.substring(p + 1, j)));

			System.out.println("Case #" + i + ": " + sb.toString());
		}
		sc.close();
	}

	private static StringBuilder process(String s) {

		int index = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) > s.charAt(index))
				index = i;
		}

		int arr[] = new int[s.length()];

		int i = index;
		while (i > 0) {
			arr[i] = s.charAt(i - 1) - s.charAt(i);
			i--;
		}
		arr[0] = '0' - s.charAt(0);
		StringBuilder sb = new StringBuilder();
		for (i = 0; i <= index; i++) {
			if (arr[i] < 0) {
				int j = arr[i];
				while (j != 0) {
					sb.append('(');
					j++;
				}
				sb.append(s.charAt(i));
			} else {
				int j = arr[i];
				while (j != 0) {
					sb.append(')');
					j--;
				}
				sb.append(s.charAt(i));
			}
		}
		i = index;
		while (i < s.length() - 1) {
			arr[i] = s.charAt(i + 1) - s.charAt(i);
			i++;
		}
		arr[s.length() - 1] = '0' - s.charAt(s.length() - 1);

		for (i = index; i < s.length(); i++) {
			if (arr[i] < 0) {
				if (i!=index)
					sb.append(s.charAt(i));
				int j = arr[i];
				while (j != 0) {
					sb.append(')');
					j++;
				}
			} else {
				if (i!=index)
					sb.append(s.charAt(i));
				int j = arr[i];
				while (j != 0) {
					sb.append('(');
					j--;
				}

			}
		}

		return sb;
	}

}