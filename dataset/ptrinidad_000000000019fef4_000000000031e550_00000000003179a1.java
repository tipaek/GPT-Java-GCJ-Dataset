import java.util.*;
import java.io.*;

public class Solution {
	// Try to program this with my daughter jumping over my head!! :D
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		Map<Integer,LinkedList<Character>> map;
		Collection<Character> letters;
		
		for (int test = 1; test <= t; ++test) {
			int U = in.nextInt();
			map = new HashMap<Integer,LinkedList<Character>>();
			letters = new LinkedList<Character>();
			for (int i=0; i < 10; i++) {
				map.put(i,new LinkedList<Character>());
			}
			for (int i = 0; i < 10000; i++) {
				String digit = in.next();
				String msg = in.next();
				if (digit.equals("-1")) {
					digit = "";
					for (int j=0; j < U;j++) {
						digit+="9";
					}
				}
				if (letters.size() < 10) {
					for (int pos = 0; pos < msg.length(); pos++) {
						char c = msg.charAt(pos);
						if (!letters.contains(c)) {
							letters.add(c);		
							for (Map.Entry<Integer,LinkedList<Character>> pair: map.entrySet()) {
								pair.getValue().add(c);
							}
						}
					}
				}
				if (msg.length() == digit.length()) {
					int number = digit.charAt(0) - 48;
					char c = msg.charAt(0);
					for (int j = number + 1; j < 10; j++) {
						map.get(j).remove(new Character(c));
					}
					if (msg.length() > 1) {
						map.get(0).remove(new Character(c));
					}
				}
				// confirm unique letters
				if (letters.size() == 10) {
					for (Map.Entry<Integer,LinkedList<Character>> pair: map.entrySet())  {
						if (pair.getValue().size() == 1) {
							Character c = new Character(pair.getValue().getFirst());
							for (int j = 0; j < 10; j++) {
								if (j != pair.getKey()) {
									map.get(j).remove(c);
								}
							}
						}
					}
				}
			}
			
			String res = "";
			for (int i = 0; i < 10; i++) {
				res += map.get(i).getFirst();
			}
			System.out.println(String.format("Case #%d: %s", test, res));
		}
		in.close();
	}

}