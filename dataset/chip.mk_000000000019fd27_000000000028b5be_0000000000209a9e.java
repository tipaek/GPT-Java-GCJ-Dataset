import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		try (
			//BufferedReader ibr = new BufferedReader(new FileReader("D:/codejam_in.txt"));
			BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(ibr)
			)
		{
			sc.useLocale(new Locale("US"));
			int parT = sc.nextInt();
			int B = sc.nextInt();
			
			for (int t = 1; t <= parT; t++) {
				StringBuilder sb = new StringBuilder();

				if (B == 10) {
					for (int i = 1; i <= B; i++) {
						System.out.println(i);
						System.out.flush();
						int bit = sc.nextInt();
						sb.append(bit);
					} 
					
				} else if (B == 20) {
					boolean[] xrt = new boolean[10];
					for (int i = 0; i < 10; i++) {
						System.out.println(i + 1);
						System.out.flush();
						int bitL = sc.nextInt();
						System.out.println(20 - i);
						System.out.flush();
						int bitR = sc.nextInt();
						xrt[i] = bitL != bitR;
					}
					int[] output = new int[20];
					for (int i = 0; i < 10; i++) {
						System.out.println(i + 1);
						System.out.flush();
						int bitL = sc.nextInt();
						output[i] = bitL;
						
						output[20 - i - 1] = (xrt[i] ? 1 - bitL : bitL);
					} 
					
					for (int j : output) sb.append(j);
					
				} else {
					break;
				}
				
				System.out.println(sb.toString());
				System.out.flush();
				if (!sc.next().equalsIgnoreCase("Y")) break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
