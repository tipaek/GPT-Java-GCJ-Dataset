import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int T = in.nextInt();	
		int B = in.nextInt();		
		for (int casNumero = 1; casNumero <= T; casNumero++) {	
			int position = 1;
			List<Integer> posicionsIguals = new ArrayList<Integer>();
			List<Integer> posicionsDiferents = new ArrayList<Integer>();			
			int[] bits = new int[B];
			boolean initial = false;
			for (int i = 1; i <= 150; i++) {
				if (position > ((int)B / 2)) {
					break;
				}
				if (i % 10 == 1 && posicionsIguals.size() > 0) {
					writer.print(posicionsIguals.get(0) + 1);
					writer.println();
					writer.flush();
					int newValue = in.nextInt();
					if (newValue != bits[posicionsIguals.get(0)]) {
						for (int j = 0; j < posicionsIguals.size(); j++) {
							if (bits[posicionsIguals.get(j)] == 1) {
								bits[posicionsIguals.get(j)] = 0;
								bits[B - posicionsIguals.get(j)] = 0;
							}
							else {
								bits[posicionsIguals.get(j)] = 1;
								bits[B - posicionsIguals.get(j)] = 1;
							}
						}
					}
				}
				else if ((i % 10 == 1 && posicionsDiferents.size() > 0) 
						|| (i % 10 == 2 && posicionsIguals.size() > 0 && posicionsDiferents.size() > 0)) {
					writer.print(posicionsDiferents.get(0) + 1);
					writer.println();
					writer.flush();
					int newValue = in.nextInt();
					if (newValue != bits[posicionsDiferents.get(0)]) {
						for (int j = 0; j < posicionsDiferents.size(); j++) {
							if (bits[posicionsDiferents.get(j)] == 1) {
								bits[posicionsDiferents.get(j)] = 0;
								bits[B - posicionsDiferents.get(j)] = 1;
							}
							else {
								bits[posicionsDiferents.get(j)] = 1;
								bits[B - posicionsDiferents.get(j)] = 0;
							}
						}
					}
				}
				else if (initial) {
					writer.print(B + 1 - position);
					writer.println();
					writer.flush();
					bits[B - position] = in.nextInt();
					if (bits[B - position] == bits[position - 1]) {
						posicionsIguals.add(position - 1);
					}
					else {
						posicionsDiferents.add(position - 1);
					}
					position++;
					initial = false;
				}
				else {
					writer.print(position);
					writer.println();
					writer.flush();
					bits[position - 1] = in.nextInt();
					initial = true;
				}				
				
			}
			
			StringBuilder result = new StringBuilder();
			for (int j = 0; j < bits.length; j++) {
				result.append(bits[j]);
			}
			
			writer.print(result.toString());
			writer.println();
			writer.flush();
			if (in.next().equals("N")) {
				return;
			}				
		}
		in.close();
		writer.close();
	}	
}
