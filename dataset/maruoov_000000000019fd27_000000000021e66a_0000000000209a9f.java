import java.util.*;
class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int cn = 1;
		while(T > 0) {
			T--;

            String S = sc.next();
            Stack<Character> stack = new Stack<>();
            String res = "";
            for (int i = 0; i < S.length(); i++) {
				char ch = S.charAt(i);

				if (stack.isEmpty()) {
					for (int j = 0; j < Integer.valueOf(ch + ""); j++) {
						res += "(";
					}

					res += ch + "";
					stack.push(ch);
				}
				else {
					if (stack.peek() == ch) {
						res += ch + "";
					}
					else {
						if (stack.peek() > ch) {
							int c = Integer.valueOf(stack.pop() + "") - Integer.valueOf(ch + "");

							for (int j = 0; j < c; j++) {
								res += ")";
							}

							res += ch + "";
							stack.push(ch);
						} else {
							int c = Integer.valueOf(ch + "") - Integer.valueOf(stack.pop() + "");

							for (int j = 0; j < c; j++) {
								res += "(";
							}
//
//							for (int j = 0; j < c; j++) {
//								res += ")";
//							}
							stack.push(ch);

							i--;
						}
					}
				}

			}


			if (!stack.isEmpty()) {
				int num = Integer.valueOf(stack.pop() + "");
				for (int j = 0; j < num; j++) {
					res += ")";
				}
			}

			System.out.printf("Case #%d: %s%n",cn, res);
			cn++;
		}
	}
}