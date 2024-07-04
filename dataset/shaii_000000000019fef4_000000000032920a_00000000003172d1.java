import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testCasesNum = scanner.nextInt();
		for (int i = 1; i <= testCasesNum; i++) {
			int N = scanner.nextInt();
			int D = scanner.nextInt();
			long[] slicesAngles = new long[N];
			for (int j = 0; j < N; j++) {
				slicesAngles[j] = scanner.nextLong();
			}
			Arrays.sort(slicesAngles);
			System.out.println("Case #" + i + ": " + calculateResult(D, slicesAngles));
		}
		try{
			scanner.close();
		}
		catch (Exception e){}
		System.out.flush();
	}
	
	private static int calculateResult(int D, long[] slicesAngles)
	{
		int totalSlicesNeededMin = Integer.MAX_VALUE;
		for (int i = 0; i < slicesAngles.length; i++) {
			int dTemp = D;
			long currentSliceSize = slicesAngles[i];
			int totalSlicesNeeded = 0;
			int k = i;
			while (dTemp > 0 && k < slicesAngles.length && currentSliceSize == slicesAngles[k]){
				dTemp--;
				k++;
			}
			if (k == slicesAngles.length && dTemp > 0)
			{
				totalSlicesNeeded = D - 1;
			}
			else{
				int j = k;
				for (; j < slicesAngles.length && dTemp > 0; j++) {
					if (slicesAngles[j] % currentSliceSize == 0){
						long newSlices = slicesAngles[j] / currentSliceSize;
						if (newSlices > dTemp)
							newSlices = dTemp;
						totalSlicesNeeded += Math.max(newSlices - 1, 1);
						dTemp -= newSlices;
					}
				}
				j = k;
				while (dTemp > 0 && j < slicesAngles.length){
					if (slicesAngles[j] % currentSliceSize != 0)
					{
						long newSlices = (long)Math.floor(slicesAngles[j] / (double)currentSliceSize);
						if (newSlices > dTemp)
							newSlices = dTemp;
						totalSlicesNeeded += newSlices;
						dTemp -= newSlices;
					}
					j++;
				}
			}
			
			totalSlicesNeededMin = Math.min(totalSlicesNeededMin, totalSlicesNeeded);
		}
		
		return totalSlicesNeededMin;
	}
}
