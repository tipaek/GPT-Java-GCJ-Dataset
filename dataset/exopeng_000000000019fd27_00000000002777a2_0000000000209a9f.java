import java.io.*;
import java.util.*;



public class Solution {
	public static int[] lTally;
	public static int[] rTally;
	public static int[] nums;
	public static void main(String[] args) throws IOException {
		//get input separately
		
		
		
		/*
		 * test = extendLeft(test, 1, 0, 0); System.out.println(test);
		 * 
		 * System.out.println(Arrays.toString(lTally));
		 * 
		 * 
		 * test = extendRight(test, 1,1,0);
		 * 
		 * System.out.println(test); System.out.println(Arrays.toString(rTally));
		 * 
		 * lTally = Arrays.copyOf(rTally, rTally.length); //have to do these in order,
		 * left to right, update left when updating right test = extendLeft(test, 0, 3,
		 * 1); System.out.println(test);
		 * 
		 * test = extendRight(test, 0, 3,1); System.out.println(test);
		 * 
		 * lTally = Arrays.copyOf(rTally, rTally.length);
		 * 
		 * test = extendLeft(test, 1, 4, 2); System.out.println(test);
		 * System.out.println(Arrays.toString(lTally));
		 * 
		 * test = extendRight(test, 1, 5, 2);
		 * System.out.println(Arrays.toString(rTally)); System.out.println(test);
		 */
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		int cases = Integer.parseInt(s.nextToken());
		//store the answers in an int array
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(b.readLine());
			String fin = s.nextToken();
			rTally = new int[fin.length()];
			lTally = new int[fin.length()];
			nums = new int[fin.length()];
			for (int j = 0; j < fin.length(); j++) {
				nums[j] = Integer.parseInt(fin.substring(j, j+1));
			}
			int currElement = 0;
			int elementIndex = 0;
			for (int j = 0; j < fin.length(); j++) {
				if (fin.charAt(j) =='(' || fin.charAt(j) ==')') {
					continue;
				}
				fin = extendLeft(fin, Integer.parseInt(fin.substring(j,j+1)), j, elementIndex);
				while (fin.charAt(j) == ')' || fin.charAt(j) == '(') {
					j++;
				}
				fin = extendRight(fin, Integer.parseInt(fin.substring(j,j+1)), j, elementIndex);
				elementIndex++;
				lTally = Arrays.copyOf(rTally, rTally.length);
			}
			
			p.println("Case #" + (i + 1) + ": " +  fin);
		}
		p.close();
	}
	public static String extendRight(String str, int currElement, int strIndex, int elementIndex) {
		if (rTally[elementIndex] == currElement) {
			return str;
		}
		int parens = currElement - rTally[elementIndex];
		for (int i = strIndex; i < str.length(); i++) {
			//if were on the last element
			if (str.charAt(i) == '(' || str.charAt(i) == ')') {
				continue;
			}
			rTally[elementIndex] += parens;
			if (elementIndex == rTally.length - 1) {
				return endParenAdder(str, parens, i);

				/*
				 * for (int j = str.length() - 1; j > -1; j--) {
				 * 
				 * if (str.substring(j, j + 1).equals("(") || str.substring(j, j +
				 * 1).equals(")") ) { continue; } if (rTally[rTally.length - 1] ==
				 * Integer.parseInt(str.substring(j, j + 1))) { //loop back to the last one
				 * return endParenAdder(str, parens, j - 1); } rTally[origIndex] = currElement;
				 * return endParenAdder(str, parens, str.length() - 1); }
				 */
			}
			//check if the next element has enough, if it doesn't require all of it, add to the current one now
			elementIndex++;
			int needed = nums[elementIndex] - rTally[elementIndex];
			//if the next element doesn't need any more parentheses, stop, if it needs a few more, add the rest to the current one and then parens = needed
			if (needed < parens) {
				//should i comment this?
				//rTally[elementIndex] += needed;
				//even if it can only take a few, the few can keep going on
				str = endParenAdder(str, parens - needed , i);
				parens = needed;
				/*
				 * for (int j = i - 1; j > -1; j--) { if (str.substring(j,j+1).equals(")") ||
				 * str.substring(j,j+1).equals("(")) { continue; } //rTally[origIndex] =
				 * currElement; str = endParenAdder(str, parens, j); j+=parens;
				 * //System.out.println(str); parens = needed; break; }
				 */
			}
			//if the current element is already fulfilled, meaning it has enough parentheses, then you have to stop there
			//problem code, have to fast forward to the next element
			/*
			 * if (rTally[elementIndex] == Integer.parseInt(str.substring(i, i + 1))) { //go
			 * back to the last element for (int j = i - 1; j > -1; j--) { if
			 * (str.substring(j,j+1).equals(")") || str.substring(j,j+1).equals("(")) {
			 * continue; } rTally[origIndex] = currElement; return endParenAdder(str,
			 * parens, j); } } else { needed = Integer.parseInt(str.substring(i, i + 1)) -
			 * rTally[elementIndex]; if (needed < parens) { //should i comment this?
			 * rTally[elementIndex] += needed;
			 * 
			 * //even if it can only take a few, the few can keep going on parens -= needed;
			 * //str = endParenAdder(str, parens, i); for (int j = i - 1; j > -1; j--) { if
			 * (str.substring(j,j+1).equals(")") || str.substring(j,j+1).equals("(")) {
			 * continue; } //rTally[origIndex] = currElement; str = endParenAdder(str,
			 * parens, j); j+=parens; //System.out.println(str); parens = needed; break; }
			 * 
			 * } else {
			 * 
			 * } }
			 */
		}
		return str;
		
	}
	public static String extendLeft(String str, int currElement, int strIndex, int elementIndex) {
		if (lTally[elementIndex] == currElement) {
			return str;
		}
		int parens = currElement - lTally[elementIndex];
		for (int i = strIndex; i > -1; i--) {
			//if were on the last element
			if (str.charAt(i) == '(' || str.charAt(i) == ')') {
				continue;
			}
			lTally[elementIndex] += parens;
			if (elementIndex == 0) {
				return startParenAdder(str, parens, i - 1);
			}
			
			elementIndex--;
			int needed = nums[elementIndex] - lTally[elementIndex];
			if (needed < parens) {
				str = startParenAdder(str, parens - needed , i - 1);
				parens = needed;
			}
		}
		return str;
	}

	/*
	 * public static String extendLeft(String str, int currElement, int strIndex,
	 * int elementIndex) { if (lTally[elementIndex] == currElement) { return str; }
	 * int origIndex = elementIndex; int parens = currElement -
	 * lTally[elementIndex]; //handle special case where somehting is on the edge
	 * for (int i = strIndex; i > -1; i--) { if (i == 0) { for (int j = 0; j <
	 * str.length(); j++) { if (str.substring(j, j + 1).equals("(") ||
	 * str.substring(j, j + 1).equals(")") ) { continue; } if (lTally[0] ==
	 * Integer.parseInt(str.substring(j, j + 1))) { return startParenAdder(str,
	 * parens, j); } lTally[origIndex] = currElement; return startParenAdder(str,
	 * parens, -1); } } if (str.charAt(i) == '(' || str.charAt(i) == ')') {
	 * continue; } //if the current element is already fulfilled, meaning it has
	 * enough parentheses, then you have to stop there if (lTally[elementIndex] ==
	 * Integer.parseInt(str.substring(i, i + 1))) { lTally[origIndex] = currElement;
	 * //go back to the last element for (int j = i + 1; j < str.length(); j++) { if
	 * (str.substring(j,j+1).equals(")") || str.substring(j,j+1).equals("(")) {
	 * continue; } lTally[origIndex] = currElement; return startParenAdder(str,
	 * parens, j - 1); } } else { int needed = Integer.parseInt(str.substring(i, i +
	 * 1)) - lTally[elementIndex]; if (needed < parens) { str = startParenAdder(str,
	 * needed, i - 1); lTally[elementIndex] += needed;
	 * 
	 * //go back and add the rest of the parentheses to the last element as the
	 * current one can only handle so much parens -= needed; for (int j = i + 1; j <
	 * str.length(); j++) { if (str.substring(j,j+1).equals(")") ||
	 * str.substring(j,j+1).equals("(")) { continue; } lTally[origIndex] =
	 * currElement; str = startParenAdder(str, parens, j - 1); break; } parens =
	 * needed; } else { lTally[elementIndex] += parens; elementIndex--; } }
	 * 
	 * } return str; }
	 */
	public static String startParenAdder(String str, int num, int start) {
		String startPar = "";
		for (int i = 0; i < num; i++) {
			startPar += "(";
		}
		str = str.substring(0, start + 1) + startPar + str.substring(start + 1);
		return str;
	}
	public static String endParenAdder(String str, int num, int start) {
		String endPar = "";
		for (int i = 0; i < num; i++) {
			endPar += ")";
		}
		str = str.substring(0, start + 1) + endPar + str.substring(start + 1);
		return str;
	}
	
	// you should actually read the stuff at the bottom

}
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
