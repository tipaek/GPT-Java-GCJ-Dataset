

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final String[] settings = in.nextLine().split(" ");
		final int t = Integer.parseInt(settings[0]);
		final int b = Integer.parseInt(settings[1]);
	    for (int c = 1; c <= t; ++c) {
	        processCase(in, b);
	    }
	    in.close();
	}
	
	// Okay, so this shouldn't actually be all that hard.
	// By looking at the front and back, and then every 10 confirm by looking at 2(/1)
	// prior fields, I should always be able to get the current state and with 150
	// queries, be able to get exactly 122 fields.
	// Sounds sound in theory - let's give this a shot :)
	private static void processCase(final Scanner in, final int bytes) {
		// Waste 4 bytes for convenient access
		int[] byteState = new int[bytes+1];
		boolean hasEqual = false;
		boolean hasUnequal = false;
		int equalPos = 0;
		int unequalPos = 0;
		int nextInspect = 1;
		final int target = bytes / 2;
		int doublePeeks = 0;
		while (nextInspect <= target) {
			int nextLow = getNum(nextInspect, in);
			int highPos = bytes + 1 - nextInspect;
			int nextHigh = getNum(highPos, in);
			if (!hasEqual && nextLow == nextHigh) {
				hasEqual = true;
				equalPos = nextInspect;
			} else if (!hasUnequal && nextLow != nextHigh) {
				hasUnequal = true;
				unequalPos = nextInspect;
			}
			byteState[nextInspect] = nextLow;
			byteState[highPos] = nextHigh;
			
			nextInspect++;
			if (nextInspect > target) break;
			doublePeeks++;
			if (doublePeeks == 5) {
				// TODO: reshuffleState, which costs one double-peek
				
				// We've only met one type of match type so far. All that can happen is a flip (50%)
				// Or it remains the way it is (50%). We'd only need one peek for this, but do two
				// to stay in sync with our double peeks.
				if (!hasEqual || !hasUnequal) {
					getNum(1, in);
					int newValue = getNum(1, in);
					if (newValue != byteState[1]) {
						byteState = complementBytes(byteState, nextInspect, bytes);
					}
				} else {
					// We have both. We need to check one side of both equal and unequal to determine
					// which of the 4 possible actions was taken.
					final boolean hasEqualChanged = byteState[equalPos] != getNum(equalPos, in);
					final boolean hasUnequalChanged = byteState[unequalPos] != getNum(unequalPos, in);
					if(hasEqualChanged && hasUnequalChanged) {
						byteState = complementBytes(byteState, nextInspect, bytes);
					} else if (hasUnequalChanged) {
						byteState = reverseBytes(byteState, nextInspect, bytes);
					} else if (hasEqualChanged) {
						byteState = complementBytes(byteState, nextInspect, bytes);
						byteState = reverseBytes(byteState, nextInspect, bytes);
					} // else { noop }
				}
				
				doublePeeks = 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= bytes; i++) sb.append(byteState[i]);
		System.out.println(sb.toString());
		in.nextLine();
	}
	
	// Return is unnecessary, bur for consistency with reverse
	private static int[] complementBytes(int[] byteState, int exclusiveCap, int bytes) {
		for(int i = 1; i < exclusiveCap; i++) {
			byteState[i] = 1 - byteState[i];
			byteState[bytes+1-i] = 1 - byteState[bytes+1-i];
		}
		return byteState;
	}
	
	private static int[] reverseBytes(int[] byteState, int exclusiveCap, int bytes) {
		int[] newArray = new int[byteState.length];
		for(int i = 1; i < exclusiveCap; i++) {
			newArray[i] = byteState[bytes+1-i];
			newArray[bytes+1-i] = byteState[i];
		}
		return newArray;
	}
	
	private static int getNum(final int pos, final Scanner in) {
		System.out.println(pos);
		return Integer.parseInt(in.nextLine());
	}
	
	// Let's get that single point before I even start thinking about this...
	// Making sure the interactive setup works as expected.
	private static void processCaseOnePoint(final Scanner in, final int bytes) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			sb.append(in.nextLine());
		}
		System.out.println(sb.toString());
		in.nextLine();
	}
}