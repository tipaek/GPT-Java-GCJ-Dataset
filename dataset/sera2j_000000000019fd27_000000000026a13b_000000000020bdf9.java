import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		
		
        
		Scanner console = new Scanner(System.in);
		int numberOfMatrixes = console.nextInt();
		
		String[] results = new String[numberOfMatrixes];
		
		for(int i = 0; i < numberOfMatrixes; i++) {
			
			List<List<Integer>> C = new ArrayList<>();
			List<List<Integer>> J = new ArrayList<>();
			
			String result = "";
			boolean impossible = false;
			
			int numberOfPeriods = console.nextInt();
			
			for(int j = 0; j < numberOfPeriods; j++) {
				int startingPeriod = console.nextInt();
				int endingPeriod = console.nextInt();
				
				List<Integer> entry = new ArrayList<Integer>();
				entry.add(startingPeriod);
				entry.add(endingPeriod);
				
				if(!impossible) {
					boolean cCanTakeIt = true, jCanTakeIt = true;
					
					//check if C can take it
					Iterator<List<Integer>> cIterator = C.iterator();
					while (cIterator.hasNext()) {
						List<Integer> oldEntry = cIterator.next();
						//check if they overlap
						if(Math.max(entry.get(0), oldEntry.get(0)) < Math.min(entry.get(1), oldEntry.get(1))){							
							cCanTakeIt = false;
							break;
						}
					}
					
					//check if J can take it
					if(!cCanTakeIt) {
						Iterator<List<Integer>> jIterator = J.iterator();
						while (jIterator.hasNext()) {
							List<Integer> oldEntry = jIterator.next();
							//check if they overlap
							if(Math.max(entry.get(0), oldEntry.get(0)) < Math.min(entry.get(1), oldEntry.get(1))){	
								jCanTakeIt = false;
								impossible = true;
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
						impossible = true;
					}
				}
			}
			results[i] = result;
		}
		
		for(int i = 0; i < results.length; i++) {
			System.out.println("Case #" + ((int)(i+1))+ ": " + results[i]);
		}
		
	}
}
