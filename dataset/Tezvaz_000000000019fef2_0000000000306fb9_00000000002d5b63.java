import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	static int firstX;
	static int firstY;
	
	static int bottomX;
	static int bottomY;
	
	static int topX;
	static int topY;
	
	static int leftX;
	static int leftY;
	
	static int rightX;
	static int rightY;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		int totalTestCases = Integer.parseInt(firstLine.split(" ")[0]);
		int A = Integer.parseInt(firstLine.split(" ")[1]);
		int B = Integer.parseInt(firstLine.split(" ")[2]);

		for(int i = 0; i < totalTestCases; i++) {
			
			int result = findFirstHit("0 0", in);
			
			if(result == 1) {
				continue;
			} else if (result == 0) {
				firstX = 0;
				firstY = 0;
				if(findAllEnds(in) == 1) continue;
			} else if (result == -1) {
				result = findFirstHit("500000 500000", in);
				
				if(result == 1) {
					continue;
				} else if (result == 0) {
					firstX = 500000;
					firstY = 500000;
					if(findAllEnds(in) == 1) continue;
				} else if (result == -1) {
					result = findFirstHit("-500000 500000", in);
					
					if(result == 1) {
						continue;
					} else if (result == 0) {
						firstX = -500000;
						firstY = 500000;
						if(findAllEnds(in) == 1) continue;
					} else if (result == -1) {
						result = findFirstHit("-500000 -500000", in);
						
						if(result == 1) {
							continue;
						} else if (result == 0) {
							firstX = -500000;
							firstY = -500000;
							if(findAllEnds(in) == 1) continue;
						} else if (result == -1) {
							result = findFirstHit("500000 -500000", in);
							
							if(result == 1) {
								continue;
							} else if (result == 0) {
								firstX = 500000;
								firstY = -500000;
								if(findAllEnds(in) == 1) continue;
							}
						}
					}
				}
				
			}
			
			findCenter(in);
		}
		
		in.close();
	}
	
	public static int findFirstHit(String triedValue, Scanner in) {
		
		System.out.println(triedValue);
		
		String nextLine = in.nextLine();
		
		if(nextLine.equals("CENTER")) {
			return 1;
		} else if (nextLine.equals("HIT")) {
			
			return 0;
		} else if (nextLine.equals("MISS")) {
			return -1;
		}
		
		return -1;
	}
	
	public static int findAllEnds(Scanner in) {
		
		//go right
		System.out.println("1000000000 " + firstY);
		String result = in.nextLine();
		
		if(result.equals("CENTER")) {
			return 1;
		} else if(result.equals("HIT")) {
			rightX = 1000000000;
			rightY = firstY;
		} else {
			
			int start = firstX;
			int end = 1000000000;
			
			while(true) {
				System.out.println((start + end)/2 + " " + firstY);
				result = in.nextLine();
				
				if(result.equals("CENTER")) {
					return 1;
				} else if(result.equals("HIT")) {
					start = (start + end)/2;
				} else {
					end = (start + end)/2;
				}
				
				if(end - start == 1) {
					rightX = start;
					rightY = firstY;
					break;
				}
			}
		}
		
		//go left
		System.out.println("-1000000000 " + firstY);
		result = in.nextLine();
		
		if (result.equals("CENTER")) {
			return 1;
		} else if(result.equals("HIT")) {
			leftX = -1000000000;
			leftY = firstY;
		} else {
			
			int start = firstX;
			int end = -1000000000;
			
			while(true) {
				System.out.println((start + end)/2 + " " + firstY);
				result = in.nextLine();
				
				if(result.equals("CENTER")) {
					return 1;
				} else if(result.equals("HIT")) {
					start = (start + end)/2;
				} else {
					end = (start + end)/2;
				}
				
				if(end - start == -1) {
					leftX = start;
					leftY = firstY;
					break;
				}
			}
		}
		
		//go top
		System.out.println(firstX + " 1000000000");
		result = in.nextLine();
		
		if(result.equals("CENTER")) {
			return 1;
		} else if(result.equals("HIT")) {
			topX = firstX;
			topY = 1000000000;
		} else {
			
			int start = firstY;
			int end = 1000000000;
			
			while(true) {
				System.out.println(firstX + " " + (start + end)/2);
				result = in.nextLine();
				
				if(result.equals("CENTER")) {
					return 1;
				} if(result.equals("HIT")) {
					start = (start + end)/2;
				} else {
					end = (start + end)/2;
				}
				
				if(end - start == 1) {
					topX = firstX;
					topY = start;
					break;
				}
			}
		}
		
		//go bottom
		System.out.println(firstX + " -1000000000");
		result = in.nextLine();
		
		if(result.equals("CENTER")) {
			return 1;
		} if(result.equals("HIT")) {
			bottomX = firstX;
			bottomY = -1000000000;
		} else {
			
			int start = firstY;
			int end = -1000000000;
			
			while(true) {
				System.out.println(firstX + " " + (start + end)/2);
				result = in.nextLine();
				
				if(result.equals("CENTER")) {
					return 1;
				} if(result.equals("HIT")) {
					start = (start + end)/2;
				} else {
					end = (start + end)/2;
				}
				
				if(end - start == -1) {
					bottomX = firstX;
					bottomY = start;
					break;
				}
			}
		}
		
		return 0;
	}
	
	public static int findMax(int coordinate) {
		return 1000000000 - coordinate;
	}
	
	public static int findMin(int coordinate) {
		return 1000000000 + coordinate;
	}
	
	public static void findCenter(Scanner in) {
		BigInteger bottomX_1 = BigInteger.valueOf(bottomX);
		BigInteger bottomY_1 = BigInteger.valueOf(bottomY);
		
		BigInteger topX_1 = BigInteger.valueOf(topX);
		BigInteger topY_1 = BigInteger.valueOf(topY);
		
		BigInteger leftX_1 = BigInteger.valueOf(leftX);
		BigInteger leftY_1 = BigInteger.valueOf(leftY);
		
		BigInteger rightX_1 = BigInteger.valueOf(rightX);
		BigInteger rightY_1 = BigInteger.valueOf(rightY);
		BigInteger two = BigInteger.valueOf(2);;
		
		BigInteger D = two.multiply(( topX_1.multiply((bottomY_1.subtract(rightY_1))).add(bottomX_1.multiply((rightY_1.subtract(topY_1)))).add(rightX_1.multiply((topY_1.subtract(bottomY_1))))));
		BigInteger RX = topX_1.multiply(topX_1).add(topY_1.multiply(topY_1)).multiply(bottomY_1.min(rightY_1)).add(bottomX_1.multiply(bottomX_1).add(bottomY_1.multiply(bottomY_1)).multiply(rightY_1.min(topY_1))).add(rightX_1.multiply(rightX_1).add(rightY_1.multiply(rightY_1)).multiply(topY_1.min(rightY_1))).divide(D);
		BigInteger RY = topX_1.multiply(topX_1).add(topY_1.multiply(topY_1)).multiply(rightX_1.min(bottomX_1)).add(bottomX_1.multiply(bottomX_1).add(bottomY_1.multiply(bottomY_1)).multiply(topX_1.min(rightX_1))).add(rightX_1.multiply(rightX_1).add(rightY_1.multiply(rightY_1)).multiply(rightX_1.min(topX_1))).divide(D);;
		
		System.out.println(RX.intValue() + " " + RY.intValue());
	}
}
