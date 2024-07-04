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
		for (int casNumero = 1; casNumero <= T; casNumero++) {
			StringBuilder resultat = new StringBuilder();
			resultat.append("Case #");
			resultat.append(casNumero);
			resultat.append(": ");
			boolean impossible = false;
			int n = in.nextInt();
			List<String> word = new ArrayList<>();	
			String start = "";
			String ending = "";
			int lastWord = 0;
			for (int i = 0; i < n; i++) {
				String pattern = in.next();
				String[] parts = pattern.split("\\*");		
				for (int j = 0; j < parts.length; j++) {
					if (!parts[j].isEmpty() && !impossible) {
						if (j == 0) {
							if (parts[j].contains(start)) {
								start = parts[j];
							}
							else if (!start.contains(parts[j])) {
								impossible = true;
								break;
							}
						}	
						else if (j == parts.length - 1) {
							if (parts[j].contains(ending)) {
								ending = parts[j];
							}
							else if (!ending.contains(parts[j])) {
								impossible = true;
								break;
							}
						}	
						else if (word.isEmpty()){
							word.add(parts[j]);
						}
						else {
							if (lastWord + 1 < word.size()) {
								boolean introduced = false;
								for (int k = lastWord + 1; k < word.size(); k++) {
									if (word.get(k).contains(parts[j])) {
										lastWord = k;
										introduced = true;
										break;
									}
									else if (parts[j].contains(word.get(k))) {
										word.set(k, parts[j]);
										lastWord = k;
										introduced = true;
										break;
									}
								}
								if (!introduced) {
									word.add(parts[j]);
									lastWord = word.size() - 1;
								}
							}
							else {
								word.add(parts[j]);
								lastWord++;
							}
						}
					}	
				}	
			}
			
			if (impossible) {
				resultat.append("*");
			}
			else {
				resultat.append(start);
				for (String string : word) {
					resultat.append(string);
				}
				resultat.append(ending);
			}
			
			writer.print(resultat.toString());
			writer.println();
		}
		in.close();
		writer.close();
	}	
}
