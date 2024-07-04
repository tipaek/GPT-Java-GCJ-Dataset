
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long T = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (long t = 1; t <= T; ++t) {
			long meta[] = Arrays.stream(in.nextLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
			long col = meta[0], row = meta[1];
			String ans = "";
			if ((col + row) % 2 == 0)
				ans = "IMPOSSIBLE";
			else {
				long absCol = (long) Math.abs(col), absRow = (long) Math.abs(row);
				int countC = 0, countR = 0;
				for (int i = 0; i < 32; i++) {
					long temp = 1L << i;
					if ((absCol & temp) > 0)
						countC++;
					if ((absRow & temp) > 0)
						countR++;
				}
				//System.out.println(countC + " " + countR);
				int tot = countC + countR;
				int[] colArr = new int[tot], rowArr = new int[tot];
				long max = (1L << tot) - 1;
				if (absCol % 2 == 1) {
					long ansC = 0, ansR = 0;
					for (int i = 0; i < tot; i++) {
						if (i < countC)
							ansC |= 1L << i;
						else
							ansR |= 1L << i;
					}
					while (true) {
						rowArr = new int[tot];
						colArr = new int[tot];
						long tempRow = row, tempCol = col;
						for (int i = tot - 1; i >= 0; i--) {
							long temp = 1L << i;
							if ((ansR & temp) > 0) {
								if (tempRow < 0) {
									tempRow += temp;
									rowArr[i] = -1;
								} else {
									tempRow -= temp;
									rowArr[i] = 1;
								}
							} else {
								if (tempCol < 0) {
									tempCol += temp;
									colArr[i] = -1;
								} else {
									tempCol -= temp;
									colArr[i] = 1;
								}
							}
						}
						if (tempRow == 0 && tempCol == 0)
							break;
						ansR = (ansR << 1) % max;
						ansC = (ansC << 1) % max;
					}
				} else {
					long ansC = 0, ansR = 0;
					for (int i = 0; i < tot; i++) {
						if (i < countR)
							ansR |= 1L << i;
						else
							ansC |= 1L << i;
					}
					//System.out.println(ansR + " " + ansC);
					while (true) {
						rowArr = new int[tot];
						colArr = new int[tot];
						long tempRow = row, tempCol = col;
						for (int i = tot - 1; i >= 0; i--) {
							long temp = 1L << i;
							if ((ansR & temp) > 0) {
								if (tempRow < 0) {
									tempRow += temp;
									rowArr[i] = -1;
								} else {
									tempRow -= temp;
									rowArr[i] = 1;
								}
							} else {
								if (tempCol < 0) {
									tempCol += temp;
									colArr[i] = -1;
								} else {
									tempCol -= temp;
									colArr[i] = 1;
								}
							}
						}
						if (tempRow == 0 && tempCol == 0)
							break;
						ansR = (ansR << 1) % max;
						ansC = (ansC << 1) % max;
						//System.out.println( max+ " " +ansR + " " + ansC + " " +tempRow + " " + tempCol);
						//in.nextLine();
					}
				}
				for(int i = 0 ; i < tot ; i++) {
					if(rowArr[i] == 1)
						ans+="N";
					else if(rowArr[i] == -1)
						ans+="S";
					else if(colArr[i] == 1)
						ans += "E";
					else if(colArr[i] == -1)
						ans+="W";
				}
			}

			System.out.println("Case #" + t + ": " + ans);
		}
	}
}