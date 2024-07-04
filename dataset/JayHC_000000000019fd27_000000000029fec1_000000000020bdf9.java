import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	private static Scanner scanner;
	static int tn=1;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);

		int t = scanner.nextInt();
		scanner.nextLine();

		while(t-- > 0) {
			solve();
		}

		/*List<String> output = new ArrayList<>();

		int testCases = scanner.nextInt();

		for(int i=0; i<testCases; i++) {

			int activities = scanner.nextInt();

			String solution = "";
			indexes = new ArrayList<Integer>();

			//startMap<startTime, index>
			Map<Integer, Integer> startMap = new HashMap<>();

			//endMap<index, endTime>
			Map<Integer, Integer> endMap = new HashMap<>();

			for(int j=0; j<activities; j++) {

				startMap.put(scanner.nextInt(), j);
				endMap.put(j, scanner.nextInt());
			}

			String helper = solve(startMap, endMap);

			if(helper.equals("IMPOSSIBLE")) {
				output.add("IMPOSSIBLE");
				continue;
			}

			if(helper.length()==2) {
				output.add(helper);
				continue;
			}

			for(int j=0;j<indexes.size(); j++) {

				solution += helper.charAt(indexes.get(j));
			}

			output.add(solution);
		}

		scanner.close();

		for(int i=0; i<output.size(); i++) {
			System.out.println("Case #"+(i+1)+": "+output.get(i));
		}*/

	}

	private static void solve() {

		int n = scanner.nextInt();

		int[][] mat = new int[n][2];
		int[][] matSorted = mat.clone();

		char person = 'J';
		char[] chars = new char[n];

		Stack<int[]> JStack = new Stack<>();
		Stack<int[]> CStack = new Stack<>();

		boolean impossible = false;

		Map<int[], Integer> map = new HashMap<>();

		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[i].length; j++) {
				mat[i][j] = scanner.nextInt();
			}

			map.put(mat[i], i);
		}

		Arrays.sort(matSorted, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		for(int i=0; i<matSorted.length; i++) {
			chars[map.get(matSorted[i])] = person;

			if(i<matSorted.length - 1 && doesOverlap(matSorted[i], matSorted[i+1])) {

				if(person == 'J') {
					JStack.push(matSorted[i]);
					person = getPerson(person);

					if(!CStack.isEmpty() && doesOverlap(CStack.peek(), matSorted[i+1])) {
						impossible = true;
						break;
					}
				}else {
					CStack.push(matSorted[i]);
					person = getPerson(person);

					if(!JStack.isEmpty() && doesOverlap(JStack.peek(), matSorted[i+1])) {
						impossible=true;
						break;
					}
				}
			}else {
				if(person=='J') {
					JStack.push(matSorted[i]);
				}else {
					CStack.push(matSorted[i]);
				}
			}
		}

		System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
	}

	private static char getPerson(char p) {
		return p == 'J' ? 'C' : 'J';
	}

	private static boolean doesOverlap(int[] a, int[] b) {
		return a[1]>b[0];
	}

}