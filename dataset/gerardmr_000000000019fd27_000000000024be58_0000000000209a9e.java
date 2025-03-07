import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
			StringBuilder bits = new StringBuilder();
			
			for (int i = 0; i < 150; i++) {
				if (query % 10 != 1 && position < B) {
					writer.print(position + 1);
					writer.println();
					writer.flush();
					bits.append(in.nextInt());
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
			writer.print(bits.toString());
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
