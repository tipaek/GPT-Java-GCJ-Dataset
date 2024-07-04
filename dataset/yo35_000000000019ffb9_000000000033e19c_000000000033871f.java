
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private static void solveTestCases(Scanner sc) {

		int testCaseCount = sc.nextInt();
		for (int i = 1; i <= testCaseCount; ++i) {
			System.out.println("Case #" + i + ": " + solveTestCase(sc));
		}
	}

	private static String solveTestCase(Scanner sc) {

		int C = sc.nextInt();
		int D = sc.nextInt();

		int[] infos = new int[C - 1];
		for (int i = 0; i < infos.length; ++i) {
			infos[i] = sc.nextInt();
		}

		List<Link> links = new ArrayList<>();
		Map<Integer, Map<Integer, Link>> nodesToLink = new HashMap<>();
		for (int i = 0; i < D; ++i) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			Link link = new Link(u, v);
			links.add(link);
			nodesToLink.computeIfAbsent(u, key -> new HashMap<>()).put(v, link);
			nodesToLink.computeIfAbsent(v, key -> new HashMap<>()).put(u, link);
		}

		Map<Integer, Set<Link>> assignable = new HashMap<>();
		for (Map.Entry<Integer, Link> entry : nodesToLink.get(1).entrySet()) {
			assignable.computeIfAbsent(entry.getKey(), key -> new HashSet<>()).add(entry.getValue());
		}

		int[] reachedAt = new int[C];
		Arrays.fill(reachedAt, -1);
		reachedAt[0] = 0;

		int time = 1;
		for (int alreadyAssigned = 1; alreadyAssigned < C; ++alreadyAssigned) {

			Set<Integer> toAssign = findToAssignByBefore(C, infos, alreadyAssigned);

			for (int computerToAssign : toAssign) {
				Set<Link> candidateLinks = assignable.get(computerToAssign);
				if (candidateLinks.isEmpty()) {
					throw new IllegalStateException("Cannot find a solution.");
				}
				Link candidateLink = candidateLinks.iterator().next();
				candidateLink.latency = time - reachedAt[candidateLink.getOther(computerToAssign) - 1];
			}

			for (int computerToAssign : toAssign) {
				reachedAt[computerToAssign - 1] = time;

				for (Map.Entry<Integer, Link> entry : nodesToLink.get(computerToAssign).entrySet()) {
					assignable.computeIfAbsent(entry.getKey(), key -> new HashSet<>()).add(entry.getValue());
				}
			}

			++time;
		}

		int maxTime = time;
		return links.stream().mapToInt(link -> link.latency < 0 ? maxTime : link.latency).mapToObj(Integer::toString).collect(Collectors.joining(" "));
	}

	private static Set<Integer> findToAssignByBefore(int C, int[] infos, int alreadyAssigned) {
		return IntStream.rangeClosed(2, C).filter(computerIndex -> infos[computerIndex - 2] == -alreadyAssigned).mapToObj(i -> i).collect(Collectors.toSet());
	}

	private static final class Link {
		public final int u;
		public final int v;
		public int latency = -1;

		public Link(int u, int v) {
			this.u = u;
			this.v = v;
		}

		public int getOther(int a) {
			return u == a ? v : u;
		}
	}

	// #####################################################################################################################
	// #####################################################################################################################
	// #####################################################################################################################
	// *** DO NOT EDIT BELOW ***
	// #####################################################################################################################
	// #####################################################################################################################
	// #####################################################################################################################

	public static String join(char[] values) {
		return join(" ", values);
	}

	public static String join(int[] values) {
		return join(" ", values);
	}

	public static String join(long[] values) {
		return join(" ", values);
	}

	public static String join(double[] values) {
		return join(" ", values);
	}

	public static <T> String join(T[] values) {
		return join(" ", values);
	}

	public static String join(Collection<?> values) {
		return join(" ", values);
	}

	public static String join(String delimiter, char[] values) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; ++i) {
			if (i != 0) sb.append(delimiter);
			sb.append(values[i]);
		}
		return sb.toString();
	}

	public static String join(String delimiter, int[] values) {
		return Arrays.stream(values).mapToObj(value -> Integer.toString(value)).collect(Collectors.joining(delimiter));
	}

	public static String join(String delimiter, long[] values) {
		return Arrays.stream(values).mapToObj(value -> Long.toString(value)).collect(Collectors.joining(delimiter));
	}

	public static String join(String delimiter, double[] values) {
		return Arrays.stream(values).mapToObj(value -> Double.toString(value)).collect(Collectors.joining(delimiter));
	}

	public static <T> String join(String delimiter, T[] values) {
		return Arrays.stream(values).map(value -> value.toString()).collect(Collectors.joining(delimiter));
	}

	public static String join(String delimiter, Collection<?> values) {
		return values.stream().map(value -> value.toString()).collect(Collectors.joining(delimiter));
	}

	public static void run(InputStream stream) {
		try {
			Scanner sc = new Scanner(new BufferedInputStream(stream));
			sc.useLocale(Locale.ROOT);
			solveTestCases(sc);
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public static void main(String[] args) {
		run(System.in);
	}
}
