
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int x = 1; x <= t; ++x) {
			System.out.println("Case #" + x + ": " + getResult(in.nextLine()));
		}
		in.close();
	}
		
	private static String getResult(String targetString) {
		String[] settings = targetString.split(" ");
		int north = Integer.parseInt(settings[1]);
		int east = Integer.parseInt(settings[0]);
		char[] directions = settings[2].toCharArray();
		if(north == 0 && east == 0) return "0";
		
		final int maxTurns = directions.length;
		for(int turn = 0; turn < maxTurns; turn++) {
			final char direction = directions[turn];
			int turnInt = turn+1;
			if(direction == 'S') north--;
			else if(direction == 'N') north++;
			else if(direction == 'E') east++;
			else east--;
			if(Math.abs(north) + Math.abs(east) <= turnInt) return "" + turnInt;
		}
		return "IMPOSSIBLE";
	}
}
