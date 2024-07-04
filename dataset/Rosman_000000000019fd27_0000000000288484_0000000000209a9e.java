import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		new Solution(false).start();
	}

	private InputStream in;
	private PrintStream out;

	public Solution(final boolean local) {
		if (local) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("python -i local_testing_tool.py 1");
				in = p.getInputStream();
				out = new PrintStream(p.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			in = System.in;
			out = System.out;
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		int b = sc.nextInt();
		sc.nextLine();

		System.err.println(t + " " + b);

		boolean work = true;

		while (work) {
			BitSet bc;
			if (b == 10) {
				System.err.println("C10");
				bc = new BitSet(b + 1);
				for (int i = 1; i <= 10; i++) {
					read(sc, bc, i);
				}
			} else {
				bc = new BitSet(b + 1);

				read(sc, bc, 1);
				read(sc, bc, 2);
				read(sc, bc, 3);
				read(sc, bc, 4);
				read(sc, bc, 5);
				read(sc, bc, b - 4);
				read(sc, bc, b - 3);
				read(sc, bc, b - 2);
				read(sc, bc, b - 1);
				read(sc, bc, b);

				int index = -1;
				if (((bc.get(1) == bc.get(b)) && (bc.get(2) == bc.get(b - 1)) && (bc.get(3) == bc.get(b - 2)))
						|| ((bc.get(1) == !bc.get(b)) && (bc.get(2) == !bc.get(b - 1))
								&& (bc.get(3) == !bc.get(b - 2)))) {
					if (((bc.get(2) == bc.get(b - 1)) && (bc.get(3) == bc.get(b - 2)) && (bc.get(4) == bc.get(b - 3)))
							|| ((bc.get(2) == !bc.get(b - 1)) && (bc.get(3) == !bc.get(b - 2))
									&& (bc.get(4) == !bc.get(b - 3)))) {
						if (((bc.get(3) == bc.get(b - 2)) && (bc.get(4) == bc.get(b - 3))
								&& (bc.get(5) == bc.get(b - 4)))
								|| ((bc.get(3) == !bc.get(b - 2)) && (bc.get(4) == !bc.get(b - 3))
										&& (bc.get(5) == !bc.get(b - 4)))) {
							System.err.println("BAD 5");
						} else {
							index = 2;
						}
					} else {
						index = 1;
					}
				} else {
					index = 0;
				}

				if (index < 0) {
					bc = new BitSet(b + 1);

					read(sc, bc, 6);
					read(sc, bc, 7);
					read(sc, bc, 8);
					read(sc, bc, 9);
					read(sc, bc, 10);
					read(sc, bc, b - 9);
					read(sc, bc, b - 8);
					read(sc, bc, b - 7);
					read(sc, bc, b - 6);
					read(sc, bc, b - 5);

					index = -1;
					if (((bc.get(6) == bc.get(b - 5)) && (bc.get(7) == bc.get(b - 6)) && (bc.get(8) == bc.get(b - 7)))
							|| ((bc.get(6) == !bc.get(b - 5)) && (bc.get(7) == !bc.get(b - 6))
									&& (bc.get(8) == !bc.get(b - 7)))) {
						if (((bc.get(7) == bc.get(b - 6)) && (bc.get(8) == bc.get(b - 7))
								&& (bc.get(9) == bc.get(b - 8)))
								|| ((bc.get(7) == !bc.get(b - 6)) && (bc.get(8) == !bc.get(b - 7))
										&& (bc.get(9) == !bc.get(b - 8)))) {
							if (((bc.get(8) == bc.get(b - 7)) && (bc.get(9) == bc.get(b - 8))
									&& (bc.get(10) == bc.get(b - 9)))
									|| ((bc.get(8) == !bc.get(b - 7)) && (bc.get(9) == !bc.get(b - 8))
											&& (bc.get(10) == !bc.get(b - 9)))) {
								System.err.println("IMPOSSIBLE");
								index = 5;
							} else {
								index = 7;
							}
						} else {
							index = 6;
						}
					} else {
						index = 5;
					}
				}

				System.err.println("I: " + index);

				BitSet br = new BitSet(b + 1);
				if (index > 4) {
					br.set(6, 11);
					br.set(b - 9, b - 4);
				} else {
					br.set(1, 6);
					br.set(b - 4, b + 1);
				}

				if (index >= 0) {
					boolean work2 = true;
					while (work2) {
						boolean ref1 = bc.get(index + 1);
						boolean ref2 = bc.get(index + 2);
						boolean ref3 = bc.get(index + 3);
						boolean refI1 = bc.get(b - index);
						boolean refI2 = bc.get(b - index - 1);
						boolean refI3 = bc.get(b - index - 2);

						boolean act1 = read(sc, 1 + index);
						boolean act2 = read(sc, 2 + index);
						boolean act3 = read(sc, 3 + index);

						if ((ref1 == act1) && (ref2 == act2) && (ref3 == act3)) {
							System.err.println("NORMAL");
						} else if ((refI1 == act1) && (refI2 == act2) && (refI3 == act3)) {
							System.err.println("REVERSE");
							bc = reverse(b, bc);
							br = reverse(b, br);
						} else if ((ref1 == !act1) && (ref2 == !act2) && (ref3 == !act3)) {
							System.err.println("FLIP");
							bc.flip(1, b + 1);
						} else if ((refI1 == !act1) && (refI2 == !act2) && (refI3 == !act3)) {
							System.err.println("REVERSE & FLIP");
							bc.flip(1, b + 1);
							bc = reverse(b, bc);
							br = reverse(b, br);
						} else {
							System.err.println("ERROR");
						}

						for (int j = 0; j < 7; j++) {
							int k = 1;
							while (k <= b) {
								if (!br.get(k)) {
									read(sc, bc, k);
									br.set(k);
									break;
								}
								k++;
							}
							if (k > b) {
								work2 = false;
								break;
							}
						}
					}
				}
			}

			write(bs2String(bc, b));
			sc.nextLine();
			String result = sc.nextLine();
			System.err.println("R " + t + ":" + result);
			if (result.equals("Y")) {
				work = true;
				t--;
				if (t == 0) {
					work = false;
				}
			} else {
				work = false;
			}
		}
	}

	private BitSet reverse(final int b, BitSet bc) {
		BitSet tmp = new BitSet(b + 1);
		for (int j = 0; j < b; j++) {
			tmp.set(j + 1, bc.get(b - j));
		}
		bc = tmp;
		return bc;
	}

	private void read(final Scanner sc, final BitSet bc, final int pos) {
		int v;
		write(pos);
		v = sc.nextInt();
		System.err.println(pos + " > " + v);
		bc.set(pos, v == 1);
	}

	private boolean read(final Scanner sc, final int pos) {
		int v;
		write(pos);
		v = sc.nextInt();
		System.err.println(pos + " > " + v);
		return v == 1;
	}

	private String bs2String(final BitSet bs, final int l) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= l; i++) {
			sb.append(bs.get(i) ? "1" : "0");
		}
		return sb.toString();
	}

	private void write(final String data) {
		System.err.println(">>" + data);
		out.println(data);
		out.flush();
	}

	private void write(final int v) {
		String data = Integer.toString(v);
		System.err.println(">>" + data);
		out.println(data);
		out.flush();
	}
}
