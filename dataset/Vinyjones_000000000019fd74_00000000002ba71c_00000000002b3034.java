
import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private boolean endAll;
	private boolean endCase;
	private int currentTest = 0;
	List<String> patterns;

	public Solution(List<String> patterns) {
		this.patterns = patterns;
	}

	public static void main(String[] args) throws IOException {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			String[] tab = br.readLine().split(" ");;
			int nbCaseToSolve = Integer.parseInt(tab[0]);
			for (int i = 1; i <= nbCaseToSolve; i++) {
				int N = Integer.parseInt(br.readLine());
				List<String> patterns = new ArrayList<>();
				for (int j = 0; j < N; j++) {
					patterns.add(br.readLine());
				}

				Solution solver = new Solution(patterns);
				String messageOut = solver.out();
				if (messageOut.isEmpty()) {
					throw new RuntimeException("empty message generated");
				}
				System.out.println(messageOut);
				System.out.flush();
			}
		}
	}

	private String out() {
		List<String> lstart = patterns.stream().map(this::first).filter(s -> !s.isEmpty()).collect(Collectors.toList());
		List<String> lend = patterns.stream().map(this::last).filter(s -> !s.isEmpty()).collect(Collectors.toList());
		List<String> lmiddle = patterns.stream().map(this::middle).filter(s -> !s.isEmpty()).collect(Collectors.toList());

		String start = buildStart(lstart);
		String end = buildEnd(lend);
		if (start == null || end == null) {
			return "*";
		}
		return start + lmiddle.stream().collect(Collectors.joining()) + end;
	}

	String buildStart(List<String> patt) {
		if (patt.isEmpty()) {
			return "";
		}
		String ret = patt.get(0);
		for (int i = 1; i < patt.size(); i++) {
			if (ret.length() > patt.get(i).length()) {
				if (!ret.startsWith(patt.get(i))) {
					return null;
				}
			} else {
				if (!patt.get(i).startsWith(ret)) {
					return null;
				}
				ret = patt.get(i);
			}
		}
		return ret;
	}

	String buildEnd(List<String> patt) {
		if (patt.isEmpty()) {
			return "";
		}
		String ret = patt.get(0);
		for (int i = 1; i < patt.size(); i++) {
			if (ret.length() > patt.get(i).length()) {
				if (!ret.endsWith(patt.get(i))) {
					return null;
				}
			} else {
				if (!patt.get(i).endsWith(ret)) {
					return null;
				}
				ret = patt.get(i);
			}
		}
		return ret;
	}

	String first(String s) {
		if(s.startsWith("*")) {
			return "";
		}
		return s.split("\\*")[0];
	}
	String last(String s) {
		if(s.endsWith("*")) {
			return "";
		}
		String[] tab = s.split("\\*");
		String ret = tab[tab.length - 1];
		return ret;
	}

	String middle(String s) {
		s="#" + s + "#";
		String[] tab = s.split("\\*");
		return Arrays.stream(Arrays.copyOfRange(tab, 1, tab.length - 1)).collect(Collectors.joining());
	}

}
