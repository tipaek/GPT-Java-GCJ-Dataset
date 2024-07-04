import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int t = in.nextInt();
	in.nextLine();
	for (int i = 1; i <= t; ++i) {
		Map<Integer,String> numberMap = new HashMap<Integer, String>();
		String line = in.nextLine();
		String[] chars = line.split("");
		List<Integer> numbers = new ArrayList<>();
		List<String> blocks = new ArrayList<String>();
		for(int j = 0; j < chars.length; j++) {
			int prevNumber = -1;
			int currentNumber = Integer.valueOf(chars[j]);
			if(j > 0) {
				prevNumber = Integer.valueOf(chars[j-1]);
				if(currentNumber == prevNumber) {
					blocks.set(blocks.size()-1, blocks.get(blocks.size()-1).concat(chars[j]));
				}
				else {
					blocks.add(new String(chars[j]));
				}
			}
			else {
				blocks.add(new String(chars[j]));
			}
		}
		String output = "";
		for(String numStr : blocks) {
			int parenth = Integer.valueOf(String.copyValueOf(new char[] {numStr.charAt(0)}));
			System.err.println(parenth);
			String open = "";
			String close = "";
			for(int m = 0; m < parenth; m++) {
				open += "(";
				close += ")";
			}
			output += open + numStr + close; 
		}
		System.out.println("Case #"+i+": "+output);
	}
      
  }
}