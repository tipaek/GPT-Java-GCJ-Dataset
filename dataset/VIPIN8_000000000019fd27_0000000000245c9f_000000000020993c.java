
import java.util.Scanner;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		//int param = 0;
		//int[][] sqaure = new int[100][100];
		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCase = Integer.parseInt(in.nextLine().trim());
		
		for (int x = 1; x <= testCase; x++) {
			int trace = 0;
			int nRows = 0, nColumn = 0;
			int param = Integer.parseInt(in.nextLine().trim());
			//testRowArray = new int[param+1];
			int[][] sqaure = new int[param][param];
			int testRowArray[] = new int[param+1];
			int testColumnArray[] = new int[param+1];
			for (int y = 0; y < param; y++) {
				String[] arItems = in.nextLine().split(" ");

				for (int z = 0; z < param; z++) {
					int arItem = Integer.parseInt(arItems[z].trim());
					sqaure[y][z] = arItem;
				}
			}

			boolean noRowRepeat = false, noColumnRepeat = false;
			for (int i = 0; i < param; i++) {
				trace += sqaure[i][i];
				for (int j = 0; j < param; j++) {
					if (!noRowRepeat) {
						if (testRowArray[sqaure[i][j]] == 0) {
							testRowArray[sqaure[i][j]] = sqaure[i][j];

						} else {
							nRows++;
							noRowRepeat = true;
						}
					}
					if (!noColumnRepeat) {
						if (testColumnArray[sqaure[j][i]] == 0) {
							testColumnArray[sqaure[j][i]] = sqaure[j][i];

						} else {
							nColumn++;
							noColumnRepeat = true;
						}
					}

				}
				testRowArray = new int[100];
				testColumnArray = new int[100];
				noRowRepeat = false;
				noColumnRepeat = false;
			}
			System.out.println("Case #" + x + ": " + trace + " " + nRows + " " + nColumn);
			trace = 0;
			nRows = 0;
			nColumn = 0;
		}

	}

}