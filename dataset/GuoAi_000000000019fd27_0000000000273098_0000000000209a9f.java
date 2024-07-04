import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int T = fio.nextInt();
		for (int i = 0; i < T; i++) {
			int caseNum = i + 1;
			String str = fio.nextLine();
			ArrayList<Integer> digits = new ArrayList<>();
			ArrayList<Integer> digitsOri = new ArrayList<>();
			for (int j = 0; j < str.length(); j++) {
				digits.add(Character.getNumericValue(str.charAt(j)));
				digitsOri.add(Character.getNumericValue(str.charAt(j)));
			}
			ArrayList<String> parentheses = new ArrayList<>();
			for (int j = 0; j < digits.size() + 1; j++) {
				parentheses.add("");
			}
			while (!allZero(digits)) {
				int first = -1, second = -1;
				for (int j = 0; j < digits.size(); j++) {
					if (digits.get(j) != 0) {
						first = j;
						break;
					}
				}
				for (int j = first + 1; j < digits.size(); j++) {
					if (digits.get(j) == 0) {
						second = j - 1;
						break;
					}
				}
				if (first == -1 && second == -1) {
					break;
				} else if (first != -1 && second == -1) {
					second = digits.size() - 1;
				}
				parentheses.set(first, parentheses.get(first) + "(");
				parentheses.set(second + 1, ")" + parentheses.get(second + 1));
				if (first != second) {
					for (int j = first; j <= second; j++) {
						digits.set(j, digits.get(j) - 1);
					}
				} else {
					digits.set(first, digits.get(first) - 1);
				}
				first = -1;
				second = -1;
			}
			fio.print("Case #" + caseNum + ": ");
			for (int j = 0; j < digits.size(); j++) {
				fio.print(parentheses.get(j) + digitsOri.get(j));
			}
			fio.println(parentheses.get(digits.size()));
		}
		fio.close();
	}
	static boolean allZero(ArrayList<Integer> digits) {
		boolean res = true;
		for (int i = 0; i < digits.size(); i++) {
			if (digits.get(i) != 0) {
				res = false;
			}
		}
		return res;
	}
}

class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}