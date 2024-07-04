
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int dataSize = Integer.parseInt(s.next());

		int count = 0;
		while (s.hasNext() && dataSize != count) {
			count++;
			
			String input = s.next();
			ArrayList<Integer> in = convertToInt(input);
			System.out.print("Case #"+count+": ");
			findUpDown(in);
			System.out.println("");
		}
		System.exit(0);
	}
	private static ArrayList<Integer> convertToInt(String input) {
		ArrayList<Integer> output=new ArrayList<>();
		for (char c : input.toCharArray()) {
			output.add(Character.getNumericValue(c));
		}
		return output;		
	}

	private static void findUpDown( ArrayList<Integer> in) {
		in.add(-99);
		Iterator<Integer> iter =  in.iterator();
		int count =0;
		boolean leftParen = true; 
		int val = iter.next();
		
		do {
			
			while(val==count) {
				System.out.print(val);
				if (iter.hasNext()) {
					val = iter.next();
					
					if (val<count ||val==0)
						leftParen = false;
					else
						leftParen = true;
				}else {
					break;
				}
			} 
			if (iter.hasNext()) {
				if (leftParen) {
					System.out.print("(");
					count++;
				} else {
					System.out.print(")");
					count--;
				}
			}
			//System.out.print("{"+val+","+count+","+leftParen+"}");

		} while (iter.hasNext());
		
		while (count > 0) {
			System.out.print(")");
			count--;
		}
	}
	

}