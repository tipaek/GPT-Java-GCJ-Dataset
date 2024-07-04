import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		input.nextLine();
		
		for (int k = 1; k <= cases; k++) {
			String str = input.nextLine();
			
			LinkedList<Character> list = new LinkedList<>();
			
			for (int i = Integer.parseInt(str.charAt(0)+""); i > 0; i--)
				list.add('(');
			list.add(str.charAt(0));
			
			int cur, next;
			for (int i = 0; i < str.length() - 1; i++) {
				cur = Integer.parseInt(str.charAt(i)+"");
				next = Integer.parseInt(str.charAt(i + 1)+"");
				if (cur > next) {
					for (int j = cur - next; j > 0; j--)
						list.add(')');
					list.add(str.charAt(i + 1));
				}
				else
					if (cur < next) {
						for (int j = next - cur; j > 0; j--)
							list.add('(');
						list.add(str.charAt(i + 1));
					}
					else
						list.add(str.charAt(i + 1));
			}
			
			for (int i = Integer.parseInt(str.charAt(str.length() - 1) + ""); i > 0; i--)
				list.add(')');
			
			System.out.print("Case #" + k + ": ");
			for (char c : list)
				System.out.print(c);
			System.out.println();
		}
	}

}
