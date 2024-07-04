import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//scan("problem/qual.p2/input1.txt", in -> {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				String s = in.next();
				System.out.println("Case #" + i + ": " + solve(s) );
			}
		//});
		in.close();
	}

	private static String solve(String s) {
		StringBuilder sb = new StringBuilder();
		int n;
		char [] chars = s.toCharArray();
		int level = 0;
		int toAdd=0;
		for(int i=0; i<chars.length; i++) {
			n = chars[i]-'0';
			toAdd = n-level;
			if(toAdd>0) {
				// open par
				for(int p=0; p<toAdd; p++)
					sb.append('(');
			} else if (toAdd<0) {
				// close par
				for(int p=0; p<(-toAdd); p++)
					sb.append(')');
			}
			level += toAdd; 
			sb.append(n);
		}
		if(level>0) {
			for(int p=0; p<level; p++)
				sb.append(')');
		}
		return sb.toString();
	}

	static void scan(String filename, Consumer<Scanner> consumer) {
		try (Scanner sc = new Scanner(new File(filename))) {
			consumer.accept(sc);
		} catch (FileNotFoundException e) {
			System.err.printf("Error scanning %s", filename);
			e.printStackTrace();
		}
	}

}