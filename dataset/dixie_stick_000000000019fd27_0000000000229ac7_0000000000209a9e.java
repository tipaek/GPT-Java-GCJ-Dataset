import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
	
	public static Scanner in;
	public static int numGuesses;
	public static int[] arr;
	public static int[] typeOf;
	public static int[] indices;
	
	// e = identity
	// a = complement
	// b = reverse
	// c = ab = complement + reverse
	
	public static void main2(String[] args) {
		in = new Scanner(System.in);
		String g = "11001000101110110100";
		arr = new int[g.length()];
		typeOf = new int[g.length()];
		indices = new int[4];
		for(int i = 0; i < g.length(); i++) {
			arr[i] = g.charAt(i) - '0';
		}
		
		map("c");
		System.out.println("Arr = " + Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int T = in.nextInt();
		int B = in.nextInt();
		
		HashMap<Pair, String> map = new HashMap<>();
		map.put(new Pair(0, 0), "eb");
		map.put(new Pair(0, 3), "ac");
		map.put(new Pair(1, 1), "ec");
		map.put(new Pair(1, 2), "ab");
		map.put(new Pair(2, 1), "ab");
		map.put(new Pair(2, 2), "ec");
		map.put(new Pair(3, 0), "ac");
		map.put(new Pair(3, 3), "eb");
		
		// example: if 11 (3) transform to 00 (0) (new Pair(3,0),
		// then either we applied transformation a (complement)
		// or we applied transformation c (complement + reverse)
		
		for(int t = 0; t < T; t++) {
			numGuesses = 0;
			arr = new int[B];
			Arrays.fill(arr, -1);
			
			typeOf = new int[B];
			Arrays.fill(typeOf, -1);
			
			indices = new int[4];
			Arrays.fill(indices, -1);
			
			int unknownIndex = 0;
			
			for(int z = 0; z < 15; z++) {
				if(getKnownTypes().size() == 0) {
					
					if(unknownIndex >= B/2) {
						// know all types!
						break;
					}
					
					//System.out.println("PART A");
					
					for(int i = 0; i < 5; i++) {
						int bit = query(unknownIndex+1);
						int otherSide = query(B-unknownIndex);
						
						arr[unknownIndex] = bit;
						arr[B - unknownIndex - 1] = otherSide;
						
						int bitmask = 2 * bit + otherSide;
						typeOf[unknownIndex] = bitmask;
						typeOf[B - unknownIndex - 1] = bitmask;
						if(indices[bitmask] == -1) {
							indices[bitmask] = i;
						}
						
						unknownIndex++;
						
						
					}
					
					if(unknownIndex >= B/2) {
						// know all types!
						break;
					}
					
				}
				else if(getKnownTypes().size() == 1) {
					
					//System.out.println("PART B");
					
					int knownType = getKnownTypes().get(0);
					int indexOfKnownType = indices[knownType];
					
					int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
					int bit = query(indexOfKnownType + 1);
					int otherSide = query(B - indexOfKnownType);
					
					int newType = 2 * bit + otherSide;
					
					String currentTransformations = map.get(new Pair(originalType, newType));
					String firstTransformations = currentTransformations.substring(0, 1);
					
					//System.out.println("gonna map transformation " + firstTransformations);
					//System.out.println("So from " + Arrays.toString(arr));
					map(firstTransformations);
					//System.out.println("to      " + Arrays.toString(arr));
					
					
					for(int i = 0; i < 4; i++) {
						if(unknownIndex >= B/2) {
							// know all types!
							break;
						}
						
						bit = query(unknownIndex + 1);
						otherSide = query(B - unknownIndex);
						
						arr[unknownIndex] = bit;
						arr[B - unknownIndex - 1] = otherSide;
						
						int bitmask = 2 * bit + otherSide;
						typeOf[unknownIndex] = bitmask;
						typeOf[B - unknownIndex - 1] = bitmask;
						if(indices[bitmask] == -1) {
							indices[bitmask] = i;
						}
						
						unknownIndex++;
						
					}
					
					if(unknownIndex >= B/2) {
						// know all types!
						break;
					}
					
				}
				else {
					// getKnownTypes 2
					
					//System.out.println("PART C");
					
					ArrayList<Integer> saved = getKnownTypes();
					
					int knownType = saved.get(0);
					int indexOfKnownType = indices[knownType];
					
					int originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
					int bit = query(indexOfKnownType + 1);
					int otherSide = query(B - indexOfKnownType);
					
					int newType = 2 * bit + otherSide;
					
					String currentTransformations = map.get(new Pair(originalType, newType));
					
					knownType = saved.get(1);
					indexOfKnownType = indices[knownType];
					
					originalType = 2 * arr[indexOfKnownType] + arr[B - 1 - indexOfKnownType];
					bit = query(indexOfKnownType + 1);
					otherSide = query(B - indexOfKnownType);
					
					newType = 2 * bit + otherSide;
					
					String otherTransformations = map.get(new Pair(originalType, newType));
					
					HashSet<Character> set1 = new HashSet<>();
					HashSet<Character> set2 = new HashSet<>();
					
					set1.add(currentTransformations.charAt(0));
					set1.add(currentTransformations.charAt(1));
					
					set2.add(otherTransformations.charAt(0));
					set2.add(otherTransformations.charAt(1));
					
					set1.retainAll(set2); // set1 is now intersection of the original 2 sets
					
					char firstTransformation = '?';
					for(char what : set1) {
						firstTransformation = what;
						break;
					}
					
					//System.out.println("map = " + firstTransformation);
					//System.out.println("So from " + Arrays.toString(arr));
					map("" + firstTransformation);
					//System.out.println("to      " + Arrays.toString(arr));
					
					for(int i = 0; i < 3; i++) {
						if(unknownIndex >= B/2) {
							// know all types!
							break;
						}
						
						bit = query(unknownIndex + 1);
						otherSide = query(B - unknownIndex);
						
						arr[unknownIndex] = bit;
						arr[B - unknownIndex - 1] = otherSide;
						
						int bitmask = 2 * bit + otherSide;
						typeOf[unknownIndex] = bitmask;
						typeOf[B - unknownIndex - 1] = bitmask;
						if(indices[bitmask] == -1) {
							indices[bitmask] = i;
						}
						
						unknownIndex++;
						
					}
					
					if(unknownIndex >= B/2) {
						// know all types!
						break;
					}
				}
			}
			
			boolean result = outputFinalArray();
			
			if(!result) {
				//System.out.println("bad!");
				return;
			}
			else {
				//System.out.println("good!");
			}
		}

	}
	
	public static void map(String transformation) {
		if(transformation.equals("e")) {
			
		}
		else if(transformation.equals("a")) {
			for(int i = 0; i < typeOf.length; i++) {
				if(arr[i] != -1) {
					arr[i] = 1 - arr[i];
					typeOf[i] = 3 - typeOf[i];
				}
			}
			
			int temp = indices[0];
			indices[0] = indices[3];
			indices[3] = temp;
			
			temp = indices[1];
			indices[1] = indices[2];
			indices[2] = temp;
		}
		else if(transformation.equals("b")) {
			for(int i = 0; i < typeOf.length/2; i++) {
				if(arr[i] != -1) {
					//System.out.println("bruh");
					int temp = arr[i];
					arr[i] = arr[typeOf.length - 1 - i];
					arr[typeOf.length - 1 - i] = temp;
					
					if(typeOf[i] == 1 || typeOf[i] == 2) {
						typeOf[i] = 3 - typeOf[i];
					}
				}
			}
			
			int temp = indices[1];
			indices[1] = indices[2];
			indices[2] = temp;
		}
		else {
			// transformations == "c": reverse + complement
			
			for(int i = 0; i <= typeOf.length/2; i++) {
				if(arr[i] != -1) {
					int temp1 = arr[i];
					int temp2 = arr[typeOf.length - 1 - i];
					
					arr[i] = 1 - temp2;
					arr[typeOf.length - 1 - i] = 1 - temp1;
					
					// typeOf map:
					// 00 -> 11
					// 01 -> 01
					// 10 -> 10
					// 11 -> 00
					
					if(typeOf[i] == 0 || typeOf[i] == 3) {
						typeOf[i] = 3 - typeOf[i];
					}
				}
			}
			
			int temp = indices[0];
			indices[0] = indices[3];
			indices[3] = temp;
		}
	}
	
	public static int query(int pos) {
		numGuesses++;
		//System.out.println("making guess #" + numGuesses);
		
		// if numGuesses % 10 == 1, then array changed
		
		System.out.println(pos);
		System.out.flush();
		int bit = in.nextInt();
		
		return bit;
	}
	
	public static boolean outputFinalArray() {
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(i);
		}
		
		System.out.println(sb.toString());
		System.out.flush();
		
		String g = in.next();
		
		if(g.equals("Y")) {
			return true;
		}
		
		return false;
	}
	
	// return which types are known: either have 0, 1, 2, or 3
	public static ArrayList<Integer> getKnownTypes() {
		ArrayList<Integer> list = new ArrayList<>();
		if(indices[0] != -1) {
			list.add(0);
		}
		else if(indices[3] != -1){
			list.add(3);
		}
		
		if(indices[1] != -1) {
			list.add(1);
		}
		else if(indices[2] != -1) {
			list.add(2);
		}
		
		return list;
	}
	
	static class Pair implements Comparable<Pair> {
		int a;
		int b;

		public Pair(int x, int y) {
			a = x;
			b = y;
		}

		public int compareTo(Pair p2) {
			if (a < p2.a)
				return -1;
			if (a == p2.a) {
				if (b < p2.b)
					return -1;
				if (b == p2.b)
					return 0;
				return 1;
			}
			return 1;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Pair))
				return false;
			Pair p2 = (Pair) o;
			return (a == p2.a && b == p2.b);
		}

		public int hashCode() {
			return (a + " " + b).hashCode();
		}

		public String toString() {
			return "(" + a + ", " + b + ")";
		}
	}

}
/*

Suppose B = 10
1 10

1234567890
1101001000

1 20
12345678901234567890
11010010001011101100

a:
12345678901234567890
00101101110100010011

b:
12345678901234567890
00110111010001001011

c:
12345678901234567890
11001000101110110100

EAC
BAB

1 20
12345678901234567890
11111111111111111111
*/