import java.util.*;
import java.util.stream.Stream;
import java.io.*;
public class Solution {

	static String solve(int[] q, String[] r) {
		String result = "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<10000; i++) {
			char ch = r[i].charAt(0);
			Integer v = map.get(ch);
			if (v == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, v+1);
			}	
		}
		for(int i=0; i<10000; i++) {
			char ch = r[i].charAt(r[i].length()-1);
			Integer v = map.get(ch);
			if (v == null) {
				map.put(ch, 100000);
				break;
			}	
		}
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<Character, Integer> entry : list) {
            result = entry.getKey() + result;
        }
		return result;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int u = in.nextInt();
			int[] q = new int[10000];
			String[] r = new String[10000];
			for (int k = 0; k < 10000; ++k) {
				q[k] = in.nextInt();
				r[k] = in.next();
			}
			String result = solve(q, r);
			System.out.println("Case #" + i + ": " + result);
		}
		in.close();
	}

}
