import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Solution {
    
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
        //  Scanner console = new Scanner(System.in);
		int numberOfMatrixes = in.nextInt();
		String[] results = new String[numberOfMatrixes];
		for(int i = 0; i < numberOfMatrixes; i++) {
			List<ArrayList<Integer>> cc = new ArrayList<>();
			List<ArrayList<Integer>> jj = new ArrayList<>();
			String result = "";
			boolean impossible = false;
			int numberOfPeriods = in.nextInt();
			
			for(int j = 0; j < numberOfPeriods; j++) {
				int startingPeriod = in.nextInt();
				int endingPeriod = in.nextInt();
				ArrayList<Integer> entry = new ArrayList<Integer>();
				entry.add(startingPeriod);
				entry.add(endingPeriod);
				
				if(!impossible) {
					boolean cCanTakeIt = true, jCanTakeIt = true;
					//check if C can take it
					Iterator<ArrayList<Integer>> cIterator = cc.iterator();
					
					while (cIterator.hasNext()) {
						List<Integer> oldEntry1 = cIterator.next();
						//check if they overlap
						if(Math.max(entry.get(0), oldEntry1.get(0)) < Math.min(entry.get(1), oldEntry1.get(1))){							
							cCanTakeIt = false;
							break;
						}
					}
					//   check if J can take it
					if(!cCanTakeIt) {
						Iterator<ArrayList<Integer>> jIterator = jj.iterator();
						
						while (jIterator.hasNext()) {
							List<Integer> oldEntry2 = jIterator.next();
							//  check if j & c  has an overlap
							
							if(Math.max(entry.get(0), oldEntry2.get(0)) < Math.min(entry.get(1), oldEntry2.get(1))){	
								jCanTakeIt = false;
								impossible = true;
								break;
							}
						} 
					}
					
					if(cCanTakeIt) {
						result+="C";
						cc.add(entry);
						jCanTakeIt = false;
					}else if(jCanTakeIt) {
						result+="J";
						jj.add(entry);
					}else {
						result = "IMPOSSIBLE";
					}
				}
			}
			results[i] = result;
		}
		for(int x = 0; x < results.length; x++) {
			System.out.println("Case #" + ((int)(x+1)) + ": " + results[x]);
		}
	}
}
