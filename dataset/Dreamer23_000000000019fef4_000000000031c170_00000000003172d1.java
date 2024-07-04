
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
			System.out.println("Case #" + x + ": " + getResult(in.nextLine(), in.nextLine()));
		}
		in.close();
	}
		
	// Start with D <= 3.
	private static String getResult(String targetString, String sliceString) {
		String[] settings = targetString.split(" ");
		final int diners = Integer.parseInt(settings[1]);
		long[] sliceSizes = getSlices(sliceString);
		Arrays.sort(sliceSizes);
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		Set<Long> set = new HashSet<Long>();
		int duplicates = 0;
		for(int i = 0; i < sliceSizes.length; i++) {
			final long size = sliceSizes[i];
			Integer num = map.get(size);
			if (num == null) {
				num = 0;
			}
			num++;
			map.put(size, num);
			set.add(size);
			if(i > 0 && size == sliceSizes[i-1]) duplicates++;
		}
		if(duplicates + 1 >= diners) return "0";
		
		if (diners == 2) return "1";
		
		for(int i = 0; i < sliceSizes.length; i++) {
			if (set.contains(sliceSizes[i] * 2)) return "1";
		}
		
		return "2";
	}
	
	private static long[] getSlices(String line) {
		String[] snum = line.split(" ");
		long[] l = new long[snum.length];
		for(int i = 0; i < snum.length; i++) l[i] = Long.parseLong(snum[i]);
		return l;
	}
}
