import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Vestigium {

	static ArrayList<Integer> solveVestigium(int arr[][], int n, int cNum) {
		int maxR = 0;
		int maxC = 0;

		int diagSum = 0;

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			HashSet<Integer> chkR= new HashSet<>();
			HashSet<Integer>chkC= new HashSet<>();

			for (int j = 0; j < n; j++) {
				if (i == j) {
					diagSum += arr[i][j];
				}
			}
			

			for (int j = 0; j < n; j++) {
				if (chkC.contains(arr[j][i])) {
					maxC++;
					break;
				}

				else {
					chkC.add(arr[j][i]);
				}
			}

			for (int j = 0; j < n; j++) {
				if (chkR.contains(arr[i][j])) {
					maxR++;
					break;
				}

				else {
					chkR.add(arr[i][j]);
				}
			}
		}
		result.add(cNum);
		result.add(diagSum);
		result.add(maxR);
		result.add(maxC);

		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();

		ArrayList<ArrayList<Integer>> sol = new ArrayList<>();

		String[] result = new String[numOfTestCases];

		for (int repeat = 0; repeat < numOfTestCases; repeat++) {

			int n = sc.nextInt();

			int arr[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			sol.add(solveVestigium(arr, n, repeat + 1));
		}
		for (ArrayList<Integer> r : sol) {
			System.out.println("Case #" + r.get(0) + ": " + r.get(1) + " " + r.get(2) + " " + r.get(3));
		}
	}
}
