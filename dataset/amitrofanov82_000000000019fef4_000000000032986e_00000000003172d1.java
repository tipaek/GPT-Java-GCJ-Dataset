import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Alexey") || 
				System.getProperties().getProperty("user.name").equals("Aleksiej_Mitrofanov")) {
			sc = new Scanner(new FileInputStream("input.txt"));;
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < testCases + 1; i++) {
			String[] nd = sc.nextLine().split(" ");
			int n = Integer.parseInt(nd[0]);
			int d = Integer.parseInt(nd[1]);
			long[] arr = new long[n];
			String[] arrasstring = sc.nextLine().split(" ");
			for (int j = 0; j < arrasstring.length; j++) {
				arr[j] = Long.parseLong(arrasstring[j]);
			}
			String result = readAndresolveSingleCase(arr, d);
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndresolveSingleCase(long[] slices, int d) {
		Arrays.sort(slices);
		Map<Long, Long> repeatsMap = new HashMap<>();
		
		/*long lastRepeatNum = -1;
		for (int i = 1; i < slices.length; i++) {
			if (slices[i] == slices[i-1]) {
				if (slices[i] != lastRepeatNum) {
					repeatsMap.put(slices[i], 2L);
					lastRepeatNum = slices[i];
				} else {
					repeatsMap.put(slices[i], repeatsMap.get(slices[i]) + 1L);
				}
			}
		}
		
		long mincuts = d-1;
		for (long key : repeatsMap.keySet()) {
			long repeats = repeatsMap.get(key);
			if (repeats >= d) {
				return "0";
			}
		
			long availableD = repeats;
			long savedCuts=repeats;
			int indexFrom = Arrays.binarySearch(slices, key);
			while (slices[indexFrom] == key && indexFrom != slices.length-1) {
				indexFrom++;
			}
			for (int i = indexFrom; i<slices.length; i++) {
				
				availableD += slices[i] / key;
			}
			
		}*/
		
		long mincuts = d-1;
		for (int i = 0; i < slices.length; i++) {
			int availD = 1;
			int availDall = 1;
			long mincutsCandidate = d-1;
			for (int j = i+1; j < slices.length; j++) {
				availDall += slices[j]/slices[i];
				if (availD >= d) break;
				if (slices[j] == slices[i]) {
					mincutsCandidate--;
					availD+=slices[j]/slices[i];
				} else if (slices[j] % slices[i] == 0) {
					availD+=slices[j]/slices[i];
					if (mincutsCandidate != 1) {
						mincutsCandidate--;
					}
				} 
			}
			if (availDall >=d && mincutsCandidate < mincuts) {
				mincuts = mincutsCandidate;
			}
		}

		return "" + mincuts;
	}

}










