    import java.util.*;
    import java.io.*;
    public class Solution {
    	public static void main(String[] args) throws FileNotFoundException {
    		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		//File f = new File("tests/2_1.txt");
    		//Scanner in = new Scanner(f);
    		int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		StringBuilder sb;
    		for (int test = 1; test <= testCount; test++) {
    			sb = new StringBuilder();
    			String input = in.next();
				char c;
				int currentNum;
				int numsProcessed = 0;
				int capacity = 0;
    			
				for(int position = 0; position < input.length(); position++) {
					currentNum = Character.getNumericValue(input.charAt(position));
					int difference = Math.abs(capacity - currentNum);
					if(capacity < currentNum) {
						for(int i = 0; i < (currentNum - capacity); i++) {
							sb.append("(");
						}
						capacity += difference;
					}
					else if(capacity > currentNum) {
						for(int i = 0; i < (capacity - currentNum); i++) {
							sb.append(")");
						}
						capacity -= difference;
					}
					else {
						//
					}
					sb.append(currentNum);
					
					if(position == input.length() - 1) {
						for(int i = 0; i < capacity; i++) {
							sb.append(")");
						}
						capacity = 0;
					}
				}

    			System.out.println("Case #" + test + ": " + sb.toString());
    		}
    		in.close();
    	}
    }