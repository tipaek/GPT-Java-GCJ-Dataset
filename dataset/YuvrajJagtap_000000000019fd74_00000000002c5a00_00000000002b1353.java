import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int numberOfTestCases = Integer.parseInt(s);
		Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
		int size;
		for (int i = 0; i < numberOfTestCases; i++) {
			size = Integer.parseInt(in.nextLine());
			elements.put(i, size);
		}
		for (Integer key : elements.keySet()) {
			findPath(key, elements.get(key));
		}
	}
	
	public static void findPath(Integer key, Integer total) {
		System.out.println("Case #" + (key+1) + ":");
		int remainder = total;
		int pascVal;
		int i =1;
		int j = 1;
		boolean comingBack = false;
		while (remainder != 0) {
			pascVal = getPascalValue(i, j);
			if (pascVal <= remainder ) {
				System.out.println(i + " " + (j));
				remainder = remainder - pascVal;
				if (remainder == 0)
						return;
					if (comingBack == false) {
						if (remainder < getPascalValue(i+1, j + i%2)) {
							comingBack=true;
							j--;
						} else {
							j= j + (i%2);
							i++;
						}
					} else {
						//i--;
						if(j < 2) {
							i--;
						} else {
							j--;
						}
					}
					//i++;
				
				
				
			} else if (pascVal > remainder ) {
				comingBack = true;
				if (j != 0) {
					i--;
					j = j - (i%2);
				} else {
					i--;
				}
			}
			
		}
		
			
		
	}
	
	public static int getPascalValue(int i, int j) {
		if (j == 1) {
	           return 1;
	       } else if (j == i) {
	           return 1;
	       } else {
	           return getPascalValue(i - 1, j - 1) + getPascalValue(i - 1, j);
	       }
		
	}

}
