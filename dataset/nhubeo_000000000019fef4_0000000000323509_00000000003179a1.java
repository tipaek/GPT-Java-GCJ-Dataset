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
		HashMap<String, String> pairs = new HashMap<String, String>();
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
			if (key.length() == value.length()) {
				if (!uhm.containsKey(value.charAt(0))) {
					uhm.put(value.charAt(0), key.charAt(0) - '0');
				} else {
					uhm.put(value.charAt(0), Math.min(key.charAt(0) - '0', uhm.get(value.charAt(0))));
				}
			} else {
				pairs.put(key, value);
			}
		}
		
		HashMap<Character, Integer> resulthm = new HashMap<Character, Integer>();
		
		while (resulthm.size() <9) {
			TreeMap<Integer, Character> tmv = new TreeMap<Integer, Character>();
			for (Map.Entry<Character, Integer> entry:uhm.entrySet()) {
				int number = entry.getValue();
				char c = entry.getKey();
				//System.out.println("number " + number + " " + c);
				tmv.put(number, c);
			}
			
			for (int i=1; i<=9; i++) {
				if (tmv.containsKey(i)) {
					resulthm.put(tmv.get(i), i);
				} else {
					break;
				}
			}
			
			for (Map.Entry<String, String> entry:pairs.entrySet() ) {
				String key = entry.getKey();
				String value = entry.getValue();
				int i = 0;
				if (key.length() == value.length()) {
					for (i=0; i<key.length()-1; i++) {
						if (!resulthm.containsKey(value.charAt(i))) {
							break;
						}
					}
					if (i == key.length()-1) {
						if (!uhm.containsKey(value.charAt(0))) {
							uhm.put(value.charAt(i), key.charAt(i) - '0');
						} else {
							uhm.put(value.charAt(i), Math.min(key.charAt(i) - '0', uhm.get(value.charAt(i))));
						}
					}
				}
			}
		}
		
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
