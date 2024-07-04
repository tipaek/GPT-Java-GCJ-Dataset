import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberTest = in.nextInt();
		int bit = in.nextInt();
		for (int i = 0; i < numberTest; i++) {
			int[] array = new int[bit];
			for (int j = 0; j < bit; j++) {
				System.out.println(j + 1);
				array[j] = in.nextInt();
			}
			String test = "";
			for (int j = 0; j < bit; j++) {
				test = test + array[j];
			}
			System.out.println(test);
		}
	}
}