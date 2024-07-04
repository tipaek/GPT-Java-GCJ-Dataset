import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int caseCount = in.nextInt();
		for (int x = 0; x < caseCount; x++) {
			StringBuilder out = new StringBuilder();
			int activityCount = in.nextInt();
			List<int[]> activities = new ArrayList<>();

			for (int y = 0; y < activityCount; y++) {
				int[] pair = new int[2];
				pair[0] = in.nextInt();
				pair[1] = in.nextInt();
				activities.add(pair);
			}

			activities = activities.stream().sorted(Comparator.comparingInt(e -> e[0])).collect(Collectors.toList());
			List<int[]> cBucket = new ArrayList<int[]>();
			List<int[]> jBucket = new ArrayList<int[]>();

			for (int[] e : activities) {
				if (e[0] >= getLastActivityEndingTime(cBucket)) {
					cBucket.add(e);
					out.append("C");
				} else if (e[0] >= getLastActivityEndingTime(jBucket)) {
					jBucket.add(e);
					out.append("J");
				} else {
					out.delete(0, out.length());
					out.append("IMPOSSIBLE");
					break;
				}
			}

			System.out.println(String.format("Case #%d: %s", x + 1, out.toString()));
		}
	}

	public static int getLastActivityEndingTime(List<int[]> bucket) {
		if (bucket.isEmpty())
			return 0;
		else
			return bucket.get(bucket.size() - 1)[1];
	}

}