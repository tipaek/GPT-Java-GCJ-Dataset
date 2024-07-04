

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

	static long[] arr = new long[31];
	static long[] arr1 = new long[31];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out, false);

	static {
		long k = 1;
		long b = 1;
		for (int i = 0; i < 31; i++) {
			b = b << 1;
			arr1[i] = b - 1;
			if (i == 0) {
				arr[i] = 1;
				continue;
			}
			k = k << 1;
			arr[i] = k;
		}
	}

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int startX = 0;
			int startY = 0;

			if (isPossible(X, Y)) {
				boolean found = false;
				if (X == 0) {
					int index = -1;
					for (int j = 0; j < arr1.length; j++) {
						if (Math.abs(Y) == arr1[j]) {
							found = true;
							index = j;
							break;
						}
					}
					if (!found) {
						pw.println("Case #" + i + ": IMPOSSIBLE");
						continue;
					}
					String ch = (Y > 0) ? "N" : "S";
					pw.print("Case #" + i + ": ");
					for (int j = 0; j <= index; j++) {
						pw.print(ch);

					}
					pw.println();
					continue;
				}
				if (Y == 0) {
					int index = -1;
					for (int j = 0; j < arr1.length; j++) {
						if (Math.abs(X) == arr1[j]) {
							found = true;
							index = j;
							break;
						}
					}
					if (!found) {
						pw.println("Case #" + i + ": IMPOSSIBLE");
						continue;
					}
					String ch = (X > 0) ? "E" : "W";
					pw.print("Case #" + i + ": ");
					for (int j = 0; j <= index; j++) {
						pw.print(ch);

					}
					pw.println();
					continue;

				}

				if (Math.abs(X) == arr[0]) {
					if (Math.abs(Y) == arr[1]) {
						pw.print("Case #" + i + ": ");
						if (X < 0) {
							pw.print("W");
						} else if (X > 0) {
							pw.print("E");
						}
						if (Y > 0) {
							pw.print("N");
						} else if (Y < 0) {
							pw.print("S");
						}
						pw.println();
					}
				}

				if (Math.abs(Y) == arr[0]) {
					if (Math.abs(X) == arr[1]) {
						pw.print("Case #" + i + ": ");
						if (Y < 0) {
							pw.print("S");
						} else if (Y > 0) {
							pw.print("N");
						}
						if (X > 0) {
							pw.print("E");
						} else if (X < 0) {
							pw.print("W");
						}
						pw.println();
					}
				}

				pw.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}

			if (X > 0) {
				// take east
			} else if (X < 0) {
//take west
			}

			int[] res1 = checkIndex(X, Y);
			int[] res2 = checkIndex2(X, Y);
			char[] result = new char[32];
			int index1 = -1;
			if (res1[0] == 1) {
				result[res1[1]] = (X > 0) ? 'E' : 'W';
				// search Y
				int s = 0;
				boolean result1 = false;
				for (int j = 0; j < arr.length; j++) {
					if (j == res1[1]) {
						continue;
					}
					if (Y > 0) {
						s += arr[j];
						result[j] = 'N';
						if (s > Y) {
							boolean found = false;
							for (int e = 0; e < arr.length; e++) {
								if (e != res1[1]) {
									if (Math.abs(Y) == Math.abs(s - 2 * arr[e])) {
										result[e] = ('N' == result[e]) ? 'S' : 'N';
										found = true;
										break;
									}
								}
							}
							if (found) {
								result1 = true;
								break;
							}
						}
					}
					if (result1) {
						break;
					}
					if (Y < 0) {
						s -= arr[j];
						result[j] = 'S';
						if (s < Y) {
							boolean found = false;
							for (int e = 0; e < arr.length; e++) {
								if (e != res1[1]) {
									// if (Math.abs(Y - s) == arr[e]) {
									if (Math.abs(Y) == Math.abs(s + 2 * arr[e])) {
										result[e] = ('N' == result[e]) ? 'S' : 'N';
										found = true;
										break;
									}
								}
							}
							if (found) {

								result1 = true;
								break;
							}
						}
					}
					if (result1) {
						break;
					}
					index1 = j;
				}
				if (index1 == arr.length - 1) {
					pw.println("Case #" + i + ": IMPOSSIBLE");
				} else {
					pw.println("Case #" + i + ": " + String.valueOf(result));
				}
				continue;
			}

			if (specialCase(X, Y, i)) {
				continue;
			}

			if (res1[0] == 2) {
				result[res1[1]] = (Y > 0) ? 'N' : 'S';
				// search Y
				int s = 0;
				boolean result1 = false;
				for (int j = 0; j < arr.length; j++) {
					if (j == res1[1]) {
						continue;
					}
					if (X > 0) {
						s += arr[j];
						result[j] = 'E';
						if (s > X) {
							boolean found = false;
							for (int e = 0; e < arr.length; e++) {
								if (e != res1[1]) {
									if (Math.abs(X) == Math.abs(s - 2 * arr[e])) {
										result[e] = ('E' == result[e]) ? 'W' : 'E';
										found = true;
										break;
									}
								}
							}
							if (found) {
								result1 = true;
								break;
							}
						}
					}
					if (result1) {
						break;
					}
					if (X < 0) {
						s -= arr[j];
						result[j] = 'W';
						if (s < Y) {
							boolean found = false;
							for (int e = 0; e < arr.length; e++) {
								if (e != res1[1]) {
									if (Math.abs(X) == Math.abs(s + 2 * arr[e])) {
										result[e] = ('W' == result[e]) ? 'E' : 'W';
										found = true;
										break;
									}
								}
							}
							if (found) {

								result1 = true;
								break;
							}
						}
					}
					if (result1) {
						break;
					}
					index1 = j;
				}
				if (index1 == arr.length - 1) {
					pw.println("Case #" + i + ": IMPOSSIBLE");
					// Impossible
				} else {
					pw.println("Case #" + i + ": " + String.valueOf(result));
				}
				continue;
			}

