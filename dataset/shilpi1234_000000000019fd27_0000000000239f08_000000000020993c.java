
import java.util.*;

class Test {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int ntest = sc.nextInt();
		int t = 1;
		while (t <= ntest) {
			int msize = sc.nextInt();
			int arr[][] = new int[msize][msize];
			for (int i = 0; i < msize; i++)
				for (int j = 0; j < msize; j++)
					arr[i][j] = sc.nextInt();
			int tracem = trace(arr, msize);
			int nrc = nRepeatingValueColumn(arr, msize);
			int nrw = nRepeatingValueRow(arr, msize);
			System.out.println("Case #" + t +": " + tracem + nrw + nrc);
			t++;
		}

	}

	static int trace(int arr[][], int msize) {
		int traceval = 0;
		for (int i = 0; i < msize; i++) {
			for (int j = 0; j < msize; j++) {
				if (i == j) {
					traceval = traceval + arr[i][j];
				}
			}
		}
		return traceval;
	}

	static int nRepeatingValueColumn(int arr[][], int msize) {
		int ndupc = 0;
		for (int i = 0; i < msize; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < msize; j++) {
				if (set.contains(arr[j][i])) {
					ndupc = ndupc + 1;
					break;
				}
				set.add(arr[j][i]);
			}

		}

		return ndupc;

	}

	static int nRepeatingValueRow(int arr[][], int msize) {

		int ndupc = 0;
		for (int i = 0; i < msize; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < msize; j++) {
				if (set.contains(arr[i][j])) {
					ndupc = ndupc + 1;
					break;
				}
				set.add(arr[i][j]);
			}

		}

		return ndupc;
	}
}
