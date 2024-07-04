import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

			List<int[]> cBucket = new ArrayList<int[]>();
			List<int[]> jBucket = new ArrayList<int[]>();

			for (int[] e : activities) {
				
				if(e[1] == 0){
					out.append("IMPOSSIBLE");
					break;
				}
				
				if (isNotOverlapping(cBucket, e)) {
					cBucket.add(e);
					out.append("C");
				} else if (isNotOverlapping(jBucket, e)) {
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

	public static boolean isNotOverlapping(List<int[]> bucket, int[] newActivity) {
		if(bucket.isEmpty())
			return true;
		else return bucket.stream().allMatch(e-> (e[0] >= newActivity[1] || e[1] <= newActivity[0]));
	}

}