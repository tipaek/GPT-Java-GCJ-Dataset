import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static List<Long> powerList = new ArrayList<Long>();

	public static String solve(int x, int y) {
		char[] returnVal = "                                ".toCharArray();

		int x1 = x, y1 = y;

		int index = 0;

		if (x % 2 != 0 && y % 2 != 0)
			return "IMPOSSIBLE";
		else {
			if (x % 2 != 0) {
				if (x > 0) {
					returnVal[0] = 'E';
					x--;
				} else {
					returnVal[0] = 'W';
					x++;
				}
				index++;
			}

			if (y % 2 != 0) {
				if (index > 0)
					return "IMPOSSIBLE";
				if (y > 0) {
					returnVal[0] = 'N';
					y--;
				} else {
					returnVal[0] = 'S';
					y++;
				}
				index++;
			}

			if (index == 0) {
				return "IMPOSSIBLE";
			} else {
				Set<Integer> indexes = new HashSet<Integer>();
				if (x > 0) {
					while (x > 0) {
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= x && powerList.get(i + 1) > x) {
								x -= powerList.get(i);
								returnVal[i] = 'E';
								indexes.add(i);
								break;
							}
						}
					}
				} else if (x < 0) {
					x = x * (-1);
					while (x > 0) {
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= x && powerList.get(i + 1) > x) {
								x -= powerList.get(i);
								returnVal[i] = 'W';
								indexes.add(i);
								break;
							}
						}
					}
				}

				if (y > 0) {
					while (y > 0) {
						int oldY = y;
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= y && powerList.get(i + 1) > y && !indexes.contains(i)) {
								y -= powerList.get(i);
								returnVal[i] = 'N';
								break;
							}
						}
						if (y == oldY) {
							break;
						}
					}
				} else if (y < 0) {
					y = y * (-1);
					while (y > 0) {
						int oldY = y;
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= y && powerList.get(i + 1) > y && !indexes.contains(i)) {
								y -= powerList.get(i);
								returnVal[i] = 'S';
								break;
							}
						}
						if (y == oldY) {
							break;
						}
					}
				}
			}
		}

		if (x != 0 || y != 0) {
			x = x1;
			y = y1;
			returnVal =  "                                ".toCharArray();
			index = 0;
			if (x % 2 != 0) {
				if (x > 0) {
					returnVal[0] = 'W';
					x++;
				} else {
					returnVal[0] = 'E';
					x--;
				}
				index++;
			}

			if (y % 2 != 0) {
				if (index > 0)
					return "IMPOSSIBLE";

				if (y > 0) {
					returnVal[0] = 'S';
					y++;
				} else {
					returnVal[0] = 'N';
					y--;
				}
				index++;
			}

			if (index == 0) {
				return "IMPOSSIBLE";
			} else {
				Set<Integer> indexes = new HashSet<Integer>();
				if (x > 0) {
					while (x > 0) {
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= x && powerList.get(i + 1) > x) {
								x -= powerList.get(i);
								returnVal[i] = 'E';
								indexes.add(i);
								break;
							}
						}
					}
				} else if (x < 0) {
					x = x * (-1);
					while (x > 0) {
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= x && powerList.get(i + 1) > x) {
								x -= powerList.get(i);
								returnVal[i] = 'W';
								indexes.add(i);
								break;
							}
						}
					}
				}

				if (y > 0) {
					while (y > 0) {
						int oldY = y;
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= y && powerList.get(i + 1) > y && !indexes.contains(i)) {
								y -= powerList.get(i);
								returnVal[i] = 'N';
								break;
							}
						}
						if (y == oldY) {
							break;
						}
					}
				} else if (y < 0) {
					y = y * (-1);
					while (y > 0) {
						int oldY = y;
						for (int i = 1; i < 31; i++) {
							if (powerList.get(i) <= y && powerList.get(i + 1) > y && !indexes.contains(i)) {
								y -= powerList.get(i);
								returnVal[i] = 'S';
								break;
							}
						}
						if (y == oldY) {
							break;
						}
					}
				}
			}
		}

		if (x != 0 || y != 0) {
			return "IMPOSSIBLE";
		}

		String strReturnVal = new String(returnVal);
		strReturnVal = strReturnVal.trim();

		if (strReturnVal.indexOf(' ') >= 0)
			return "IMPOSSIBLE";

		return strReturnVal;
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		powerList.add(1l);
		for (int i = 1; i <= 30; i++) {
			powerList.add(powerList.get(i - 1) * 2);
		}

		for (int ks = 1; ks <= T; ks++) {
			int x = input.nextInt();
			int y = input.nextInt();
			String result = solve(x, y);
			System.out.println("Case #" + ks + ": " + result);
		}

		input.close();
	}
}