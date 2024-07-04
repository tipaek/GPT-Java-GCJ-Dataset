import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CJ1 {
	public static void main(String args[]) {
	
		Scanner input = new Scanner(System.in);
		int numt = input.nextInt();
		for (int i = 0; i < numt; i++) {
			int side = input.nextInt(), trace = 0, totc = 0, totr = 0;
			Integer rowarr[][] = new Integer[side][side], colarr[][] = new Integer[side][side];
			for (int r = 0; r < side; r++) {
				for (int c = 0; c < side; c++) {
					int tmp = input.nextInt();
					rowarr[r][c]=tmp;
					colarr[c][r]=tmp;
					if (r == c) {
						trace += tmp;
					}}}
			for (Integer a[] : rowarr) {
				if (checkForDuplicates(a)) {
					totc++;
				}}
			for (Integer a[] : colarr) {
				if (checkForDuplicates(a)) {
					totr++;
				}}
			System.out.println("Case #" + (i + 1) + ":" + " " + trace + " " + totc + " " + totr);
		}}
	private static boolean checkForDuplicates(Integer[] array)
	{
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(array));
		return array.length != set.size();
	}
}
