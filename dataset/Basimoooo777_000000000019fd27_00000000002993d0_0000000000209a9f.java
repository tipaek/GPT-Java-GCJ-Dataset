import java.util.*;

public class Solution {

	private static int calcMinimum(int[] a, int s, int e) {
		int min = Integer.MAX_VALUE;
		for(int i = s; i <= e; i ++) if(a[i] < min) min = a[i];
		return min;
	}

	private static String solve(int [] a, int s, int e, int p) {
		String str = "";
		
		int minimum = calcMinimum(a, s, e);

		for(int i = 0; i < minimum - p; i ++) str += "(";
		
		if(s == e) str += a[s] + "";
		else {
			int iter1 = s, iter2 = e;
			while(iter1 <= e && iter2 <= e) {
				while(iter1 <= e && a[iter1] == minimum) {
					str += a[iter1] + "";
					iter1 ++;
				}

				if(iter1 > e) break;

				iter2 = iter1;
				
				while(iter2 <= e && a[iter2] != minimum) iter2 ++;
				
				iter2 --;
				
				str += solve(a, iter1, iter2, minimum);
				iter1 = iter2 + 1;
			}
		}

		for(int i = 0; i < minimum - p; i ++) str += ")";

		return str;
	}

	private static int[] convertStrToIntArr(String s) {
		int len = s.length();
		char[] charArr = s.toCharArray();
        int[] intArr = new int[len];
        for(int i = 0; i < len; i++) {
        	intArr[i] = (int) (charArr[i] - '0'); 
        }
        return intArr;
	}
	
	public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int testCasesIterator = 1;
        String res = "";
        int [] input;
    	while(testCasesIterator <= testCases) {
    		input = convertStrToIntArr(sc.next());
            res = solve(input, 0, input.length - 1, 0);
        	System.out.println("Case #" + testCasesIterator + ": " + res);
        	testCasesIterator ++;
        }
        sc.close();
		
	}

}
