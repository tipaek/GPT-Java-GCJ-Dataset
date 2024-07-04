
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private boolean endAll;
	private boolean endCase;
	private int currentTest = 0;
	List<String> Qs;
	List<Integer> Ms;
	Map<Character, Integer> counts = new HashMap<>();
	Set<Character> chars = new HashSet<>();
	public Solution(List<String> Qs, List<Integer> Ms) {
		this.Qs = Qs;
		this.Ms = Ms;
	}

	public static void main(String[] args) throws IOException {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String[] tab = br.readLine().split(" ");;
			int nbCaseToSolve = Integer.parseInt(tab[0]);
			for (int i = 1; i <= nbCaseToSolve; i++) {
				int U = Integer.parseInt(br.readLine());
				List<String> Qs = new ArrayList<>();
				List<Integer> Ms = new ArrayList<>();
				String line ;
				
				while ((line =  br.readLine()) != null) {
					Qs.add(line.split(" ")[1]);
					Ms.add(Integer.parseInt(line.split(" ")[0]));
				}

				Solution solver = new Solution(Qs, Ms);
				String messageOut = solver.print(i, solver.out());
				if (messageOut.isEmpty()) {
					throw new RuntimeException("empty message generated");
				}
				System.out.println(messageOut);
				System.out.flush();
			}
		}
	}

	private String out() {
		Map<Integer, Character> knowns = new HashMap<>();
		for (int i = 0; i < Qs.size(); i++) {
			String Q = Qs.get(i);
			Integer M = Ms.get(i);
			if (M != -1) {
				if (Integer.toString(M).length() == Q.length()) {
					int firstFigure = Integer.toString(M).charAt(0) - '0';
					char firstChar = Q.charAt(0);
					if (!knowns.values().contains(firstChar)) {
						List<Integer> possibility = IntStream.range(1, firstFigure+1)
								.filter(n -> knowns.get(n) == null).boxed()
								.collect(Collectors.toList());
						if (possibility.size() == 1) {
							knowns.put(possibility.get(0), firstChar);
						}
					}
				}
			}
		}
		for (String string : Qs) {
			string.chars().forEach(c -> chars.add((char) c));
			char c = string.charAt(0);

			Integer count = counts.get(c);
			if (count == null) {
				count = 0;
			}
			count++;
			counts.put(c, count);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			chars.remove(entry.getKey());
		}
		for (Character char_ : knowns.values()) {
			chars.remove(char_);
		}

		knowns.values().forEach(counts::remove);
		LinkedList<Character> queue = counts.entrySet().stream()
		.sorted((a, b) -> b.getValue().compareTo(a.getValue()))
		.map(Entry::getKey)
		.collect(Collectors.toCollection(LinkedList::new));
		
		knowns.put(0, chars.stream().findFirst().get());
		IntStream.range(0, 10).filter(i -> knowns.get(i) == null)
		.forEach(i -> knowns.put(i, queue.poll()));
		
		String all = knowns.entrySet().stream()
				.sorted((a, b) -> a.getKey().compareTo(b.getKey()))
				.map(Entry::getValue)
				.map(c -> c.toString())
				.collect(Collectors.joining());
		// String other = revMap.entrySet().stream().sorted((a, b) ->
		// b.getKey().compareTo(a.getKey()))
		// .map(Entry::getValue)
		// .map(c -> c.toString())
		// .collect(Collectors.joining());

		return all;
	}

	String print(int x, String path) {

		return String.format("Case #%d: %s", x, path);

	}

}