//			
//			if (res1[0] == 1 && res2[0] == 2) {
//				// x direction
//				if (X > 0) {
//					// take East Direction
//				} else {
//					//take WestDirction
//				}
//
//			}

			// calculatePath(startX, startY, X, Y, "E", 0);
			// pw.println("Case #" + i + ": " + count);
		}
		pw.flush();
	}

	private static boolean specialCase(int x, int y, int i) {
		String res = "";
		if (Math.abs(x) == 2) {
			if (Math.abs(y) == 1) {
				if (y < 0) {
					res += "S";
				} else {
					res += "N";
				}
				if (x < 0) {
					res += "W";
				} else {
					res += "E";
				}
				pw.println("Case #" + i + ": " + res);
			}

		}

		if (Math.abs(x) == 1) {
			if (Math.abs(y) == 2) {

				if (x < 0) {
					res += "W";
				} else {
					res += "E";
				}

				if (y < 0) {
					res += "S";
				} else {
					res += "N";
				}

				pw.println("Case #" + i + ": " + res);
			}

		}
		return res.length() > 0 ? true : false;
	}

	static int c = 0;

	private static int[] checkIndex(int X, int Y) {
		boolean a = false;
		boolean b = false;
		int index = -1;
		int[] x = new int[2];
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == Math.abs(X)) {
				a = true;
				index = j;
			}

			if (arr[j] == Math.abs(Y)) {
				b = true;
				index = j;
			}
		}

		x[1] = index;
		if (a) {
			x[0] = 1;
		}
		if (b) {
			x[0] = 2;
		}
		return x;
	}

	private static int[] checkIndex2(int X, int Y) {
		boolean a = false;
		boolean b = false;
		int index = -1;
		int[] x = new int[2];
		for (int j = 0; j < arr1.length; j++) {
			if (arr1[j] == Math.abs(X)) {
				a = true;
				index = j;
			}

			if (arr1[j] == Math.abs(Y)) {
				b = true;
				index = j;
			}
		}

		x[1] = index;
		if (a) {
			x[0] = 1;
		}
		if (b) {
			x[0] = 2;
		}
		return x;
	}

	private static boolean isPossible(int X, int Y) {
		boolean a = false;
		boolean b = false;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == Math.abs(X)) {
				a = true;
			}

			if (arr[j] == Math.abs(Y)) {
				b = true;
			}
		}

		if (a && b) {
			return false;
		}

		for (int j = 0; j < arr1.length; j++) {
			if (arr1[j] == Math.abs(X)) {
				a = true;
			}

			if (arr1[j] == Math.abs(Y)) {
				b = true;
			}
		}
		if (a && b) {
			return false;
		}
		return true;
	}

	private static boolean distance(int startX, int startY, int X, int Y, String direction, int count) {
		return (int) Math.sqrt(Math.pow(startX - X, 2) + Math.pow(startY - Y, 2)) <= arr[30];
	}

	private static void calculatePath(int startX, int startY, int X, int Y, String direction, int count) {
		if (count == 32) {
		}
		// return "IMPOSSBLE"
		if (startX == X && Y == startY) {
			return;
		}

		if (distance(startX, startY, X, Y, direction, count)) {
			if ("S".equalsIgnoreCase(direction)) {
				startY -= arr[count];
			} else if ("N".equalsIgnoreCase(direction)) {
				startY += arr[count];
			} else if ("E".equalsIgnoreCase(direction)) {
				startX += arr[count];
			} else if ("W".equalsIgnoreCase(direction)) {
				startX -= arr[count];
			}
			count++;
			calculatePath(startX, startY, X, Y, "N", count);
			count--;
			calculatePath(startX, startY, X, Y, "S", count);
			count++;
			calculatePath(startX, startY, X, Y, "E", count);
			count--;
			calculatePath(startX, startY, X, Y, "W", count);
			count++;
			count--;
		}

	}
}
