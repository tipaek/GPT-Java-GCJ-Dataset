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
			
			List<int[]> sorted = activities.stream().sorted(Comparator.comparingInt(e -> e[0])).collect(Collectors.toList());

			List<int[]> cBucket = new ArrayList<int[]>();
			List<int[]> jBucket = new ArrayList<int[]>();
			boolean impossible = false;
			for (int[] e : sorted) {
				if (isNotOverlapping(cBucket, e)) {
					cBucket.add(e);
				} else if (isNotOverlapping(jBucket, e)) {
					jBucket.add(e);
				} else {
					impossible = true;
					out.append("IMPOSSIBLE");
					break;
				}
			}
			
			if(!impossible) {
				for (int[] e : activities) {
					if (cBucket.contains(e))
						out.append("C");
					else if (jBucket.contains(e))
						out.append("J");
						
				}
			}
			

			System.out.println(String.format("Case #%d: %s", x + 1, out.toString()));
		}
	}

	public static boolean isNotOverlapping(List<int[]> bucket, int[] newActivity) {
		if(bucket.isEmpty())
			return true;
		else return bucket.stream().allMatch(e-> (e[0] >= newActivity[1] || e[1] <= newActivity[0]));
	}

}