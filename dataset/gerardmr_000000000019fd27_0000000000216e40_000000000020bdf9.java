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
			
			int n = in.nextInt();
			List<Integer> jstarts = new ArrayList<Integer>();
			List<Integer> jends = new ArrayList<Integer>();
			List<Integer> cstarts = new ArrayList<Integer>();
			List<Integer> cends = new ArrayList<Integer>();
			StringBuilder schedule = new StringBuilder();
			boolean impossible = false;
			
			for (int i = 0; i < n; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				
				boolean jamie = false;
				for (int j = 0; j < jstarts.size(); j++) {
					if (impossible) {
						break;
					}
					else if ((jstarts.get(j).intValue() < end && jstarts.get(j).intValue() > start) 
							|| (jends.get(j).intValue() < end && jends.get(j).intValue() > start)
							|| (jstarts.get(j).intValue() < start && jends.get(j).intValue() > end)) {
						jamie = true;
						break;
					}
				}
				
				if (jamie) {
					boolean cameron = false;
					for (int j = 0; j < cstarts.size(); j++) {
						if ((cstarts.get(j).intValue() < end && cstarts.get(j).intValue() > start) 
								|| (cends.get(j).intValue() < end && cends.get(j).intValue() > start)
								|| (cstarts.get(j).intValue() < start && cends.get(j).intValue() > end)) {
							cameron = true;
							break;
						}
					}
					if (!cameron) {
						schedule.append("C");
						cstarts.add(start);
						cends.add(end);
					}
					else {
						impossible = true;
					}
				}
				else {
					schedule.append("J");
					jstarts.add(start);
					jends.add(end);
				}	
			}
			
			if (impossible) {
				resultat.append("IMPOSSIBLE");
			}
			else {
				resultat.append(schedule.toString());
			}
			
			writer.print(resultat.toString());
			writer.println();
		}
		in.close();
		writer.close();
	}
}
