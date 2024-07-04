import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i=0; i<testCase; i++) {
			System.out.println("Case #" + (i+1) + ": " + solution(sc));
		}
	}

	private static String solution(Scanner sc) {
		int U = sc.nextInt();
		TreeMap<String, String> tm = new TreeMap<String, String>();
		
		HashMap<Character, Integer> shm = new HashMap<Character, Integer>();
		HashMap<Character, Integer> uhm = new HashMap<Character, Integer>();
		HashSet<Character> cset = new HashSet<Character>();
		//for (int i=0; i<10000; i++) {
			
		//}
		
		for (int j=0; j<10000; j++) {
			//Map.Entry<String, String> entry = tm.pollFirstEntry();
			String key = sc.next();
			String value = sc.next();
			for (int i=0; i<value.length(); i++) {
				cset.add(value.charAt(i));
			}
			
			
		//	System.out.println(key + " " + value);
			if (key.length() == 1) {
				//System.out.println(key + " " +value);
				for (int i=0; i<value.length(); i++) {
					if (!uhm.containsKey(value.charAt(i))) {
						uhm.put(value.charAt(i), key.charAt(i) - '0');
					} else {
						uhm.put(value.charAt(i), Math.min(key.charAt(i) - '0', uhm.get(value.charAt(i))));
					}
				}
			}
		}
		
		HashMap<Integer, List<Character>> keyhm = new HashMap<Integer, List<Character>>();
		TreeMap<Integer, Character> tmv = new TreeMap<Integer, Character>();
		
		for (Map.Entry<Character, Integer> entry:uhm.entrySet()) {
			int number = entry.getValue();
			char c = entry.getKey();
			//System.out.println("number " + number + " " + c);
			tmv.put(number, c);
		}
		String result = "";
		//System.out.println(tmv.size());
		while (tmv.size() >0) {
			Map.Entry<Integer, Character> entry = tmv.pollFirstEntry();
			result += entry.getValue();
			cset.remove(entry.getValue());
		}
		if (cset.size() >0) {
			result =  cset.toArray()[0] + result;
		}
		//System.out.println("result " + result);
		return result;
	}
	
	class SComparators implements Comparator<String[]>{

		

		@Override
		public int compare(String[] o1, String[] o2) {
			return o1[0].compareTo(o2[1]);
		}
		
	}
}
