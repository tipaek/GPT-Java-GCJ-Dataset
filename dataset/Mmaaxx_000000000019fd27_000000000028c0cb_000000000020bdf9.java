import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream(new File("src/codeJam2020/round1/parentingPartnering/test.txt")));

		try(Scanner sc = new Scanner(System.in)) {
			int test = sc.nextInt();

			for (int i = 0; i < test; i++) {
				int events = sc.nextInt();
				int[] freeOn = new int[2];
				StringBuilder sb = new StringBuilder();
				boolean isImpossible = false;
				int[][] eventsMatrix = new int[events][2];
				String[] who = new String[events];

				for (int j = 0; j < events; j++) {
					eventsMatrix[j][0] = sc.nextInt();
					eventsMatrix[j][1] = sc.nextInt();
				}

				for (int j = 0; j < events; j++) {
					int indexNextSmallest = nextSmallest(eventsMatrix);
					int start = eventsMatrix[indexNextSmallest][0];
					int end = eventsMatrix[indexNextSmallest][1];

					if(start >= freeOn[0]) {
						freeOn[0] = end;
						who[indexNextSmallest] = "C";
					} else if (start >= freeOn[1]) {
						freeOn[1] = end;
						who[indexNextSmallest] = "J";
					} else {
						isImpossible = true;
					}

					eventsMatrix[indexNextSmallest][0] = 24 * 60 + 1;
				}

				if(isImpossible) {
					System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
				} else {
					for (int k = 0; k < who.length; k++) {
						sb.append(who[k]);
					}
					System.out.println("Case #" + (i + 1) + ": " + sb.toString());
				}
			}
		}
	}

	private static int nextSmallest(int[][] mat) {
		int smallestStart = 24 * 60 + 1;
		int index = -1;
		for (int i = 0; i < mat.length; i++) {
			if(mat[i][0] < smallestStart) {
				index = i;
				smallestStart = mat[i][0];
			}
		}

		return index;
	}
}
