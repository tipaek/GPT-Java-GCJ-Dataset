import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		for (int q = 1; q <= test_cases; q++) {
			System.out.println("Case #" + q + ": ");
			int n = in.nextInt();
			int curr_sum = 1,  val = 1;
			System.out.println(1+" "+1);
			int i = 2,j = 1;
			while(val +curr_sum <= n) {
				curr_sum += val;
				System.out.println(i+" "+j);
				j++;
				val++;
			}
			int left = n - curr_sum;
			i--;
			for(int x = 0; x < left; x++) {
				System.out.println(i+" "+(j+x));
			}
		}

	}

}