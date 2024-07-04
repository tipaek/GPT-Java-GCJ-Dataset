import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

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
			int d = in.nextInt();
			
			Map<BigInteger, Integer> slices = new HashMap<>();
			for (int i = 0; i < n; i++) {
				BigInteger slice = in.nextBigInteger();
				if (slices.containsKey(slice)) {
					slices.put(slice, slices.get(slice) + 1);
				}
				else {
					slices.put(slice, 1);
				}
			}
			
			int count = 0;
			int maxValue = slices.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
			if (maxValue < d) {
				for (Entry<BigInteger, Integer> entry : slices.entrySet()) {
					int slicesCount = entry.getValue();
					int possibleCount = 0;
					Integer multiplicador = 2;
					while (slicesCount < d && multiplicador <= d - entry.getValue()) {
						BigInteger value = entry.getKey().multiply(new BigInteger(multiplicador.toString()));
						if (slices.containsKey(value)) {
							if (d - slicesCount > slices.get(value) * multiplicador) {
								possibleCount += slices.get(value) * (multiplicador - 1);
								slicesCount += slices.get(value) * multiplicador;
							}
							else {
								int left = d - slicesCount;
								int units = left / multiplicador;
								possibleCount += units * (multiplicador - 1) + (left - units * multiplicador);
								slicesCount = d;
								break;
							}
						}
						multiplicador++;
					}
					
					if (slicesCount == d && (count == 0 || count > possibleCount)) {
						count = possibleCount;
					}					
				}
				
				for (Entry<BigInteger, Integer> entry : slices.entrySet()) {
					int slicesCount = entry.getValue();
					int possibleCount = 0;
					List<Entry<BigInteger, Integer>> biggerSlices = slices.entrySet().stream().filter(s -> s.getKey().compareTo(entry.getKey()) > 0).collect(Collectors.toList());
					for (Entry<BigInteger, Integer> slice : biggerSlices) {
						BigInteger pices = slice.getKey().divide(entry.getKey()).multiply(new BigInteger(new Integer(entry.getValue()).toString()));
						if (pices.compareTo(new BigInteger(new Integer(d - slicesCount).toString())) >= 0) {
							possibleCount += d - slicesCount;
							slicesCount = d;
							break;
						}
						else {
							slicesCount += pices.intValue();
							possibleCount += pices.intValue();
						}
					}
					
					if (slicesCount == d && (count == 0 || count > possibleCount)) {
						count = possibleCount;
					}					
				}	
				
				if (count == 0) {
					count = d - 1;
				}
			}
			
			resultat.append(count);
			writer.print(resultat.toString());
			writer.println();			
		}
		in.close();
		writer.close();
	}	
	
}
