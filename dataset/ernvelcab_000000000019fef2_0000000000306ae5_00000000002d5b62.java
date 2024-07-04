import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = bufferedReader.readLine();
			final int numberOfCases = Integer.parseInt(line);

			for (int c = 1; c <= numberOfCases; c ++) {
				line = bufferedReader.readLine();
				final String parts[] = line.split(" ");
				int x = Integer.parseInt(parts[0]);
				int y = Integer.parseInt(parts[1]);
				final boolean flippedX = x < 0;
				final boolean flippedY = y < 0;
				x = flippedX ? -x : x;
				y = flippedY ? -y : y;

				int current = 1;
				String verticalSteps = "";
				String horizontalSteps = "";

				if (((x % 2 == 0) && (y % 2 == 1)) || ((x % 2 == 1) && (y % 2 == 0))) {
					while (((x != 0) || (y != 0)) && ((x == 0) || (Math.abs(x) >= current)) && ((y == 0) || (Math.abs(y) >= current))) {
						int option = 0;

						if (y % 2 == 1) {
							// Options 0 or 1
							if (x == 0) {
								option = 1;
							} else {
								if (y - current != 0) {
									option = 1;
								} else {
									option = 0;
								}
							}
						} else if (x % 2 == 1) {
							// Options 2 or 3
							if (y == 0) {
								option = 3;
							} else {
								if (x - current != 0) {
									option = 3;
								} else {
									option = 2;
								}
							}
						} else {
							if (((x != 0) && (Math.abs(x) < current)) || ((y != 0) && (Math.abs(y) < current))) {
								break;
							}

							if (x == 0) {
								// Options 0 or 1
								if (y < 0) {
										option = 0;
								} else {
										option = 1;
								}
							} else if (y == 0) {
								// Options 2 or 3
								if (x < 0) {
										option = 2;
								} else {
										option = 3;
								}
							} else {
								// Options 0, 1, 2 or 3
								if (x < y) {
									if (x < 0) {
										option = 2;
									} else {
										option = 3;
									}
								} else /*if (x > y)*/ {
									if (y < 0) {
										option = 0;
									} else {
										option = 1;
									}
								}
							}
						}

						switch (option) {
							case 0:
								verticalSteps += "N";
								horizontalSteps += " ";
								y += current;
								break;
							case 1:
								verticalSteps += "S";
								horizontalSteps += " ";
								y -= current;
								break;
							case 2:
								verticalSteps += " ";
								horizontalSteps += "E";
								x += current;
								break;
							default:
								verticalSteps += " ";
								horizontalSteps += "W";
								x -= current;
						}

						current *= 2;
					}
				}

				String result = "IMPOSSIBLE";
				if ((x == 0) && (y == 0)) {
					result = "";
					for (int i = 0; i < verticalSteps.length(); i ++) {
						final char verticalStep = verticalSteps.charAt(i);
						final char horizontalStep = horizontalSteps.charAt(i);
						if (verticalStep == ' ') {
							result += horizontalStep;
						} else {
							result += verticalStep;
						}
					}
					if (!flippedX) {
						result = result.replaceAll("E", "T").replaceAll("W", "E").replaceAll("T", "W");
					}
					if (!flippedY) {
						result = result.replaceAll("N", "T").replaceAll("S", "N").replaceAll("T", "S");
					}
				}
				System.out.println("Case #" + c + ": " + result);
			}
		}
	}
}
