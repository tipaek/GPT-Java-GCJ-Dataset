import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();
		int B = reader.nextInt();
//
//		if (B == 10) {
//			solveEasy(T, B);
//			return;
//		}

		// 1 for 1, -1 for bit 0, 0 for unknown
		// int[] arr = new int[B];
		// the bits currently stored in the array
		// (which will not necessarily match the bits that were initially present!)
		// System.out.println("10101001010");
		int lasti = B - 1;
		int lim = 150;
		try {
			for (int t = 0; t < T; t++) {
				boolean[] know = new boolean[B];
				int[] bits = new int[B];
				List<Integer> known = new ArrayList<Integer>();
				int asked = 0;
				int lastAsked = 0;
				for (int i = 0; i < 5; i++) {
					System.out.println(i + 1);
					System.out.flush();
					int bit = reader.nextInt();
					know[i] = true;
					bits[i] = bit;
					known.add(i);
					System.out.println(lasti - i + 1);
					System.out.flush();
					bit = reader.nextInt();
					know[lasti - i] = true;
					bits[lasti - i] = bit;
					asked += 2;
				}
				lastAsked = 5;
				for (int i = 10; i < lim && lastAsked <= (B / 2);) {
					//System.err.println(i);
					if (i % 10 == 0) {
						// there was a quantum change
						int ii = isSym(known, bits);
						if (ii < 0) {
							// is symmetric
							// check any pair and see if it was reverse
							int ik = known.get(0);
							System.out.println(ik + 1);
							System.out.flush();
							int bit = reader.nextInt();
							if (bits[ik] != bit) {
								// complemenet
								bits = complement(bits);
							}
							i++;
						} else {
							int is = findSym(known, bits);
							if (is < 0) {
								System.out.println(ii + 1);
								System.out.flush();
								int bit = reader.nextInt();
								if (bits[ii] != bit) {
									// either rev or comp, but same res
									bits = complement(bits);
								}
								i++;
							} else {
								System.out.println(ii + 1);
								System.out.flush();
								int bit1 = reader.nextInt();
								System.out.println(is + 1);
								System.out.flush();
								int bit2 = reader.nextInt();

								boolean CCR = bit2 != bits[is];
								boolean RC = bit1 != bits[ii];

								if (!CCR && RC) {
									bits = reverse(bits);
								} else if (CCR && RC) {
									bits = complement(bits);
								} else if (CCR && !RC) {
									bits = complement(bits);
									bits = reverse(bits);
								}
								i += 2;
							}
						}

					} else {
						if (solved(know)) {
							break;
						}
						if ((i + 1) % 10 != 0) {
							System.out.println(lastAsked + 1);
							System.out.flush();
							int bit = reader.nextInt();
							bits[lastAsked] = bit;
							know[lastAsked] = true;
							known.add(lastAsked);
							System.out.println(lasti - lastAsked + 1);
							System.out.flush();
							bit = reader.nextInt();
							know[lasti - lastAsked ] = true;
							bits[lasti - lastAsked ] = bit;
							i += 2;
							lastAsked++;
						} else {
							System.out.println(lastAsked + 1);
							int bit = reader.nextInt();
							i++;
						}
					}
				}

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < B; i++) {
					sb.append(bits[i]);
				}
				System.out.println(sb.toString());
				String ret = reader.next();
				if (ret.equals("N")) {
					return;
				}
			}
		} catch (Exception e) {
			return;
		}

	}

	private static void solveEasy(int T, int B) {
		for (int t = 0; t < T; t++) {
			String res = "";
			for (int b = 0; b < B; b++) {
				System.out.println(b + 1);
				String bit = reader.next();
				res += bit;
			}
			System.out.println(res);
			String ret = reader.next();
			if (ret.equals("N")) {
				return;
			}
		}
	}

	static boolean solved(boolean[] know) {
		for (boolean b : know) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	static int findSym(List<Integer> known, int[] bits) {
		for (int i : known) {
			if (bits[i] == bits[bits.length - 1 - i]) {
				return i;
			}
		}
		return -1;
	}

	static int isSym(List<Integer> known, int[] bits) {
		for (int i : known) {
			if (bits[i] != bits[bits.length - 1 - i]) {
				return i;
			}
		}
		return -1;
	}

	static int[] reverse(int[] bits) {
		for (int i = 0; i < bits.length / 2; i++) {
			int temp = bits[i];
			bits[i] = bits[bits.length - i - 1];
			bits[bits.length - i - 1] = temp;
		}
		return bits;
	}

	static int[] complement(int[] bits) {
		for (int i = 0; i < bits.length; i++) {
			if (bits[i] == 1) {
				bits[i] = 0;
			} else {
				bits[i] = 1;
			}
		}
		return bits;
	}

}
