import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			Integer x = in.nextInt();
			Integer y = in.nextInt();

			if ((x + y) % 2 == 0) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}

			System.out.print("Case #" + i + ": ");

			Boolean xSign = x >= 0;
			Boolean ySign = y >= 0;
			Integer xAbs = Math.abs(x);
			Integer yAbs = Math.abs(y);

			Integer dist = xAbs + yAbs;
			Integer highNum = Integer.highestOneBit(dist) * 2 - 1;
			Integer negateBits = (Integer.highestOneBit(dist) * 2 - dist - 1) / 2;
			Integer bitVals = negateBits ^ highNum;

			Integer it = Integer.highestOneBit(bitVals);

			Deque<Character> result = new ArrayDeque<>();

			while (it != 0) {
				
				if((it & bitVals) != 0) {
					//positive - assign to highest
					if(xAbs > yAbs) {
						xAbs -= it;
						result.push(xSign == true ? 'E' : 'W');
					}
					else {
						yAbs -= it;
						result.push(ySign == true ? 'N' : 'S');
					}
				}
				
				else {
					
					//System.out.println("IT " + it);
					if(yAbs > xAbs) {
						xAbs += it;
						result.push(xSign == true ? 'W' : 'E');
					}
					else {
						yAbs += it;
						result.push(ySign == true ? 'S' : 'N');
					}
				}

				it /= 2;
			}
			
			while(!result.isEmpty()) {
				System.out.print(result.pop());
			}

			System.out.println();
		}
	}
}