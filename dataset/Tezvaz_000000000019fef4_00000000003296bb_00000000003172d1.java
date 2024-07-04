import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			String firstLine = in.nextLine();
			int N = Integer.parseInt(firstLine.split(" ")[0]);
			int D = Integer.parseInt(firstLine.split(" ")[1]);
			
			String[] slices = in.nextLine().split(" ");
			
			HashMap<BigInteger, Integer> freq = new HashMap<BigInteger, Integer>();
			
			for(int j = 0; j < slices.length; j++) {
				
				BigInteger sliceSize = new BigInteger(slices[j]);
				
				if(freq.containsKey(sliceSize)) {
					freq.put(sliceSize, freq.get(sliceSize) + 1);
				} else {
					freq.put(sliceSize, 1);
				}
			}
			
			boolean solutionFound = false;
			HashSet<BigInteger> twos = new HashSet<BigInteger>();
			
			for (BigInteger curr : freq.keySet()) {
				
				if(freq.get(curr) >= D) {
					System.out.println("Case #" + (i+1) + ": 0");
					solutionFound = true;
					break;
				}
				
				if(freq.get(curr) >= D - 2) {
					twos.add(curr);
				}
			}
			
			if(solutionFound) {
				continue;
			}
			
			//get all 2s
			for(int j = 0; j < slices.length; j++) {
				
				for(BigInteger twoSlice : twos) {
						
					if(!slices[j].equals(twoSlice.toString())) {
						break;
					}	
					
					BigInteger sliceSizeASBI = new BigInteger(slices[j]);
					BigInteger zero = new BigInteger("0");
					BigInteger two = new BigInteger("2");
					
					if(sliceSizeASBI.compareTo(twoSlice) > 0 && sliceSizeASBI.remainder(twoSlice).compareTo(zero) == 0 && sliceSizeASBI.divide(twoSlice).compareTo(two) == 0) {
						System.out.println("Case #" + (i+1) + ": " + (D-2));
					}
				}
				
				
			}
			
			System.out.println("Case #" + (i+1) + ": " + (D-1));
		}
		
		in.close();
	}
}
