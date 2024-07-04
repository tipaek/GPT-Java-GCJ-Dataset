    import java.util.*;
    import java.io.*;
    public class Solution {
    	public static void main(String[] args) throws FileNotFoundException {
    		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    		//File f = new File("tests/2.txt");
    		//Scanner in = new Scanner(f);
    		int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    		StringBuilder sb;
    		for (int test = 1; test <= testCount; test++) {
    			sb = new StringBuilder();
    			String input = in.next();
				char c;
				int currentNum;
				int numsProcessed = 0;
				boolean zeros = true;
    			
				for(int position = 0; position < input.length(); position++) {
					int current = Character.getNumericValue(input.charAt(position));
					if(current == 0 && zeros) {
						sb.append(current);
						zeros = true;

					}
					else if (current == 0 && !zeros) {
						sb.append(")");
						sb.append(current);
						zeros = true;

					}
					else if (current == 1 && zeros) {
						sb.append("(");
						sb.append(current);
						zeros = false;
					}
					else {
						sb.append(current);
						zeros = false;
					}
					if(position == input.length() - 1 && !zeros) {
						sb.append(")");
					}
				}

    			System.out.println("Case #" + test + ": " + sb.toString());
    		}
    		in.close();
    	}
    }