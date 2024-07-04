
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	private boolean endAll;
	private boolean endCase;
	private int currentTest = 0;
	List<String> Qs;
	Map<Character, Integer> counts = new HashMap<>();
	Set<Character> chars = new HashSet<>();
	public Solution(List<String> Qs) {
		this.Qs = Qs;
	}

	public static void main(String[] args) throws IOException {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String[] tab = br.readLine().split(" ");;
			int nbCaseToSolve = Integer.parseInt(tab[0]);
			for (int i = 1; i <= nbCaseToSolve; i++) {
				int U = Integer.parseInt(br.readLine());
				List<String> Qs = new ArrayList<>();
				for (int j = 0; j < 1000; j++) {
					Qs.add(br.readLine().split(" ")[1]);
				}

				Solution solver = new Solution(Qs);
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
		for (String string : Qs) {
			string.chars().forEach(c -> chars.add((char)c));
			char c = string.charAt(0);

			Integer count = counts.get(c);
			if (count == null) {
				count = 0;
			}
			count++;
			counts.put(c, count);
		}
		Map<Integer, Character> revMap = new HashMap<>();
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			revMap.put(entry.getValue(), entry.getKey());
			chars.remove(entry.getKey());
		}

		if (!(revMap.size() == 9)) {
			throw new RuntimeException();
		}
		String zero = chars.stream().findFirst().get().toString();
		String other = revMap.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey()))
				.map(Entry::getValue)
				.map(c -> c.toString())
				.collect(Collectors.joining());

		return zero + other;
	}

	String print(int x, String path) {

		return String.format("Case #%d: %s", x, path);

	}

}
