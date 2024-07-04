import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution{

	public static void main(String args[]) {
		
		Scanner console = new Scanner(System.in);
		int numberOfMatrixes = console.nextInt();
		
		String[] results = new String[numberOfMatrixes];
		for(int i = 0; i < numberOfMatrixes; i++) {
			List<Entry<Integer,Integer>> C = new ArrayList<>();
			List<Entry<Integer,Integer>> J = new ArrayList<>();
			int numberOfPeriods = console.nextInt();
			String result = "";
			for(int j = 0; j < numberOfPeriods; j++) {
				int startingPeriod = console.nextInt();
				int endingPeriod = console.nextInt();
				Entry<Integer, Integer> entry = Map.entry(startingPeriod, endingPeriod);
				
				boolean cCanTakeIt = true, jCanTakeIt = true;
				
				//check if C can take it
				Iterator<Entry<Integer, Integer>> cIterator = C.iterator();
				while (cIterator.hasNext()) {
					Entry<Integer, Integer> oldEntry = cIterator.next();
					//check if they overlap
					if(entry.getKey() < oldEntry.getValue() && entry.getValue() > oldEntry.getKey()) {
						cCanTakeIt = false;
						break;
					}
				}
				
				//check if J can take it
				if(!cCanTakeIt) {
					Iterator<Entry<Integer, Integer>> jIterator = J.iterator();
					while (jIterator.hasNext()) {
						Entry<Integer, Integer> oldEntry = jIterator.next();
						if(entry.getKey() < oldEntry.getValue() && entry.getValue() > oldEntry.getKey()) {
							jCanTakeIt = false;
							break;
						}
					}
				}
				
				if(cCanTakeIt) {
					result+="C";
					C.add(entry);
				}else if(jCanTakeIt) {
					result+="J";
					J.add(entry);
				}else {
					result = "IMPOSSIBLE";
					break;
				}
			}
			results[i] = result;
		}
		
		for(int i = 0; i < results.length; i++) {
			System.out.println("Case #" + ((int)(i+1))+ ": " + results[i]);
		}
		
	}
}
