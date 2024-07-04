import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int x = 1; x <= t; x++) {

			Integer a = sc.nextInt();
			Integer b = sc.nextInt();

			List<Character> directions = Arrays.asList(sc.next().trim().split("")).stream()
					.map(s -> new Character(s.charAt(0))).collect(Collectors.toList());

			if (a.equals(0) && b.equals(0)) {
				System.out.println("Case #" + x + ": 0");
				continue;
			}

			boolean flag = false;

			for (int i = 0; i < directions.size(); i++) {
				
				Character move = directions.get(i);
				
				if(move.equals('S')) {
					b--;
				} else if(move.equals('N')) {
					b++;
				} else if(move.equals('E')) {
					a++;
				} else if(move.equals('W')) {
					a--;
				}

				if (Math.abs(a) + Math.abs(b) <= (i+1)) {
					System.out.println("Case #" + x + ": " + (i + 1));
					flag = true;
					break;
				}

			}

			if (flag) {
				continue;
			}

			System.out.println("Case #" + x + ": IMPOSSIBLE");

		}
	}

}
