import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt();
      int b = in.nextInt();
      if(in.hasNextLine()) in.nextLine();
      
      for (int i = 1; i <= t; ++i) {  
    	  solve(in, b);
    	  in.nextLine();
    	  String veredict = in.nextLine().replace("\n", "");
    	  if(veredict.equals("N")) break;
      }
      in.close();
    }

	private static void solve(Scanner in, int b) {
		
		int query = 0;
		
		int firstSym = -1;
		int firstAntisym = -1;
		boolean[] sym = new boolean[b];
		boolean[] antisym = new boolean[b];
		boolean[] bits = new boolean[b];
		int bitsFound = 0;
		int j = 0;
		
		while(bitsFound < b) {
		
			if(query % 10 == 0 && query > 0) {
				
				if(firstSym > 0) {
					System.out.println(firstSym+1);
					query++;
					boolean symBit = in.nextInt() == 1;
					if(symBit == bits[firstSym]) {
						// Reversed or Nothing Happened
					}else {
						// Complemented or Complemented & Reversed
						for(int i = 0; i < bits.length; i++)
							if(sym[i]) bits[i] = !bits[i];
					}
				}else {
					System.out.println(0);
					query++;
					in.nextInt();
				}
				if(firstAntisym > 0) {
					System.out.println(firstAntisym+1);
					query++;
					boolean antisymBit = in.nextInt() == 1;
					if(antisymBit == bits[firstAntisym]) {
						// Complemented & Reversed or Nothing Happened
					}else {
						// Complemented or Reversed
						for(int i = 0; i < bits.length; i++)
							if(antisym[i]) bits[i] = !bits[i];
					}
				}else {
					System.out.println(0);
					query++;
					in.nextInt();
				}
				
			}else {
		
				int testX = j;
				int testY = (b-1)-j;
				
				System.out.println(testX+1);
				query++;
				int x = in.nextInt();
				System.out.println(testY+1);
				query++;
				int y = in.nextInt();
				if(x == y) {
					// Sym
					if(firstSym < 0) firstSym = testX;
					sym[testX] = sym[testY] = true;
				}else{
					// Antisym
					if(firstAntisym < 0) firstAntisym = testX;
					antisym[testX] = antisym[testY] = true;
				}
				bits[testX] = x == 1;
				bits[testY] = y == 1;
				bitsFound += 2;
				j++;
			}
		}

		String bitString = "";
		for(int i = 0; i < bits.length; i++)
			bitString += bits[i] ? "1" : "0";
		System.out.println(bitString);
		
	}
	
}
