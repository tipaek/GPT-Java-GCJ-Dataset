import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	private static int b;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String tb = in.nextLine();
		Integer t = Integer.valueOf(tb.split(" ")[0]);
		b = Integer.valueOf(tb.split(" ")[1]);
		int unknown = b;
		
		for (int i = 0; i < t; i++) {
			List<Integer> sames = new ArrayList<>();
			List<Integer> differents = new ArrayList<>();
			int[] bits = new int[b];
			int currentFirstIndex = 0;
			int askCounter = 0;
			while(unknown > 0) {
				if (askCounter > 1 && askCounter % 10 == 0) {
					if (maintainSameBits(bits, sames, in)) {
						askCounter++;
					}
					if (maintainDifferentBits(bits, differents, in)) {
						askCounter++;
					}
				}
				System.out.println(currentFirstIndex + 1);
				askCounter ++;
				int currentFirstBit = Integer.valueOf(in.nextLine());
				bits[currentFirstIndex] = currentFirstBit;
				unknown--;
				if (unknown == 0) {
					break;
				}
				boolean maintained = false;
				if (askCounter > 1 && askCounter % 10 == 0) {
					maintained = true;
					if (maintainSameBits(bits, sames, in)) {
						askCounter++;
					}
					if (maintainDifferentBits(bits, differents, in)) {
						askCounter++;
					}
				}
				
				if (maintained) {
					System.out.println(currentFirstIndex + 1);
					askCounter ++;
					currentFirstBit = Integer.valueOf(in.nextLine());
					bits[currentFirstIndex] = currentFirstBit;
				}

				int currentLastIndex = (b - 1) - currentFirstIndex;
				System.out.println(currentLastIndex + 1);
				askCounter ++;
				int currentLastBit = Integer.valueOf(in.nextLine());
				bits[currentLastIndex] = currentLastBit;
				unknown--;
				if (currentFirstBit == currentLastBit) {
					sames.add(currentFirstIndex);
				}
				else {
					differents.add(currentFirstIndex);
				}
				currentFirstIndex++;
			}
			
			StringBuffer sb = new StringBuffer();
			for (int bit : bits) {
				sb.append(bit);
			}
			System.out.println(sb.toString());
			unknown = b;
			String result = in.nextLine();
			if ("N".equals(result)) {
				return;
			}
		}
	}	
	
	private static boolean maintainSameBits(int[] bits, List<Integer> indexes, Scanner in) {
		if (indexes.isEmpty()) {
			return false;
		}
		
		int idx = indexes.get(0);
		System.out.println(idx + 1);
		int currentBit = Integer.valueOf(in.nextLine());
		if (bits[idx] != currentBit) {
			for (Integer index : indexes) {
				int newValue = 0;
				if (bits[index] == 0) {
					newValue = 1;
				}
				bits[index] = newValue;
				bits[b - 1 - index] = newValue;
			}
		}
		return true;
	}
	
	private static boolean maintainDifferentBits(int[] bits, List<Integer> indexes, Scanner in) {
		if (indexes.isEmpty()) {
			return false;
		}
		
		int idx = indexes.get(0);
		System.out.println(idx + 1);
		int currentBit = Integer.valueOf(in.nextLine());
		if (bits[idx] != currentBit) {
			for (Integer index : indexes) {
				int oldValue1 = bits[index];
				int oldValue2 = bits[b - 1 - index];
				bits[index] = oldValue2;
				bits[b -1 - index] = oldValue1;
			}
		}
		return true;
	}
}

// 