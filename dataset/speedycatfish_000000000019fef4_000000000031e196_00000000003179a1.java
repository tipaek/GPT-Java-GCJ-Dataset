import java.util.*;
import java.io.*;

public class Solution {
	static HashSet<Integer> allNums = new HashSet<>();
	static {
		for (int i = 0; i <= 9; i++) {
			allNums.add(i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			int upperBound = Integer.parseInt(bufread.readLine());
			HashSet<Integer> remove = new HashSet<>();
			HashMap<Character, HashSet<Integer>> characterMap = new HashMap<>();
			HashSet<Character> solved = new HashSet<>();
			char[] solution = new char[10];
			for (int counter2 = 0; counter2 < 10000; counter2++) {
				StringTokenizer st = new StringTokenizer(bufread.readLine());
				String nextVal = st.nextToken();
				String response = st.nextToken();
				if (nextVal.charAt(0) == '-' || response.length() < nextVal.length()) {
					for (int i = 0; i < response.length(); i++) {
						char c = response.charAt(i);
						if (characterMap.containsKey(c) == false) {
							HashSet<Integer> allNumsCopy = new HashSet<>();
							allNumsCopy.addAll(allNums);
							allNumsCopy.removeAll(remove);
							characterMap.put(c, allNumsCopy);
						}
						if (i == 0) {
							HashSet<Integer> options = characterMap.get(c);
							options.remove(0);
						}
					}
				} else {
					int digit1 = Character.getNumericValue(nextVal.charAt(0));
					for (int i = 0; i < response.length(); i++) {
						char c = response.charAt(i);
						if (characterMap.containsKey(c) == false) {
							HashSet<Integer> allNumsCopy = new HashSet<>();
							allNumsCopy.addAll(allNums);
							allNumsCopy.removeAll(remove);
							characterMap.put(c, allNumsCopy);
						}
						if (i == 0) {
							HashSet<Integer> options = characterMap.get(c);
							options.remove(0);
							for (int j = digit1 + 1; j <= 9; j++) {
								options.remove(j);
							}
						}
					}
				}
				Iterator<Character> itr = characterMap.keySet().iterator();
				while (itr.hasNext()) {
					char c = itr.next();
					HashSet<Integer> options = characterMap.get(c);
					if (options.size() == 1 && solved.contains(c) == false) {
						int digit = 0;
						for (int x : options) {
							digit = x;
						}
						remove.add(digit);
						solved.add(c);
						solution[digit] = c;
						for (Character c2 : characterMap.keySet()) {
							characterMap.get(c2).remove(digit);
						}
						itr = characterMap.keySet().iterator();
					}
				}
			}
			System.out.print("Case #" + (counter + 1) + ": ");
			for (char c : solution) {
				System.out.print(c);
			}
			System.out.println();
		}
		bufread.close();
	}

}
