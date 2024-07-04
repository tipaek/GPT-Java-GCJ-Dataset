import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int T = in.nextInt();	
		int B = in.nextInt();
		for (int casNumero = 1; casNumero <= T; casNumero++) {			
			int query = 1;
			int position = 0;
			int[] bits = new int[B];
			
			for (int i = 0; i < 150; i++) {
				if (query % 10 != 1 && position < B) {
					writer.print(position + 1);
					writer.println();
					writer.flush();
					bits[position] = in.nextInt();
					position++;
				}
				else {
					writer.print(1);
					writer.println();
					writer.flush();
					in.nextInt();
				}
				query++;
			}
			writer.print(Arrays.toString(bits));
			writer.println();
			writer.flush();
			if (in.next().equals("-1")) {
				return;
			}				
		}
		in.close();
		writer.close();
	}	
}
