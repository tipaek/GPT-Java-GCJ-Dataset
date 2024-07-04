import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static void send(String str) {
		System.out.println(str);
		System.out.flush();
	}

	static boolean process(Scanner in, int B) throws IOException {
		StringBuilder result = new StringBuilder();
		
		for(int i = 1; i <= 10; i++) {
			send(Integer.toString(i));
			char c = in.next().charAt(0);
			result.append(c);
		}

		send(result.toString());
		char c = in.next().charAt(0);
		return c == 'Y';
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int B = in.nextInt();
		for(int i = 0; i < T; i++) 
			if (!process(in, B))
				break;
	}
}
