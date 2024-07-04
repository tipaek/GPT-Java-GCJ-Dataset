import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberTest = in.nextInt();
		int bit = in.nextInt();
		int half = bit/2;
		for (int i = 0; i < numberTest; i++) {
			int[] array = new int[bit];
			boolean foundSame = false;
			int same = -1;
			int different = -1;
			int prevSame = -1, prevDiff = -1;
			int tickCounter = 0;
			boolean foundDifferent = false;
			
			for (int j = 0; j < half; j++) {
				tickCounter++;
				System.out.println(half+j+1);
				array[half+j] = in.nextInt();
				tickCounter++;
				System.out.println(half-j);
				array[half-j - 1] = in.nextInt();
				if (array[half+j] == array[half-j-1]) {
					foundSame = true;
					same = j;
				} else {
					foundDifferent = true;
					different = j;
				}
			}
			
			for (int lol = 0; lol < bit; lol++) {
				if (tickCounter%10 == 0) {
					tickCounter++;
					System.out.println(half+same+1);
					int temp1 = in.nextInt();
					if (prevSame == -1) {
						prevSame = temp1;
					}
					tickCounter++;
					
					tickCounter++;
					System.out.println(half+different+1);
					int temp3 = in.nextInt();
					if (prevDiff == -1) {
						prevDiff = temp3;
					}
					tickCounter++;
					
					boolean samesame = (temp1 == prevSame);
					boolean diffdiff = (temp3 == prevDiff);
					if (!diffdiff && samesame) {
						for (int j = 0; j < half; j++) {
							int temp = array[j];
							array[j] = array[bit-j];
							array[bit-j] = temp;
						}
					} else if (!diffdiff && !samesame) {
						for (int j = 0; j < bit; j++) {
							array[j] = (array[j] - 1) % 2;
						}
					} else if (diffdiff && !samesame) {
						for (int j = 0; j < half; j++) {
							int temp = array[j];
							array[j] = array[bit-j-1];
							array[bit-j] = temp;
						}
						for (int j = 0; j < bit; j++) {
							array[j] = (array[j] - 1) % 2;
						}
					}
				}
				System.out.println(lol + 1);
				array[lol] = in.nextInt();
			}
			
			String test = "";
			for (int j = 0; j < bit; j++) {
				test = test + array[j];
			}
			System.out.println(test);
			String x = in.next();
			if (x.equals("N")) {
				return;
			}
		}
	}
}