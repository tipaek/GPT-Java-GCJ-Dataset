import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int totalCase = scan.nextInt();
		for(int i=0; i<totalCase; i++) {
			int first = scan.nextInt();
			int second = scan.nextInt();
			Map<Integer, Integer> firstNumberSet = setCombination(first);
			Map<Integer, Integer> firstOptionalSet;
			if(first==0) {
				firstOptionalSet = new HashMap<Integer, Integer>();
			}
			else if(first<0) {
				firstOptionalSet = getNegativeSet(setCombination(getRemainder(first*(-1))), getMaxPower(first*(-1)), true);
			}
			else {
				firstOptionalSet = getNegativeSet(setCombination(getRemainder(first)), getMaxPower(first), false);
			}
			
			Map<Integer, Integer> secondNumberSet = setCombination(second);
			Map<Integer, Integer> secondOptionalSet;
			if(second==0) {
				secondOptionalSet = new HashMap<Integer, Integer>();
			}
			else if(second<0) {
				secondOptionalSet = getNegativeSet(setCombination(getRemainder(second*(-1))), getMaxPower(second*(-1)), true);
			}
			else {
				secondOptionalSet = getNegativeSet(setCombination(getRemainder(second)), getMaxPower(second), false);
			}
			
			
			if(checkCombination(firstNumberSet, secondNumberSet)) {
				System.out.println("Case #" + (i+1) + ": " + getDecompose(firstNumberSet, secondNumberSet));
			}
			else if(firstOptionalSet.size()>secondOptionalSet.size()) {
				if(checkCombination(firstNumberSet, secondOptionalSet)) {
					System.out.println("Case #" + (i+1) + ": " + getDecompose(firstNumberSet, secondOptionalSet));
				}
				else if(checkCombination(firstOptionalSet, secondNumberSet)) {
					System.out.println("Case #" + (i+1) + ": " + getDecompose(firstOptionalSet, secondNumberSet));
				}
				else if(checkCombination(firstOptionalSet, secondOptionalSet)) {
					System.out.println("Case #" + (i+1) + ": " + getDecompose(firstOptionalSet, secondOptionalSet));
				}
				else {
					System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
				}
			}
			else {
				if(checkCombination(firstOptionalSet, secondNumberSet)) {
					System.out.println("Case #" + (i+1) + ": " + getDecompose(firstOptionalSet, secondNumberSet));
				}
				else if(checkCombination(firstNumberSet, secondOptionalSet)) {
					System.out.println("Case #" + (i+1) + ": " + getDecompose(firstNumberSet, secondOptionalSet));
				}
				else if(checkCombination(firstOptionalSet, secondOptionalSet)) {
					System.out.println("Case #" + (i+1) + ": " + getDecompose(firstOptionalSet, secondOptionalSet));
				}
				else {
					System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
				}
			}			
		}
	}
	
	private static Map<Integer, Integer> setCombination(int number){
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		if(number==0) {
			return numbers;
		}
		boolean negative = false;
		if(number<0) {
			negative = true;
			number *= -1;
		}
		
		int index = 0;
		while(number>0) {
			if(number%2==1) {
				if(negative) {
					numbers.put(index, -1);
				}
				else {
					numbers.put(index, 1);
				}
			}
			
			number/=2;
			index++;
		}
		
		return numbers;
	}
	
	private static Map<Integer, Integer> getNegativeSet(Map<Integer, Integer> map, int number, boolean negative){
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			map.put(entry.getKey(), entry.getValue() * (-1));
		}
		
		map.put(number, 1);
		
		if(negative) {
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				map.put(entry.getKey(), entry.getValue() * (-1));
			}
		}
		
		
		return map;
	}
	
	private static int getRemainder(int number) {
		int twoPower = 1;
		while(twoPower<=number) {
			twoPower*=2;
		}
		
		return twoPower - number;
	}
	
	private static int getMaxPower(int number) {
		int twoPower = 1;
		int result = 0;
		while(twoPower<=number) {
			twoPower*=2;
			result++;
		}
		
		return result;
	}
	
	private static boolean checkCombination(Map<Integer, Integer> first, Map<Integer, Integer> second) {
		int max = 0;
		for(Map.Entry<Integer, Integer> entry : first.entrySet()) {
			max = Math.max(max, entry.getKey());
		}
		
		for(Map.Entry<Integer, Integer> entry : second.entrySet()) {
			max = Math.max(max, entry.getKey());
		}
		
		
		for(int i=0; i<=max; i++) {
			if(!(first.containsKey(i)^second.containsKey(i))) {
				return false;
			}
		}
		
		return true;
	}

	
	private static String getDecompose(Map<Integer, Integer> first, Map<Integer, Integer> second) {
		StringBuilder result = new StringBuilder();
		int max = 0;
		for(Map.Entry<Integer, Integer> entry : first.entrySet()) {
			max = Math.max(max, entry.getKey());
		}
		
		for(Map.Entry<Integer, Integer> entry : second.entrySet()) {
			max = Math.max(max, entry.getKey());
		}
		
		for(int i=0; i<=max; i++) {
			if(first.containsKey(i)) {
				if(first.get(i)==1) {
					result.append("E");
				}
				else {
					result.append("W");
				}
			}
			else {
				if(second.get(i)==1) {
					result.append("N");
				}
				else {
					result.append("S");
				}
			}
		}
		
		return result.toString();
	}
}