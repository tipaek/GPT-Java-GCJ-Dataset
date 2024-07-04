import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	
	static Scanner sc = null;
	
	public static void main(String[] args) throws Exception {
		if (System.getProperties().getProperty("user.name").equals("Alexey")) {
			sc = new Scanner(new FileInputStream("input.txt"));;
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		String[] tbLine = sc.nextLine().split(" ");
		int testCases = Integer.parseInt(tbLine[0]);
		int B = Integer.parseInt(tbLine[1]);
		for (int i = 1; i < testCases + 1; i++) {
			readAndresolveSingleCase(B);
			System.out.flush();
			String response = sc.nextLine();
			if (response.equals("N")) {
				break;
			}
			if (!response.equals("Y")) {
				//int[] heapOverflow = new int[Integer.MAX_VALUE];
				//System.out.println(heapOverflow);
			}
			
		}
		sc.close();
	}

	private static void readAndresolveSingleCase(int B) {
		int bCounter = 0;
		
		boolean[] bitSet = new boolean[B];
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				bitSet[bCounter/2] = getBit(bCounter/2);
			} else {
				bitSet[B-1-(bCounter/2)] = getBit(B-1-(bCounter/2));
			}
			bCounter++;
			if (bCounter == B) {
				StringBuilder result = new StringBuilder();
				for (int k = 0; k < bitSet.length; k++) {
					result.append(bitSet[k] ? 1 : 0);
				}
				System.out.println(result);
				return;
			}
		}



		
		for (int i = 1; i <= 14; i++) {
			//flip, reverse, flip and reverse, or no changes:
			
			if (onlyEqualBitsLeftAndRight(bitSet, bCounter)) {
				if (bitSet[0] != getBit(0)) {
					complement(bitSet); //swap has no effect
					getBit(0); //for even number
				} else {
					//known part of bitset unchanged
					getBit(0); //for even number
				}
			} else if (onlyDifferentBitsLeftAndRight(bitSet, bCounter)) {
				if (bitSet[0] == getBit(0)) {
					getBit(0); //for even number
				} else {
					complement(bitSet);
					getBit(0); //for even number
				}
			} else {
				int eqB = findEqualBit(bitSet, bCounter);
				int diffB = findDifferentBit(bitSet, bCounter);
				boolean newEqVal = getBit(eqB);
				boolean newDiffVal = getBit(diffB);
				
				if (newEqVal == bitSet[eqB]) {
					//swap or nothing
					if (newDiffVal != bitSet[diffB]) {
						swap(bitSet);
					} else {
						//nothing
					}
				} else {
					//complement or swap&implement
					if (newDiffVal != bitSet[diffB]) {
						complement(bitSet);
					} else {
						swap(bitSet);
						complement(bitSet);
					}
				}
			}
			for (int j = 1; j <= 8; j++) {
				if (j % 2 == 1) {
					bitSet[bCounter/2] = getBit(bCounter/2);
				} else {
					bitSet[B-1-(bCounter/2)] = getBit(B-1-(bCounter/2));
				}
				bCounter++;
				if (bCounter == B) {
					StringBuilder result = new StringBuilder();
					for (int k = 0; k < bitSet.length; k++) {
						result.append(bitSet[k] ? 1 : 0);
					}
					System.out.println(result);
					return;
				}
			}
		}
	}

	private static void swap(boolean[] bitSet) {
		for (int i = 0; i < bitSet.length/2; i++) {
			boolean temp = bitSet[i];
			bitSet[i] = bitSet[bitSet.length -1 - i];
			bitSet[bitSet.length -1 - i] = temp;
		}
		
	}

	private static int findDifferentBit(boolean[] bitSet, int bCounter) {
		for (int i = 0; i < bCounter/2; i++) {
			if (bitSet[i] != bitSet[bitSet.length -1 - i]) {
				return i;
			}
		}
		return -1;
	}

	private static int findEqualBit(boolean[] bitSet, int bCounter) {
		for (int i = 0; i < bCounter/2; i++) {
			if (bitSet[i] == bitSet[bitSet.length -1 - i]) {
				return i;
			}
		}
		return -1;
	}

	private static void complement(boolean[] bitSet) {
		for (int i = 0; i < bitSet.length; i++) {
			bitSet[i] = !bitSet[i];
		}
	}

	private static boolean onlyDifferentBitsLeftAndRight(boolean[] bitSet, int bCounter) {
		for (int i = 0; i < bCounter/2; i++) {
			if (bitSet[i] == bitSet[bitSet.length -1 - i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean onlyEqualBitsLeftAndRight(boolean[] bitSet, int bCounter) {
		for (int i = 0; i < bCounter/2; i++) {
			if (bitSet[i] != bitSet[bitSet.length -1 - i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean getBit(int i) {
		System.out.println("" + (i+1));
		System.out.flush();
		return Byte.parseByte(sc.nextLine()) == 0 ? false : true;
	}


}








